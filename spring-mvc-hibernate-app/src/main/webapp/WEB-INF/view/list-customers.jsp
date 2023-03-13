<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All customers</title>

    <%-- Link the stylesheet for displaying list of customers --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h1>Customer management</h1>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add customer" class="add-button" onclick="window.location.href='showAddForm'"/> <br><br>

        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
            </tr>

            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>
