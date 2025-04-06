package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BallFx extends Application {
  private static final double RADIUS = 20;
  private static final double STEP = 10;
  private static final Color COLOR = Color.GREEN;

  @Override
  public void start(Stage primaryStage) {
    BallPane ballPane = new BallPane();
    ballPane.setPrefSize(400, 400);

    Button btnLeft = new Button("Left");
    Button btnRight = new Button("Right");
    Button btnUp = new Button("Up");
    Button btnDown = new Button("Down");

    btnLeft.setOnAction(e -> ballPane.moveLeft());
    btnRight.setOnAction(e -> ballPane.moveRight());
    btnUp.setOnAction(e -> ballPane.moveUp());
    btnDown.setOnAction(e -> ballPane.moveDown());

    HBox controls = new HBox(10, btnLeft, btnRight, btnUp, btnDown);
    controls.setAlignment(Pos.CENTER);
    controls.setPadding(new Insets(10));

    BorderPane root = new BorderPane();
    root.setCenter(ballPane);
    root.setBottom(controls);

    Scene scene = new Scene(root, 400, 400);
    primaryStage.setTitle("Movable Ball");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  class BallPane extends Pane {
    private Circle circle = new Circle(RADIUS);
    private double x = 100, y = 100;

    public BallPane() {
      circle.setFill(COLOR);
      getChildren().add(circle);
      updatePosition();

      // window resiziung
      widthProperty().addListener(ov -> checkBoundaries());
      heightProperty().addListener(ov -> checkBoundaries());
    }

    private void updatePosition() {
      circle.setCenterX(x);
      circle.setCenterY(y);
    }

    private void checkBoundaries() {
      if (x < RADIUS)
        x = RADIUS;
      if (x > getWidth() - RADIUS)
        x = getWidth() - RADIUS;
      if (y < RADIUS)
        y = RADIUS;
      if (y > getHeight() - RADIUS)
        y = getHeight() - RADIUS;
      updatePosition();
    }

    public void moveLeft() {
      x -= STEP;
      checkBoundaries();
    }

    public void moveRight() {
      x += STEP;
      checkBoundaries();
    }

    public void moveUp() {
      y -= STEP;
      checkBoundaries();
    }

    public void moveDown() {
      y += STEP;
      checkBoundaries();
    }
  }

}
