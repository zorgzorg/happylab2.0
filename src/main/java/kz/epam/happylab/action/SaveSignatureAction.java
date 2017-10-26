package kz.epam.happylab.action;

import kz.epam.happylab.service.SaveSignatureService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SaveSignatureAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        new SaveSignatureService().updateSignature(request);
        return new ShowAction().execute(request);
    }
}
