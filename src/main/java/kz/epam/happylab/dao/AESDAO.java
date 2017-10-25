package kz.epam.happylab.dao;

import kz.epam.happylab.entity.AES;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.AES;
import static kz.epam.happylab.constant.Common.INSERT;
import static kz.epam.happylab.constant.Common.UPDATE;
/**
 * DAO for updating or inserting records into journal_aes table (Atomic Emission Spectrometry)
 */
public class AESDAO implements DAO<AES> {
    private Connection connection;

    public AESDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(AES aes) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, AES), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, aes);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(AES aes) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, AES));
        prepareStatement(stmt, aes);
        stmt.setInt(37, aes.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private PreparedStatement prepareStatement(PreparedStatement stmt, AES aes) throws SQLException {
        stmt.setInt(1, aes.getProbeId());
        stmt.setDate(2, (Date) aes.getDate());
        stmt.setInt(3, aes.getEmployeeId());
        stmt.setDouble(4, aes.getSilver());
        stmt.setDouble(5, aes.getAluminium());
        stmt.setDouble(6, aes.getArsenic());
        stmt.setDouble(7, aes.getBoron());
        stmt.setDouble(8, aes.getBarium());
        stmt.setDouble(9, aes.getBeryllium());
        stmt.setDouble(10, aes.getBismuth());
        stmt.setDouble(11, aes.getCalcium());
        stmt.setDouble(12, aes.getCadmium());
        stmt.setDouble(13, aes.getCobalt());
        stmt.setDouble(14, aes.getChromium());
        stmt.setDouble(15, aes.getCopper());
        stmt.setDouble(16, aes.getIron());
        stmt.setDouble(17, aes.getPotassium());
        stmt.setDouble(18, aes.getLithium());
        stmt.setDouble(19, aes.getMagnesium());
        stmt.setDouble(20, aes.getManganese());
        stmt.setDouble(21, aes.getMolybdenum());
        stmt.setDouble(22, aes.getSodium());
        stmt.setDouble(23, aes.getNickel());
        stmt.setDouble(24, aes.getPhosphorus());
        stmt.setDouble(25, aes.getLead());
        stmt.setDouble(26, aes.getSulphur());
        stmt.setDouble(27, aes.getAntimony());
        stmt.setDouble(28, aes.getSelenium());
        stmt.setDouble(29, aes.getSilicon());
        stmt.setDouble(30, aes.getTin());
        stmt.setDouble(31, aes.getStrontium());
        stmt.setDouble(32, aes.getTitanium());
        stmt.setDouble(33, aes.getThallium());
        stmt.setDouble(34, aes.getVanadium());
        stmt.setDouble(35, aes.getTungsten());
        stmt.setDouble(36, aes.getZinc());

        return stmt;
    }
}
