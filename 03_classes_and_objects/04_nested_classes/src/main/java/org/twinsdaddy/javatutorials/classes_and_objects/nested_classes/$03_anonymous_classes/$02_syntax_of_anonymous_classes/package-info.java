/**
 * Syntax of Anonymous Classes
 * <p>
 * As mentioned previously, an anonymous class is an expression. The syntax of an anonymous class expression is like the invocation of a constructor, except that there is a class definition contained in a block of code.
 * <p>
 * Consider the instantiation of the frenchGreeting object:
 *
 * <pre class="code">
 *         HelloWorld frenchGreeting = new HelloWorld() {
 *             String name = "tout le monde";
 *             public void greet() {
 *                 greetSomeone("tout le monde");
 *             }
 *             public void greetSomeone(String someone) {
 *                 name = someone;
 *                 System.out.println("Salut " + name);
 *             }
 *         };
 * </pre>
 * <p>
 * The anonymous class expression consists of the following:
 * <p>
 * - The new operator
 * <p>
 * - The name of an interface to implement or a class to extend. In this example, the anonymous class is implementing the interface HelloWorld.
 * <p>
 * - Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression. Note: When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in this example.
 * <p>
 * - A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not.
 * <p>
 * Because an anonymous class definition is an expression, it must be part of a statement. In this example, the anonymous class expression is part of the statement that instantiates the frenchGreeting object. (This explains why there is a semicolon after the closing brace.)
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$03_anonymous_classes.$02_syntax_of_anonymous_classes;