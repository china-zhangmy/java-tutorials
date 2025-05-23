/**
 * Local classes are similar to inner classes because they cannot define or declare any static members. Local classes in static methods, such as the class PhoneNumber, which is defined in the static method validatePhoneNumber, can only refer to static members of the enclosing class. For example, if you do not define the member variable regularExpression as static, then the Java compiler generates an error similar to "non-static variable regularExpression cannot be referenced from a static context."
 * <p>
 * Local classes are non-static because they have access to instance members of the enclosing block. Consequently, they cannot contain most kinds of static declarations.
 * <p>
 * You cannot declare an interface inside a block; interfaces are inherently static. For example, the following code excerpt does not compile because the interface HelloThere is defined inside the body of the method greetInEnglish:
 *
 * <pre class="code">
 *     public void greetInEnglish() {
 *         interface HelloThere {
 *            public void greet();
 *         }
 *         class EnglishHelloThere implements HelloThere {
 *             public void greet() {
 *                 System.out.println("Hello " + name);
 *             }
 *         }
 *         HelloThere myGreeting = new EnglishHelloThere();
 *         myGreeting.greet();
 *     }
 * </pre>
 * <p>
 * You cannot declare static initializers or member interfaces in a local class. The following code excerpt does not compile because the method EnglishGoodbye.sayGoodbye is declared static. The compiler generates an error similar to "modifier 'static' is only allowed in constant variable declaration" when it encounters this method definition:
 *
 * <pre class="code">
 *     public void sayGoodbyeInEnglish() {
 *         class EnglishGoodbye {
 *             public static void sayGoodbye() {
 *                 System.out.println("Bye bye");
 *             }
 *         }
 *         EnglishGoodbye.sayGoodbye();
 *     }
 * </pre>
 * <p>
 * A local class can have static members provided that they are constant variables. (A constant variable is a variable of primitive type or type String that is declared final and initialized with a compile-time constant expression. A compile-time constant expression is typically a string or an arithmetic expression that can be evaluated at compile time. See Understanding Class Members for more information.) The following code excerpt compiles because the static member EnglishGoodbye.farewell is a constant variable:
 *
 * <pre class="code">
 *     public void sayGoodbyeInEnglish() {
 *         class EnglishGoodbye {
 *             public static final String farewell = "Bye bye";
 *             public void sayGoodbye() {
 *                 System.out.println(farewell);
 *             }
 *         }
 *         EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
 *         myEnglishGoodbye.sayGoodbye();
 *     }
 * </pre>
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$02_local_classes.$03_local_classes_are_similar_to_inner_classes;