package kz.epam.happylab.entity;

import kz.epam.happylab.enumtype.Element;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Semiquantitative spectral analysis
 * Laboratory journal (getting records from tables journal_ssa) 
 */
public class SSA extends Journal {
    private double gold; //Au
    private double cerium; //Ce
    private double gallium; //Ga
    private double germanium; //Ge
    private double hafnium; //Hf
    private double indium; //In
    private double lanthanum; //La
    private double niobium; //Nb
    private double phosphorus; //P
    private double platinum; //Pt
    private double scandium; //Sc
    private double tin; //Sn
    private double tantalum; //Ta
    private double tellurium; //Te
    private double thorium; //Th
    private double titanium; //Ti
    private double uranium; //U
    private double yttrium; //Y
    private double ytterbium; //Yb
    private double zirconium; //Zr

    public SSA() {
    }

    public SSA init(HttpServletRequest request){
        SSA journal = (SSA) new Journal().create(request, new SSA());
        journal.setGold(Double.parseDouble(request.getParameter(Element.GOLD.toString()).trim()));
        journal.setCerium(Double.parseDouble(request.getParameter(Element.CERIUM.toString()).trim()));
        journal.setGallium(Double.parseDouble(request.getParameter(Element.GALLIUM.toString()).trim()));
        journal.setGermanium(Double.parseDouble(request.getParameter(Element.GERMANIUM.toString()).trim()));
        journal.setHafnium(Double.parseDouble(request.getParameter(Element.HAFNIUM.toString()).trim()));
        journal.setIndium(Double.parseDouble(request.getParameter(Element.INDIUM.toString()).trim()));
        journal.setLanthanum(Double.parseDouble(request.getParameter(Element.LANTHANUM.toString()).trim()));
        journal.setNiobium(Double.parseDouble(request.getParameter(Element.NIOBIUM.toString()).trim()));
        journal.setPhosphorus(Double.parseDouble(request.getParameter(Element.PHOSPHORUS.toString()).trim()));
        journal.setPlatinum(Double.parseDouble(request.getParameter(Element.PLATINUM.toString()).trim()));
        journal.setScandium(Double.parseDouble(request.getParameter(Element.SCANDIUM.toString()).trim()));
        journal.setTin(Double.parseDouble(request.getParameter(Element.TIN.toString()).trim()));
        journal.setTantalum(Double.parseDouble(request.getParameter(Element.TANTALUM.toString()).trim()));
        journal.setTellurium(Double.parseDouble(request.getParameter(Element.TELLURIUM.toString()).trim()));
        journal.setThorium(Double.parseDouble(request.getParameter(Element.THORIUM.toString()).trim()));
        journal.setTitanium(Double.parseDouble(request.getParameter(Element.TITANIUM.toString()).trim()));
        journal.setUranium(Double.parseDouble(request.getParameter(Element.URANIUM.toString()).trim()));
        journal.setYttrium(Double.parseDouble(request.getParameter(Element.YTTRIUM.toString()).trim()));
        journal.setYtterbium(Double.parseDouble(request.getParameter(Element.YTTERBIUM.toString()).trim()));
        journal.setZirconium(Double.parseDouble(request.getParameter(Element.ZIRCONIUM.toString()).trim()));

        return journal;
    }

    public SSA init(ResultSet rs) throws SQLException {
        SSA journal = (SSA) new Journal().create(rs, new SSA());
        journal.setGold(rs.getDouble(Element.GOLD.toString()));
        journal.setCerium(rs.getDouble(Element.CERIUM.toString()));
        journal.setGallium(rs.getDouble(Element.GALLIUM.toString()));
        journal.setGermanium(rs.getDouble(Element.GERMANIUM.toString()));
        journal.setHafnium(rs.getDouble(Element.HAFNIUM.toString()));
        journal.setIndium(rs.getDouble(Element.INDIUM.toString()));
        journal.setLanthanum(rs.getDouble(Element.LANTHANUM.toString()));
        journal.setNiobium(rs.getDouble(Element.NIOBIUM.toString()));
        journal.setPhosphorus(rs.getDouble(Element.PHOSPHORUS.toString()));
        journal.setPlatinum(rs.getDouble(Element.PLATINUM.toString()));
        journal.setScandium(rs.getDouble(Element.SCANDIUM.toString()));
        journal.setTin(rs.getDouble(Element.TIN.toString()));
        journal.setTantalum(rs.getDouble(Element.TANTALUM.toString()));
        journal.setTellurium(rs.getDouble(Element.TELLURIUM.toString()));
        journal.setThorium(rs.getDouble(Element.THORIUM.toString()));
        journal.setTitanium(rs.getDouble(Element.TITANIUM.toString()));
        journal.setUranium(rs.getDouble(Element.URANIUM.toString()));
        journal.setYttrium(rs.getDouble(Element.YTTRIUM.toString()));
        journal.setYtterbium(rs.getDouble(Element.YTTERBIUM.toString()));
        journal.setZirconium(rs.getDouble(Element.ZIRCONIUM.toString()));

        return journal;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getCerium() {
        return cerium;
    }

    public void setCerium(double cerium) {
        this.cerium = cerium;
    }

    public double getGallium() {
        return gallium;
    }

    public void setGallium(double gallium) {
        this.gallium = gallium;
    }

    public double getGermanium() {
        return germanium;
    }

    public void setGermanium(double germanium) {
        this.germanium = germanium;
    }

    public double getHafnium() {
        return hafnium;
    }

    public void setHafnium(double hafnium) {
        this.hafnium = hafnium;
    }

    public double getIndium() {
        return indium;
    }

    public void setIndium(double indium) {
        this.indium = indium;
    }

    public double getLanthanum() {
        return lanthanum;
    }

    public void setLanthanum(double lanthanum) {
        this.lanthanum = lanthanum;
    }

    public double getNiobium() {
        return niobium;
    }

    public void setNiobium(double niobium) {
        this.niobium = niobium;
    }

    public double getPlatinum() {
        return platinum;
    }

    public void setPlatinum(double platinum) {
        this.platinum = platinum;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getScandium() {
        return scandium;
    }

    public void setScandium(double scandium) {
        this.scandium = scandium;
    }

    public double getTin() {
        return tin;
    }

    public void setTin(double tin) {
        this.tin = tin;
    }

    public double getTantalum() {
        return tantalum;
    }

    public void setTantalum(double tantalum) {
        this.tantalum = tantalum;
    }

    public double getTellurium() {
        return tellurium;
    }

    public void setTellurium(double tellurium) {
        this.tellurium = tellurium;
    }

    public double getThorium() {
        return thorium;
    }

    public void setThorium(double thorium) {
        this.thorium = thorium;
    }

    public double getTitanium() {
        return titanium;
    }

    public void setTitanium(double titanium) {
        this.titanium = titanium;
    }

    public double getUranium() {
        return uranium;
    }

    public void setUranium(double uranium) {
        this.uranium = uranium;
    }

    public double getYttrium() {
        return yttrium;
    }

    public void setYttrium(double yttrium) {
        this.yttrium = yttrium;
    }

    public double getYtterbium() {
        return ytterbium;
    }

    public void setYtterbium(double ytterbium) {
        this.ytterbium = ytterbium;
    }

    public double getZirconium() {
        return zirconium;
    }

    public void setZirconium(double zirconium) {
        this.zirconium = zirconium;
    }
}
