package org.johnmaryudogu.bakevillageecoms.model;

public class ProductModel {
    private int productID;
    private String imageUrl;
    private String productName;
    private String productDescription;
    private int amount;
    private int idOfAdmin;
    private String reviews;
    private String category;

    public ProductModel(int productID, String imageUrl, String productName, String productDescription, int amount, int idOfAdmin, String reviews, String category) {
        this.productID = productID;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.productDescription = productDescription;
        this.amount = amount;
        this.idOfAdmin = idOfAdmin;
        this.reviews = reviews;
        this.category = category;
    }

    public ProductModel(String imageUrl, String productName, String productDescription, int amount, int idOfAdmin, String reviews, String category) {

        this.imageUrl = imageUrl;
        this.productName = productName;
        this.productDescription = productDescription;
        this.amount = amount;
        this.idOfAdmin = idOfAdmin;
        this.reviews = reviews;
        this.category = category;
    }

    // Getters and Setters
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdOfAdmin() {
        return idOfAdmin;
    }

    public void setIdOfAdmin(int idOfAdmin) {
        this.idOfAdmin = idOfAdmin;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "imageUrl='" + imageUrl + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", amount=" + amount +
                ", idOfAdmin=" + idOfAdmin +
                ", reviews='" + reviews + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
