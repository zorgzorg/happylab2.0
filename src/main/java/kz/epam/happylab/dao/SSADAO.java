package kz.epam.happylab.dao;

import kz.epam.happylab.entity.SSA;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.*;

/**
 * DAO for updating or inserting records into journal_ssa table (Semiquantitative spectral analysis)
 */
public class SSADAO implements DAO<SSA> {
    private Connection connection;

    public SSADAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public int insert(SSA ssa) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, SSA), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, ssa);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(SSA ssa) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, SSA));
        prepareStatement(stmt, ssa);
        stmt.setInt(47, ssa.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private PreparedStatement prepareStatement(PreparedStatement stmt, SSA ssa) throws SQLException {
        stmt.setInt(1, ssa.getProbeId());
        stmt.setDate(2, (Date) ssa.getDate());
        stmt.setInt(3, ssa.getEmployeeId());
        stmt.setDouble(4, ssa.getSilver());
        stmt.setDouble(5, ssa.getAluminium());
        stmt.setDouble(6, ssa.getArsenic());
        stmt.setDouble(7, ssa.getGold());
        stmt.setDouble(8, ssa.getBoron());
        stmt.setDouble(9, ssa.getBarium());
        stmt.setDouble(10, ssa.getBeryllium());
        stmt.setDouble(11, ssa.getBismuth());
        stmt.setDouble(12, ssa.getCadmium());
        stmt.setDouble(13, ssa.getCerium());
        stmt.setDouble(14, ssa.getCobalt());
        stmt.setDouble(15, ssa.getChromium());
        stmt.setDouble(16, ssa.getCopper());
        stmt.setDouble(17, ssa.getIron());
        stmt.setDouble(18, ssa.getGallium());
        stmt.setDouble(19, ssa.getGermanium());
        stmt.setDouble(20, ssa.getHafnium());
        stmt.setDouble(21, ssa.getIndium());
        stmt.setDouble(22, ssa.getLanthanum());
        stmt.setDouble(23, ssa.getLithium());
        stmt.setDouble(24, ssa.getManganese());
        stmt.setDouble(25, ssa.getMolybdenum());
        stmt.setDouble(26, ssa.getNiobium());
        stmt.setDouble(27, ssa.getNickel());
        stmt.setDouble(28, ssa.getPhosphorus());
        stmt.setDouble(29, ssa.getLead());
        stmt.setDouble(30, ssa.getPlatinum());
        stmt.setDouble(31, ssa.getAntimony());
        stmt.setDouble(32, ssa.getScandium());
        stmt.setDouble(33, ssa.getTin());
        stmt.setDouble(34, ssa.getStrontium());
        stmt.setDouble(35, ssa.getTantalum());
        stmt.setDouble(36, ssa.getTellurium());
        stmt.setDouble(37, ssa.getThorium());
        stmt.setDouble(38, ssa.getTitanium());
        stmt.setDouble(39, ssa.getThallium());
        stmt.setDouble(40, ssa.getUranium());
        stmt.setDouble(41, ssa.getVanadium());
        stmt.setDouble(42, ssa.getTungsten());
        stmt.setDouble(43, ssa.getYttrium());
        stmt.setDouble(44, ssa.getYtterbium());
        stmt.setDouble(45, ssa.getZinc());
        stmt.setDouble(46, ssa.getZirconium());

        return stmt;
    }
}
