/**
 * The following example, OuterClass, along with TopLevelClass, demonstrates which class members of OuterClass an inner class (InnerClass),
 * a nested static class (StaticNestedClass), and a top-level class (TopLevelClass) can access.
 *
 * Note that a static nested class interacts with the instance members of its outer class just like any other top-level class.
 * The static nested class StaticNestedClass can't directly access outerField because it's an instance variable of the enclosing class, OuterClass.
 * The Java compiler generates an error at the highlighted statement:
 *
 * static class StaticNestedClass {
 *     void accessMembers(OuterClass outer) {
 *        // Compiler error: Cannot make a static reference to the non-static
 *        //     field outerField
 *        System.out.println(outerField);
 *     }
 * }
 *
 * To fix this error, access outerField through an object reference:
 *
 * System.out.println(outer.outerField);
 *
 * Similarly, the top-level class TopLevelClass can't directly access outerField either.
 *
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$04_inner_class_and_nested_class_example;