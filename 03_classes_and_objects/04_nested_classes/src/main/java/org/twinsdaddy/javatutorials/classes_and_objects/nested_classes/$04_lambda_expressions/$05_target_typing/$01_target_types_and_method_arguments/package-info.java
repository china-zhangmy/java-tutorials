/**
 * <h1>Target Types and Method Arguments</h1>
 * <pre>
 * For method arguments, the Java compiler determines the target type with two other language features: overload resolution and type argument inference.
 *
 * Consider the following two functional interfaces ( <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html">java.lang.Runnable</a> and <a href="https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Callable.html">java.util.concurrent.Callable<V></a>):
 *      <pre>
 *          {@code
 *          public interface Runnable {
 *              void run();
 *          }
 *
 *          public interface Callable<V> {
 *              V call();
 *          }
 *          }
 *      </pre>
 *
 * The method Runnable.run does not return a value, whereas Callable<V>.call does.
 *
 * Suppose that you have overloaded the method invoke as follows (see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html">Defining Methods</a> for more information about overloading methods):
 *      <pre>
 *          {@code
 *          void invoke(Runnable r) {
 *              r.run();
 *          }
 *
 *          <T> T invoke(Callable<T> c) {
 *              return c.call();
 *          }
 *          }
 *      </pre>
 *
 * Which method will be invoked in the following statement?
 *
 *      <pre>
 *          {@code
 *          String s = invoke(() -> "done");
 *          }
 *      </pre>
 *
 * The method invoke(Callable<T>) will be invoked because that method returns a value; the method invoke(Runnable) does not. In this case, the type of the lambda expression () -> "done" is Callable<T>.
 * </pre>
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$04_lambda_expressions.$05_target_typing.$01_target_types_and_method_arguments;