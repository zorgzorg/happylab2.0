package kz.epam.happylab.dao;

import kz.epam.happylab.util.QueryGetter;

import java.sql.*;
import java.util.*;

import static kz.epam.happylab.constant.Common.*;
/**
 * DAO for getting records from journal_aes, journal_ssa, journal_sanpin and forming reports
 */
public class ReportDAO {
    private Connection connection;

    public ReportDAO(Connection connection) {
        this.connection = connection;
    }

    public int findAnalysisId(String analysis) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(FIND_ANALYSIS, REPORT));
        stmt.setString(1, analysis);
        ResultSet rs = stmt.executeQuery();
        int analysisId = ZERO;

        while (rs.next()) {
            analysisId = rs.getInt(ID);
        }

        rs.close();
        stmt.close();

        return analysisId;
    }

    public List<Map<String, Object>> findByIdReport(int recordId, String analysis) throws SQLException {

        int analysisId = findAnalysisId(analysis);
        String query = QueryGetter.getQuery(FINDBYID_AES, REPORT);

        if (SSA.equalsIgnoreCase(analysis)) {
            query = QueryGetter.getQuery(FINDBYID_SSA, REPORT);
        }
        if (SANPIN.equalsIgnoreCase(analysis)) {
            query = QueryGetter.getQuery(FINDBYID_SANPIN, REPORT);
            return formReportSanpin(recordId, analysisId, query);
        }

        return formReport(recordId, analysisId, query);
    }

    private List<Map<String, Object>> formReport(int recordId, int analysisId, String query) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, recordId);
        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> rows = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Map limits = getLimits(analysisId);
        Set<String> keys = limits.keySet();
        String value;

        while (rs.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for (String k : keys) {
                for (int i = 1; i <= columnCount; i++) {
                    if (k.equals(metaData.getColumnLabel(i))) {
                        if ((Double) rs.getObject(i) < (Double) limits.get(k)) {
                            value = "< " + limits.get(k);
                        } else {
                            value = "" + rs.getObject(i);
                        }
                        columns.put(metaData.getColumnLabel(i), value);
                    }
                    if (ASSISTANT.equals(metaData.getColumnLabel(i))) {
                        columns.put(metaData.getColumnLabel(i), rs.getObject(i));
                    }
                }
            }
            rows.add(columns);
        }

        rs.close();
        stmt.close();

        return rows;
    }

    private List<Map<String, Object>> formReportSanpin(int recordId, int analysisId, String query) throws SQLException {
        String value;
        Double limit = 0d;
        Double content = 0d;
        List<Map<String, Object>> rows = new ArrayList<>();
        Map<String, Object> result = new LinkedHashMap<>();

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, recordId);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                result.put(metaData.getColumnLabel(i), rs.getObject(i));
            }
        }

        stmt = connection.prepareStatement(QueryGetter.getQuery(FIND_LIMITS, REPORT));
        stmt.setInt(1, analysisId);
        ResultSet limits = stmt.executeQuery();

        ResultSetMetaData metaDataLimits = limits.getMetaData();
        int columnCountLimits = metaDataLimits.getColumnCount();

        while (limits.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for (int i = 1; i <= columnCountLimits; i++) {
                columns.put(metaDataLimits.getColumnLabel(i), limits.getObject(i));
                if (ELEMENT.equalsIgnoreCase(metaDataLimits.getColumnLabel(i))) {
                    if(columns.get(LIMIT)!=null) {
                        limit = (Double) columns.get(LIMIT);
                    }
                    if(result.get(limits.getObject(i))!=null) {
                        content = (Double) result.get(limits.getObject(i));
                    }
                    if (content < limit) {
                        value = "< " + columns.get(LIMIT);
                    } else {
                        value = "" + result.get(limits.getObject(i));
                    }
                    columns.put(CONTENT, value);
                }
                columns.put(ASSISTANT, result.get(ASSISTANT ));
            }
            rows.add(columns);
        }

        rs.close();
        stmt.close();

        return rows;
    }

    public Map<String, Double> getLimits(int id) throws SQLException {
        Map<String, Double> limits = new LinkedHashMap<>();

        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(FIND_LIMITS, REPORT));
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            limits.put(rs.getString(ELEMENT), rs.getDouble(LIMIT));
        }

        rs.close();
        stmt.close();

        return limits;
    }

    public String findHeadLaboratory() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(FIND_HEAD_LABORATORY, REPORT));
        ResultSet rs = stmt.executeQuery();
        String headLaboratory="";

        while(rs.next()){
            headLaboratory=rs.getString(SIGNATURE);
        }

        rs.close();
        stmt.close();

        return headLaboratory;
    }
}
