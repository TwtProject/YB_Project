package com.example.yb_project.view.dashboard;

import com.example.yb_project.model.Products;

import java.util.List;

public interface DashboardView {

    void showLoading();
    void hideLoading();
    void setProduct(List<Products.Product> product);
    void onErrorLoading(String message);
}
