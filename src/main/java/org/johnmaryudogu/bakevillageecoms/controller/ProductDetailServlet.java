package org.johnmaryudogu.bakevillageecoms.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.johnmaryudogu.bakevillageecoms.model.ProductModel;
import org.johnmaryudogu.bakevillageecoms.service.ProductService;

import java.io.IOException;
import java.sql.SQLException;

public class ProductDetailServlet extends HttpServlet {
    private ProductService productService;

    public ProductDetailServlet() {
        this.productService = new org.johnmaryudogu.bakevillageecoms.sericeimpl.ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("id");
        if (productId != null) {
            try {
                int id = Integer.parseInt(productId);
                ProductModel product = productService.getProductById(id);
                request.setAttribute("product", product);
                System.out.println("PRODUCTDETAIL HERE:   "+ product);
                RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
                dispatcher.forward(request, response);
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is required");
        }
    }
}

