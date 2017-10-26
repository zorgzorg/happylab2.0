package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Sanpin;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.INSERT;
import static kz.epam.happylab.constant.Common.SANPIN;
import static kz.epam.happylab.constant.Common.UPDATE;

/**
 * DAO for updating or inserting records into journal_sanpin table
 */
public class SanpinDAO implements DAO<Sanpin> {
    private Connection connection;

    public SanpinDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Sanpin sanpin) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, SANPIN), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, sanpin);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(Sanpin sanpin) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, SANPIN));
        prepareStatement(stmt, sanpin);
        stmt.setInt(64, sanpin.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private void prepareStatement(PreparedStatement stmt, Sanpin sanpin) throws SQLException {
        stmt.setInt(1, sanpin.getProbeId());
        stmt.setDate(2, (Date) sanpin.getDate());
        stmt.setInt(3, sanpin.getEmployeeId());
        stmt.setDouble(4, sanpin.getSilver());
        stmt.setDouble(5, sanpin.getAluminium());
        stmt.setDouble(6, sanpin.getArsenic());
        stmt.setDouble(7, sanpin.getBoron());
        stmt.setDouble(8, sanpin.getBarium());
        stmt.setDouble(9, sanpin.getBeryllium());
        stmt.setDouble(10, sanpin.getBismuth());
        stmt.setDouble(11, sanpin.getCadmium());
        stmt.setDouble(12, sanpin.getCobalt());
        stmt.setDouble(13, sanpin.getChromium6());
        stmt.setDouble(14, sanpin.getChromium());
        stmt.setDouble(15, sanpin.getCopper());
        stmt.setDouble(16, sanpin.getIron());
        stmt.setDouble(17, sanpin.getLithium());
        stmt.setDouble(18, sanpin.getManganese());
        stmt.setDouble(19, sanpin.getMolybdenum());
        stmt.setDouble(20, sanpin.getNiobium());
        stmt.setDouble(21, sanpin.getSodiumK());
        stmt.setDouble(22, sanpin.getNickel());
        stmt.setDouble(23, sanpin.getAmmonia());
        stmt.setDouble(24, sanpin.getNitrite());
        stmt.setDouble(25, sanpin.getLead());
        stmt.setDouble(26, sanpin.getAntimony());
        stmt.setDouble(27, sanpin.getSelenium());
        stmt.setDouble(28, sanpin.getSiliconAcid());
        stmt.setDouble(29, sanpin.getSilicon());
        stmt.setDouble(30, sanpin.getStrontium());
        stmt.setDouble(31, sanpin.getTellurium());
        stmt.setDouble(32, sanpin.getRodanideIon());
        stmt.setDouble(33, sanpin.getThallium());
        stmt.setDouble(34, sanpin.getVanadium());
        stmt.setDouble(35, sanpin.getTungsten());
        stmt.setDouble(36, sanpin.getZinc());
        stmt.setDouble(37, sanpin.getOdour());
        stmt.setDouble(38, sanpin.getFlavor());
        stmt.setDouble(39, sanpin.getChromaticity());
        stmt.setDouble(40, sanpin.getTurbidity());
        stmt.setDouble(41, sanpin.getHydrogenIndex());
        stmt.setDouble(42, sanpin.getMineralization());
        stmt.setDouble(43, sanpin.getDryResidue());
        stmt.setDouble(44, sanpin.getAnion());
        stmt.setDouble(45, sanpin.getStiffness());
        stmt.setDouble(46, sanpin.getOilProduct());
        stmt.setDouble(47, sanpin.getNitrate());
        stmt.setDouble(48, sanpin.getPermaganate());
        stmt.setDouble(49, sanpin.getSulfate());
        stmt.setDouble(50, sanpin.getFluoride());
        stmt.setDouble(51, sanpin.getPhenolicIndex());
        stmt.setDouble(52, sanpin.getChloride());
        stmt.setDouble(53, sanpin.getCyanide());
        stmt.setDouble(54, sanpin.getDissolvedOxygen());
        stmt.setDouble(55, sanpin.getBiologicalOxygenDemand());
        stmt.setDouble(56, sanpin.getChemicalOxygenDemand());
        stmt.setDouble(57, sanpin.getSuspendedSolid());
        stmt.setDouble(58, sanpin.getPesticideLindane());
        stmt.setDouble(59, sanpin.getPesticideIsomer());
        stmt.setDouble(60, sanpin.getRadioactivityA());
        stmt.setDouble(61, sanpin.getRadioactivityB());
        stmt.setDouble(62, sanpin.getPolyphosphate());
        stmt.setDouble(63, sanpin.getMercury());
    }
}
