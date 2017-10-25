package kz.epam.happylab.action;

import kz.epam.happylab.service.DeleteService;
import kz.epam.happylab.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static kz.epam.happylab.constant.Common.*;

public class DeleteAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {

        if(!PROFILE.equalsIgnoreCase(request.getParameter(OPTION))) {
            int i = new DeleteService().delete(request);
            request.setAttribute(i > 0 ? MESSAGE : MESSAGE_DANGER, MessageService.getDeleteMessage(i));
        }

        return new ShowAction().execute(request);
    }
}
