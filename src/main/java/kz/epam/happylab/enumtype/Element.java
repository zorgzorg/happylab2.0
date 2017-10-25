package kz.epam.happylab.enumtype;

public enum Element {
    //Common
    SILVER("Ag"),
    ALUMINIUM("Al"),
    ARSENIC("As"),
    BORON("B"),
    BARIUM("Ba"),
    BERYLLIUM("Be"),
    BISMUTH("Bi"),
    CADMIUM("Cd"),
    COBALT("Co"),
    CHROMIUM("Cr"),
    COPPER("Cu"),
    IRON("Fe"),
    LITHIUM("Li"),
    MANGANESE("Mn"),
    MOLYBDENUM("Mo"),
    NICKEL("Ni"),
    LEAD("Pb"),
    ANTIMONY("Sb"),
    STRONTIUM("Sr"),
    THALLIUM("Tl"),
    VANADIUM("V"),
    TUNGSTEN("W"),
    ZINC("Zn"),

    //AES
    CALCIUM("Ca"),
    POTASSIUM("K"),
    MAGNESIUM("Mg"),
    SODIUM("Na"),
    PHOSPHORUS("P"),
    SULPHUR("S"),
    SELENIUM("Se"),
    SILICON("Si"),
    TIN("Sn"),
    TITANIUM("Ti"),

    //SSA
    GOLD("Au"),
    CERIUM("Ce"),
    GALLIUM("Ga"),
    GERMANIUM("Ge"),
    HAFNIUM("Hf"),
    INDIUM("In"),
    LANTHANUM("La"),
    NIOBIUM("Nb"),
    PLATINUM("Pt"),
    SCANDIUM("Sc"),
    TANTALUM("Ta"),
    TELLURIUM("Te"),
    THORIUM("Th"),
    URANIUM("U"),
    YTTRIUM("Y"),
    YTTERBIUM("Yb"),
    ZIRCONIUM("Zr"),

    //SANPIN
    CHROMIUM6("Cr6"),
    SODIUMK("Na+Ka"),
    AMMONIA("NH3"),
    NITRITE("NO2"),
    SILICONACID("SiAcid"),
    RODANIDEION("Rodanide"),
    ODOUR("odour"),
    FLAVOR("flavor"),
    CHROMATICITY("chromaticity"),
    TURBIDITY("turbidity"),
    HYDROGENINDEX("hydrogenIndex"),
    MINERALIZATION("mineralization"),
    DRYRESIDUE("dryResidue"),
    ANION("anion"),
    STIFFNESS("stiffness"),
    OILPRODUCT("oilProduct"),
    NITRATE("nitrate"),
    PERMAGANATE("permaganate"),
    MERCURY("mercury"),
    SULFATE("sulfate"),
    FLUORIDE("fluoride"),
    PHENOLICINDEX("phenolicIndex"),
    CHLORIDE("chloride"),
    CYANIDE("cyanide"),
    DISSOLVEDOXYGEN("dissolvedOxygen"),
    BIOLOGICALOXYGENDEMAND("biologicalOxygenDemand"),
    CHEMICALOXYGENDEMAND("chemicalOxygenDemand"),
    SUSPENDEDSOLID("suspendedSolid"),
    PESTICIDELINDANE("pesticideLindane"),
    PESTICIDEISOMER("pesticideIsomer"),
    RADIOACTIVITYA("radioactivityA"),
    RADIOACTIVITYB("radioactivityB"),
    POLYPHOSPHATE("polyphosphate");

    private String columnName;

    Element(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toString() {
        return this.columnName;
    }
}
