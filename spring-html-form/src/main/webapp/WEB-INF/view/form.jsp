<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Spring Form</title>
</head>
<body>

<h1>Please fill the form</h1>

<%--<form action="process" method="get">--%>
<form action="processV2" method="post">

    <label for="name" title="Name">Name:</label>
    <input type="text" id="name" name="name"/>

    <br>
    <br>

    <label for="email" title="Email">Email:</label>
    <input type="text" id="email" name="email"/>

    <br>
    <br>

    <input type="submit" value="Submit form"/>
</form>

</body>
</html>
