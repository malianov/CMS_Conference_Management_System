package controller.command.util;

//import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandUtil {

    //private static final Logger logger = Logger.getLogger(CommandUtil.class);

    public static void goToPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String url) {
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(url);

        System.out.println("CommandUtil.java -> inside goToPage");

        try {
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            //logger.error(String.format("cannot forward page by url = %s", url), e);
        } catch (IOException e) {
            System.out.println("CommandUtil.java => inside catch IOException");
        }
    }

}
