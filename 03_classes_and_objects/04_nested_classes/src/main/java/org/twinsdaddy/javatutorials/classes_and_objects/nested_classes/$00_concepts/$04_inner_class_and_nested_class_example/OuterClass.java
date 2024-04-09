package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$04_inner_class_and_nested_class_example;

/**
 * @author zhangmingyu
 */
public class OuterClass {

    String outerField = "Outer Field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    /**
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
    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);

        System.out.println("\nTop-level class:");
        System.out.println("------------");
        TopLevelClass topLevelObject = new TopLevelClass();
        topLevelObject.accessMembers(outerObject);
    }
}
