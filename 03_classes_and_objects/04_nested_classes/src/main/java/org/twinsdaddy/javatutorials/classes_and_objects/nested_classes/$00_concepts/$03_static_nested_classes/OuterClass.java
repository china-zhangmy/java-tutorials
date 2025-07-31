package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$03_static_nested_classes;

/**
 * <h1>Static Nested Classes</h1>
 * As with class methods and variables, a static nested class is associated with its outer class.
 * And like static class methods, a static nested class cannot refer directly to instance variables
 * or methods defined in its enclosing class: it can use them only through an object reference.
 *    <hr>
 * Note:
 * A static nested class interacts with the instance members of its outer class (and other classes)
 * just like any other top-level class. In effect, a static nested class is behaviorally a top-level class
 * that has been nested in another top-level class for packaging convenience.
 *    <hr>
 *
 * @author zhangmingyu
 */
public class OuterClass {

    static class StaticNestedClass {

    }

    /**
     * You instantiate a static nested class the same way as a top-level class:
     *
     * @param args
     */
    public static void main(String[] args) {
        OuterClass.StaticNestedClass staticNestedClass =
                new OuterClass.StaticNestedClass();
    }
}
