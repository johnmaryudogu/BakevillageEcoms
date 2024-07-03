<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
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
    </style>
</head>
<body>
<header>
    <h1>Bakevillage</h1>
    <div class="button-container">
        <button id="loginButton" onclick="openModal('myModal')">Login</button>
        <button id="cartButton" onclick="openModal('cartModal')">
            <img src="images/shopping-cart.1024x1024.png" alt="Cart">
        </button>
    </div>
</header>
</body>
</html>
