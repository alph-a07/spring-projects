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

    Country: <form:select path="country">
    <form:option value="USA">USA</form:option>
    <form:option value="UK">UK</form:option>
    <form:option value="Canada">Canada</form:option>
    <form:option value="France">France</form:option>
    <form:option value="Germany">Germany</form:option>
    <form:option value="Japan">Japan</form:option>
    <form:option value="Italy">Italy</form:option>
    <form:option value="India">Spain</form:option>
    <form:option value="Russia">Russia</form:option>
    <form:option value="Greece">Greece</form:option>
    <form:option value="Netherlands">Netherlands</form:option>
    <form:option value="Sweden">Sweden</form:option>
</form:select>

    <br><br>

    <%-- When the form is submitted, model student object's setter methods are called to set field values --%>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
