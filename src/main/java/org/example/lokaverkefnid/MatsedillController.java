package org.example.lokaverkefnid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    private ObservableList<String> allurListinn = FXCollections.observableArrayList(
            "Morgunkorn", "Jógúrt", "Pönnukökur", "Egg og beikon", "Ristað brauð",
            "Salat", "Hamborgari", "Fiskur", "Steik", "Samloka", "Kjúklingur",
            "Pítsa", "Kók", "Pepsí", "Sódavatn", "Hvítvín", "Rauðvín", "Te", "Kaffi"
    );
    //viðmótshlutir fyrir rétti

    //viðmótshlutir fyrir körfu
    @FXML
    private Button karfaTilBaka;
    @FXML
    private Button karfaGreida;


        @FXML
        private void showDrykkir() {
            matsedillListView.setItems(FXCollections.observableArrayList("Kók", "Pepsí", "Sódavatn", "Hvítvín", "Rauðvín", "Te", "Kaffi"));
        }
        @FXML
        private void showMorgunverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Morgunkorn", "Jógúrt", "Pönnukökur", "Egg og beikon", "Ristað brauð"));
        }
        @FXML
        private void showHadegisverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Salat", "Hamborgari", "Fiskur", "Steik", "Samloka"));
        }
        @FXML
        private void showKvoldverdur(){
            matsedillListView.setItems(FXCollections.observableArrayList("Steik", "Kjúklingur", "Hamborgari", "Pítsa", "Fiskur"));
        }
        @FXML
        private void showAllt(){
        matsedillListView.setItems(FXCollections.observableArrayList("Morgunkorn", "Jógúrt", "Pönnukökur", "Egg og beikon", "Ristað brauð", "Salat", "Hamborgari", "Fiskur", "Steik", "Samloka", "Steik", "Kjúklingur", "Hamborgari", "Pítsa", "Fiskur", "Kók", "Pepsí", "Sódavatn", "Hvítvín", "Rauðvín", "Te", "Kaffi"));
    }
        @FXML
        private void initialize(){
            //Byrjunarstaða matseðils er allur listinn
            matsedillListView.setItems(allurListinn);
            //Listeners á text field til að filtera með leitarorði
            leitTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filterList(newValue);});
        }
        public void filterList(String leitarord){
               //ef ekkert er skrifað er listinn í heild sinni óbreyttur
                if (leitarord.isEmpty()) {
                    matsedillListView.setItems(allurListinn);
                }
                //ef leitarord er skrifað er listinn filteraður
                else
                {ObservableList<String> filteredList = allurListinn.stream()
                            .filter(item -> item.toLowerCase().contains(leitarord.toLowerCase()))
                            .collect(Collectors.toCollection(FXCollections::observableArrayList));
                    matsedillListView.setItems(filteredList);
                }
            }

        }


