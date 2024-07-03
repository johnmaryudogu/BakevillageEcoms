package org.johnmaryudogu.bakevillageecoms.Dao;

import org.johnmaryudogu.bakevillageecoms.model.AdminModel;
import org.johnmaryudogu.bakevillageecoms.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    public List<AdminModel> getAllAdmins() throws SQLException {
        List<AdminModel> admins = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                AdminModel admin = new AdminModel();
                admin.setId(rs.getInt("id"));
                admin.setFirstname(rs.getString("email"));
                admin.setLastname(rs.getString("firstname"));
                admin.setPassword(rs.getString("password"));
                admin.setConfirmpassword(rs.getString("confirmpassword"));
                admin.setItemEntered(rs.getString("itemEntered"));
                admins.add(admin);
            }
        }
        return admins;
    }

    public void addAdmin(AdminModel admin) throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO admin (email,firstname, password, confirmpassword, itemEntered) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, admin.getFirstname());
            stmt.setString(2, admin.getLastname());
            stmt.setString(3, admin.getPassword());
            stmt.setString(4, admin.getConfirmpassword());
            stmt.setString(5, admin.getItemEntered());
            stmt.executeUpdate();
        }
    }
    public AdminModel getAdminByEmail(String email) throws SQLException {
        AdminModel admin = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE email = ?")) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                admin = new AdminModel();
                admin.setId(rs.getInt("id"));
                admin.setFirstname(rs.getString("email"));
                admin.setLastname(rs.getString("firstname"));
                admin.setPassword(rs.getString("password"));
                admin.setConfirmpassword(rs.getString("confirmpassword"));
                admin.setItemEntered(rs.getString("itemEntered"));
            }
        }
        return admin;
    }
}
