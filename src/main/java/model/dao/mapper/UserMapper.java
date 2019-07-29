package model.dao.mapper;

import model.entity.Role;
import model.entity.User;
import model.service.ServiceFactory;
import model.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ObjectMapper<User> {

    private static final String ID = "u_id";
    private static final String LOGIN = "u_login";
    private static final String NAME = "u_name";
    private static final String SURNAME = "u_surname";
    private static final String EMAIL = "u_email";
    private static final String ROLE = "u_role";
    private static final String IS_ACTIVE = "u_isActive";
    private static final String PASSWORD = "u_password";

    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        //UserService userService = ServiceFactory.getInstance().getUserService();

        user.setId_user(rs.getLong(ID));
        user.setLogin(rs.getString(LOGIN));
        user.setName(rs.getString(NAME));
        user.setSurname(rs.getString(SURNAME));
        user.setEmail(rs.getString(EMAIL));
        user.setRole(Role.getRoleById(rs.getInt(ROLE)));
        user.setIsActive(rs.getInt(IS_ACTIVE));
        user.setPassword(rs.getString(PASSWORD));
        return user;
    }

//    @Override
//    public User makeUnique(Map<Long, User> existing, User entity) {
//        existing.putIfAbsent(entity.getId(), entity);
//
//        return existing.get(entity.getId());
//    }
}
