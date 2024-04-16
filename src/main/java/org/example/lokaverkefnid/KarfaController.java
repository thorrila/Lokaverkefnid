package org.example.lokaverkefnid;

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

/**
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class KarfaController {

    public Button karfaGreida;
    public ListView<String> karfaList;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button karfaTilBaka;

    public void showMatsedill(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showTakk(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("takk-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
