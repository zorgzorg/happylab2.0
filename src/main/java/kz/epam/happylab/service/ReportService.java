package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.dao.EntityDAO;
import kz.epam.happylab.dao.ReportDAO;
import kz.epam.happylab.entity.Report;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import static kz.epam.happylab.constant.Common.*;
import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_FIND_RECORDS;

public class ReportService {
    private final static Logger logger = Logger.getLogger(ReportService.class);

    public Report makeReport(HttpServletRequest request) throws ServletException, IOException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        String analysis = request.getParameter(ANALYSIS);
        Report report = new Report();

        ReportDAO reportDAO = new ReportDAO(connection);
        EntityDAO dao = new EntityDAO(connection, PROBE);

        try{
            Collection result = reportDAO.findByIdReport(ParameterRequest.getParameter(request, RECORD_ID), analysis);
            report.setResult(result);
            report.setHeadLaboratory(reportDAO.findHeadLaboratory());
            report.setProbes(dao.findAll(ZERO));
            report.setProbe(dao.findById(ParameterRequest.getParameter(request, PROBE_ID)));
            report.setAnalysis(analysis);
        } catch (SQLException e) {
            logger.error(EXCEPTION_FIND_RECORDS, e);
        }

        ConnectionPool.getInstance().releaseConnection(connection);

        return report;
    }
}
