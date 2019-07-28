package controller.command;


public interface TextConstants {

    interface Parameters {
        String CURRENT_PAGE = "currentPage";


        String SESSION_LOCALE_PARAMETER = "sessionLocale";
        String LANG_PARAMETER = "lang";
        String EMAIL = "email";
        String PASSWORD = "password";
        String ROLE = "role";
        String CONFIRM_PASSWORD = "confirmPassword";
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String LOGGED_USERS = "loggedUsers";

        String NO_OF_PAGES = "noOfPages";
        String REPORTS = "reports";
        String REPORTS_TO_CHANGE = "reportsToChange";
        String ITEMS = "items";
        String PERSONS = "persons";
        String COMPANY_NAME = "companyName";
        String TAXPAYER_CODE = "taxpayerCode";
        String CONTENT = "content";
        String ID_REPORT_TO_CHANGE = "idReportToChange";
        String ID_ITEM = "idItem";
        String ID_PERSON = "idPerson";
        String QUANTITY = "quantity";

        String ID_REPORT = "idReport";
        String IS_ACCEPTED = "isAccepted";
        String SHOULD_BE_CHANGED = "shouldBeChanged";
        String INSPECTOR_COMMENT = "inspectorComment";
    }


    interface Routes {
        String TO_SHOW_ALL_USERS = "/WEB-INF/view/admin/all_users_page.jsp";


        String REDIRECT = "redirect@";
        String EMPTY_STRING = "";
        String LOGIN_FAIL_INVALID_INPUT = "/WEB-INF/common/login.jsp?dataInvalid=true";
        String TO_PERSONAL_CABINET = "/app/personal-cabinet";
        String MULTILOGIN_ERROR = "/WEB-INF/common/error/multilogin.jsp";
        String INVALID_SESSION_ERROR = "/WEB-INF/common/error/invalidSession.jsp";
        String ACCESS_FORBIDDEN_403 = "/WEB-INF/common/error/403.jsp";

        String BASE = "/WEB-INF/common/base.jsp";
        String USER_NOT_EXIST = "/WEB-INF/common/login.jsp?userExist=false";

        String REGISTRATION_FAIL_INVALID_DATA = "/WEB-INF/common/registration.jsp?dataInvalid=true";
        String REGISTRATION_FAIL_PASSWORDS_DIFFERENT = "/WEB-INF/common/registration.jsp?passwordsDifferent=true";
        String REGISTRATION_FAIL_USER_EXIST = "/WEB-INF/common/registration.jsp?alreadyExist=true";
        String REGISTRATION_SUCCESS = "/WEB-INF/common/registration.jsp?success=true";


        String TO_SHOW_REPORTS = "/WEB-INF/client/show-reports.jsp";
        String TO_SUBMIT_REPORT = "/WEB-INF/client/submit-report.jsp";
        String TO_CHECK_REPORT = "/WEB-INF/inspector/check-report.jsp";
        String TO_EDIT_REPORT = "/WEB-INF/client/edit-report.jsp";
        String REDIRECT_TO_EDIT_REPORT = "/app/edit-report";
        String TO_SET_TAXABLE_ITEMS = "/WEB-INF/inspector/set-taxable.jsp";
        String TO_SUBMIT_COMPLAINT = "/WEB-INF/client/submit-complaint.jsp";

        String TO_HOME = "/WEB-INF/common/welcome.jsp";
        String TO_LOGIN = "/WEB-INF/common/login.jsp";
        String TO_REGISTRATION = "/WEB-INF/common/registration.jsp";
    }

    interface CommandPaths {
        //account
        String REGISTRATION = "registration";
        String LOGIN = "login";
        String LOGOUT = "logout";
        String PERSONAL_CABINET = "personal-cabinet";

        //directions
        String HOME = "home";
        String REG_ME = "reg-me";
        String LOG_ME = "log-me";
        String MAKE_COMPLAINT = "make-complaint";
        String MAKE_REPORT = "make-report";
        String CHECK_REPORT = "check-report";
        String SET_TAXABLE = "set-taxable";
        String EDIT_REPORTS = "edit-report";


        //actions
        String SUBMIT_REPORT = "submit-report";
        String SUBMIT_COMPLAINT = "submit-complaint";
        String SHOW_REPORTS = "show-reports";
        String SUBMIT_EDIT_REPORT = "submit-edit-report";
        String SUBMIT_CHECKING_REPORT = "submit-checking-report";
        String SUBMIT_SET_TAXABLE = "submit-set-taxable";

        //servlet
        String APPLICATION_PATH_REGEX = ".*/app/";
        String DEFAULT_PATH = "app/home";
    }

}
