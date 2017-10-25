package kz.epam.happylab.entity;

import kz.epam.happylab.enumtype.Element;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Sanpin (Sanitary rules and norms)
 * Laboratory journal (getting records from tables journal_sanpin)
 */
public class Sanpin extends Journal {
    private double chromium6; //Cr+6;
    private double niobium; //Nb
    private double selenium; //Se
    private double silicon; //Si
    private double tellurium; //Te
    private double sodiumK; //Na+K
    private double ammonia; //NH3
    private double nitrite; //NO2
    private double siliconAcid; //Si
    private double rodanideIon;
    private double odour;
    private double flavor;
    private double chromaticity;
    private double turbidity;
    private double hydrogenIndex;
    private double mineralization;
    private double dryResidue;
    private double anion;
    private double stiffness;
    private double oilProduct;
    private double nitrate;
    private double permaganate;
    private double mercury;
    private double sulfate;
    private double fluoride;
    private double phenolicIndex;
    private double chloride;
    private double cyanide;
    private double dissolvedOxygen;
    private double biologicalOxygenDemand;
    private double chemicalOxygenDemand;
    private double suspendedSolid;
    private double pesticideLindane;
    private double pesticideIsomer;
    private double radioactivityA;
    private double radioactivityB;
    private double polyphosphate;

    public Sanpin() {
    }

    
    public Sanpin init(HttpServletRequest request){
        Sanpin journal = (Sanpin) new Journal().create(request, new Sanpin());
        journal.setChromium6(Double.parseDouble(request.getParameter(Element.CHROMIUM6.toString()).trim()));
        journal.setNiobium(Double.parseDouble(request.getParameter(Element.NIOBIUM.toString()).trim()));
        journal.setSelenium(Double.parseDouble(request.getParameter(Element.SELENIUM.toString()).trim()));
        journal.setSilicon(Double.parseDouble(request.getParameter(Element.SILICON.toString()).trim()));
        journal.setTellurium(Double.parseDouble(request.getParameter(Element.TELLURIUM.toString()).trim()));
        journal.setSodiumK(Double.parseDouble(request.getParameter(Element.SODIUMK.toString()).trim()));
        journal.setAmmonia(Double.parseDouble(request.getParameter(Element.AMMONIA.toString()).trim()));
        journal.setNitrite(Double.parseDouble(request.getParameter(Element.NITRITE.toString()).trim()));
        journal.setSiliconAcid(Double.parseDouble(request.getParameter(Element.SILICONACID.toString()).trim()));
        journal.setRodanideIon(Double.parseDouble(request.getParameter(Element.RODANIDEION.toString()).trim()));
        journal.setOdour(Double.parseDouble(request.getParameter(Element.ODOUR.toString()).trim()));
        journal.setFlavor(Double.parseDouble(request.getParameter(Element.FLAVOR.toString()).trim()));
        journal.setChromaticity(Double.parseDouble(request.getParameter(Element.CHROMATICITY.toString()).trim()));
        journal.setTurbidity(Double.parseDouble(request.getParameter(Element.TURBIDITY.toString()).trim()));
        journal.setHydrogenIndex(Double.parseDouble(request.getParameter(Element.HYDROGENINDEX.toString()).trim()));
        journal.setMineralization(Double.parseDouble(request.getParameter(Element.MINERALIZATION.toString()).trim()));
        journal.setDryResidue(Double.parseDouble(request.getParameter(Element.DRYRESIDUE.toString()).trim()));
        journal.setAnion(Double.parseDouble(request.getParameter(Element.ANION.toString()).trim()));
        journal.setStiffness(Double.parseDouble(request.getParameter(Element.STIFFNESS.toString()).trim()));
        journal.setOilProduct(Double.parseDouble(request.getParameter(Element.OILPRODUCT.toString()).trim()));
        journal.setNitrate(Double.parseDouble(request.getParameter(Element.NITRATE.toString()).trim()));
        journal.setPermaganate(Double.parseDouble(request.getParameter(Element.PERMAGANATE.toString()).trim()));
        journal.setMercury(Double.parseDouble(request.getParameter(Element.MERCURY.toString()).trim()));
        journal.setSulfate(Double.parseDouble(request.getParameter(Element.SULFATE.toString()).trim()));
        journal.setFluoride(Double.parseDouble(request.getParameter(Element.FLUORIDE.toString()).trim()));
        journal.setPhenolicIndex(Double.parseDouble(request.getParameter(Element.PHENOLICINDEX.toString()).trim()));
        journal.setChloride(Double.parseDouble(request.getParameter(Element.CHLORIDE.toString()).trim()));
        journal.setCyanide(Double.parseDouble(request.getParameter(Element.CYANIDE.toString()).trim()));
        journal.setDissolvedOxygen(Double.parseDouble(request.getParameter(Element.DISSOLVEDOXYGEN.toString()).trim()));
        journal.setBiologicalOxygenDemand(Double.parseDouble(request.getParameter(Element.BIOLOGICALOXYGENDEMAND.toString()).trim()));
        journal.setChemicalOxygenDemand(Double.parseDouble(request.getParameter(Element.CHEMICALOXYGENDEMAND.toString()).trim()));
        journal.setSuspendedSolid(Double.parseDouble(request.getParameter(Element.SUSPENDEDSOLID.toString()).trim()));
        journal.setPesticideLindane(Double.parseDouble(request.getParameter(Element.PESTICIDELINDANE.toString()).trim()));
        journal.setPesticideIsomer(Double.parseDouble(request.getParameter(Element.PESTICIDEISOMER.toString()).trim()));
        journal.setRadioactivityA(Double.parseDouble(request.getParameter(Element.RADIOACTIVITYA.toString()).trim()));
        journal.setRadioactivityB(Double.parseDouble(request.getParameter(Element.RADIOACTIVITYB.toString()).trim()));
        journal.setPolyphosphate(Double.parseDouble(request.getParameter(Element.POLYPHOSPHATE.toString()).trim()));

        return journal;
    }

