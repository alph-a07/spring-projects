<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
<%-- 2 - Processing of the form fields by spring itself --%>
<%-- The fields are set values from the modelAttribute student object getter methods(Empty in our case) --%>
<form:form action="submit" modelAttribute="student">
    First Name: <form:input path="firstName"/>

    <br><br>

    Last Name: <form:input path="lastName"/>

    <br><br>

    Email: <form:input path="email"/>

    <br><br>

    <%-- When the form is submitted, model student object's setter methods are called to set field values --%>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
