package eu.goldenkoopa.javafx;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Circles extends Application {

  int WIDTH = 640;
  int HEIGHT = 480;
  int RADIUS = 15;

  @Override
  public void start(Stage stage) {

    Random random = new Random();



    int x1 = RADIUS + random.nextInt(WIDTH - 2 * RADIUS);
    int y1 = RADIUS + random.nextInt(HEIGHT - 2 * RADIUS);
    int x2 = RADIUS + random.nextInt(WIDTH - 2 * RADIUS);
    int y2 = RADIUS + random.nextInt(HEIGHT - 2 * RADIUS);

    Circle circle1 = new Circle(x1, y1, RADIUS);
    Circle circle2 = new Circle(x2, y2, RADIUS);

    Line line = new Line(x1, y1, x2, y2);

    Text lengthText = new Text();
    lengthText.setText(Double.toString(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))));
    lengthText.setLayoutX((x1 + x2) / 2);
    lengthText.setLayoutY((y1 + y2) / 2);


    Pane pane = new Pane();
    pane.getChildren().add(circle1);
    pane.getChildren().add(circle2);
    pane.getChildren().add(line);
    pane.getChildren().add(lengthText);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}
