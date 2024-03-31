/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 *
 * Method Reference:
 * You use lambda expressions to create anonymous methods. Sometimes, however, a lambda expression does nothing but call an existing method.
 * In those cases, it's often clearer to refer to the existing method by name. Method references enable you to do this;
 * they are compact, easy-to-read lambda expressions for methods that already have a name.
 *
 * There are four kinds of method references:
 *
 * - Reference to a static method: ContainingClass::staticMethodName
 * - Reference to an instance method of a particular object: containingObject::instanceMethodName
 * - Reference to an instance method of an arbitrary object of a particular type: ContainingType::methodName
 * - Reference to a constructor: ClassName::new
 */
package org.twinsdaddy.javatutorials.exercises.collections.method_reference;