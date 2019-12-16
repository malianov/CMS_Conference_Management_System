package controller.command.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandUtil {

    public static void goToPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String url) {
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(url);

        System.out.println("CommandUtil.java -> inside goToPage");

        try {
            System.out.println("CommandUtil.java -> inside goToPage = try");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            System.out.println("CommandUtil.java => inside catch ServletException");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("CommandUtil.java => inside catch IOException");
        }
    }
}
