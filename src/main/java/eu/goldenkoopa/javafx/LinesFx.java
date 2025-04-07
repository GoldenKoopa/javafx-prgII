package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LinesFx extends Application {
  private int WIDTH = 400;
  private int HEIGHT = 400;
  private double currentX;
  private double currentY;
  private static final double STEP = 20;

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    Scene scene = new Scene(pane, WIDTH, HEIGHT);

    currentX = pane.getWidth() / 2;
    currentY = pane.getHeight() / 2;

    scene.setOnKeyPressed(event -> {
      double prevX = currentX;
      double prevY = currentY;

      switch (event.getCode()) {
        case KeyCode.RIGHT:
          if (currentX + STEP <= WIDTH) {
            currentX += STEP;
          }
          break;
        case KeyCode.LEFT:
          if (currentX - STEP >= 0) {
            currentX -= STEP;
          }
          break;
        case KeyCode.UP:
          if (currentY - STEP >= 0) {
            currentY -= STEP;
          }
          break;
        case KeyCode.DOWN:
          if (currentY + STEP <= HEIGHT) {
            currentY += STEP;
          }
          break;
        default:
          break;
      }

      Line line = new Line(prevX, prevY, currentX, currentY);
      line.setStroke(
          Color.rgb((int) ((currentY + prevY) / 2 / HEIGHT * 255),
              0,
              (int) ((currentX + prevX) / 2 / WIDTH * 255)));
      line.setStrokeWidth(5);
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
