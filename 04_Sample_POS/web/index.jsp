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
<section class="container-fluid mt-3">
    <section class="row">
        <h1>Customer Added through JSP</h1>
    </section>
    <section class="row">
        <div class="col-md-4">
            <form action="customer2" method="post">
                <div>
                    <label for="id" class="form-label">Customer ID</label>
                    <input id="id" type="text" class="form-control" name="id">
                </div>
                <div>
                    <label for="name" class="form-label">Customer Name</label>
                    <input id="name" type="text" class="form-control" name="name">
                </div>
                <div>
                    <label for="address" class="form-label">Customer Address</label>
                    <input id="address" type="text" class="form-control" name="address">
                </div>
                <div>
                    <label for="salary" class="form-label">Customer Salary</label>
                    <input id="salary" type="text" class="form-control" name="salary">
                </div>
                <div class="mt-3">
                    <button class="btn btn-primary" type="submit">Save Customer</button>
                </div>

            </form>
        </div>

        <div class="col-md-8">
            <table class="table table-bordered table-hover">
                <thead>
                <tr class="table table-primary">
                    <th>Customer ID</th>
                    <th>Customer Name</th>
                    <th>Customer Address</th>
                    <th>Customer Salary</th>
                </tr>
                </thead>
                <tbody
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
