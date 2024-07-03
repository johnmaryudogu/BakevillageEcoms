package org.johnmaryudogu.bakevillageecoms.sericeimpl;

import org.johnmaryudogu.bakevillageecoms.Dao.ProductDao;
import org.johnmaryudogu.bakevillageecoms.model.ProductModel;
import org.johnmaryudogu.bakevillageecoms.service.ProductService;
import org.johnmaryudogu.bakevillageecoms.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = new ProductDao(); // Ensure ProductDao is initialized
    }

    @Override
    public void addProduct(ProductModel product, String imageUrl) throws SQLException {
        productDao.addProduct(product, imageUrl);
    }
//
//    @Override
//    public List<ProductModel> getAllProducts() throws SQLException {
//        System.out.println("ProductServiceImpl: Entering getAllProducts");
//        List<ProductModel> products = productDao.getAllProducts();
//        System.out.println("ProductServiceImpl: Retrieved products - " + products);
//        return products;
//    }

    @Override
    public List<ProductModel> getAllProducts() throws SQLException {
        System.out.println("ProductServiceImpl: Retrieved products - " + productDao.getAllProducts());
        return productDao.getAllProducts();

    }

    @Override
    public ProductModel getProductById(int id) throws SQLException {
        return productDao.getProductById(id); // Implement this method
    }
}
