<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<!-- include header & menu --> <!-- Gedaan via Web.xml-->

<h3>Hello: ${loggedInUser.userName}</h3>

User Name: <b>${loggedInUser.userName}</b>
<br />
Gender: ${loggedInUser.gender} <br />

<!-- include footer --> <!-- Gedaan via Web.xml-->

</body>
</html>