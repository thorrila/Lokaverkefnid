package org.example.lokaverkefnid;

/**
 * @author Þorri Elís Halldóruson teh4@hi.is
 */
public class Rettur {
    private String nafn;
    private int verd;

    public Rettur(String nafn, int verd) {
        this.nafn = nafn;
        this.verd = verd;
    }

    public void CartItem(String name, int price) {
        this.nafn = name;
        this.verd = price;
    }

    @Override
    public String toString() {
        return nafn + " - " + verd + "kr";
    }

    // Getters and setters
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
}
