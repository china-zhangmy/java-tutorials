/**
 * Serialization of inner classes, including local and anonymous classes, is strongly discouraged.
 * When the Java compiler compiles certain constructs, such as inner classes, it creates synthetic constructs;
 * these are classes, methods, fields, and other constructs that do not have a corresponding construct in the source code.
 * Synthetic constructs enable Java compilers to implement new Java language features without changes to the JVM.
 * However, synthetic constructs can vary among different Java compiler implementations, which means that .class files can
 * vary among different implementations as well. Consequently, you may have compatibility issues if you
 * serialize an inner class and then deserialize it with a different JRE implementation.
 * See the section Implicit and Synthetic Parameters (@link https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html#implcit_and_synthetic)
 * in the section Obtaining Names of Method Parameters for more information about the synthetic constructs
 * generated when an inner class is compiled.
 *
 * @author zhangmingyu
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$00_concepts.$06_seralization;