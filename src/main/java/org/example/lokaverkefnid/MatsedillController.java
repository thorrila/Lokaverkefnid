package org.example.lokaverkefnid;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

        //Byrjunarstaða matseðils
        @FXML
        private void initialize(){
            matsedillListView.setItems(FXCollections.observableArrayList("Morgunkorn", "Jógúrt", "Pönnukökur", "Egg og beikon", "Ristað brauð", "Salat", "Hamborgari", "Fiskur", "Steik", "Samloka", "Steik", "Kjúklingur", "Hamborgari", "Pítsa", "Fiskur", "Kók", "Pepsí", "Sódavatn", "Hvítvín", "Rauðvín", "Te", "Kaffi"));
        }

}