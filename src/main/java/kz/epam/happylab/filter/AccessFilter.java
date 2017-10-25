package kz.epam.happylab.filter;

import kz.epam.happylab.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static kz.epam.happylab.constant.Common.*;

public class AccessFilter implements Filter {
    private List<String> urlListAssistantForbidden;
    private List<String> urlListHeadForbidden;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urlsAssistantForbidden = filterConfig.getInitParameter(ASSISTANT);
        String urlsHeadForbidden = filterConfig.getInitParameter(HEAD);

        urlListAssistantForbidden = getForbiddenUrls(urlsAssistantForbidden);
        urlListHeadForbidden = getForbiddenUrls(urlsHeadForbidden);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String url = request.getServletPath();

        if (session == null || session.getAttribute(USER) == null) {
            response.sendRedirect(request.getContextPath() + LOGIN_PATH);
        } else {
            User user = (User) session.getAttribute(USER);

            if (checkAuthorization(user.getUsertype(), url)) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + LOGIN_PATH);
            }
        }
    }

    private boolean checkAuthorization(String usertype, String url){
        boolean isAuthorized = false;

        if (!usertype.isEmpty()) {
            if (HEAD.equalsIgnoreCase(usertype)) {
                if (!urlListHeadForbidden.contains(url)) {
                    isAuthorized = true;
                }
            } else if (ASSISTANT.equalsIgnoreCase(usertype)) {
                if (!urlListAssistantForbidden.contains(url)) {
                    isAuthorized = true;
                }
            } else {
                isAuthorized = true;
            }
        }

        return isAuthorized;

    }

    private List<String> getForbiddenUrls(String urls){
        StringTokenizer token = new StringTokenizer(urls, DELIMITER);
        List<String> urlList = new ArrayList<>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }

        return urlList;
    }

    @Override
    public void destroy() {

    }
}
