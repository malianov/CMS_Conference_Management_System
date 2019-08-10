package controller.filter;

import model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthorizationFilter.java -> inside init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AuthorizationFilter.java -> inside doFilter()");

        final HttpServletRequest req    = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp  = (HttpServletResponse) servletResponse;
        final HttpSession session       = req.getSession(false);
        String loginURI                 = req.getContextPath() + "/view/login";
        String not_found_pageURI        = req.getContextPath() + "/view/common/not_found_page";
        User user                       = (User) req.getSession().getAttribute("user");

        boolean loggedIn = session != null && user != null;
        boolean loginReq = req.getRequestURI().equals(loginURI);
        boolean notFPReq = req.getRequestURI().equals(not_found_pageURI);

        System.out.println("AuthorizationFilter.java -> inside doFilter: loggedIn = " + loggedIn);
        System.out.println("AuthorizationFilter.java -> inside doFilter: loginReq = " + loginReq);
        System.out.println("AuthorizationFilter.java -> inside doFilter: notFPReq = " + notFPReq);
        System.out.println("AuthorizationFilter.java -> inside doFilter: loginURI = " + loginURI );
        System.out.println("AuthorizationFilter.java -> inside doFilter: user     = " + user);

        if (loggedIn || loginReq || notFPReq) {
            System.out.println("AuthorizationFilter.java -> inside doFilter if");
            System.out.println("AuthorizationFilter.java -> filterChain = " + filterChain);
            filterChain.doFilter(req, resp);
        } else {
            System.out.println("AuthorizationFilter.java -> inside doFilter--else");
            resp.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {
        System.out.println("AuthorizationFilter.java -> inside destroy()");
    }
}
