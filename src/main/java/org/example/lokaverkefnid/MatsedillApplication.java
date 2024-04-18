package org.example.lokaverkefnid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main klasi forritsins. Opnar heimasíðuna, þ.e.a.s. matseðilinn.
 */
public class MatsedillApplication extends Application {
    /**
     * Byrjar JavaFX forritið. Þetta er aðal inngangspunkturinn fyrir JavaFX hlutann.
     *
     * @param stage Sviðið sem notar JavaFX til að sýna forritsglugga.
     * @throws IOException Ef það verður villa við að hlaða FXML skránni.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader matsedillLoader = new FXMLLoader(MatsedillApplication.class.getResource("matsedill-view.fxml"));
        Parent matsedillRoot = matsedillLoader.load();
        Scene matsedill = new Scene(matsedillRoot, 600, 500); //(parent, width, height)
        stage.setTitle("Lokaverkefni");
        stage.setScene(matsedill);
        stage.show();
    }
    /**
     * Aðal aðferð sem ræsir JavaFX forritið. Þetta er inngangspunkturinn fyrir öll Java forrit.
     *
     * @param args Fylki af strengjum sem inniheldur röðunarlínu viðföng sem forritið gæti þurft.
     */
    public static void main(String[] args) {
        launch();
    }
}