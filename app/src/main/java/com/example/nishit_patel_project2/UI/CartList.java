package com.example.nishit_patel_project2.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nishit_patel_project2.Adapter.CartAdapter;
import com.example.nishit_patel_project2.DataClass.Constant;
import com.example.nishit_patel_project2.R;
import com.example.nishit_patel_project2.databinding.ActivityCartListBinding;

public class CartList extends AppCompatActivity {
    ActivityCartListBinding cartListBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartListBinding = ActivityCartListBinding.inflate(getLayoutInflater());
        View view = cartListBinding.getRoot();
        setContentView(view);

        if (Constant.movelist.size() == 0){
            cartListBinding.btnProcessToCheckout.setVisibility(View.GONE);
            cartListBinding.itemAlertMsgShow.setVisibility(View.VISIBLE);
        }else{
            cartListBinding.btnProcessToCheckout.setVisibility(View.VISIBLE);
            cartListBinding.itemAlertMsgShow.setVisibility(View.GONE);
            cartListBinding.recyclerItemCart.setHasFixedSize(true);
            cartListBinding.recyclerItemCart.setLayoutManager(new GridLayoutManager(this, 2));
            cartListBinding.recyclerItemCart.setAdapter(new CartAdapter(CartList.this, Constant.movelist));
        }
        cartListBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cartListBinding.btnProcessToCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartList.this, CheckOut.class);
                startActivity(i);
            }
        });
    }
}