package lk.ijse.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade?useSSL=false", "root", "25412541");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = ps.executeQuery();
            resp.setContentType("text/html");

            resp.getWriter().write("<link rel=\"stylesheet\" href=\"asserts/css/bootstrap.min.css\">");
            resp.getWriter().write("<table class='table table-bordered mt-3'");
            resp.getWriter().write("<thead>");
            resp.getWriter().write("<tr class='table table-danger'>");
            resp.getWriter().write("<td>Student ID</td><td>Student Name</td><td>Student Address</td><td>Student Salary</td>");
            resp.getWriter().write("</tr>");
            resp.getWriter().write("</thead>");
            resp.getWriter().write("<tbody>");

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String salary = resultSet.getString(3);

                System.out.println(id + " " + name + " " + address + " " + salary);

                resp.getWriter().write("<tr>");
                resp.getWriter().write("<td>" +id + "</td> <td>" + name + "</td><td>" + address + "</td><td>" + salary + "</td>");
                resp.getWriter().write("</tr>");


            }
            resp.getWriter().write("</tbody>");
            resp.getWriter().write("</table>");
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
                resp.getWriter().write("Customer Added..!");
            }else {
                resp.getWriter().write("Customer Not Added..!");
            }
        } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
        }

    }
}
