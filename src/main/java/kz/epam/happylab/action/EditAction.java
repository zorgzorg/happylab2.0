package kz.epam.happylab.action;

import kz.epam.happylab.service.EditService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static kz.epam.happylab.constant.Common.*;

public class EditAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.setAttribute(DATA, new EditService().edit(request));
        return BASE_PATH + request.getParameter(OPTION) + EDIT_LAYOUT;
    }
}
