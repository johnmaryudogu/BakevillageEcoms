<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bakevillage E-commerce</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        header h1 {
            margin: 0;
            font-size: 24px;
        }

        header .button-container {
            display: flex;
            gap: 10px;
        }

        header .button-container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #ff6f61;
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        header .button-container button:hover {
            background-color: #ff3b2e;
        }

        header .button-container img {
            height: 24px;
        }

        .banner {
            background-color: #ececec;
            padding: 40px 20px;
            text-align: center;
        }

        .banner h2 {
            font-size: 36px;
            margin: 0;
            color: #333;
        }

        .banner p {
            font-size: 18px;
            color: #777;
            margin-top: 10px;
        }

        .categories {
            display: flex;
            justify-content: center;
            gap: 10px;
            padding: 20px 0;
            background-color: #fff;
        }

        .categories img {
            height: 40px;
            width: 40px;
            border-radius: 50%;
            border: 1px solid #ddd;
        }

        .flash-sale {
            background-color: #ff6f61;
            padding: 20px;
            color: #fff;
            text-align: center;
        }

        .flash-sale h3 {
            margin: 0;
            font-size: 24px;
        }

        .flash-sale .timer {
            font-size: 18px;
            margin-top: 10px;
        }

        .product-grid {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
            padding: 20px;
        }

        .product-item {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 15px;
            width: calc(25% - 40px);
            box-sizing: border-box;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s, box-shadow 0.3s;
            border-radius: 8px;
            text-align: center;
        }

        .product-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .product-item img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .product-item h3 {
            margin: 10px 0;
            font-size: 18px;
        }

        .product-item p {
            margin: 5px 0;
            font-size: 16px;
            color: #555;
        }

        .product-item .price {
            font-size: 18px;
            color: #ff6f61;
        }

        .product-item .original-price {
            text-decoration: line-through;
            color: #777;
            font-size: 14px;
        }

        .recommendation {
            background-color: #fff;
            padding: 20px;
            text-align: center;
        }

        .recommendation h3 {
            font-size: 24px;
            margin: 0 0 20px;
        }

        .recommendation .filter-buttons {
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        .recommendation .filter-buttons button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .recommendation .filter-buttons button:hover {
            background-color: #ddd;
        }

        /* Modal styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
            padding-top: 60px;
        }

        .modal-content {
            background-color: #fefefe;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        .modal h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .modal form input[type="text"],
        .modal form input[type="email"],
        .modal form input[type="password"],
        .modal form textarea {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .modal form input[type="submit"] {
            padding: 10px 20px;
            background-color: #ff6f61;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .modal form input[type="submit"]:hover {
            background-color: #ff3b2e;
        }

        /* Loader styles */
        .loader {
            display: none;
            position: fixed;
            z-index: 2;
            left: 50%;
            top: 50%;
            width: 50px;
            height: 50px;
            border: 5px solid #f3f3f3;
            border-top: 5px solid #ff6f61;
            border-radius: 50%;
            animation: spin 1s linear infinite;
        }

        @keyframes spin {
            0% { transform: translate(-50%, -50%) rotate(0deg); }
            100% { transform: translate(-50%, -50%) rotate(360deg); }
        }
    </style>

</head>
<body>
<jsp:include page="header.jsp" />
<header>
    <h1>Bakevillage</h1>
    <div class="button-container">
        <button id="loginButton" onclick="openModal('myModal')">Login</button>
        <button id="cartButton" onclick="openModal('myModal')">
            <img src="images/shopping-cart.1024x1024.png" alt="Cart">
        </button>
        <button id="addAdminButton" onclick="openModal('adminModal')">Admin</button>
    </div>
</header>

<div class="banner">
    <h2>Limited Time Offer! Up to 50% OFF!</h2>
    <p>Redefine Your Everyday Style</p>
</div>

<div class="categories">
    <img src="images/tshirt.png" alt="T-Shirt">
    <img src="images/jacket.png" alt="Jacket">
    <img src="images/shirt.png" alt="Shirt">
    <img src="images/jeans.png" alt="Jeans">
    <img src="images/bag.png" alt="Bag">
    <img src="images/shoes.png" alt="Shoes">
    <img src="images/watches.png" alt="Watches">
    <img src="images/cap.png" alt="Cap">
    <img src="images/all_category.png" alt="All Category">
</div>

<div class="flash-sale">
    <h3>Flash Sale</h3>
    <div class="timer">08 : 17 : 56</div>
</div>


<div class="recommendation">
    <h3>Categories</h3>
    <div class="filter-buttons">
        <button>Ingredients</button>
        <button>Tools</button>
        <button>Equipments</button>
        <button>Boxes</button>
        <button>Packaging</button>
    </div>
</div>


<main>
    <div class="product-grid">
        <%
            String productHtmlFile = (String) session.getAttribute("productHtmlFile");
            if (productHtmlFile != null) {
                out.print(productHtmlFile);
            }
        %>

    </div>
</main>

<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal')">&times;</span>
        <form action="users" method="post">
            <h2>Add User</h2>
            First Name: <input type="text" name="firstname" required/><br/>
            Last Name: <input type="text" name="lastname" required/><br/>
            Email: <input type="email" name="email" required/><br/>
            Password: <input type="password" name="password" required/><br/>
            Confirm Password: <input type="password" name="confirmpassword" required/><br/>
            <input type="submit" value="Add User"/>
        </form>
        <span id="loginPrompt" onclick="openModal('userloginModal'),closeModal('myModal')">Do you have an account? Login</span>

    </div>
</div>

<div id="adminModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('adminModal')">&times;</span>
        <form action="admins" method="post">
            <h2>Add Admin</h2>
            Email: <input type="email" name="email" required/><br/>
            First Name: <input type="text" name="firstname" required/><br/>
            Password: <input type="password" name="password" required/><br/>
            Confirm Password: <input type="password" name="confirmpassword" required/><br/>
            Item Entered: <textarea name="itemEntered"></textarea><br/>
            <input type="submit" value="Add Admin"/>
        </form>
        <button id="loginAdminButton" onclick="openModal('loginModal'), closeModal('adminModal')">Admin Login</button>
    </div>
</div>

<div id="loginModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('loginModal')">&times;</span>
        <form action="login" method="post">
            <h2>Admin Login</h2>
            Email: <input type="email" name="email" required/><br/>
            Password: <input type="password" name="password" required/><br/>
            <input type="submit" value="Login"/>
        </form>
    </div>
</div>

<div id="userloginModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('userloginModal')">&times;</span>
        <form action="userlogin" method="post">
            <h2>User Login</h2>
            Email: <input type="email" name="email" required/><br/>
            Password: <input type="password" name="password" required/><br/>
            <input type="submit" value="Login"/>
        </form>
    </div>
</div>

<div id="loader" class="loader"></div>
</body>

<script>
    function openModal(id) {
        document.getElementById(id).style.display = 'block';
    }

    function closeModal(id) {
        document.getElementById(id).style.display = 'none';
    }

    function checkWelcomeMessage() {
        const welcomeMessage = "<%= (request.getAttribute("welcomeMessage") != null) ? request.getAttribute("welcomeMessage").toString() : "" %>";
        if (welcomeMessage) {
            document.getElementById('welcomeMessage').innerText = welcomeMessage;
            document.getElementById('loginButton').style.display = 'none';
            closeModal('myModal');
        }
    }

    window.onload = function() {
        checkWelcomeMessage();
        if (!sessionStorage.getItem('reloaded')) {
            sessionStorage.setItem('reloaded', 'true');
            document.getElementById('loader').style.display = 'block';
            setTimeout(function() {
                location.reload();
            }, 5000);
        }
    }
</script>
</html>
