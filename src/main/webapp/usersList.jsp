<%@ page import="org.johnmaryudogu.bakevillageecoms.model.userModel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<h1>List of Users</h1>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Likes</th>
        <th>Saved Items</th>
        <th>Cart</th>
    </tr>
    <%
        List<org.johnmaryudogu.bakevillageecoms.model.userModel> userList =
                (List<org.johnmaryudogu.bakevillageecoms.model.userModel>) request.getAttribute("userList");
        if (userList != null) {
            for (org.johnmaryudogu.bakevillageecoms.model.userModel user : userList) {
    %>
    <tr>
        <td><%= user.getFirstname() %></td>
        <td><%= user.getLastname() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getLikes() %></td>
        <td><%= user.getSaveditems() %></td>
        <td><%= user.getCart() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
<br/>
<a href="index.jsp">Back to Home</a>
</body>
</html>
