package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorFx extends Application {

  @Override
  public void start(Stage primaryStage) {
    Text text = new Text("show colors");
    text.setFont(Font.font(30));

    Slider sliderRed = createColorSlider();
    Slider sliderGreen = createColorSlider();
    Slider sliderBlue = createColorSlider();
    Slider sliderOpacity = createOpacitySlider();

    Label labelRed = new Label("Red:");
    Label labelGreen = new Label("Green:");
    Label labelBlue = new Label("Blue:");
    Label labelOpacity = new Label("Opacity:");

    ChangeListener<Number> colorChangeListener = (observable, oldValue, newValue) -> {
      double red = sliderRed.getValue() / 255.0;
      double green = sliderGreen.getValue() / 255.0;
      double blue = sliderBlue.getValue() / 255.0;
      double opacity = sliderOpacity.getValue();
      text.setFill(Color.color(red, green, blue, opacity));
    };

    sliderRed.valueProperty().addListener(colorChangeListener);
    sliderGreen.valueProperty().addListener(colorChangeListener);
    sliderBlue.valueProperty().addListener(colorChangeListener);
    sliderOpacity.valueProperty().addListener(colorChangeListener);

    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setAlignment(Pos.CENTER);

    gridPane.add(labelRed, 0, 0);
    gridPane.add(sliderRed, 1, 0);

    gridPane.add(labelGreen, 0, 1);
    gridPane.add(sliderGreen, 1, 1);

    gridPane.add(labelBlue, 0, 2);
    gridPane.add(sliderBlue, 1, 2);

    gridPane.add(labelOpacity, 0, 3);
    gridPane.add(sliderOpacity, 1, 3);

    gridPane.add(text, 0, 4, 2, 1);

    Scene scene = new Scene(gridPane, 400, 300);
    primaryStage.setTitle("Color Selector");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Slider createColorSlider() {
    Slider slider = new Slider(0, 255, 0);
    slider.setShowTickLabels(true);
    slider.setShowTickMarks(true);
    return slider;
  }

  private Slider createOpacitySlider() {
    Slider slider = new Slider(0.0, 1.0, 1.0);
    slider.setShowTickLabels(true);
    slider.setShowTickMarks(true);
    return slider;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
