package com.example.nishit_patel_project2.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nishit_patel_project2.DataClass.ProductData;
import com.example.nishit_patel_project2.R;
import com.example.nishit_patel_project2.UI.ProductDetail;
import com.example.nishit_patel_project2.databinding.RowLayoutBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    Context context;
    ArrayList<ProductData> productList;

    public ProductAdapter(Context context, ArrayList<ProductData> productList) {
        this.context = context;
        this.productList = productList;
    }
    @NonNull
    @Override
    public ProductAdapter.ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductHolder holder, int position) {
        holder.rowLayoutBinding.productName.setText(productList.get(position).getName());
        holder.rowLayoutBinding.productDiscount.setText(productList.get(position).getDicountrate());
        holder.rowLayoutBinding.productPrice.setText(productList.get(position).getPrice());
        Picasso.get().load(productList.get(position).getImage()).into(holder.rowLayoutBinding.productImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ProductDetail.class);
                i.putExtra("img",productList.get(position).getImage());
                i.putExtra("discount",productList.get(position).getDicountrate());
                i.putExtra("name",productList.get(position).getName());
                i.putExtra("pr",productList.get(position).getPrice());
                i.putExtra("rating",productList.get(position).getRating());
                i.putExtra("review",productList.get(position).getReview());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        RowLayoutBinding rowLayoutBinding;
        public ProductHolder(RowLayoutBinding rowLayoutBinding) {
            super(rowLayoutBinding.getRoot());
            this.rowLayoutBinding = rowLayoutBinding;
        }
    }
}
