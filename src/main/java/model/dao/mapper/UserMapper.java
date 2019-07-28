package model.dao.mapper;

import model.entity.User;
import model.service.ServiceFactory;
import model.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

import static model.entity.Role.getRoleById;

public class UserMapper implements ObjectMapper<User>{

    private static final String ID = "u_id";
    private static final String LOGIN = "first_name";
    private static final String NAME = "last_name";
    private static final String SURNAME = "last_name";
    private static final String EMAIL = "email";
    private static final String ROLE = "password";
    private static final String IS_ACTIVE = "id_role";

    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        UserService userService = ServiceFactory.getInstance().getUserService();

        user.setId_user(rs.getInt(ID));
        user.setLogin(rs.getString(LOGIN));
        user.setName(rs.getString(NAME));
        user.setSurname(rs.getString(SURNAME));
        user.setEmail(rs.getString(EMAIL));
        user.setRole(getRoleById(rs.getInt(ROLE)));
        user.setIsActive(rs.getInt(IS_ACTIVE));

        return user;
    }

//    @Override
//    public User makeUnique(Map<Long, User> existing, User entity) {
//        existing.putIfAbsent(entity.getId(), entity);
//
//        return existing.get(entity.getId());
//    }
}
