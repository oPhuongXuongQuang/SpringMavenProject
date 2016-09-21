<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Management</title>
    </head>

    <h1>Course Management</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Course ID</th>
                <th>Name</th>
                <th>Credit Number</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${COURSES}" var="course">
            <form action="./actionCourse" method="POST">
                <tr>
                    <td>${course.id}</td>
                    <td>
                        <input type="text" name="txtName" value="${course.name}" required/>

                    </td>
                    <td>
                        <input type="number" name="txtCreditNum" value="${course.creditNum}" required/>

                    </td>
                    <td>
                        <input type="hidden" name="txtId" value="${course.id}" />

                        <input type="submit" name="btnAction" value="Update" />
                        <input type="submit" name="btnAction" value="Delete" />
                    </td>
            </form>
        </tr>

    </c:forEach>
</tbody>
</table>

<h1>Add more course</h1>

<form action="./addCourse" method="POST">
    Course Name: <input type="text" name="txtName" value="" required/> <br/>
    Course Credit number <input type="number" name="txtCreditNum" value="" required/> <br/>
    <input type="submit" name="btnAction" value="Add" />
    <input type="reset" value="Reset"/>
</form>

<h3><a href="./">&lt; Back to homepage</a></h3>
</html>
