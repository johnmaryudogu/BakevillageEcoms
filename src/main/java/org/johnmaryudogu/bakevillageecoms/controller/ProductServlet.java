package org.johnmaryudogu.bakevillageecoms.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.johnmaryudogu.bakevillageecoms.model.ProductModel;
import org.johnmaryudogu.bakevillageecoms.service.ProductService;
import org.johnmaryudogu.bakevillageecoms.sericeimpl.ProductServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/index","/productDetail"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService;

    public ProductServlet() {
        this.productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if ("/productDetail".equals(action)) {
            showProductDetail(req, resp);
        } else {
            displayProducts(req, resp);
        }
    }

    private void displayProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<ProductModel> productList = productService.getAllProducts();
            StringBuilder productHtml = new StringBuilder();
            if (productList != null && !productList.isEmpty()) {
                for (ProductModel product : productList) {
                    productHtml.append("<div class='product-item'>")
                            .append("<img src='").append(product.getImageUrl()).append("' alt='").append(product.getProductName()).append("' />")
                            .append("<h3>").append(product.getProductName()).append("</h3>")
                            .append("<p>").append(product.getProductDescription()).append("</p>")
                            .append("<p>Amount: ").append(product.getAmount()).append("</p>")
                            .append("<p>Category: ").append(product.getCategory()).append("</p>")
                            .append("<a href='productDetail?id=").append(product.getProductID()).append("'>View Details</a>") // Add link to product details with ID
                            .append("</div>");
                    System.out.println(product.getProductID());
                }
            } else {
                productHtml.append("<div class='product-item'>")
                        .append("<p>No products available. Please check back later.</p>")
                        .append("</div>");
            }

            HttpSession session = request.getSession();
            session.setAttribute("productHtmlFile", productHtml.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void showProductDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("id");
        System.out.println("SHOW PRODUCT DETAILS:  "+ productId);
        if (productId != null) {
            try {
                ProductModel product = productService.getProductById(Integer.parseInt(productId));
                req.setAttribute("product", product);
                RequestDispatcher dispatcher = req.getRequestDispatcher("productDetail.jsp");
                dispatcher.forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace(resp.getWriter());
            }
        } else {
            resp.getWriter().println("No product ID provided.");
        }
    }
}
