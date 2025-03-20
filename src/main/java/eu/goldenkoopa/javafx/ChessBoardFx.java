package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoardFx extends Application {

  @Override
  public void start(Stage stage) {
    GridPane gridpane = new GridPane();

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        Rectangle rectangle = new Rectangle(20, 20);

        if (j % 2 == i % 2) {
          rectangle.setFill(Color.WHITE);
        } else {
          rectangle.setFill(Color.BLACK);
        }
        gridpane.add(rectangle, i, j);
      }
    }

    gridpane.setBorder(
        new Border(new BorderStroke(
            Color.BLACK, BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    gridpane.setStyle("-fx-background-color: lightgray");

    Scene scene = new Scene(gridpane, 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}
