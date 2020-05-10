package com.example.yb_project.view.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.yb_project.R;
import com.example.yb_project.model.Products;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardView {

    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerProduct;

    DashboardPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_main);
        ButterKnife.bind(this);

        presenter = new DashboardPresenter(this);
        presenter.getProducts();
    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerHeader).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerProduct).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerHeader).setVisibility(View.GONE);
        findViewById(R.id.shimmerProduct).setVisibility(View.GONE);
    }

    @Override
    public void setProduct(List<Products.Product> product) {
        for (Products.Product productResult : product){
            Log.w("setProducts: ", productResult.getImgURL());
        }
    }

    @Override
    public void onErrorLoading(String message) {

    }
}
