/**
 * <pre>
 * A lambda expression consists of the following:
 * <ul style="margin:left 40px">
 *     <li>A comma-separated list of formal parameters enclosed in parentheses. The CheckPerson.test method contains one parameter, p, which represents an instance of the Person class.</li>
 *
 *     <b>Note</b>: You can omit the data type of the parameters in a lambda expression. In addition, you can omit the parentheses if there is only one parameter. For example, the following lambda expression is also valid:
 *     <p style="margin:left 20px">
 *     {@code
 *     p -> p.getGender() == Person.Sex.MALE
 *         && p.getAge() >= 18
 *         && p.getAge() <= 25
 *     }
 *     </p>
 *
 *
 *     <li>The arrow token, -></li>
 *
 *     <li>A body, which consists of a single expression or a statement block. This example uses the following expression:</li>
 *     <p style="margin:left 20px">
 *     {@code
 *     p.getGender() == Person.Sex.MALE
 *         && p.getAge() >= 18
 *         && p.getAge() <= 25
 *     }
 *     <p>
 *     If you specify a single expression, then the Java runtime evaluates the expression and then returns its value. Alternatively, you can use a return statement:
 *     <p style="margin:left 20px">
 *     {@code
 *     p -> {
 *         return p.getGender() == Person.Sex.MALE
 *             && p.getAge() >= 18
 *             && p.getAge() <= 25;
 *     }
 *     }
 *     <p>
 *     A return statement is not an expression; in a lambda expression, you must enclose statements in braces ({}). However, you do not have to enclose a void method invocation in braces. For example, the following is a valid lambda expression:
 *     <p style="margin:left 20px">
 *     {@code
 *          email -> System.out.println(email)
 *     }
 * </pre>
 * <p>
 * Note that a lambda expression looks a lot like a method declaration; you can consider lambda expressions as anonymous methods—methods without a name.
 * <p>
 * The following example, Calculator, is an example of lambda expressions that take more than one formal parameter:
 *
 * <pre>
 *     {@code
 *     public class Calculator {
 *
 *         interface IntegerMath {
 *             int operation(int a, int b);
 *         }
 *
 *         public int operateBinary(int a, int b, IntegerMath op) {
 *             return op.operation(a, b);
 *         }
 *
 *         public static void main(String... args) {
 *
 *             Calculator myApp = new Calculator();
 *             IntegerMath addition = (a, b) -> a + b;
 *             IntegerMath subtraction = (a, b) -> a - b;
 *             System.out.println("40 + 2 = " +
 *                 myApp.operateBinary(40, 2, addition));
 *             System.out.println("20 - 10 = " +
 *                 myApp.operateBinary(20, 10, subtraction));
 *         }
 *     }
 *     }
 * </pre>
 *
 * The method operateBinary performs a mathematical operation on two integer operands. The operation itself is specified by an instance of IntegerMath. The example defines two operations with lambda expressions, addition and subtraction. The example prints the following:
 *
 * <pre>
 *     {@code
 *     40 + 2 = 42
 *     20 - 10 = 10
 *     }
 * </pre>
 *
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$04_lambda_expressions.$03_syntax_of_lambda_expressions;