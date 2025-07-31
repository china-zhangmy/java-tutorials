/**
 * <h1>Inner Class and Nested Static Class Example</h1>
 * <p>
 * The following example, <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/examples/OuterClass.java">OuterClass</a>,
 * along with <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/examples/TopLevelClass.java">TopLevelClass</a>,
 * demonstrates which class members of OuterClass an inner class (InnerClass), a nested static class (StaticNestedClass),
 * and a top-level class (TopLevelClass) can access: {@link OuterClass} {@link TopLevelClass}
 * <p>
 * Note that a static nested class interacts with the instance members of its outer class just like any other top-level class.
 * The static nested class StaticNestedClass can't directly access outerField because it's an instance variable of the enclosing class, OuterClass.
 * The Java compiler generates an error at the highlighted statement:
 * <p>
 * <pre>
 *     {@code
 *          static class StaticNestedClass {
 *              void accessMembers(OuterClass outer) {
 *                  // Compiler error: Cannot make a static reference to the non-static
 *                  //     field outerField
 *                  System.out.println(outerField);
 *              }
 *          }
 *     }
 * </pre>
 * <p>
 * To fix this error, access outerField through an object reference:
 * <p>
 * <pre>
 *     {@code
 *          System.out.println(outer.outerField);
 *     }
 * </pre>
 * <p>
 * Similarly, the top-level class TopLevelClass can't directly access outerField either.
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$04_inner_class_and_nested_class_example;