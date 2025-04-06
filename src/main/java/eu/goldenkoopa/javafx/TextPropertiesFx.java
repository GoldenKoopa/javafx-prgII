package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextPropertiesFx extends Application {

  @Override
  public void start(Stage primaryStage) {
    Label labelAlignment = new Label("Alignment:");
    ComboBox<String> comboBoxAlignment = new ComboBox<>();
    comboBoxAlignment.getItems().addAll("Left", "Center", "Right");
    comboBoxAlignment.setValue("Left");

    Label labelColumnSize = new Label("Column Size:");
    TextField textFieldColumnSize = new TextField();
    textFieldColumnSize.setPromptText("Enter column size");

    TextField textField = new TextField();
    textField.setPrefColumnCount(10);
    textField.setAlignment(Pos.BASELINE_LEFT);

    Button buttonApply = new Button("Apply");

    buttonApply.setOnAction(e -> {
      String alignment = comboBoxAlignment.getValue();
      if (alignment.equals("Left")) {
        textField.setAlignment(Pos.BASELINE_LEFT);
      } else if (alignment.equals("Center")) {
        textField.setAlignment(Pos.BASELINE_CENTER);
      } else if (alignment.equals("Right")) {
        textField.setAlignment(Pos.BASELINE_RIGHT);
      }

      try {
        int columnSize = Integer.parseInt(textFieldColumnSize.getText());
        textField.setPrefColumnCount(columnSize);
      } catch (NumberFormatException ex) {
      }
    });

    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);

    gridPane.add(labelAlignment, 0, 0);
    gridPane.add(comboBoxAlignment, 1, 0);

    gridPane.add(labelColumnSize, 0, 1);
    gridPane.add(textFieldColumnSize, 1, 1);

    gridPane.add(buttonApply, 1, 2);
    gridPane.add(textField, 0, 3, 2, 1);

    gridPane.setAlignment(Pos.CENTER);

    Scene scene = new Scene(gridPane, 400, 200);
    primaryStage.setTitle("TextField Properties Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
