package org.johnmaryudogu.bakevillageecoms.sericeimpl;

import org.johnmaryudogu.bakevillageecoms.Dao.AdminDao;
import org.johnmaryudogu.bakevillageecoms.model.AdminModel;
import org.johnmaryudogu.bakevillageecoms.service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;

    public AdminServiceImpl() {
        this.adminDao = new AdminDao();
    }

    @Override
    public List<AdminModel> getAllAdmins() throws SQLException {
        return adminDao.getAllAdmins();
    }

    @Override
    public void addAdmin(AdminModel admin) throws SQLException {
        adminDao.addAdmin(admin);
    }

    @Override
    public AdminModel getAdminByEmail(String email) throws SQLException {
        return adminDao.getAdminByEmail(email);
    }
}
