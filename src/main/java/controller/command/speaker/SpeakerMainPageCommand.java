package controller.command.speaker;

import controller.command.Command;
import controller.command.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpeakerMainPageCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SpeakerMainPageCommand.java -> inside execute");
        CommandUtil.goToPage(request,response,"/WEB-INF/view/speaker/speaker_page.jsp");
    }
}
