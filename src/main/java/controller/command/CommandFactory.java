package controller.command;

import controller.command.admin.*;
import controller.command.common.impl.LoginCommand;
import controller.command.common.impl.LogoutCommand;
import controller.command.common.impl.NotFoundPageCommand;
import controller.command.util.Operation;
import model.exception.NotFoundCommandException;

import java.util.HashMap;
import java.util.Map;

//import org.apache.log4j.Logger;

public class CommandFactory {

    // private static final Logger logger = Logger.getLogger(CommandFactory.class);

    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put(Operation.LOGIN.getPath(),             new LoginCommand());
        commands.put(Operation.LOGOUT.getPath(),            new LogoutCommand());
        commands.put(Operation.NOT_FOUND_PAGE.getPath(),    new NotFoundPageCommand());


        commands.put(Operation.ADMIN_PAGE.getPath(),        new AdminPageCommand());
        commands.put(Operation.ADMIN_MAIN_PAGE.getPath(),   new AdminPageCommand());
        commands.put(Operation.ADMIN_ALL_CMS_USERS_PAGE.getPath(), new AdminAllUsersPageCommand());
        commands.put(Operation.ADMIN_CALENDAR_PAGE.getPath(), new AdminCalendarCommand());
        commands.put(Operation.ADMIN_ARCHIVE_PAGE.getPath(), new AdminArchiveCommand());


//        commands.put(Operation.USER_MAIN_PAGE.getPath(), new UserMainPageCommand());
//
//        commands.put(Operation.SHOW_LOGIN_PAGE.getPath(), new ShowLoginCommand());
//        commands.put(Operation.SHOW_MAIN_PAGE.getPath(), new ShowMainCommand());
//
//        commands.put(Operation.SCHEDULE.getPath(), new ScheduleCommand());
//        commands.put(Operation.SHOW_SCHEDULE.getPath(), new ShowScheduleCommand());
//
//        commands.put(Operation.MATERIALS.getPath(), new MaterialsCommand());
//        commands.put(Operation.SHOW_MATERIALS.getPath(), new ShowMaterialsCommand());
//
//        commands.put(Operation.SPEAKERS.getPath(), new SpeakersCommand());
//        commands.put(Operation.SHOW_SPEAKERS.getPath(), new ShowSpeakersCommand());
//
//        commands.put(Operation.MY_CABINET.getPath(), new MyCabinetCommand());
//        commands.put(Operation.SHOW_MY_CABINET.getPath(), new ShowMyCabinetCommand());

//
    }

    public static Command getCommand(String url) throws NotFoundCommandException {
        System.out.println("CommandFactory.java -> inside getCommand");
        Command command = commands.get(url);
        System.out.println("CommandFactory.java -> command = " + command);
        //logger.info(String.format("get command by url = %s", url));

        if (command == null) {
            throw new NotFoundCommandException();
        }

        return command;

    }

}
