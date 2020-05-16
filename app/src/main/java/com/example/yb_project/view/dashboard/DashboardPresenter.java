package com.example.yb_project.view.dashboard;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.yb_project.Utils;
import com.example.yb_project.model.Products;
import com.example.yb_project.model.Settings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

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
                    //Log.w(TAG, "onResponse: " + response.body().getProducts());
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

    void getSettings(){
        view.showLoading();
        Call<Settings> settingsCall = Utils.getApi().getSetting();
        settingsCall.enqueue(new Callback<Settings>() {
            @Override
            public void onResponse(Call<Settings> call, Response<Settings> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null){
                    view.setSetting(response.body().getSettings());
                }else{
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Settings> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
