<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher management</title>
        <script   src="https://code.jquery.com/jquery-1.12.4.min.js"   integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="   crossorigin="anonymous"></script>
    </head>

    <h1>Teacher management</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Teacher ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${TEACHERS}" var="teacher">
            <form action="./actionTeacher" method="POST">
                <tr>
                    <td>${teacher.id}</td>
                    <td>
                        <input type="text" name="txtName" value="${teacher.name}" required/>

                    </td>
                    <td>
                        <input type="text" name="txtAddr" value="${teacher.addr}" required/>

                    </td>
                    <td>
                        <input type="text" name="txtPhone" value="${teacher.phone}" required/>

                    </td>
                    <td>

                        <input type="hidden" name="txtId" value="${teacher.id}" />

                        <input type="submit" class="btnValidate" name="btnAction" value="Update" />
                        <input type="submit" class="btnValidate" name="btnAction" value="Delete" />
                    </td>
            </form>
        </tr>

    </c:forEach>
</tbody>
</table>

<h1>Add more teacher</h1>

<form id="teacherForm" action="./addTeacher" method="POST">
    Teacher Name: <input type="text" name="txtName" value="" required/> <br/>
    Teacher Address: <input type="text" name="txtAddr" value="" required/> <br/>
    Teacher Phone <input type="text" name="txtPhone" value="" required/> <br/>
    <input type="button" class="btnValidate"  value="Add" />
    <input type="reset" value="Reset"/>
</form>
<h3><a href="./">&lt; Back to homepage</a></h3>

<script>
    $.fn.isValid = function(){
        return this[0].checkValidity();
    };
    $(document).ready(function (){
       $(".btnValidate").click(function() {
          var name = $(this).closest("form").find("input[name='txtName']");
          var addr = $(this).closest("form").find("input[name='txtAddr']");
          var phone = $(this).closest("form").find("input[name='txtPhone']");
          var pattern = /[\d]+$/;
          var regex = new RegExp(pattern);
          if(name.isValid() && addr.isValid()) {
                if(regex.test(phone.val().trim())) {
                   $(this).closest("form").submit();
                } else {
                   alert("Phone format is incorrect!");
                }
            } else {
                alert("All fields are required!");
            }
       });
    });
</script>
</html>
