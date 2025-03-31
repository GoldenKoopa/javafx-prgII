package eu.goldenkoopa.javafx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class EllipsisFx extends Application {

  int WIDTH = 640;
  int HEIGHT = 480;

  @Override
  public void start(Stage stage) {

    Random random = new Random();

    List<Ellipse> ellipses = new ArrayList<>();

    for (int i = 10; i < Math.max(WIDTH, HEIGHT); i += 5) {
      Ellipse ellipse = new Ellipse(WIDTH / 2, HEIGHT / 2, i, 2 * i);
      ellipse.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
      ellipse.setRotate(i / 3);
      ellipses.add(ellipse);
    }

    Pane pane = new Pane();

    Collections.reverse(ellipses);

    ellipses.forEach(ellipse -> pane.getChildren().add(ellipse));

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}