    public Sanpin init(ResultSet rs) throws SQLException {
        Sanpin journal = (Sanpin) new Journal().create(rs, new Sanpin());
        journal.setChromium6(rs.getDouble(Element.CHROMIUM6.toString()));
        journal.setNiobium(rs.getDouble(Element.NIOBIUM.toString()));
        journal.setSelenium(rs.getDouble(Element.SELENIUM.toString()));
        journal.setSilicon(rs.getDouble(Element.SILICON.toString()));
        journal.setTellurium(rs.getDouble(Element.TELLURIUM.toString()));
        journal.setSodiumK(rs.getDouble(Element.SODIUMK.toString()));
        journal.setAmmonia(rs.getDouble(Element.AMMONIA.toString()));
        journal.setNitrite(rs.getDouble(Element.NITRITE.toString()));
        journal.setSiliconAcid(rs.getDouble(Element.SILICONACID.toString()));
        journal.setRodanideIon(rs.getDouble(Element.RODANIDEION.toString()));
        journal.setOdour(rs.getDouble(Element.ODOUR.toString()));
        journal.setFlavor(rs.getDouble(Element.FLAVOR.toString()));
        journal.setChromaticity(rs.getDouble(Element.CHROMATICITY.toString()));
        journal.setTurbidity(rs.getDouble(Element.TURBIDITY.toString()));
        journal.setHydrogenIndex(rs.getDouble(Element.HYDROGENINDEX.toString()));
        journal.setMineralization(rs.getDouble(Element.MINERALIZATION.toString()));
        journal.setDryResidue(rs.getDouble(Element.DRYRESIDUE.toString()));
        journal.setAnion(rs.getDouble(Element.ANION.toString()));
        journal.setStiffness(rs.getDouble(Element.STIFFNESS.toString()));
        journal.setOilProduct(rs.getDouble(Element.OILPRODUCT.toString()));
        journal.setNitrate(rs.getDouble(Element.NITRATE.toString()));
        journal.setPermaganate(rs.getDouble(Element.PERMAGANATE.toString()));
        journal.setMercury(rs.getDouble(Element.MERCURY.toString()));
        journal.setSulfate(rs.getDouble(Element.SULFATE.toString()));
        journal.setFluoride(rs.getDouble(Element.FLUORIDE.toString()));
        journal.setPhenolicIndex(rs.getDouble(Element.PHENOLICINDEX.toString()));
        journal.setChloride(rs.getDouble(Element.CHLORIDE.toString()));
        journal.setCyanide(rs.getDouble(Element.CYANIDE.toString()));
        journal.setDissolvedOxygen(rs.getDouble(Element.DISSOLVEDOXYGEN.toString()));
        journal.setBiologicalOxygenDemand(rs.getDouble(Element.BIOLOGICALOXYGENDEMAND.toString()));
        journal.setChemicalOxygenDemand(rs.getDouble(Element.CHEMICALOXYGENDEMAND.toString()));
        journal.setSuspendedSolid(rs.getDouble(Element.SUSPENDEDSOLID.toString()));
        journal.setPesticideLindane(rs.getDouble(Element.PESTICIDELINDANE.toString()));
        journal.setPesticideIsomer(rs.getDouble(Element.PESTICIDEISOMER.toString()));
        journal.setRadioactivityA(rs.getDouble(Element.RADIOACTIVITYA.toString()));
        journal.setRadioactivityB(rs.getDouble(Element.RADIOACTIVITYB.toString()));
        journal.setPolyphosphate(rs.getDouble(Element.POLYPHOSPHATE.toString()));

        return journal;
    }

    public double getChromium6() {
        return chromium6;
    }

    public void setChromium6(double chromium6) {
        this.chromium6 = chromium6;
    }

    public double getNiobium() {
        return niobium;
    }

