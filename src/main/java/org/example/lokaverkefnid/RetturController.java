package org.example.lokaverkefnid;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class RetturController {
    @FXML private Label nafnLabel;
    @FXML private ImageView imageView;
    @FXML private TextArea innihaldTextArea;
    @FXML private TextArea ofnaemiTextArea;
    @FXML private Label verdLabel;

    private Rettur currentRettur;

    public void setRettur(Rettur rettur) {
        currentRettur = rettur;
        nafnLabel.setText(rettur.getNafn());
        imageView.setImage(new Image(rettur.getImagePath()));
        innihaldTextArea.setText(String.join("\n", rettur.getInnihald()));
        ofnaemiTextArea.setText(String.join("\n", rettur.getOfnaemi()));
        verdLabel.setText(String.format("%.2f", rettur.getVerd()));
    }
}
