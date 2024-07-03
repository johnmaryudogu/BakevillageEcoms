package org.johnmaryudogu.bakevillageecoms.service;

import org.johnmaryudogu.bakevillageecoms.model.AdminModel;
import org.johnmaryudogu.bakevillageecoms.model.userModel;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<userModel> getAllUsers() throws SQLException;
    void addUser(userModel user) throws SQLException;

    interface AdminService {
        List<AdminModel> getAllAdmins() throws SQLException;
        void addAdmin(AdminModel admin) throws SQLException;
    }
}

