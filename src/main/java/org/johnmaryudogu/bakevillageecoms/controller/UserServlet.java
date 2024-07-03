package org.johnmaryudogu.bakevillageecoms.controller;

import org.johnmaryudogu.bakevillageecoms.model.userModel;
import org.johnmaryudogu.bakevillageecoms.sericeimpl.UserServiceImpl;
import org.johnmaryudogu.bakevillageecoms.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public UserServlet() {
        this.userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<userModel> userList = userService.getAllUsers();
            request.setAttribute("userList", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("usersList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");
        String likes = request.getParameter("likes");
        String saveditems = request.getParameter("saveditems");
        String cart = request.getParameter("cart");
        userModel newUser = new userModel(firstname, lastname, email, password, confirmpassword);
        newUser.setLikes(likes);
        newUser.setSaveditems(saveditems);
        newUser.setCart(cart);
        try {
            userService.addUser(newUser);
            request.setAttribute("welcomeMessage", "Welcome " + firstname);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
