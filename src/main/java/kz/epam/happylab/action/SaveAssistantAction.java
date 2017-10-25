package kz.epam.happylab.action;

import kz.epam.happylab.service.SaveAssistantService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SaveAssistantAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        new SaveAssistantService().updateAssistant(request);
        return new ShowAction().execute(request);
    }
}
