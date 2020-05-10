package com.example.yb_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.yb_project.R;
import com.example.yb_project.model.Products;

import java.util.List;

public class ViewPagerHeaderAdapter extends PagerAdapter {

    private List<Products.Product> products;
    private Context context;
    private static ClickListener clickListener;

    public ViewPagerHeaderAdapter(List<Products.Product> products, Context context){
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_view_pager_header,
                container,
                false
        );

        return null;
    }

    public interface ClickListener{
        void onClick(View v, int position);
    }
}
