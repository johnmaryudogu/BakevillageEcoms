package org.johnmaryudogu.bakevillageecoms.service;
import org.johnmaryudogu.bakevillageecoms.model.ProductModel;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void addProduct(ProductModel product,  String imageUrl) throws SQLException;
    List<ProductModel> getAllProducts() throws SQLException;
    ProductModel getProductById(int id) throws SQLException;

}
