<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add customer</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list-style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h1>Add new customer</h1>
    </div>
</div>

<div id="container">
    <form:form action="saveCustomer" method="POST" modelAttribute="customer">
        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" class="save" value="Save customer"></td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>

</body>
</html>
