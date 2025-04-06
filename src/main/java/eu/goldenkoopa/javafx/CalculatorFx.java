package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CalculatorFx extends Application {

  @Override
  public void start(Stage primaryStage) {
    Label labelNum1 = new Label("Number 1:");
    Label labelNum2 = new Label("Number 2:");
    Label labelResult = new Label("Result:");

    TextField textFieldNum1 = new TextField();
    TextField textFieldNum2 = new TextField();
    TextField textFieldResult = new TextField();
    textFieldResult.setEditable(false);

    Button btnAdd = new Button("Add");
    Button btnSubtract = new Button("Subtract");
    Button btnMultiply = new Button("Multiply");
    Button btnDivide = new Button("Divide");

    btnAdd.setOnAction(e -> {
      try {
        double num1 = Double.parseDouble(textFieldNum1.getText());
        double num2 = Double.parseDouble(textFieldNum2.getText());
        textFieldResult.setText(String.valueOf(num1 + num2));
      } catch (NumberFormatException ex) {
        textFieldResult.setText("Invalid input!");
      }
    });

    btnSubtract.setOnAction(e -> {
      try {
        double num1 = Double.parseDouble(textFieldNum1.getText());
        double num2 = Double.parseDouble(textFieldNum2.getText());
        textFieldResult.setText(String.valueOf(num1 - num2));
      } catch (NumberFormatException ex) {
        textFieldResult.setText("Invalid input!");
      }
    });

    btnMultiply.setOnAction(e -> {
      try {
        double num1 = Double.parseDouble(textFieldNum1.getText());
        double num2 = Double.parseDouble(textFieldNum2.getText());
        textFieldResult.setText(String.valueOf(num1 * num2));
      } catch (NumberFormatException ex) {
        textFieldResult.setText("Invalid input!");
      }
    });

    btnDivide.setOnAction(e -> {
      try {
        double num1 = Double.parseDouble(textFieldNum1.getText());
        double num2 = Double.parseDouble(textFieldNum2.getText());
        if (num2 == 0) {
          textFieldResult.setText("Cannot divide by zero!");
        } else {
          textFieldResult.setText(String.valueOf(num1 / num2));
        }
      } catch (NumberFormatException ex) {
        textFieldResult.setText("Invalid input!");
      }
    });

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setHgap(10);
    gridPane.setVgap(10);

    gridPane.add(labelNum1, 0, 0);
    gridPane.add(textFieldNum1, 1, 0);

    gridPane.add(labelNum2, 0, 1);
    gridPane.add(textFieldNum2, 1, 1);

    gridPane.add(labelResult, 0, 2);
    gridPane.add(textFieldResult, 1, 2);

    HBox buttonBox = new HBox(10, btnAdd, btnSubtract, btnMultiply, btnDivide);
    buttonBox.setAlignment(Pos.CENTER);

    gridPane.add(buttonBox, 0, 3, 2, 1);

    Scene scene = new Scene(gridPane, 400, 200);
    primaryStage.setTitle("Simple Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
