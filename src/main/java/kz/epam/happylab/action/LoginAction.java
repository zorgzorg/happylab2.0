package kz.epam.happylab.action;

import kz.epam.happylab.service.LoginService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException  {
        return new LoginService().login(request);
    }
}


