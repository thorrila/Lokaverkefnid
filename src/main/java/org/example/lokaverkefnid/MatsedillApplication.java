package org.example.lokaverkefnid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MatsedillApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Loada fxml fyrir senu matseðils (forsíðu)
        FXMLLoader matsedillLoader = new FXMLLoader(MatsedillApplication.class.getResource("matsedill-view.fxml"));
        Parent matsedillRoot = matsedillLoader.load();
        Scene matsedill = new Scene(matsedillRoot, 600, 500); //(parent, width, height)


        //Setja upp senu fyrir matseðil
        stage.setTitle("Lokaverkefni");
        stage.setScene(matsedill);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}