package kz.epam.happylab.controller;

import kz.epam.happylab.action.Action;
import kz.epam.happylab.action.ActionFactory;
import kz.epam.happylab.connection.ConnectionPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static kz.epam.happylab.constant.Common.ACTION;

public class Controller extends HttpServlet {

    public void init(ServletConfig servletConfig)
    {
            ConnectionPool.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Action action = ActionFactory.createAction(request.getParameter(ACTION));
        String view = action.execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    public void destroy()
    {
            ConnectionPool.dispose();
    }
}
