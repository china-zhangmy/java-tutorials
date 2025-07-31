/**
 * <h1>Accessing Local Variables of the Enclosing Scope</h1>
 *
 * Like local and anonymous classes, lambda expressions can capture variables; they have the same access to local variables of the enclosing scope. However, unlike local and anonymous classes, lambda expressions do not have any shadowing issues (see Shadowing for more information). Lambda expressions are lexically scoped. This means that they do not inherit any names from a supertype or introduce a new level of scoping. Declarations in a lambda expression are interpreted just as they are in the enclosing environment. The following example, LambdaScopeTest, demonstrates this:
 *
 * <pre>
 *     {@code
 *      import java.util.function.Consumer;
 *
 *      public class LambdaScopeTest {
 *
 *          public int x = 0;
 *
 *          class FirstLevel {
 *
 *               public int x = 1;
 *
 *              void methodInFirstLevel(int x) {
 *
 *                    int z = 2;
 *
 *                     Consumer<Integer> myConsumer = (y) ->
 *                     {
 *                         // The following statement causes the compiler to generate
 *                         // the error "Local variable z defined in an enclosing scope
 *                         // must be final or effectively final"
 *                         //
 *                         // z = 99;
 *
 *                         System.out.println("x = " + x);
 *                         System.out.println("y = " + y);
 *                         System.out.println("z = " + z);
 *                         System.out.println("this.x = " + this.x);
 *                         System.out.println("LambdaScopeTest.this.x = " +
 *                             LambdaScopeTest.this.x);
 *                    };
 *
 *                    myConsumer.accept(x);
 *
 *                }
 *          }
 *
 *          public static void main(String... args) {
 *              LambdaScopeTest st = new LambdaScopeTest();
 *              LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
 *              fl.methodInFirstLevel(23);
 *          }
 *      }
 *     }
 * </pre>
 * This example generates the following output:
 * <pre>
 *     {@code
 *      x = 23
 *      y = 23
 *      z = 2
 *      this.x = 1
 *      LambdaScopeTest.this.x = 0
 *     }
 * </pre>
 *
 * If you substitute the parameter x in place of y in the declaration of the lambda expression myConsumer, then the compiler generates an error:
 *
 * <pre>
 *     {@code
 *      Consumer<Integer> myConsumer = (x) -> {
 *          // ...
 *      }
 *     }
 * </pre>
 *
 * The compiler generates the error "Lambda expression's parameter x cannot redeclare another local variable defined in an enclosing scope" because the lambda expression does not introduce a new level of scoping. Consequently, you can directly access fields, methods, and local variables of the enclosing scope. For example, the lambda expression directly accesses the parameter x of the method methodInFirstLevel. To access variables in the enclosing class, use the keyword this. In this example, this.x refers to the member variable FirstLevel.x.
 * <p>
 * However, like local and anonymous classes, a lambda expression can only access local variables and parameters of the enclosing block that are final or effectively final. In this example, the variable z is effectively final; its value is never changed after it's initialized. However, suppose that you add the following assignment statement in the the lambda expression myConsumer:
 *
 * <pre>
 *     {@code
 *      Consumer<Integer> myConsumer = (y) -> {
 *          z = 99;
 *          // ...
 *      }
 *     }
 * </pre>
 *
 * Because of this assignment statement, the variable z is not effectively final anymore. As a result, the Java compiler generates an error message similar to "Local variable z defined in an enclosing scope must be final or effectively final".
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$04_lambda_expressions.$04_accessing_local_variables_of_the_enclosing_scope;