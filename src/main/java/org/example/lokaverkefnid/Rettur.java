package org.example.lokaverkefnid;

import java.util.List;

/**
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class Rettur {
    private String nafn;
    private List<String> innihald;
    private List<String> ofnaemi;
    private double verd;
    //laga þetta
    private String imagePath;

    //smiður
    public Rettur(String nafn, List<String> innihald, List<String> ofnaemi, double verd, String imagePath) {
        this.nafn = nafn;
        this.innihald = innihald;
        this.ofnaemi = ofnaemi;
        this.verd = verd;
        this.imagePath = imagePath;
    }
    public String getNafn() {
        return nafn;
    }

    public List<String> getInnihald() {
        return innihald;
    }

    public List<String> getOfnaemi() {
        return ofnaemi;
    }

    public double getVerd() {
        return verd;
    }

    public String getImagePath() {
        return imagePath;
    }
}
