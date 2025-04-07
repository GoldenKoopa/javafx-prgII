package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Shapes extends Application {

  private StackPane drawingPane = new StackPane();

  @Override
  public void start(Stage primaryStage) {
    RadioButton radioButtonCircle = new RadioButton("Circle");
    RadioButton radioButtonRectangle = new RadioButton("Rectangle");
    RadioButton radioButtonEllipse = new RadioButton("Ellipse");

    ToggleGroup group = new ToggleGroup();
    radioButtonCircle.setToggleGroup(group);
    radioButtonRectangle.setToggleGroup(group);
    radioButtonEllipse.setToggleGroup(group);

    CheckBox checkBoxFill = new CheckBox("Fill");

    HBox controls = new HBox(10, radioButtonCircle, radioButtonRectangle, radioButtonEllipse, checkBoxFill);
    controls.setAlignment(Pos.CENTER);
    controls.setPadding(new Insets(10));

    group.selectedToggleProperty()
        .addListener(
            (observable, oldValue, newValue) -> drawShape((RadioButton) newValue, checkBoxFill.isSelected()));
    checkBoxFill.selectedProperty().addListener((observable, oldValue, newValue) -> {
      if (group.getSelectedToggle() != null) {
        drawShape((RadioButton) group.getSelectedToggle(), newValue);
      }
    });

    BorderPane root = new BorderPane();
    root.setCenter(drawingPane);
    root.setBottom(controls);

    Scene scene = new Scene(root, 400, 400);
    primaryStage.setTitle("Geometric Figures");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void drawShape(RadioButton selectedShape, boolean isFilled) {
    drawingPane.getChildren().clear();

    if (selectedShape == null) {
      return;
    }

    switch (selectedShape.getText()) {
      case "Circle":
        Circle circle = new Circle(200, 200, 50);
        circle.setStroke(Color.BLACK);
        circle.setFill(isFilled ? Color.BLUE : Color.TRANSPARENT);
        drawingPane.getChildren().add(circle);
        break;

      case "Rectangle":
        Rectangle rectangle = new Rectangle(150, 170, 100, 60);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(isFilled ? Color.GREEN : Color.TRANSPARENT);
        drawingPane.getChildren().add(rectangle);
        break;

      case "Ellipse":
        Ellipse ellipse = new Ellipse(200, 200, 80, 40);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(isFilled ? Color.RED : Color.TRANSPARENT);
        drawingPane.getChildren().add(ellipse);
        break;

      default:
        break;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
