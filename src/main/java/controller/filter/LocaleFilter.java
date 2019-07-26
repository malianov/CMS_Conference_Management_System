package controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocaleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LocaleFilter.java -> inside init()");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LocaleFilter.java -> inside doFilter");
        //System.out.println("LocaleFilter.java -> inside doFilter  ==<< " + servletRequest.getPathInfo());
        final HttpServletRequest request   = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();
        path        = path.replaceAll("language/", "");

        if (path.equals("/view//")) {
            path = "/";
        }

        String language = request.getParameter("language");

        boolean isEnglish   = language.equals("EN");
        boolean isUkrainian = language.equals("UA");

        if (isEnglish) {
            request.getSession().setAttribute("language", "en-EN");
        } else if (isUkrainian) {
            request.getSession().setAttribute("language", "uk-UA");
        }

        request.getSession().getAttribute("language");
        response.sendRedirect(path);
    }

    @Override
    public void destroy() {
        System.out.println("LocaleFilter.java -> inside destroy");
    }
}

