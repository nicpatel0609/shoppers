package com.example.nishit_patel_project2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nishit_patel_project2.DataClass.CartData;
import com.example.nishit_patel_project2.DataClass.Constant;
import com.example.nishit_patel_project2.R;
import com.example.nishit_patel_project2.databinding.ActivityProductDetailBinding;
import com.squareup.picasso.Picasso;

public class ProductDetail extends AppCompatActivity {
    ActivityProductDetailBinding productDetailBinding;
    int product_image;
    String product_name, product_price, product_dicount, product_review, product_rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productDetailBinding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        View view = productDetailBinding.getRoot();
        setContentView(view);
        try {
            Intent i = getIntent();
            product_dicount = i.getStringExtra("discount");
            product_name = i.getStringExtra("name");
            product_price = i.getStringExtra("pr");
            product_review = i.getStringExtra("review");
            product_rating = i.getStringExtra("rating");
            product_image = i.getIntExtra("img", 0);

            productDetailBinding.productRating.setText(product_rating);
            productDetailBinding.productPrice.setText(product_price);
            productDetailBinding.productName.setText(product_name);
            productDetailBinding.productReview.setText(product_review);
            Picasso.get().load(product_image).into(productDetailBinding.productImg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        productDetailBinding.btnMoveToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constant.movelist.add(new CartData(product_image,product_name, product_price,product_dicount));
                startActivity(new Intent(ProductDetail.this, CartList.class));
                Toast.makeText(ProductDetail.this, "Save to cart ", Toast.LENGTH_SHORT).show();
            }
        });
        productDetailBinding.cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetail.this, CartList.class);
                startActivity(i);
                finish();
            }
        });

    }
}