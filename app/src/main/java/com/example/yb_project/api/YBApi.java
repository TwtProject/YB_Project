package com.example.yb_project.api;

import com.example.yb_project.model.Products;

import retrofit2.Call;
import retrofit2.http.GET;


public interface YBApi {
    @GET("api-routes.php")
    Call<Products> getProduct();
}
