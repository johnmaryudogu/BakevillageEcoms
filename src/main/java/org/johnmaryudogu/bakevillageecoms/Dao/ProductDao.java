package org.johnmaryudogu.bakevillageecoms.Dao;

import org.johnmaryudogu.bakevillageecoms.model.ProductModel;
import org.johnmaryudogu.bakevillageecoms.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public void addProduct(ProductModel product, String imageUrl) throws SQLException {
        String sql = "INSERT INTO product (imageUrl, productname, productdescription, amount, idofadmin, reviews, category) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, imageUrl);
            stmt.setString(2, product.getProductName());
            stmt.setString(3, product.getProductDescription());
            stmt.setInt(4, product.getAmount());
            stmt.setInt(5, product.getIdOfAdmin());
            stmt.setString(6, product.getReviews());
            stmt.setString(7, product.getCategory());
            stmt.executeUpdate();
        }
    }

    public List<ProductModel> getAllProducts() throws SQLException {
        String sql = "SELECT * FROM product";
        List<ProductModel> products = new ArrayList<>();

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProductModel product = new ProductModel(
                        rs.getInt("id"),
                        rs.getString("imageUrl"),
                        rs.getString("productname"),
                        rs.getString("productdescription"),
                        rs.getInt("amount"),
                        rs.getInt("idofadmin"),
                        rs.getString("reviews"),
                        rs.getString("category")
                );
                System.out.println("ProductDao: Adding product to list - " + product);
                products.add(product);
            }
        }

        return products;
    }

    public ProductModel getProductById(int id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            System.out.println("Executing query with ID: " + id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductModel(
                            rs.getInt("id"),
                            rs.getString("imageUrl"),
                            rs.getString("productname"),
                            rs.getString("productdescription"),
                            rs.getInt("amount"),
                            rs.getInt("idofadmin"),
                            rs.getString("reviews"),
                            rs.getString("category")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}
