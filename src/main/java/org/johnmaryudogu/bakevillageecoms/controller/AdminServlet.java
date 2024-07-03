package org.johnmaryudogu.bakevillageecoms.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import org.johnmaryudogu.bakevillageecoms.model.AdminModel;
import org.johnmaryudogu.bakevillageecoms.model.ProductModel;
import org.johnmaryudogu.bakevillageecoms.sericeimpl.AdminServiceImpl;
import org.johnmaryudogu.bakevillageecoms.service.AdminService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.johnmaryudogu.bakevillageecoms.service.ProductService;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admins", "/login", "/addProduct"})
@MultipartConfig
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminService adminService;
    private ProductService productService;

    public AdminServlet() {
        this.adminService = new AdminServiceImpl();
        this.productService = new org.johnmaryudogu.bakevillageecoms.sericeimpl.ProductServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                displayAdmins(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if ("/login".equals(action)) {
            handleLogin(request, response);
        } else if ("/admins".equals(action)) {
            addAdmin(request, response);
        } else if ("/addProduct".equals(action)) {
            addProduct(request, response);
        }
    }

    private void displayAdmins(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<AdminModel> adminList = adminService.getAllAdmins();
            request.setAttribute("adminList", adminList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        }
    }

    private void addAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname = request.getParameter("email");
        String lastname = request.getParameter("firstname");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");
        String itemEntered = request.getParameter("itemEntered");
        AdminModel newAdmin = new AdminModel(firstname, lastname, password, confirmpassword, itemEntered);
        try {
            adminService.addAdmin(newAdmin);
            request.setAttribute("adminName", firstname);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            AdminModel admin = adminService.getAdminByEmail(email);
            if (admin != null && admin.getPassword().equals(password)) {
                request.setAttribute("adminName", admin.getFirstname());
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminList.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("Invalid email or password");
            }
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String amountStr = request.getParameter("amount");
        String idOfAdminStr = request.getParameter("idOfAdmin");
        String reviews = request.getParameter("reviews");
        String category = request.getParameter("category");

        // Validate and parse integer fields
        int amount = 0;
        int idOfAdmin = 0;
        try {
            if (amountStr != null && !amountStr.isEmpty()) {
                amount = Integer.parseInt(amountStr);
            }
            if (idOfAdminStr != null && !idOfAdminStr.isEmpty()) {
                idOfAdmin = Integer.parseInt(idOfAdminStr);
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid number format: " + e.getMessage());
            return;
        }

        String imageUrl = request.getParameter("imageUrl");

        ProductModel newProduct = new ProductModel(imageUrl, productName, productDescription, amount, idOfAdmin, reviews, category);

        try {
            productService.addProduct(newProduct, imageUrl);
            response.sendRedirect("adminList.jsp");
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        }
    }



}
