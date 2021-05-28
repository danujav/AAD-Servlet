package lk.ijse.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade?useSSL=false", "root", "25412541");
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM Item");

            ResultSet rst = pst.executeQuery();
            req.getServletContext().setAttribute("rst", rst);
            resp.sendRedirect("item.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String description = req.getParameter("description");
        String qtyOnHand = req.getParameter("qtyOnHand");
        String price = req.getParameter("price");

   /*     System.out.println(code);
        System.out.println(description);
        System.out.println(qtyOnHand);
        System.out.println(price);*/

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade?useSSL=false", "root", "25412541");
            PreparedStatement pst = connection.prepareStatement("INSERT INTO Item VALUES(?, ?, ?, ?)");
            pst.setString(1, code);
            pst.setString(2, description);
            pst.setString(3, qtyOnHand);
            pst.setString(4, price);

            if(pst.executeUpdate() > 0){
                resp.sendRedirect("item");
            }else{
                resp.getWriter().write("What fuck are you doing there...");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

}
