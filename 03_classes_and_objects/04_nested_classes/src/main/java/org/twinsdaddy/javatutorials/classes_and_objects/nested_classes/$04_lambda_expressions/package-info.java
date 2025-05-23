/**
 * One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. In these cases, you're usually trying to pass functionality as an argument to another method, such as what action should be taken when someone clicks a button. Lambda expressions enable you to do this, to treat functionality as method argument, or code as data.
 * <p>
 * The previous section, Anonymous Classes, shows you how to implement a base class without giving it a name. Although this is often more concise than a named class, for classes with only one method, even an anonymous class seems a bit excessive and cumbersome. Lambda expressions let you express instances of single-method classes more compactly.
 * <p>
 * This section covers the following topics:
 * <pre class="code">
 *     Ideal Use Case for Lambda Expressions
 *         Approach 1: Create Methods That Search for Members That Match One Characteristic
 *         Approach 2: Create More Generalized Search Methods
 *         Approach 3: Specify Search Criteria Code in a Local Class
 *         Approach 4: Specify Search Criteria Code in an Anonymous Class
 *         Approach 5: Specify Search Criteria Code with a Lambda Expression
 *         Approach 6: Use Standard Functional Interfaces with Lambda Expressions
 *         Approach 7: Use Lambda Expressions Throughout Your Application
 *         Approach 8: Use Generics More Extensively
 *         Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
 *     Lambda Expressions in GUI Applications
 *     Syntax of Lambda Expressions
 *     Accessing Local Variables of the Enclosing Scope
 *     Target Typing
 *         Target Types and Method Arguments
 *     Serialization
 * </pre>
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$04_lambda_expressions;