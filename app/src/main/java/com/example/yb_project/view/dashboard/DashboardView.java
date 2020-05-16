package com.example.yb_project.view.dashboard;

import com.example.yb_project.model.Products;
import com.example.yb_project.model.Settings;

import java.util.List;

public interface DashboardView {

    void showLoading();
    void hideLoading();
    void setProduct(List<Products.Product> product);
    void setSetting(List<Settings.Setting> setting);
    void onErrorLoading(String message);
}
