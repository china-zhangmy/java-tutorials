/**
 * <h1>When to Use Nested Classes, Local Classes, Anonymous Classes, and Lambda Expressions</h1>
 *
 * As mentioned in the section <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html">Nested Classes</a>, nested classes enable you to logically group classes that are only used in one place, increase the use of encapsulation, and create more readable and maintainable code. Local classes, anonymous classes, and lambda expressions also impart these advantages; however, they are intended to be used for more specific situations:
 * <ul>
 *     <li>
 *         <b><a href="https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html">Local class</a></b>: Use it if you need to create more than one instance of a class, access its constructor, or introduce a new, named type (because, for example, you need to invoke additional methods later).
 *     </li>
 *     <li>
 *         <b><a href="https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html">Anonymous class</a></b>: Use it if you need to declare fields or additional methods.
 *     </li>
 *     <li>
 *         <b><a href="https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html">Lambda expression</a></b>:
 *         <ul>
 *             <li>
 *                 Use it if you are encapsulating a single unit of behavior that you want to pass to other code. For example, you would use a lambda expression if you want a certain action performed on each element of a collection, when a process is completed, or when a process encounters an error.
 *             </li>
 *             <li>
 *                 Use it if you need a simple instance of a functional interface and none of the preceding criteria apply (for example, you do not need a constructor, a named type, fields, or additional methods).
 *             </li>
 *         </ul>
 *     </li>
 *     <li>
 *         <b><a href="https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html">Nested class</a></b>: Use it if your requirements are similar to those of a local class, you want to make the type more widely available, and you don't require access to local variables or method parameters.
 *         <ul>
 *             <li>
 *                 Use a non-static nested class (or inner class) if you require access to an enclosing instance's non-public fields and methods. Use a static nested class if you don't require this access.
 *             </li>
 *         </ul>
 *     </li>
 * </ul>
 *
 *
 *
 *
 *
 *
 *
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$06_when_to_use_nested_classes_local_classes_anonymous_classes_and_lambda_expressions;