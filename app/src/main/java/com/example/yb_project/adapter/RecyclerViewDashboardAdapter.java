package com.example.yb_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yb_project.R;
import com.example.yb_project.model.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewDashboardAdapter extends RecyclerView.Adapter<RecyclerViewDashboardAdapter.RecyclerViewHolder> {

    private List<Products.Product> products;
    private Context context;
    private static ClickListener clickListener;

    public RecyclerViewDashboardAdapter(List<Products.Product> products, Context context){
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewDashboardAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category,
                parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewDashboardAdapter.RecyclerViewHolder holder, int position) {
        String strGambar = products.get(position).getGambar();
        Picasso.get().load(strGambar).placeholder(R.drawable.ic_circle).into(holder.productThumb);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.productThumb)
        ImageView productThumb;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewDashboardAdapter.clickListener = clickListener;
    }
    public interface ClickListener {
        void onClick(View view, int position);
    }

}
