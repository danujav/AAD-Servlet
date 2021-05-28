<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: danu
  Date: 5/6/21
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item Servlet</title>
    <link rel="stylesheet" href="asserts/css/bootstrap.min.css">
</head>
<body>
    <section class="container-fluid">
        <section class="row">
            <h1>Item Manage</h1>
        </section>
        <section class="row mt-3">
            <div class="col-md-4">
                <form action="item" method="post" >
                    <div>
                        <label for="code" class="form-label">Item Code</label>
                        <input id="code" type="text" name="code" class="form-control">
                    </div>
                    <div>
                        <label for="description" class="form-label">Item Description</label>
                        <input id="description" type="text" name="description" class="form-control">
                    </div>
                    <div>
                        <label for="qtyOnHand" class="form-label">Qty On Hand</label>
                        <input id="qtyOnHand" type="text" name="qtyOnHand" class="form-control">
                    </div>
                    <div>
                        <label for="price" class="form-label">Price</label>
                        <input id="price" type="text" name="price" class="form-control">
                    </div>
                    <div>
                        <button id="btn" class="btn btn-primary mt-3" type="submit">Add Item</button>
                        <button id="update" class="btn btn-info mt-3" type="submit">Update</button>
                    </div>
                </form>
            </div>
            <div class="col-md-8">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr class="table table-primary">
                            <td>Item Code</td>
                            <td>Item Description</td>
                            <td>Qty On Hand</td>
                            <td>Price</td>
                        </tr>
                    </thead>
                    <tbody id="tblItem">
                    <%
                        ResultSet rst = (ResultSet) request.getServletContext().getAttribute("rst");
                        while (rst.next()) {
                            String code = rst.getString(1);
                            String description = rst.getString(2);
                            String qtyOnHand = rst.getString(3);
                            String price = rst.getString(4);
                    %>
                        <tr>
                            <td><%=code%></td>
                            <td><%=description%></td>
                            <td><%=qtyOnHand%></td>
                            <td><%=price%></td>
                        </tr>
                    <%
                        }
                    %>
                    </tbody>

                </table>
            </div>
        </section>
    </section>

    <script src="asserts/js/jquery-3.6.0.min.js"></script>
    <script src="asserts/js/bootstrap.js"></script>
    <script src="itemManage.js"></script>
</body>
</html>
