package kz.epam.happylab.action;

import kz.epam.happylab.service.BlockService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BlockAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        new BlockService().updateBlock(request);
        return new ShowAction().execute(request);
    }
}
