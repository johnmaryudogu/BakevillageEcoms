package org.johnmaryudogu.bakevillageecoms.service;

import org.johnmaryudogu.bakevillageecoms.model.AdminModel;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {
    List<AdminModel> getAllAdmins() throws SQLException;
    void addAdmin(AdminModel admin) throws SQLException;

    AdminModel getAdminByEmail(String email) throws SQLException;
    }
