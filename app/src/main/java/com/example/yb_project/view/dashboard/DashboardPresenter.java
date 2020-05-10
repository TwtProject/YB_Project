package com.example.yb_project.view.dashboard;

import androidx.annotation.NonNull;

import com.example.yb_project.Utils;
import com.example.yb_project.model.Products;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardPresenter {
    private DashboardView view;

    public DashboardPresenter(DashboardView view) {
        this.view = view;
    }

    void getProducts(){
        view.showLoading();
        Call<Products> productsCall = Utils.getApi().getProduct();
        productsCall.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(@NonNull Call<Products> call, @NonNull Response<Products> response) {

                view.hideLoading();

                if (response.isSuccessful() && response.body() != null){
                    view.setProduct(response.body().getProducts());
                }else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Products> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
