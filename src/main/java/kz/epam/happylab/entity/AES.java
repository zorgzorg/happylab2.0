package kz.epam.happylab.entity;

import kz.epam.happylab.enumtype.Element;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Atomic Emission Spectrometry
 * Laboratory journal (getting records from tables journal_aes)
 */
public class AES extends Journal {
    private double calcium; //Ca
    private double potassium; //K
    private double magnesium; //Mg
    private double sodium; //Na
    private double phosphorus; //P
    private double sulphur; //S;
    private double selenium; //Se
    private double silicon; //Si
    private double tin; //Sn
    private double titanium; //Ti

    public AES() {
    }

    public AES init(HttpServletRequest request){
        AES journal = (AES) new Journal().create(request, new AES());
        journal.setCalcium(Double.parseDouble(request.getParameter(Element.CALCIUM.toString()).trim()));
        journal.setPotassium(Double.parseDouble(request.getParameter(Element.POTASSIUM.toString()).trim()));
        journal.setMagnesium(Double.parseDouble(request.getParameter(Element.MAGNESIUM.toString()).trim()));
        journal.setSodium(Double.parseDouble(request.getParameter(Element.SODIUM.toString()).trim()));
        journal.setPhosphorus(Double.parseDouble(request.getParameter(Element.PHOSPHORUS.toString()).trim()));
        journal.setSulphur(Double.parseDouble(request.getParameter(Element.SULPHUR.toString()).trim()));
        journal.setSelenium(Double.parseDouble(request.getParameter(Element.SELENIUM.toString()).trim()));
        journal.setSilicon(Double.parseDouble(request.getParameter(Element.SILICON.toString()).trim()));
        journal.setTin(Double.parseDouble(request.getParameter(Element.TIN.toString()).trim()));
        journal.setTitanium(Double.parseDouble(request.getParameter(Element.TITANIUM.toString()).trim()));

        return journal;
    }

    public AES init(ResultSet rs) throws SQLException {
        AES journal = (AES) new Journal().create(rs, new AES());
        journal.setCalcium(rs.getDouble(Element.CALCIUM.toString()));
        journal.setPotassium(rs.getDouble(Element.POTASSIUM.toString()));
        journal.setMagnesium(rs.getDouble(Element.MAGNESIUM.toString()));
        journal.setSodium(rs.getDouble(Element.SODIUM.toString()));
        journal.setPhosphorus(rs.getDouble(Element.PHOSPHORUS.toString()));
        journal.setSulphur(rs.getDouble(Element.SULPHUR.toString()));
        journal.setSelenium(rs.getDouble(Element.SELENIUM.toString()));
        journal.setSilicon(rs.getDouble(Element.SILICON.toString()));
        journal.setTin(rs.getDouble(Element.TIN.toString()));
        journal.setTitanium(rs.getDouble(Element.TITANIUM.toString()));

        return journal;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getSulphur() {
        return sulphur;
    }

    public void setSulphur(double sulphur) {
        this.sulphur = sulphur;
    }

    public double getSelenium() {
        return selenium;
    }

    public void setSelenium(double selenium) {
        this.selenium = selenium;
    }

    public double getSilicon() {
        return silicon;
    }

    public void setSilicon(double silicon) {
        this.silicon = silicon;
    }

    public double getTin() {
        return tin;
    }

    public void setTin(double tin) {
        this.tin = tin;
    }

    public double getTitanium() {
        return titanium;
    }

    public void setTitanium(double titanium) {
        this.titanium = titanium;
    }
}
