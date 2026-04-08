package com.example.demo.Recommendation;


import java.util.List;

public class Recommendation {

    private int productId;
    private String category;
    private List<String> recommendedProducts;

    public Recommendation() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getRecommendedProducts() {
        return recommendedProducts;
    }

    public void setRecommendedProducts(List<String> recommendedProducts) {
        this.recommendedProducts = recommendedProducts;
    }
}
