package kz.epam.happylab.action;

import kz.epam.happylab.service.LoginService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginAction implements Action {
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException  {
        return new LoginService().login(request);
    }
}