    public void setNiobium(double niobium) {
        this.niobium = niobium;
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

    public double getTellurium() {
        return tellurium;
    }

    public void setTellurium(double tellurium) {
        this.tellurium = tellurium;
    }

    public double getSodiumK() {
        return sodiumK;
    }

    public void setSodiumK(double sodiumK) {
        this.sodiumK = sodiumK;
    }

    public double getAmmonia() {
        return ammonia;
    }

    public void setAmmonia(double ammonia) {
        this.ammonia = ammonia;
    }

    public double getNitrite() {
        return nitrite;
    }

    public void setNitrite(double nitrite) {
        this.nitrite = nitrite;
    }

    public double getSiliconAcid() {
        return siliconAcid;
    }

    public void setSiliconAcid(double siliconAcid) {
        this.siliconAcid = siliconAcid;
    }

    public double getRodanideIon() {
        return rodanideIon;
    }

    public void setRodanideIon(double rodanideIon) {
        this.rodanideIon = rodanideIon;
    }

    public double getOdour() {
        return odour;
    }

    public void setOdour(double odour) {
        this.odour = odour;
    }

    public double getFlavor() {
        return flavor;
    }

    public void setFlavor(double flavor) {
        this.flavor = flavor;
    }

    public double getChromaticity() {
        return chromaticity;
    }

    public void setChromaticity(double chromaticity) {
        this.chromaticity = chromaticity;
    }

    public double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(double turbidity) {
        this.turbidity = turbidity;
    }

    public double getHydrogenIndex() {
        return hydrogenIndex;
    }

    public void setHydrogenIndex(double hydrogenIndex) {
        this.hydrogenIndex = hydrogenIndex;
    }

    public double getMineralization() {
        return mineralization;
    }

    public void setMineralization(double mineralization) {
        this.mineralization = mineralization;
    }

    public double getDryResidue() {
        return dryResidue;
    }

    public void setDryResidue(double dryResidue) {
        this.dryResidue = dryResidue;
    }

    public double getAnion() {
        return anion;
    }

    public void setAnion(double anion) {
        this.anion = anion;
    }

    public double getStiffness() {
        return stiffness;
    }

    public void setStiffness(double stiffness) {
        this.stiffness = stiffness;
    }

    public double getOilProduct() {
        return oilProduct;
    }

    public void setOilProduct(double oilProduct) {
        this.oilProduct = oilProduct;
    }

    public double getNitrate() {
        return nitrate;
    }

    public void setNitrate(double nitrate) {
        this.nitrate = nitrate;
    }

    public double getPermaganate() {
        return permaganate;
    }

    public void setPermaganate(double permaganate) {
        this.permaganate = permaganate;
    }

    public double getMercury() {
        return mercury;
    }

    public void setMercury(double mercury) {
        this.mercury = mercury;
    }

    public double getSulfate() {
        return sulfate;
    }

    public void setSulfate(double sulfate) {
        this.sulfate = sulfate;
    }

    public double getFluoride() {
        return fluoride;
    }

    public void setFluoride(double fluoride) {
        this.fluoride = fluoride;
    }

    public double getPhenolicIndex() {
        return phenolicIndex;
    }

    public void setPhenolicIndex(double phenolicIndex) {
        this.phenolicIndex = phenolicIndex;
    }

    public double getChloride() {
        return chloride;
    }

    public void setChloride(double chloride) {
        this.chloride = chloride;
    }

    public double getCyanide() {
        return cyanide;
    }

    public void setCyanide(double cyanide) {
        this.cyanide = cyanide;
    }

    public double getDissolvedOxygen() {
        return dissolvedOxygen;
    }

    public void setDissolvedOxygen(double dissolvedOxygen) {
        this.dissolvedOxygen = dissolvedOxygen;
    }

    public double getBiologicalOxygenDemand() {
        return biologicalOxygenDemand;
    }

    public void setBiologicalOxygenDemand(double biologicalOxygenDemand) {
        this.biologicalOxygenDemand = biologicalOxygenDemand;
    }

    public double getChemicalOxygenDemand() {
        return chemicalOxygenDemand;
    }

    public void setChemicalOxygenDemand(double chemicalOxygenDemand) {
        this.chemicalOxygenDemand = chemicalOxygenDemand;
    }

    public double getSuspendedSolid() {
        return suspendedSolid;
    }

    public void setSuspendedSolid(double suspendedSolid) {
        this.suspendedSolid = suspendedSolid;
    }

    public double getPesticideLindane() {
        return pesticideLindane;
    }

    public void setPesticideLindane(double pesticideLindane) {
        this.pesticideLindane = pesticideLindane;
    }

    public double getPesticideIsomer() {
        return pesticideIsomer;
    }

    public void setPesticideIsomer(double pesticideIsomer) {
        this.pesticideIsomer = pesticideIsomer;
    }

    public double getRadioactivityA() {
        return radioactivityA;
    }

    public void setRadioactivityA(double radioactivityA) {
        this.radioactivityA = radioactivityA;
    }

    public double getRadioactivityB() {
        return radioactivityB;
    }

    public void setRadioactivityB(double radioactivityB) {
        this.radioactivityB = radioactivityB;
    }

    public double getPolyphosphate() {
        return polyphosphate;
    }

    public void setPolyphosphate(double polyphosphate) {
        this.polyphosphate = polyphosphate;
    }
}
