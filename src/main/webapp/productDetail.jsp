<%@ page import="org.johnmaryudogu.bakevillageecoms.model.ProductModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        .product-detail {
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .product-detail img {
            width: 100%;
            height: 400px;
            object-fit: cover;
            border-radius: 8px;
        }

        .product-detail h2 {
            font-size: 28px;
            margin: 20px 0 10px;
        }

        .product-detail p {
            font-size: 16px;
            color: #555;
            margin: 10px 0;
        }

        .product-detail .price {
            font-size: 22px;
            color: #ff6f61;
            margin-top: 10px;
        }

        .product-detail .original-price {
            text-decoration: line-through;
            color: #777;
            font-size: 14px;
        }

        .actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
        }

        .actions .like-button,
        .actions .add-to-cart {
            background-color: #ff6f61;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .actions .like-button:hover,
        .actions .add-to-cart:hover {
            background-color: #ff3b2e;
        }

        .actions .quantity {
            display: flex;
            align-items: center;
        }

        .actions .quantity input {
            width: 60px;
            text-align: center;
            font-size: 16px;
            margin-right: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="product-detail">
    <%
        ProductModel product = (ProductModel) request.getAttribute("product");
        if (product != null) {
    %>
    <img src="<%= product.getImageUrl() %>" alt="<%= product.getProductName() %>">
    <h2><%= product.getProductName() %></h2>
    <p><%= product.getProductDescription() %></p>
    <p class="price">Amount: $<%= product.getAmount() %></p>
    <p>Category: <%= product.getCategory() %></p>

    <div class="actions">
        <button class="like-button">Like</button>
        <div class="quantity">
            <input type="number" min="1" value="1" id="quantity">
            <button class="add-to-cart">Add to Cart</button>
        </div>
    </div>
    <%
        } else {
            out.print("<p>Product not found.</p>");
        }
    %>
</div>
</body>
</html>
