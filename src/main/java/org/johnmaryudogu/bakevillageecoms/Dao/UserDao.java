package org.johnmaryudogu.bakevillageecoms.Dao;

import org.johnmaryudogu.bakevillageecoms.model.AdminModel;
import org.johnmaryudogu.bakevillageecoms.model.userModel;
import org.johnmaryudogu.bakevillageecoms.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<userModel> getAllUsers() throws SQLException {
        List<userModel> users = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                userModel user = new userModel();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setConfirmpassword(rs.getString("confirmpassword"));
                user.setLikes(rs.getString("likes"));
                user.setSaveditems(rs.getString("saveditems"));
                user.setCart(rs.getString("cart"));
                users.add(user);
            }
        }
        return users;
    }

    public void addUser(userModel user) throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO users (firstname, lastname, email, password, confirmpassword, likes, saveditems, cart) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, user.getFirstname());
            stmt.setString(2, user.getLastname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getConfirmpassword());
            stmt.setString(6, user.getLikes());
            stmt.setString(7, user.getSaveditems());
            stmt.setString(8, user.getCart());
            stmt.executeUpdate();
        }
    }

    public AdminModel UserByEmail(String email) throws SQLException {
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
