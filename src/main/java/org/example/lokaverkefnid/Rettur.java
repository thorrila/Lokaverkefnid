package org.example.lokaverkefnid;

/**
 * Klasi fyrir gögn um rétti, svo sem nafn, verð og innihaldslýsing
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class Rettur {
    private String nafn;
    private int verd;
    private String innihaldslysing;

    //Smiður fyrir rétt
    public Rettur(String nafn, int verd, String innihaldslysing) {
        this.nafn = nafn;
        this.verd = verd;
        this.innihaldslysing = innihaldslysing;
    }

    @Override
    public String toString() {
        return nafn + " - " + verd + "kr";
    }

    //Getters og setters
    public String getNafn() {
        return nafn;
    }
    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    public int getVerd() {
        return verd;
    }

    public void setVerd(int verd) {
        this.verd = verd;
    }

    public void setInnihaldslysing(String innihaldslysing) {this.innihaldslysing = innihaldslysing; }
}
