/**
 * <h1>Target Typing</h1>
 * <pre>
 * How do you determine the type of a lambda expression? Recall the lambda expression that selected members who are male and between the ages 18 and 25 years:
 *      <pre>
 *          {@code
 *              p -> p.getGender() == Person.Sex.MALE
 *                  && p.getAge() >= 18
 *                  && p.getAge() <= 25
 *          }
 *      </pre>
 *
 * This lambda expression was used in the following two methods:
 *     <ul>
 *         <li>
 *             public static void printPersons(List<Person> roster, CheckPerson tester) in Approach 3: Specify Search Criteria Code in a Local Class
 *         </li>
 *         <li>
 *             public void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) in Approach 6: Use Standard Functional Interfaces with Lambda Expressions
 *         </li>
 *     </ul>
 *
 * When the Java runtime invokes the method printPersons, it's expecting a data type of CheckPerson, so the lambda expression is of this type. However, when the Java runtime invokes the method printPersonsWithPredicate, it's expecting a data type of Predicate<Person>, so the lambda expression is of this type. The data type that these methods expect is called the target type. To determine the type of a lambda expression, the Java compiler uses the target type of the context or situation in which the lambda expression was found. It follows that you can only use lambda expressions in situations in which the Java compiler can determine a target type:
 *
 *     <ul>
 *         <li>
 *             Variable declarations
 *         </li>
 *         <li>
 *             Assignments
 *         </li>
 *         <li>
 *             Return statements
 *         </li>
 *         <li>
 *             Array initializers
 *         </li>
 *         <li>
 *             Method or constructor arguments
 *         </li>
 *         <li>
 *             Lambda expression bodies
 *         </li>
 *         <li>
 *             Conditional expressions, ?:
 *         </li>
 *         <li>
 *             Cast expressions
 *         </li>
 *     </ul>
 * </pre>
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$04_lambda_expressions.$05_target_typing;