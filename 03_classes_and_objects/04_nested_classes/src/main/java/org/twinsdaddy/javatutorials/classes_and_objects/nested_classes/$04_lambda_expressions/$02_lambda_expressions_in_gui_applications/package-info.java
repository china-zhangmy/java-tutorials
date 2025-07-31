/**
 * To process events in a graphical user interface (GUI) application, such as keyboard actions, mouse actions, and scroll actions, you typically create event handlers, which usually involves implementing a particular interface. Often, event handler interfaces are functional interfaces; they tend to have only one method.
 * <p>
 * In the JavaFX example HelloWorld.java (discussed in the previous section Anonymous Classes), you can replace the highlighted anonymous class with a lambda expression in this statement:
 *
 * <pre>
 *     {@code
 *         btn.setOnAction(new EventHandler<ActionEvent>() {
 *
 *             @Override
 *             public void handle(ActionEvent event) {
 *                 System.out.println("Hello World!");
 *             }
 *         });
 *     }
 * </pre>
 * <p>
 * The method invocation btn.setOnAction specifies what happens when you select the button represented by the btn object. This method requires an object of type EventHandler<ActionEvent>. The EventHandler<ActionEvent> interface contains only one method, void handle(T event). This interface is a functional interface, so you could use the following highlighted lambda expression to replace it:
 *
 * <pre>
 *     {@code
 *         btn.setOnAction(
 *           event -> System.out.println("Hello World!")
 *         );
 *      }
 * </pre>
 */
package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$04_lambda_expressions.$02_lambda_expressions_in_gui_applications;