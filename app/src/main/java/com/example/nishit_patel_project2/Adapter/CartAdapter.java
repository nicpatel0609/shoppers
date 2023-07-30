package com.example.nishit_patel_project2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nishit_patel_project2.DataClass.CartData;
import com.example.nishit_patel_project2.databinding.RowLayoutBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    Context context;
    ArrayList<CartData> movelist;
    public CartAdapter(Context context, ArrayList<CartData> movelist) {
        this.context = context;
        this.movelist = movelist;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartHolder holder, int position) {
        holder.rowLayoutBinding.productName.setText(movelist.get(position).getName());
        holder.rowLayoutBinding.productDiscount.setText(movelist.get(position).getDiscount());
        holder.rowLayoutBinding.productPrice.setText(movelist.get(position).getPrice());
        Picasso.get().load(movelist.get(position).getImage()).into(holder.rowLayoutBinding.productImg);
    }

    @Override
    public int getItemCount() {
        return movelist.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        RowLayoutBinding rowLayoutBinding;
        public CartHolder(@NonNull RowLayoutBinding rowLayoutBinding) {
            super(rowLayoutBinding.getRoot());
            this.rowLayoutBinding = rowLayoutBinding;
        }
    }
}
