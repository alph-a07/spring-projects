<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<h1>Student confirmed!</h1>
<%-- Accessing model attribute --%>
<<<<<<< HEAD
👉🏻Student name: ${student.firstName} ${student.lastName} <br>
👉🏻Student email: ${student.email} <br>
👉🏻Student country: ${student.country} <br>
👉🏻Favourite programming language: ${student.favProgrammingLanguage} <br>
👉🏻Spoken languages:
<c:forEach var="language" items="${student.languages}">
    ${language}
    <br>
</c:forEach>
=======
Student name: ${student.firstName} ${student.lastName} <br>
Student email: ${student.email} <br>
Student country: ${student.country} <br>
Favourite programming language: ${student.favProgrammingLanguage} <br>
Spoken languages:
<ul>
    <c:forEach var="language" items="${student.languages}">
        <li>${language}</li>
    </c:forEach>
</ul>
>>>>>>> 2680d78eae4440dbd45f4c2e4fd880bcd9e84e27
</body>
</html>
