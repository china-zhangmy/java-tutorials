/**
 * A local class has access to the members of its enclosing class. In the previous example, the PhoneNumber constructor accesses the member LocalClassExample.regularExpression.
 * <p>
 * In addition, a local class has access to local variables. However, a local class can only access local variables that are declared final. When a local class accesses a local variable or parameter of the enclosing block, it captures that variable or parameter. For example, the PhoneNumber constructor can access the local variable numberLength because it is declared final; numberLength is a captured variable.
 * <p>
 * However, starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final. For example, suppose that the variable numberLength is not declared final, and you add the highlighted assignment statement in the PhoneNumber constructor to change the length of a valid phone number to 7 digits:
 *
 * <pre class="code">
 *     PhoneNumber(String phoneNumber) {
 *         numberLength = 7;
 *         String currentNumber = phoneNumber.replaceAll(
 *             regularExpression, "");
 *         if (currentNumber.length() == numberLength)
 *             formattedPhoneNumber = currentNumber;
 *         else
 *             formattedPhoneNumber = null;
 *     }
 * </pre>
 * <p>
 * Because of this assignment statement, the variable numberLength is not effectively final anymore. As a result, the Java compiler generates an error message similar to "local variables referenced from an inner class must be final or effectively final" where the inner class PhoneNumber tries to access the numberLength variable:
 *
 * <pre class="code">
 *     if (currentNumber.length() == numberLength)
 * </pre>
 * <p>
 * Starting in Java SE 8, if you declare the local class in a method, it can access the method's parameters. For example, you can define the following method in the PhoneNumber local class:
 *
 * <pre class="code">
 *     public void printOriginalNumbers() {
 *         System.out.println("Original numbers are " + phoneNumber1 +
 *             " and " + phoneNumber2);
 *     }
 * </pre>
 * <p>
 * The method printOriginalNumbers accesses the parameters phoneNumber1 and phoneNumber2 of the method validatePhoneNumber.
 *
 * Shadowing and Local Classes
 * <p>
 * Declarations of a type (such as a variable) in a local class shadow declarations in the enclosing scope that have the same name. See Shadowing for more information.
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$02_local_classes.$02_accessing_members_of_an_enclosing_class;