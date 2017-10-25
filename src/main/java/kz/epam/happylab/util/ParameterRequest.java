package kz.epam.happylab.util;

import javax.servlet.http.HttpServletRequest;

import static kz.epam.happylab.constant.Common.EMPTY_PARAMETER;
import static kz.epam.happylab.constant.Common.ZERO;

public class ParameterRequest {

    public static int getParameter(HttpServletRequest request, String parameterName){
        int parameter=ZERO;

        if (request.getParameter(parameterName) != null && !EMPTY_PARAMETER.equals(request.getParameter(parameterName))
                && !request.getParameter(parameterName).isEmpty()) {
            parameter = Integer.parseInt(request.getParameter(parameterName));
        }

        return  parameter;
    }
}
