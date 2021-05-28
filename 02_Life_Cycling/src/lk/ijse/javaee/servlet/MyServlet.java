package lk.ijse.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    public MyServlet() {
        System.out.println("Onna hard eken glawila awilla MyServlet class eken Object ekak hadagena container" +
                "ekata awe");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("onna dan object eken Servlet ekak widiyata hadagnnwa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dan thami do get method eka call wenne");
        try(PrintWriter writer = resp.getWriter()){
            writer.write("My Servlet Called..!");
        }
    }

    @Override
    public void destroy() {
        System.out.println("onna dan container eka close karanwa. ekynne tomcat server eka stop karwnwa." +
                "dan man marenwa");
    }
}
