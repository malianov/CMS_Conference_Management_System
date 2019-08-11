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
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req    = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp  = (HttpServletResponse) servletResponse;
        final HttpSession session       = req.getSession(false);
        String loginURI                 = req.getContextPath() + "/view/login";
        String not_found_pageURI        = req.getContextPath() + "/view/common/not_found_page";
        User user                       = (User) req.getSession().getAttribute("user");

        boolean loggedIn = session != null && user != null;
        boolean loginReq = req.getRequestURI().equals(loginURI);
        boolean notFPReq = req.getRequestURI().equals(not_found_pageURI);

        if (loggedIn || loginReq || notFPReq) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/cms");
        }
    }

    @Override
    public void destroy() {
    }
}
