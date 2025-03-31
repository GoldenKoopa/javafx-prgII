package eu.goldenkoopa.javafx;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VerticalFx extends Application {

  @Override
  public void start(Stage stage) {
    Random random = new Random();
    GridPane gridpane = new GridPane();

    for (int i = 0; i < 5; i++) {
      Text text = new Text("Java");
      text.setFont(Font.font("Times Roman", FontWeight.BOLD, 22));
      text.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
      text.setOpacity(random.nextDouble());
      text.setRotate(90);
      gridpane.add(text, i, 0);
    }

    gridpane.setLayoutX(10);
    gridpane.setLayoutY(20);

    Scene scene = new Scene(gridpane, 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}
