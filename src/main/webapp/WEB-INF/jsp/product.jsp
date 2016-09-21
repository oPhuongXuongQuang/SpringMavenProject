<%-- 
    Document   : product
    Created on : Sep 16, 2016, 1:34:45 PM
    Author     : quangphuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
    </head>

    <h1>Product Management</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Category</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty PRODUCTS}">
                <c:forEach items="${PRODUCTS}" var="product">
                <form action="./actionProduct" method="POST">
                    <tr>
                        <td>${product.productId}</td>
                        <td>
                            <input type="text" name="txtName" value="${product.name}" required/>
                        </td>
                        <td>
                            <input type="number" name="txtPrice" value="${product.price}" required/>
                        </td>
                        <td>
                            <input type="text" name="txtDes" value="${product.description}" required/>
                        </td>
                        <td>
                            <select name="txtCategoryID">
                                <c:forEach items="${CATEGORIES}" var="category">
                                    <option value="${category.categoryId}" 
                                            <c:if test="${product.categoryId.categoryId == category.categoryId}">
                                                selected
                                            </c:if>
                                            >${category.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>

                            <input type="hidden" name="txtId" value="${product.productId}" />

                            <input type="submit" name="btnAction" value="Update" />
                            <input type="submit" name="btnAction" value="Delete" />
                        </td>
                </form>
            </tr>

        </c:forEach>
    </c:if>
</tbody>
</table>

<h1>Add more product</h1>

<form action="./addProduct" method="POST">
    Product ID: <input type="text" name="txtId" value="" required/> <br/>
    Product Name: <input type="text" name="txtName" value="" required/> <br/>
    Product Price: <input type="number" name="txtPrice" value="" required/> <br/>
    Product Description: <input type="text" name="txtDes" value="" required/> <br/>
    Category: 
    <select name="txtCategoryID">
        <c:forEach items="${CATEGORIES}" var="category">
            <option value="${category.categoryId}">${category.name}</option>
        </c:forEach>
    </select> <br/>

    <input type="submit" name="btnAction" value="Add" />
    <input type="reset" value="Reset"/> <br/>

</form>
<font color="red">${param.ERROR}</font>
<h3><a href="./">&lt; Back to homepage</a></h3>
</html>
