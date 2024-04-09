package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$01_inner_classes;

/**
 * As with instance methods and variables, an inner class is associated with an instance of its enclosing class
 * and has direct access to that object's methods and fields.
 * Also, because an inner class is associated with an instance, it cannot define any static members itself.
 *
 * Objects that are instances of an inner class exist within an instance of the outer class. Consider the following classes:
 *
 * @author zhangmingyu
 */
public class OuterClass {

    class InnerClass {

    }

    /**
     * An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and fields of its enclosing instance.
     *
     * To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:
     *
     * @param args
     */
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }
}
