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
 *Controller fyrir körfu
 *Þessi klasi sér um að meðhöndla notendaviðmótshandlinga sem tengjast körfunni,
 *eins og að fara til baka til matsedils eða halda áfram til staðfestingar.
 *
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class KarfaController {
    //Viðmótshlutir fyrir körfu
    @FXML
    public ListView<String> karfaList;
    public Button karfaGreida;
    public Button karfaTilBaka;

    /**
     * Aðferð sem sýnir matsedilinn. Þessi aðferð er kölluð þegar notandi ætlar að fara aftur á matsedils skjáinn.
     *
     * @param event Atburður sem kveikti á aðferðinni, framkvæmd með 'Til baka' hnappi
     * @throws IOException Ef það verður villa við að hlaða FXML skránni fyrir matsedilinn.
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
     * Aðferð sem síðuna þegar notandi er búinn að panta. Þessi aðferð er kölluð þegar notandi ætlar að ljúka pöntun og greiða.
     *
     * @param event Atburður sem kveikti á aðferðinni, framkvæmd með 'Greiða' hnappi
     * @throws IOException Ef það verður villa við að hlaða FXML skránni fyrir síðuna.
     */
    public void showTakk(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("takk-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
