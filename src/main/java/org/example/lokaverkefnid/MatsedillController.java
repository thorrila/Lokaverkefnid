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
 *Controller fyrir matseðil. Á að taka inn upplýsingar frá Rettur klasanum.
 *Leyfir notenda að velja rétt og fara í nýja senu með því að smella á réttinn.
 *Leyfir notenda að fara leita að rétti og fara í körfu.
 */
public class MatsedillController {
    //Viðmótshlutir fyrir matseðil
    public Button morgunverdurButton;
    public Button kvoldverdurButton;
    public Button hadegisverdurButton;
    public Button drykkirButton;
    public Button karfaButton;
    public Button alltButton;
    @FXML
    private TextField leitTextField;
    @FXML
    private ListView<String> matsedillListView;

    //Allur listinn
    private final ObservableList<String> allurListinn = FXCollections.observableArrayList(
            "Morgunkorn", "Egg og beikon",
            "Salat", "Hamborgari", "Steik", "Samloka",
            "Pítsa", "Kók", "Te", "Kaffi"
    );

    /**
     * Aðferð sem sýnir drykki einungis og felur hina réttina
     */
        @FXML
        private void showDrykkir() {
            matsedillListView.setItems(FXCollections.observableArrayList("Kók", "Te", "Kaffi"));
        }
     /**
     * Aðferð sem sýnir morgunverði einungis og felur hina réttina
     */
        @FXML
        private void showMorgunverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Morgunkorn", "Egg og beikon"));
        }
     /**
     * Aðferð sem sýnir hádegisverði einungis og felur hina réttina
     */
        @FXML
        private void showHadegisverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Salat", "Samloka"));
        }
     /**
     * Aðferð sem sýnir kvöldverði einungis og felur hina réttina
     */
        @FXML
        private void showKvoldverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Steik", "Hamborgari", "Pítsa"));
        }
     /**
     * Aðferð sem sýnir alla rétti
     */
        @FXML
        private void showAllt(){
        matsedillListView.setItems(FXCollections.observableArrayList("Morgunkorn", "Salat", "Hamborgari", "Fiskur", "Samloka", "Steik", "Hamborgari", "Pítsa", "Kók", "Te", "Kaffi"));
        }
     //Skipta um senu yfir í körfu
        private Stage stage;
        private Scene scene;

     /**
     * Aðferð sem sýnir körfuna.
     * @param event Atburður sem kveikti á aðferðinni, framkvæmd með 'Karfa' hnappi
     * @throws IOException Ef það verður villa við að hlaða FXML skránni.
     */
        public void showKarfa(ActionEvent event) throws IOException {
        FXMLLoader karfaLoader = new FXMLLoader(MatsedillApplication.class.getResource("karfa-view.fxml"));
        Parent karfaRoot = karfaLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(karfaRoot);
        stage.setScene(scene);
        stage.show();
        }

    /**
     * Byrjunarstaða matseðils er allur listinn
     */
    @FXML
    private void initialize(){
            matsedillListView.setItems(allurListinn);
            //Listeners á mousclicks
            matsedillListView.setOnMouseClicked(event -> {
                String selectedItem = matsedillListView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    try {
                        showRettur(selectedItem, event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            //Listeners á text field til að filtera með leitarorði
            leitTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                leitarstika(newValue);});
        }

    /**
     * Skiptir yfir í senu út frá hvaða réttur er valinn.
     * @param item
     * @param event Atburður þegar smellt er á rétt í listview.
     * @throws IOException
     */
    private void showRettur(String item, MouseEvent event) throws IOException {
        if (item == null) return; // Ekkert gert ef ekkert er valið
        String fxmlFile = "";
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
                fxmlFile = "gos-view.fxml";
                break;
            case "Te":
                fxmlFile = "te-view.fxml";
                break;
            case "Kaffi":
                fxmlFile = "kaffi-view.fxml";
                break;
            case "Steik":
                fxmlFile = "steik-view.fxml";
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

    /**
     * Aðferð fyrir leitarstikuna.
     * Felur rétti sem uppfylla ekki leitarorð.
     * @param leitarord
     */
    private void leitarstika(String leitarord){
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


