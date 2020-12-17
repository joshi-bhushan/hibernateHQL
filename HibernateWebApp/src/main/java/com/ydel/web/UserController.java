package com.ydel.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.ydel.dao.UserDAOImpl;
import com.ydel.dao.UserDao;
import com.ydel.model.User;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/register")
public class UserController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private UserDao userDao;

	    public void init() {
	        userDao = new UserDAOImpl();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException, jakarta.servlet.ServletException {
	        register(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.sendRedirect("register.jsp");
	    }

	    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, jakarta.servlet.ServletException {
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        User user = new User();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setUsername(username);
	        user.setPassword(password);

	        userDao.saveUser(user);

	        jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
	        dispatcher.forward(request, (ServletResponse) response);
	    }
}
