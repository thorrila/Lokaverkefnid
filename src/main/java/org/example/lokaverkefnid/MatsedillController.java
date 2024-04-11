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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 *
 */
public class MatsedillController {
    //viðmótshlutir fyrir matseðil
    @FXML
    private TextField leitTextField;
    @FXML
    private ListView<String> matsedillListView;
    @FXML

    private Button alltButton;
    @FXML
    private Button kvoldverdurButton;
    @FXML
    private Button morgunverdurButton;
    @FXML
    private Button hadegisverdurButton;
    @FXML
    private Button drykkirButton;
    @FXML
    private Button karfaButton;
    //Allur listinn
    private final ObservableList<String> allurListinn = FXCollections.observableArrayList(
            "Morgunkorn", "Egg og beikon",
            "Salat", "Hamborgari", "Steik", "Samloka",
            "Pítsa", "Kók", "Te", "Kaffi"
    );
    //viðmótshlutir fyrir rétti

    //viðmótshlutir fyrir körfu
    @FXML
    private Button karfaTilBaka;
    @FXML
    private Button karfaGreida;

    //Skipta um senu yfir í körfu
    private Stage stage;
    private Scene scene;

    public void showKarfa(ActionEvent event) throws IOException {
        FXMLLoader karfaLoader = new FXMLLoader(MatsedillApplication.class.getResource("karfa-view.fxml"));
        Parent karfaRoot = karfaLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(karfaRoot);
        stage.setScene(scene);
        stage.show();
    }

        @FXML
        private void showDrykkir() {
            matsedillListView.setItems(FXCollections.observableArrayList("Kók", "Te", "Kaffi"));
        }
        @FXML
        private void showMorgunverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Morgunkorn", "Egg og beikon"));
        }
        @FXML
        private void showHadegisverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Salat", "Samloka"));
        }
        @FXML
        private void showKvoldverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Steik", "Hamborgari", "Pítsa"));
        }
        @FXML
        private void showAllt(){
        matsedillListView.setItems(FXCollections.observableArrayList("Morgunkorn", "Salat", "Hamborgari", "Fiskur", "Samloka", "Steik", "Hamborgari", "Pítsa", "Kók", "Te", "Kaffi"));
        }


        @FXML
        private void initialize(){
            //Byrjunarstaða matseðils er allur listinn
            matsedillListView.setItems(allurListinn);
            //Listeners á mousclicks
            matsedillListView.setOnMouseClicked(event -> {
                String selectedItem = matsedillListView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    try {
                        switchToSceneBasedOnItem(selectedItem, event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            //Listeners á text field til að filtera með leitarorði
            leitTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filterList(newValue);});
        }

    private void switchToSceneBasedOnItem(String item, MouseEvent event) throws IOException {
        if (item == null) return; // Nothing to do if no item is selected

        String fxmlFile = ""; // Default FXML file
        // Determine the scene to load based on the selected item
        switch (item) {
            case "Morgunkorn":
                fxmlFile = "morgunkorn-view.fxml";
                break;
            case "Egg og beikon":
                fxmlFile = "eggogbeikon-view.fxml";
                break;
            case "Salat":
                fxmlFile = "salat-view.fxml";
                break;
            case "Hamborgari":
                fxmlFile = "hamborgari-view.fxml";
                break;
            case "Samloka":
                fxmlFile = "samloka-view.fxml";
                break;
            case "Pítsa":
                fxmlFile = "pitsa-view.fxml";
                break;
            case "Kók":
                fxmlFile = "kok-view.fxml";
                break;
            case "Te":
                fxmlFile = "te-view.fxml";
                break;
            case "Kaffi":
                fxmlFile = "kaffi-view.fxml";
                break;
        }

        if (!fxmlFile.isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
        //Leitarstika
        private void filterList(String leitarord){
                if (leitarord.isEmpty()) {
                    matsedillListView.setItems(allurListinn);
                }
                else
                {ObservableList<String> filteredList = allurListinn.stream()
                            .filter(item -> item.toLowerCase().contains(leitarord.toLowerCase()))
                            .collect(Collectors.toCollection(FXCollections::observableArrayList));
                    matsedillListView.setItems(filteredList);
                }
            }
        }


