package lk.ijse.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/customer2")
public class CustomerServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade?useSSL=false", "root", "25412541");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = ps.executeQuery();

            req.getServletContext().setAttribute("resultSet", resultSet);
            resp.sendRedirect("index.jsp");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* String parameter = req.getParameter("id");
        String method = req.getMethod();
        String contextPath = req.getContextPath();
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();

        System.out.println("parameter" + parameter);
        System.out.println("method" + method);
        System.out.println("contextPath" + contextPath);
        System.out.println("requestURI" + requestURI);
        System.out.println("requestURL" + requestURL);*/

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade?useSSL=false", "root", "25412541");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Customer VALUES (?, ?, ?, ?)");
            ps.setObject(1, id);
            ps.setObject(2, name);
            ps.setObject(3, address);
            ps.setObject(4, salary);

            if(ps.executeUpdate() > 0){
//                resp.getWriter().write("Customer Added..!");
                  resp.sendRedirect("customer2");
            }else {
                resp.getWriter().write("Customer Not Added..!");
            }
        } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
        }

    }
}
