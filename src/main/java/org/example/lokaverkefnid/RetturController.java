package org.example.lokaverkefnid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class RetturController {
    public Button retturKarfa;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button retturTilBaka;

    public void showMatsedill(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showKarfa(ActionEvent event) throws IOException {
        FXMLLoader karfaLoader = new FXMLLoader(MatsedillApplication.class.getResource("karfa-view.fxml"));
        Parent karfaRoot = karfaLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(karfaRoot);
        stage.setScene(scene);
        stage.show();
    }
}

