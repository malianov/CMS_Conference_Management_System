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
            System.out.println("CommandUtil.java -> inside goToPage = try");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            System.out.println("CommandUtil.java => inside catch ServletException");
            System.out.println(e);
            //logger.error(String.format("cannot forward page by url = %s", url), e);
        } catch (IOException e) {
            System.out.println("CommandUtil.java => inside catch IOException");
        }
    }

//    public static String getPageBasedOnRole(int role) {
//        System.out.println("CommandUtil.java -> inside getPageBasedOnRole");
//        System.out.println("CommandUtil.java -> inside getPageBasedOnRole, role = " + role);
//        return role == 0 ? "/WEB-INF/view/admin/admin_page.jsp"
//                : role == 1 ? "/WEB-INF/view/moderator/moderator_page.jsp"
//                : role == 2 ? "/WEB-INF/view/speaker/speaker_page.jsp"
//                : role == 3 ? "/WEB-INF/view/user/user_page.jsp"
//                : "/WEB-INF/view/common/not_found_page.jsp";
//    }


}
