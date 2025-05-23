package org.twinsdaddy.javatutorials.classes_and_objects.nested_classes.$03_anonymous_classes.$04_examples_of_anonymous_classes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Anonymous classes are often used in graphical user interface (GUI) applications.
 * <p>
 * Consider the JavaFX example HelloWorld.java (from the section Hello World, JavaFX Style from Getting Started with JavaFX).
 * This sample creates a frame that contains a Say 'Hello World' button.
 * <p>
 * In this example, the method invocation btn.setOnAction specifies what happens when you select the Say 'Hello World' button.
 * This method requires an object of type EventHandler<ActionEvent>. The EventHandler<ActionEvent> interface contains only one method, handle.
 * Instead of implementing this method with a new class, the example uses an anonymous class expression.
 * Notice that this expression is the argument passed to the btn.setOnAction method.
 * <p>
 * Because the EventHandler<ActionEvent> interface contains only one method, you can use a lambda expression instead of an anonymous class expression.
 * See the section Lambda Expressions for more information.
 */
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
