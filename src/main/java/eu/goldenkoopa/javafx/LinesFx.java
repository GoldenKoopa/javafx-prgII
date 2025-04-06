package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LinesFx extends Application {
  private double currentX;
  private double currentY;
  private static final double STEP = 20;

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 400, 400);

    currentX = pane.getWidth() / 2;
    currentY = pane.getHeight() / 2;

    scene.setOnKeyPressed(event -> {
      double prevX = currentX;
      double prevY = currentY;

      if (event.getCode() == KeyCode.RIGHT) {
        currentX += STEP;
      } else if (event.getCode() == KeyCode.LEFT) {
        currentX -= STEP;
      } else if (event.getCode() == KeyCode.UP) {
        currentY -= STEP;
      } else if (event.getCode() == KeyCode.DOWN) {
        currentY += STEP;
      }

      Line line = new Line(prevX, prevY, currentX, currentY);
      line.setStroke(Color.BLACK);
      pane.getChildren().add(line);
    });

    primaryStage.setTitle("Draw Lines with Arrow Keys");
    primaryStage.setScene(scene);
    primaryStage.show();

    pane.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
