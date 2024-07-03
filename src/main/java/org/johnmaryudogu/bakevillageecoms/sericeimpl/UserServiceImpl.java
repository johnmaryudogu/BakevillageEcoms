package org.johnmaryudogu.bakevillageecoms.sericeimpl;

import org.johnmaryudogu.bakevillageecoms.Dao.UserDao;
import org.johnmaryudogu.bakevillageecoms.model.userModel;
import org.johnmaryudogu.bakevillageecoms.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDao();
    }

    @Override
    public List<userModel> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(userModel user) throws SQLException {
        userDao.addUser(user);
    }
}
