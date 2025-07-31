/**
 * <h1>Method References</h1>
 *
 * You use <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html">lambda expressions</a> to create anonymous methods. Sometimes, however, a lambda expression does nothing but call an existing method. In those cases, it's often clearer to refer to the existing method by name. Method references enable you to do this; they are compact, easy-to-read lambda expressions for methods that already have a name.
 * <p>
 * Consider again the <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Person.java">Person</a> class discussed in the section <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html">Lambda Expressions</a>:
 *
 * <blockquote>
 *     <pre>
 * public class Person {
 *
 *     // ...
 *
 *     LocalDate birthday;
 *
 *     public int getAge() {
 *         // ...
 *     }
 *
 *     public LocalDate getBirthday() {
 *         return birthday;
 *     }
 *
 *     public static int compareByAge(Person a, Person b) {
 *         return a.birthday.compareTo(b.birthday);
 *     }
 *
 *     // ...
 * }
 *     </pre>
 * </blockquote>
 *
 * Suppose that the members of your social networking application are contained in an array, and you want to sort the array by age. You could use the following code (find the code excerpts described in this section in the example <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/examples/MethodReferencesTest.java">MethodReferencesTest</a>):
 *
 * <blockquote>
 *     <pre>
 * Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
 *
 * class PersonAgeComparator implements Comparator<Person> {
 *     public int compare(Person a, Person b) {
 *         return a.getBirthday().compareTo(b.getBirthday());
 *     }
 * }
 *
 * Arrays.sort(rosterAsArray, new PersonAgeComparator());
 *     </pre>
 * </blockquote>
 *
 * The method signature of this invocation of sort is the following:
 *
 * <blockquote>
 *     <pre>
 * static <T> void sort(T[] a, Comparator<? super T> c)
 *     </pre>
 * </blockquote>
 *
 * Notice that the interface Comparator is a functional interface. Therefore, you could use a lambda expression instead of defining and then creating a new instance of a class that implements Comparator:
 *
 * <blockquote>
 *     <pre>
 * Arrays.sort(rosterAsArray,
 *     (Person a, Person b) -> {
 *         return a.getBirthday().compareTo(b.getBirthday());
 *     }
 * );
 *     </pre>
 * </blockquote>
 *
 * However, this method to compare the birth dates of two Person instances already exists as Person.compareByAge. You can invoke this method instead in the body of the lambda expression:
 *
 * <blockquote>
 *     <pre>
 * Arrays.sort(rosterAsArray,
 *     (a, b) -> Person.compareByAge(a, b)
 * );
 *     </pre>
 * </blockquote>
 *
 * Because this lambda expression invokes an existing method, you can use a method reference instead of a lambda expression:
 *
 * <blockquote>
 *     <pre>
 * Arrays.sort(rosterAsArray, Person::compareByAge);
 *     </pre>
 * </blockquote>
 *
 * The method reference Person::compareByAge is semantically the same as the lambda expression (a, b) -> Person.compareByAge(a, b). Each has the following characteristics:
 *
 * <ul>
 *     <li>
 *         Its formal parameter list is copied from Comparator<Person>.compare, which is (Person, Person).
 *     </li>
 *     <li>
 *         Its body calls the method Person.compareByAge.
 *     </li>
 * </ul>
 *
 * <h2>Kinds of Method References</h2>
 *
 * There are four kinds of method references:
 * <table style="border:2px">
 *     <thead>
 *         <th>Kind</th>
 *         <th>Syntax</th>
 *         <th>Examples</th>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>Reference to a static method</td>
 *             <td>ContainingClass::staticMethodName</td>
 *             <td>Person::compareByAge<br/>MethodReferencesExamples::appendStrings</td>
 *         </tr>
 *         <tr>
 *             <td>Reference to an instance method of a particular object</td>
 *             <td>containingObject::instanceMethodName</td>
 *             <td>myComparisonProvider::compareByName<br/>myApp::appendStrings2</td>
 *         </tr>
 *         <tr>
 *             <td>Reference to an instance method of an arbitrary object of a particular type</td>
 *             <td>ContainingType::methodName</td>
 *             <td>String::compareToIgnoreCase<br/>String::concat</td>
 *         </tr>
 *         <tr>
 *             <td>Reference to a constructor</td>
 *             <td>ClassName::new</td>
 *             <td>HashSet::new</td>
 *         </tr>
 * </table>
 *
 * The following example, <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/examples/MethodReferencesExamples.java">MethodReferencesExamples</a>, contains examples of the first three types of method references:
 *
 * <blockquote>
 *     <pre>
 * import java.util.function.BiFunction;
 *
 * public class MethodReferencesExamples {
 *
 *     public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
 *         return merger.apply(a, b);
 *     }
 *
 *     public static String appendStrings(String a, String b) {
 *         return a + b;
 *     }
 *
 *     public String appendStrings2(String a, String b) {
 *         return a + b;
 *     }
 *
 *     public static void main(String[] args) {
 *
 *         MethodReferencesExamples myApp = new MethodReferencesExamples();
 *
 *         // Calling the method mergeThings with a lambda expression
 *         System.out.println(MethodReferencesExamples.
 *             mergeThings("Hello ", "World!", (a, b) -> a + b));
 *
 *         // Reference to a static method
 *         System.out.println(MethodReferencesExamples.
 *             mergeThings("Hello ", "World!", MethodReferencesExamples::appendStrings));
 *
 *         // Reference to an instance method of a particular object
 *         System.out.println(MethodReferencesExamples.
 *             mergeThings("Hello ", "World!", myApp::appendStrings2));
 *
 *         // Reference to an instance method of an arbitrary object of a
 *         // particular type
 *         System.out.println(MethodReferencesExamples.
 *             mergeThings("Hello ", "World!", String::concat));
 *     }
 * }
 *     </pre>
 * </blockquote>
 *
 * All the System.out.println() statements print the same thing: Hello World!
 * <p>
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html">BiFunction</a> is one of many functional interfaces in the <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html">java.util.function</a> package. The BiFunction functional interface can represent a lambda expression or method reference that accepts two arguments and produces a result.
 *
 * <h2>Reference to a Static Method</h2>
 *
 * The method references Person::compareByAge and MethodReferencesExamples::appendStrings are references to a static method.
 *
 * <h2>Reference to an Instance Method of a Particular Object</h2>
 *
 * The following is an example of a reference to an instance method of a particular object:
 *
 * <blockquote>
 *     <pre>
 * class ComparisonProvider {
 *     public int compareByName(Person a, Person b) {
 *         return a.getName().compareTo(b.getName());
 *     }
 *
 *     public int compareByAge(Person a, Person b) {
 *         return a.getBirthday().compareTo(b.getBirthday());
 *     }
 * }
 * ComparisonProvider myComparisonProvider = new ComparisonProvider();
 * Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);
 *     </pre>
 * </blockquote>
 *
 * The method reference myComparisonProvider::compareByName invokes the method compareByName that is part of the object myComparisonProvider. The JRE infers the method type arguments, which in this case are (Person, Person).
 *  <p>
 * Similarly, the method reference myApp::appendStrings2 invokes the method appendStrings2 that is part of the object myApp. The JRE infers the method type arguments, which in this case are (String, String).
 *
 * <h2>Reference to an Instance Method of an Arbitrary Object of a Particular Type</h2>
 *
 * The following is an example of a reference to an instance method of an arbitrary object of a particular type:
 *
 * <blockquote>
 *     <pre>
 * String[] stringArray = { "Barbara", "James", "Mary", "John",
 *     "Patricia", "Robert", "Michael", "Linda" };
 * Arrays.sort(stringArray, String::compareToIgnoreCase);
 *     </pre>
 * </blockquote>
 *
 * The equivalent lambda expression for the method reference String::compareToIgnoreCase would have the formal parameter list (String a, String b), where a and b are arbitrary names used to better describe this example. The method reference would invoke the method a.compareToIgnoreCase(b).
 *  <p>
 * Similarly, the method reference String::concat would invoke the method a.concat(b).
 *
 * <h2>Reference to a Constructor</h2>
 *
 * You can reference a constructor in the same way as a static method by using the name new. The following method copies elements from one collection to another:
 *
 * <blockquote>
 *     <pre>
 * public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
 *     DEST transferElements(
 *         SOURCE sourceCollection,
 *         Supplier<DEST> collectionFactory) {
 *
 *     DEST result = collectionFactory.get();
 *     for (T t : sourceCollection) {
 *         result.add(t);
 *     }
 *     return result;
 * }
 *     </pre>
 * </blockquote>
 *
 * The functional interface Supplier contains one method get that takes no arguments and returns an object. Consequently, you can invoke the method transferElements with a lambda expression as follows:
 *
 * <blockquote>
 *     <pre>
 * Set<Person> rosterSetLambda =
 *     transferElements(roster, () -> { return new HashSet<>(); });
 *     </pre>
 * </blockquote>
 *
 * You can use a constructor reference in place of the lambda expression as follows:
 *
 * <blockquote>
 *     <pre>
 * Set<Person> rosterSet = transferElements(roster, HashSet::new);
 *     </pre>
 * </blockquote>
 *
 * The Java compiler infers that you want to create a HashSet collection that contains elements of type Person. Alternatively, you can specify this as follows:
 *
 * <blockquote>
 *     <pre>
 * Set<Person> rosterSet = transferElements(roster, HashSet<Person>::new);
 *     </pre>
 * </blockquote>
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$05_method_references;