<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<h1>Student confirmed!</h1>
<%-- Accessing model attribute --%>
👉🏻Student name: ${student.firstName} ${student.lastName} <br>
👉🏻Age: ${student.age} <br>
👉🏻Student email: ${student.email} <br>
👉🏻Student country: ${student.country} <br>
👉🏻Pin-code: ${student.pincode} <br>
👉🏻Favourite programming language: ${student.favProgrammingLanguage} <br>
👉🏻Spoken languages:
<c:forEach var="language" items="${student.languages}">
    ${language}
</c:forEach>
</body>
</html>
