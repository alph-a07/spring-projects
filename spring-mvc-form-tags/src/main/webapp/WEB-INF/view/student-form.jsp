<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student form</title>

    <style>
        .error {
            color: red;
            font-style: italic;
        }
        .blueError{
            color: blue;
            font-style: italic;
        }
    </style>
</head>
<body>
<%-- 2 - Processing of the form fields by spring itself --%>
<%-- The fields are set values from the modelAttribute student object getter methods(Empty in our case) --%>
<form:form action="submit" modelAttribute="student">
    First Name(*): <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>

    <br><br>

    Last Name: <form:input path="lastName"/>

    <br><br>

    Age(*): <form:input path="age"/>
    <form:errors path="age" cssClass="error"/>

    <br><br>

    Email: <form:input path="email"/>
    <form:errors path="email" cssClass="blueError"/>

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

    Pin code(*): <form:input path="pincode"/>
    <form:errors path="pincode" cssClass="error"/>

    <br><br>

    Java <form:radiobutton path="favProgrammingLanguage" value="Java"/>
    C++ <form:radiobutton path="favProgrammingLanguage" value="C++"/>
    Python <form:radiobutton path="favProgrammingLanguage" value="Python"/>
    PHP <form:radiobutton path="favProgrammingLanguage" value="PHP"/>

    <br><br>

    Hindi <form:checkbox path="languages" value="Hindi"/>
    English <form:checkbox path="languages" value="English"/>
    Gujarati <form:checkbox path="languages" value="Gujarati"/>
    Kannada <form:checkbox path="languages" value="Kannada"/>

    <br><br>

    <%-- When the form is submitted, model student object's setter methods are called to set field values --%>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
