package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$05_shadowing;

/**
 * If a declaration of a type (such as a member variable or a parameter name) in a particular scope (such as an inner class or a method definition)
 * has the same name as another declaration in the enclosing scope, then the declaration shadows the declaration of the enclosing scope.
 * You cannot refer to a shadowed declaration by its name alone. The following example, ShadowTest, demonstrates this:
 *
 * @author zhangmingyu
 */
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodFirstLevel(int x) {
            /*
            The variable x defined as a parameter of the method methodInFirstLevel shadows the variable of the inner class FirstLevel.
            Consequently, when you use the variable x in the method methodInFirstLevel, it refers to the method parameter.
             */
            System.out.println("x = " + x);
            /*
             To refer to the member variable of the inner class FirstLevel, use the keyword this to represent the enclosing scope:
             */
            System.out.println("this.x = " + this.x);
            /*
            Refer to member variables that enclose larger scopes by the class name to which they belong.
             */
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String[] args) {
        ShadowTest shadowTest = new ShadowTest();
        ShadowTest.FirstLevel f1 = shadowTest.new FirstLevel();
        f1.methodFirstLevel(23);
    }
}
