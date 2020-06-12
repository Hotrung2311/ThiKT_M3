<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/12/2020
  Time: 9:13 AM
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
    <a href="/products?action=create">Add New Product</a>
  </h2>
<div align="center">
  <input name="id" id="id">
  <button>
    <a href="/products?action=search&id=${id}">Search</a>
  </button>

  <table border="1" cellpadding="5">
    <caption><h2>List of Products</h2></caption>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Price</th>
      <th>Amount</th>
      <th>Color</th>
      <th>Description</th>
      <th>Category</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${productList}">
      <tr>
        <td><c:out value="${product.getId()}"/></td>
        <td><c:out value="${product.getName()}"/></td>
        <td><c:out value="${product.getPrice()}"/></td>
        <td><c:out value="${product.getAmount()}"/></td>
        <td><c:out value="${product.getColor()}"/></td>
        <td><c:out value="${product.getDescription()}"/></td>
        <td><c:out value="${product.getCategory()}"/></td>
        <td>
          <a href="/products?action=edit&id=${product.getId()}">Edit</a>
        </td>
        <td>
          <a href="/products?action=delete&id=${product.getId()}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
