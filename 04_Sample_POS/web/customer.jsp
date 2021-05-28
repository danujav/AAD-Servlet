<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: danu
  Date: 5/5/21
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer JSP Testing</title>
    <link rel="stylesheet" href="asserts/css/bootstrap.min.css">
</head>
<body>
<%
   /* String id = "C001";
    String name = "Kamal";
    String address = "Galle";
    String salary = "3000";*/

%>

<section class="container-fluid mt-3">
    <section class="row">
        <h1>Customer Added through JSP</h1>
    </section>
    <section class="row">
        <div class="col-md-6">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr class="table table-primary">
                        <th>Customer ID</th>
                        <th>Customer Name</th>
                        <th>Customer Address</th>
                        <th>Customer Salary</th>
                    </tr>
                </thead>
                <tbody>
                   <%-- <tr>
                        <td><%=id%></td>
                        <td><%=name%></td>
                        <td><%=address%></td>
                        <td><%=salary%></td>
                    </tr>--%>

                <%
                    ResultSet resultSet = (ResultSet) request.getServletContext().getAttribute("resultSet");
                    while (resultSet.next()) {
                        String id = resultSet.getString(1);
                        String name = resultSet.getString(2);
                        String address = resultSet.getString(3);
                        String salary = resultSet.getString(4);
                %>
                   <tr>
                       <td><%=id%></td>
                       <td><%=name%></td>
                       <td><%=address%></td>
                       <td><%=salary%></td>
                   </tr>
                 <%
                     }
                %>


                </tbody>
            </table>
        </div>
    </section>
</section>

<script src="asserts/js/bootstrap.min.js"></script>
</body>
</html>
