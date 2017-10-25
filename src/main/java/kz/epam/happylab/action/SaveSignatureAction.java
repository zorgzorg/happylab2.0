package kz.epam.happylab.action;

import kz.epam.happylab.service.SaveSignatureService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SaveSignatureAction implements Action {
    private final static Logger logger = Logger.getLogger(SaveSignatureAction.class);

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        new SaveSignatureService().updateSignature(request);
        return new ShowAction().execute(request);
    }
}
