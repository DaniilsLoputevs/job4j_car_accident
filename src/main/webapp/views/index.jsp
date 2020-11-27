<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>Car Accident</title>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.5.4/umd/popper.min.js"--%>
<%--            integrity="sha512-7yA/d79yIhHPvcrSiB8S/7TyX0OxlccU8F/kuB8mHYjLlF1MInPbEohpoqfz0AILoq5hoD7lELZAYYHbyeEjag=="--%>
<%--            crossorigin="anonymous"></script>--%>
    <!-- Bootstrap: css & js-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

<%--    <link rel="stylesheet" href="../styles/index.css"/>--%>
<%--    <script src="../scripts/loadTable.js"></script>--%>
</head>
<body>

<h1>
    Hello : Accident
</h1>

<a href="<c:url value='/accidents/create'/>">Add accident</a>

<div class="container">
    <table class="table table-striped table-inverse">
        <thead>
        <tr>
            <td>members</td>
            <td>edit</td>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="accidents" scope="request" type="java.util.List"/>
        <c:forEach items="${accidents}" var="accident">
            <tr>
                <td>${accident}</td>
                <td>
                    <a href="<c:url value='/update?id=${accident.id}'/>">Edit accident</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>