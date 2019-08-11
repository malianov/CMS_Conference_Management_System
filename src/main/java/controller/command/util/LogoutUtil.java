package controller.command.util;

//import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class LogoutUtil {

    //private static final Logger logger = Logger.getLogger(LogoutCommand.class);

    public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        //logger.info("logout");
        response.sendRedirect("/cms/");
    }
}
