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
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class RetturController {
    public Button retturKarfa;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button retturTilBaka;

    private ObservableList<Rettur> retturIKorfu = FXCollections.observableArrayList();

    @FXML
    private void addToCart() {
        // Assuming you have access to the item name and price here
        String itemNafn = "Hamborgari"; // This should come from the item's actual data
        int itemVerd = 1200; // This should come from the item's actual data

        retturIKorfu.add(new Rettur(itemNafn, itemVerd));
        // You might want to switch to the cart scene here or update a ListView in the current scene
    }

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
        //
        RetturController retturController = karfaLoader.getController();
        retturController.setRettur(retturIKorfu);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(karfaRoot);
        stage.setScene(scene);
        stage.show();
    }
    private ListView<String> cartListView;

    public void setRettur(ObservableList<Rettur> items) {
        List<String> itemDescriptions = items.stream()
                .map(Rettur::toString)
                .collect(Collectors.toList());
        cartListView.setItems(FXCollections.observableArrayList(itemDescriptions));
    }
}

