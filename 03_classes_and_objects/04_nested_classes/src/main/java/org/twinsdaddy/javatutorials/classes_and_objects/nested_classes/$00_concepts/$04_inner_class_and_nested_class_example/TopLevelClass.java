package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$04_inner_class_and_nested_class_example;

/**
 * @author zhangmingyu
 */
public class TopLevelClass {

    public void accessMembers(OuterClass outer) {
        // Compiler error: Cannot make a static reference to the non-static
        //     field OuterClass.outerField
        // System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }
}
