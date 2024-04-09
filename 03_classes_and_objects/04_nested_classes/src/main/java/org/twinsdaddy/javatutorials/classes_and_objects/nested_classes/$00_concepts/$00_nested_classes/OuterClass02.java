package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$00_nested_classes;

/**
 * Terminology: Nested classes are divided into two categories: non-static and static.
 * Non-static nested classes are called inner classes.
 * Nested classes that are declared static are called static nested classes.
 * <p>
 * A nested class is a member of its enclosing class.
 * Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private.
 * Static nested classes do not have access to other members of the enclosing class.
 * As a member of the OuterClass, a nested class can be declared private, public, protected, or package private.
 * (Recall that outer classes can only be declared public or package private.)
 * <p>
 * Why Use Nested Classes?
 * <p>
 * Compelling reasons for using nested classes include the following:
 * <p>
 * - It is a way of logically grouping classes that are only used in one place:
 * If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together.
 * Nesting such "helper classes" makes their package more streamlined.
 * <p>
 * - It increases encapsulation:
 * Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private.
 * By hiding class B within class A, A's members can be declared private and B can access them.
 * In addition, B itself can be hidden from the outside world.
 * <p>
 * - It can lead to more readable and maintainable code:
 * Nesting small classes within top-level classes places the code closer to where it is used.
 *
 * @author zhangmingyu
 */
public class OuterClass02 {

    class InnerClass {

    }

    static class StaticNestedClass {

    }

}
