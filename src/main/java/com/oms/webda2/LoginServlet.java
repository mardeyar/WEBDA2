package com.oms.webda2;

import com.oms.webda2.DAO.UserDAO;
import com.oms.webda2.controller.UserController;
import com.oms.webda2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private UserDAO user;

    @Override
    public void init() throws ServletException {
        super.init();
        user = new UserController();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserController();

        try {
            List<User> users = userDAO.select();
            request.setAttribute("users", users);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();
        if (path.equals("/login")) {
            loginUser(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            boolean isValid = user.login(email, password);
            if (isValid) {
                response.sendRedirect("homepage.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
