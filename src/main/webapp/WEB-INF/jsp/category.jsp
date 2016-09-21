<%-- 
    Document   : category
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
        <title>Category Management</title>
    </head>

    <h1>Category Management</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Category ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${CATEGORIES}" var="category">
            <form action="./actionCategory" method="POST">
                <tr>
                    <td>${category.categoryId}</td>
                    <td>
                        <input type="text" name="txtName" value="${category.name}" required/>
                    </td>
                    <td>

                        <input type="hidden" name="txtId" value="${category.categoryId}" />

                        <input type="submit" name="btnAction" value="Update" />
                        <input type="submit" name="btnAction" value="Delete" />
                    </td>
            </form>
        </tr>

    </c:forEach>
</tbody>
</table>

<h1>Add more category</h1>

<form action="./addCategory" method="POST">
    Category ID: <input type="text" name="txtId" value="" required/> <br/>
    Category Name: <input type="text" name="txtName" value="" required/> <br/>
    <input type="submit" name="btnAction" value="Add" />
    <input type="reset" value="Reset"/> <br/>
        
</form>
<font color="red">${param.ERROR}</font>
<h3><a href="./">&lt; Back to homepage</a></h3>
</html>
