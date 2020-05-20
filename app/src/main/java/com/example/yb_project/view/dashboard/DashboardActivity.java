package com.example.yb_project.view.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.yb_project.R;
import com.example.yb_project.SwitchSetting;
import com.example.yb_project.Utils;
import com.example.yb_project.WebviewActivity;
import com.example.yb_project.adapter.RecyclerViewDashboardAdapter;
import com.example.yb_project.adapter.ViewPagerHeaderAdapter;
import com.example.yb_project.adapter.ViewPagerSettingAdapter;
import com.example.yb_project.model.Products;
import com.example.yb_project.model.Settings;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardView {

    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerHeader;
    @BindView(R.id.recyclerCategory)
    RecyclerView recyclerViewProduct;
    @BindView(R.id.viewPagerWhatsapp)
    ViewPager viewPagerWhatsapp;

    DashboardPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Dashboard");
        setSupportActionBar(toolbar);

        presenter = new DashboardPresenter(this);
        presenter.getProducts();
        presenter.getSettings();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
    }

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            DashboardActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPagerHeader.getCurrentItem() == 0){
                        viewPagerHeader.setCurrentItem(1);
                    }else if (viewPagerHeader.getCurrentItem() == 1){
                        viewPagerHeader.setCurrentItem(2);
                    }else if (viewPagerHeader.getCurrentItem() == 2){
                        viewPagerHeader.setCurrentItem(3);
                    }else if (viewPagerHeader.getCurrentItem() == 3){
                        viewPagerHeader.setCurrentItem(4);
                    }else if (viewPagerHeader.getCurrentItem() == 4){
                        viewPagerHeader.setCurrentItem(5);
                    }else if (viewPagerHeader.getCurrentItem() == 5){
                        viewPagerHeader.setCurrentItem(6);
                    }else{
                        viewPagerHeader.setCurrentItem(0);
                    }
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings){
            Intent intent = new Intent(DashboardActivity.this, SwitchSetting.class);
            startActivity(intent);
        }else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerHeader).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerProduct).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerWhatsapp).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerHeader).setVisibility(View.GONE);
        findViewById(R.id.shimmerProduct).setVisibility(View.GONE);
        findViewById(R.id.shimmerWhatsapp).setVisibility(View.GONE);
    }

    @Override
    public void setProduct(List<Products.Product> product) {
        RecyclerViewDashboardAdapter dashboardAdapter = new RecyclerViewDashboardAdapter(product, this);
        recyclerViewProduct.setAdapter(dashboardAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false);
        recyclerViewProduct.setLayoutManager(layoutManager);
        recyclerViewProduct.setNestedScrollingEnabled(true);
        dashboardAdapter.notifyDataSetChanged();
        dashboardAdapter.setOnItemClickListener((view, position) -> {
            Toast.makeText(this, product.get(position).getLink(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, WebviewActivity.class);
            intent.putExtra("link_url", product.get(position).getLink());
            startActivity(intent);
        });

        ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(product, this);
        viewPagerHeader.setAdapter(headerAdapter);
        viewPagerHeader.setPadding(20, 0, 150, 0);
        headerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setSetting(List<Settings.Setting> setting) {
        ViewPagerSettingAdapter settingAdapter = new ViewPagerSettingAdapter(setting, this);
        viewPagerWhatsapp.setAdapter(settingAdapter);
        viewPagerWhatsapp.setPadding(20, 0, 20, 0);
        settingAdapter.notifyDataSetChanged();
        settingAdapter.setOnItemClickListener((view, position) -> {

            Intent kirimWhatsapp = new Intent(Intent.ACTION_SEND);
            kirimWhatsapp.setType("text/plain");
            kirimWhatsapp.putExtra(Intent.EXTRA_TEXT, setting.get(position).getIsiPesan());
            kirimWhatsapp.putExtra("jid", setting.get(position).getNomor() + "@s.whatsapp.net");
            kirimWhatsapp.setPackage("com.whatsapp");

            startActivity(kirimWhatsapp);
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Title", message);
    }
}
