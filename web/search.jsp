<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/12/2020
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<h1>Product Management</h1>
<h2>
    <a href="products?action=showAll">List All Products</a>
</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Product</h2>
            </caption>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Amount:</th>
                <td>
                    <input type="text" name="amount" id="amount" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Product Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Description:</th>
                <td>
                    <input type="text" name="description" id="description" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Category:</th>
                <td>
                    <input type="text" name="category" id="category" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
