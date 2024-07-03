llll<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.johnmaryudogu.bakevillageecoms.model.AdminModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .welcome-message {
            margin-top: 20px;
            font-size: 24px;
        }
        .tab-container {
            margin-top: 20px;
            display: flex;
            gap: 10px;
        }
        .tab {
            padding: 10px 20px;
            border: 1px solid #ccc;
            cursor: pointer;
        }
        .tab-content {
            margin-top: 20px;
        }
        .tab-content > div {
            display: none;
        }
        .tab-content > div.active {
            display: block;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .form-group input[type="submit"] {
            width: auto;
            cursor: pointer;
        }
    </style>
    <script>
        function openTab(evt, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tab-content")[0].children;
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].classList.remove("active");
            }
            tablinks = document.getElementsByClassName("tab");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].classList.remove("active");
            }
            document.getElementById(tabName).classList.add("active");
            evt.currentTarget.classList.add("active");
        }
    </script>
</head>
<body>
<div class="welcome-message">
    Welcome, <%= request.getAttribute("adminName") %>!
</div>
<div class="tab-container">
    <div class="tab active" onclick="openTab(event, 'AddProducts')">Add Products</div>
    <div class="tab" onclick="openTab(event, 'DeleteProduct')">Delete Product</div>
    <div class="tab" onclick="openTab(event, 'Orders')">Orders</div>
    <div class="tab" onclick="openTab(event, 'Others')">Others</div>
</div>
<div id="AddProducts" class="active">
    <h2>Add Products</h2>
    <form action="addProduct" method="post">
        <h2>Add Product</h2>
        Image URL: <input type="text" name="imageUrl" required/><br/>
        Product Name: <input type="text" name="productName" required/><br/>
        Product Description: <input type="text" name="productDescription" required/><br/>
        Amount: <input type="number" name="amount" required/><br/>
        Admin ID: <input type="number" name="idOfAdmin" required/><br/>
        Reviews: <textarea name="reviews"></textarea><br/>
        Category: <input type="text" name="category" required/><br/>
        <input type="submit" value="Add Product"/>
    </form>

</div>

    <div id="DeleteProduct">
        <h2>Delete Product</h2>
        <!-- Delete product form or content here -->
    </div>
    <div id="Orders">
        <h2>Orders</h2>
        <!-- Orders content here -->
    </div>
    <div id="Others">
        <h2>Others</h2>
        <!-- Other content here -->
    </div>
</div>
</body>
</html>
