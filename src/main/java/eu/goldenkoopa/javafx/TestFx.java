package eu.goldenkoopa.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestFx extends Application {

    @Override
    public void start(Stage stage) {
        GridPane gridpane = new GridPane();

        // System.out.println(System.getProperty("user.dir"));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ImageView imgView = new ImageView(new Image(
                        "file:src/main/resources/img" + (3-(i * 2 + j)) + ".jpg"));
                imgView.setFitWidth(300);
                imgView.setFitHeight(300);
                gridpane.add(imgView, i, j);
            }
        }

        Scene scene = new Scene(gridpane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

