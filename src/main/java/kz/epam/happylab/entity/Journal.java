package kz.epam.happylab.entity;

import kz.epam.happylab.util.DateFormatter;
import kz.epam.happylab.enumtype.Element;
import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static kz.epam.happylab.constant.Common.*;

/**
 * Laboratory journal (getting records from tables journal_aes, journal_ssa, journal_sanpin)
 * @author Cate
 */
public class Journal extends Entity{
    private int probeId;
    private int numberLab;
    private Date date;
    private int employeeId;
    private String assistant;
    //Common
    private double aluminium; //Al
    private double silver; //Ag;
    private double arsenic; //As
    private double boron; //B
    private double barium; //Ba
    private double beryllium; //Be
    private double bismuth; //Bi;
    private double cadmium; //Cd
    private double cobalt; //Co;
    private double chromium; //Cr;
    private double copper; //Cu;
    private double iron; //Fe
    private double lithium; //Li
    private double manganese; //Mn
    private double molybdenum; //Mo
    private double nickel; //Ni
    private double lead; //Pb
    private double antimony; //Sb
    private double strontium; //Sr
    private double thallium; //Tl
    private double vanadium; //V
    private double tungsten; //W
    private double zinc; //Zn

    public Journal() {
    }

    public Journal create(HttpServletRequest request, Journal journal){
        journal.setId(ParameterRequest.getParameter(request, RECORD_ID));
        journal.setProbeId(Integer.parseInt(request.getParameter(PROBE_ID).trim()));
        journal.setDate(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE).trim())));
        journal.setEmployeeId(Integer.parseInt(request.getParameter(EMPLOYEE_ID).trim()));
        journal.setSilver(Double.parseDouble(request.getParameter(Element.SILVER.toString()).trim()));
        journal.setAluminium(Double.parseDouble(request.getParameter(Element.ALUMINIUM.toString()).trim()));
        journal.setArsenic(Double.parseDouble(request.getParameter(Element.ARSENIC.toString()).trim()));
        journal.setBoron(Double.parseDouble(request.getParameter(Element.BORON.toString()).trim()));
        journal.setBarium(Double.parseDouble(request.getParameter(Element.BARIUM.toString()).trim()));
        journal.setBeryllium(Double.parseDouble(request.getParameter(Element.BERYLLIUM.toString()).trim()));
        journal.setBismuth(Double.parseDouble(request.getParameter(Element.BISMUTH.toString()).trim()));
        journal.setCadmium(Double.parseDouble(request.getParameter(Element.CADMIUM.toString()).trim()));
        journal.setCobalt(Double.parseDouble(request.getParameter(Element.COBALT.toString()).trim()));
        journal.setChromium(Double.parseDouble(request.getParameter(Element.CHROMIUM.toString()).trim()));
        journal.setCopper(Double.parseDouble(request.getParameter(Element.COPPER.toString()).trim()));
        journal.setIron(Double.parseDouble(request.getParameter(Element.IRON.toString()).trim()));
        journal.setLithium(Double.parseDouble(request.getParameter(Element.LITHIUM.toString()).trim()));
        journal.setManganese(Double.parseDouble(request.getParameter(Element.MANGANESE.toString()).trim()));
        journal.setMolybdenum(Double.parseDouble(request.getParameter(Element.MOLYBDENUM.toString()).trim()));
        journal.setNickel(Double.parseDouble(request.getParameter(Element.NICKEL.toString()).trim()));
        journal.setLead(Double.parseDouble(request.getParameter(Element.LEAD.toString()).trim()));
        journal.setAntimony(Double.parseDouble(request.getParameter(Element.ANTIMONY.toString()).trim()));
        journal.setStrontium(Double.parseDouble(request.getParameter(Element.STRONTIUM.toString()).trim()));
        journal.setThallium(Double.parseDouble(request.getParameter(Element.THALLIUM.toString()).trim()));
        journal.setVanadium(Double.parseDouble(request.getParameter(Element.VANADIUM.toString()).trim()));
        journal.setTungsten(Double.parseDouble(request.getParameter(Element.TUNGSTEN.toString()).trim()));
        journal.setZinc(Double.parseDouble(request.getParameter(Element.ZINC.toString()).trim()));

        return journal;
    }

    public Journal create(ResultSet rs, Journal journal) throws SQLException {
        journal.setId(rs.getInt(ID));
        journal.setProbeId(rs.getInt(PROBE_ID));
        journal.setDate(rs.getDate(DATE));
        journal.setAssistant(rs.getString(ASSISTANT));
        journal.setEmployeeId(rs.getInt(EMPLOYEE_ID));
        journal.setNumberLab(rs.getInt(NUMBER_LAB));
        journal.setSilver(rs.getDouble(Element.SILVER.toString()));
        journal.setAluminium(rs.getDouble(Element.ALUMINIUM.toString()));
        journal.setArsenic(rs.getDouble(Element.ARSENIC.toString()));
        journal.setBoron(rs.getDouble(Element.BORON.toString()));
        journal.setBarium(rs.getDouble(Element.BARIUM.toString()));
        journal.setBeryllium(rs.getDouble(Element.BERYLLIUM.toString()));
        journal.setBismuth(rs.getDouble(Element.BISMUTH.toString()));
        journal.setCadmium(rs.getDouble(Element.CADMIUM.toString()));
        journal.setCobalt(rs.getDouble(Element.COBALT.toString()));
        journal.setChromium(rs.getDouble(Element.CHROMIUM.toString()));
        journal.setCopper(rs.getDouble(Element.COPPER.toString()));
        journal.setIron(rs.getDouble(Element.IRON.toString()));
        journal.setLithium(rs.getDouble(Element.LITHIUM.toString()));
        journal.setManganese(rs.getDouble(Element.MANGANESE.toString()));
        journal.setMolybdenum(rs.getDouble(Element.MOLYBDENUM.toString()));
        journal.setNickel(rs.getDouble(Element.NICKEL.toString()));
        journal.setLead(rs.getDouble(Element.LEAD.toString()));
        journal.setAntimony(rs.getDouble(Element.ANTIMONY.toString()));
        journal.setStrontium(rs.getDouble(Element.STRONTIUM.toString()));
        journal.setThallium(rs.getDouble(Element.THALLIUM.toString()));
        journal.setVanadium(rs.getDouble(Element.VANADIUM.toString()));
        journal.setTungsten(rs.getDouble(Element.TUNGSTEN.toString()));
        journal.setZinc(rs.getDouble(Element.ZINC.toString()));

        return journal;
    }

    public int getProbeId() {
        return probeId;
    }

    public void setProbeId(int probeId) {
        this.probeId = probeId;
    }

    public int getNumberLab() {
        return numberLab;
    }

    public void setNumberLab(int numberLab) {
        this.numberLab = numberLab;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public double getAluminium() {
        return aluminium;
    }

    public void setAluminium(double aluminium) {
        this.aluminium = aluminium;
    }

    public double getSilver() {
        return silver;
    }

    public void setSilver(double silver) {
        this.silver = silver;
    }

    public double getArsenic() {
        return arsenic;
    }

    public void setArsenic(double arsenic) {
        this.arsenic = arsenic;
    }

    public double getBoron() {
        return boron;
    }

    public void setBoron(double boron) {
        this.boron = boron;
    }

    public double getBarium() {
        return barium;
    }

    public void setBarium(double barium) {
        this.barium = barium;
    }

    public double getBeryllium() {
        return beryllium;
    }

    public void setBeryllium(double beryllium) {
        this.beryllium = beryllium;
    }

    public double getBismuth() {
        return bismuth;
    }

    public void setBismuth(double bismuth) {
        this.bismuth = bismuth;
    }

    public double getCadmium() {
        return cadmium;
    }

    public void setCadmium(double cadmium) {
        this.cadmium = cadmium;
    }

    public double getCobalt() {
        return cobalt;
    }

    public void setCobalt(double cobalt) {
        this.cobalt = cobalt;
    }

    public double getChromium() {
        return chromium;
    }

    public void setChromium(double chromium) {
        this.chromium = chromium;
    }

    public double getCopper() {
        return copper;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getLithium() {
        return lithium;
    }

    public void setLithium(double lithium) {
        this.lithium = lithium;
    }

    public double getManganese() {
        return manganese;
    }

    public void setManganese(double manganese) {
        this.manganese = manganese;
    }

    public double getMolybdenum() {
        return molybdenum;
    }

    public void setMolybdenum(double molybdenum) {
        this.molybdenum = molybdenum;
    }

    public double getNickel() {
        return nickel;
    }

    public void setNickel(double nickel) {
        this.nickel = nickel;
    }

    public double getLead() {
        return lead;
    }

    public void setLead(double lead) {
        this.lead = lead;
    }

    public double getAntimony() {
        return antimony;
    }

    public void setAntimony(double antimony) {
        this.antimony = antimony;
    }

    public double getStrontium() {
        return strontium;
    }

    public void setStrontium(double strontium) {
        this.strontium = strontium;
    }

    public double getThallium() {
        return thallium;
    }

    public void setThallium(double thallium) {
        this.thallium = thallium;
    }

    public double getVanadium() {
        return vanadium;
    }

    public void setVanadium(double vanadium) {
        this.vanadium = vanadium;
    }

    public double getTungsten() {
        return tungsten;
    }

    public void setTungsten(double tungsten) {
        this.tungsten = tungsten;
    }

    public double getZinc() {
        return zinc;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }
}
