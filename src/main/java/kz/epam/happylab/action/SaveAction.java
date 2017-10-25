package kz.epam.happylab.action;

import kz.epam.happylab.service.SaveService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static kz.epam.happylab.constant.Common.*;

public class SaveAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.setAttribute(DATA, new SaveService().save(request));
        return BASE_PATH + request.getParameter(OPTION) + FORM_LAYOUT;
    }
}
