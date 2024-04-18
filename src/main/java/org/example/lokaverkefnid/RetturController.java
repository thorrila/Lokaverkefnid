package org.example.lokaverkefnid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Controller fyrir senur allra rétta.
 * Leyfir notenda að panta réttinn og fara í körfuna eða til baka í matseðil
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class RetturController {
    //Viðmótshlutir fyrir rétti
    public Button retturKarfa;
    public Button retturMatsedill;
    private Stage stage;
    private Scene scene;

    /**
     * Aðferð sem fer með notenda í aftur matseðil
     *
     * @param event Atburður sem er framkvæmdur þegar smellt er á 'Til baka' hnapp
     * @throws IOException Ef það verður villa við að hlaða FXML skránni.
     */
    public void showMatsedill(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Aðferð sem fer með notenda í körfu
     *
     * @param event Atburður sem er framkvæmdur þegar smellt er á 'Setja í körfu' hnapp
     * @throws IOException Ef það verður villa við að hlaða FXML skránni.
     */
    public void showKarfa(ActionEvent event) throws IOException {
        FXMLLoader karfaLoader = new FXMLLoader(MatsedillApplication.class.getResource("karfa-view.fxml"));
        Parent karfaRoot = karfaLoader.load();
        KarfaController controller = karfaLoader.getController();
        controller.karfaList.setItems(FXCollections.observableArrayList("Kók", "Te", "Kaffi"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(karfaRoot);
        stage.setScene(scene);
        stage.show();

    }
}
