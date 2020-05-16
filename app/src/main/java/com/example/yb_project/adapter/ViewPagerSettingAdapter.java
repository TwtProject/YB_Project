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
import com.example.yb_project.model.Settings;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerSettingAdapter extends PagerAdapter {

    private List<Settings.Setting> settings;
    private Context context;
    private static ClickListener clickListener;

    public ViewPagerSettingAdapter(List<Settings.Setting> settings, Context context){
        this.settings = settings;
        this.context = context;
    }

    public void setOnItemClickListener(ClickListener clickListener){
        ViewPagerSettingAdapter.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return settings.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_view_pager_whatsapp,
                container,
                false
        );

        ImageView whatsappThumb = view.findViewById(R.id.whatsappThumb);
        String strWhatsappThumb = settings.get(position).getThumb();
        Picasso.get().load(strWhatsappThumb).into(whatsappThumb);

        view.setOnClickListener(v -> clickListener.onClick(v, position));

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public interface ClickListener{
        void onClick(View v, int position);
    }
}
