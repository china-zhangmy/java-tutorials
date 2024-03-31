/**
 * https://blog.csdn.net/ikownyou/article/details/53081426
 * <p>
 * == 动态代理 ==
 * <p>
 * 所谓动态是指代理类的源码是在程序运行期间由JVM根据反射等机制动态的生成，所以不存在代理类的字节码文件。代理类和委托类的关系是在程序运行时确定。
 * <p>
 * 与动态代理紧密关联的Java API：
 * 1）java.lang.reflect.Proxy
 * 这是 Java 动态代理机制生成的所有动态代理类的父类，它提供了一组静态方法来为一组接口动态地生成代理类及其对象。
 * ------------------------------核心方法-------------------------------------
 * // 方法 1: 该方法用于获取指定代理对象所关联的调用处理器
 * static InvocationHandler getInvocationHandler(Object com.demo.javacore.proxy)
 * // 方法 2：该方法用于获取关联于指定类装载器和一组接口的动态代理类的类对象
 * static Class getProxyClass(ClassLoader loader, Class[] interfaces)
 * // 方法 3：该方法用于判断指定类对象是否是一个动态代理类
 * static boolean isProxyClass(Class cl)
 * // 方法 4：该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
 * static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)
 * ---------------------------------------------------------------------------
 * 2）java.lang.reflect.InvocationHandler
 * 这是调用处理器接口，它自定义了一个 invoke 方法，用于集中处理在动态代理类对象上的方法调用，通常在该方法中实现对委托类的代理访问。每次生成动态代理类对象时都要指定一个对应的调用处理器对象。
 * ------------------------------核心方法-------------------------------------
 * // 该方法负责集中处理动态代理类上的所有方法调用。第一个参数既是代理类实例，第二个参数是被调用的方法对象，第三个方法是调用参数。调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
 * Object invoke(Object com.demo.javacore.proxy, Method method, Object[] args)
 * ---------------------------------------------------------------------------
 * 3）java.lang.ClassLoader
 * 这是类装载器类，负责将类的字节码装载到 Java 虚拟机（JVM）中并为其定义类对象，然后该类才能被使用。Proxy 静态方法生成动态代理类同样需要通过类装载器来进行装载才能使用，它与普通类的唯一区别就是其字节码是由 JVM 在运行时动态生成的而非预存在于任何一个 .class 文件中。每次生成动态代理类对象时都需要指定一个类装载器对象。
 * <p>
 * 实现步骤：
 * （一）具体步骤
 * a. 实现InvocationHandler接口创建自己的调用处理器
 * b. 给Proxy类提供ClassLoader和代理接口类型数组创建动态代理类
 * c. 以调用处理器类型为参数，利用反射机制得到动态代理类的构造函数
 * d. 以调用处理器对象为参数，利用动态代理类的构造函数创建动态代理类对象
 * --------------------------------代-----码----------------------------------
 * // InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发。其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用。
 * InvocationHandler handler = new InvocationHandlerImpl(..);
 * // 通过 Proxy 为包括 Interface 接口在内的一组接口动态创建代理类的类对象
 * Class clazz = Proxy.getProxyClass(classLoader, new Class[] { Interface.class, ... });
 * // 通过反射从生成的类对象获得构造函数对象
 * Constructor constructor = clazz.getConstructor(new Class[] { InvocationHandler.class });
 * // 通过构造函数对象创建动态代理类实例
 * Interface Proxy = (Interface)constructor.newInstance(new Object[] { handler });
 * ---------------------------------------------------------------------------
 * <p>
 * （二）简化步骤 -- Proxy类的静态方法newProxyInstance对上面具体步骤的后三步做了封装，简化了动态代理对象的获取过程
 * a. 实现InvocationHandler接口创建自己的调用处理器
 * b. 给Proxy类提供ClassLoader、代理接口类型数组和调用处理器对象作为参数创建动态代理类对象
 * --------------------------------代-----码----------------------------------
 * // InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
 * InvocationHandler handler = new InvocationHandlerImpl(..);
 * // 通过 Proxy 直接创建动态代理类实例
 * Interface com.demo.javacore.proxy = (Interface)Proxy.newProxyInstance( classLoader, new Class[] { Interface.class },  handler );
 * ---------------------------------------------------------------------------
 */
package org.twinsdaddy.javatutorials.exercises.proxy.static_vs_dyna.dyna_proxy;