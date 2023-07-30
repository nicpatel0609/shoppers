package com.example.nishit_patel_project2.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nishit_patel_project2.Adapter.ProductAdapter;
import com.example.nishit_patel_project2.DataClass.ProductData;
import com.example.nishit_patel_project2.R;
import com.example.nishit_patel_project2.databinding.ActivityProductListBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    ActivityProductListBinding productListBinding;
    ArrayList<ProductData> productList = new ArrayList<>();
    DatabaseReference productRef;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productListBinding = ActivityProductListBinding.inflate(getLayoutInflater());
        View view = productListBinding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null){
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();
        }

        productListBinding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();

            }
        });

        productList.add(new ProductData(R.drawable.img_1,"SJCAM SJ4000 WI-FI SJ4000 WIFI Sports and Action Camera  (Black, 12 MP)","$3299","4.3","19 reviews","-14%"));
        productList.add(new ProductData(R.drawable.img_2,"SJCAM SJ6 Legend SJ6 Legend Sports and Action Camera  (Black, 16 MP)","$2499","4.2","32 reviews","-22%"));
        productList.add(new ProductData(R.drawable.img_3,"SONY ILCE-7SM3/BQ IN5 Mirrorless Camera Mirrorless  (Black)","$4519","3.1","26 reviews","-30%"));
        productList.add(new ProductData(R.drawable.img_4,"Canon EOS 3000D DSLR Camera 1 Camera Body, 18 - 55 mm Lens","$10709","4.4","40 reviews","-26%"));
        productList.add(new ProductData(R.drawable.img_5,"SONY Alpha Full Frame ILCE-7M2K/BQ IN5 Mirrorless Camera Body with 28 - 70 mm Lens","$4890","4.1","30 reviews","-14%"));
        productList.add(new ProductData(R.drawable.img_6,"FUJIFILM X Series X-T4 Mirrorless Camera Body Only","$4299","4.2","25 reviews","-16%"));
        productList.add(new ProductData(R.drawable.img_7,"Panasonic Lumix DMC-GH4 Mirrorless Camera Body with 12-60mm Lens","$469","3.9","18 reviews","-6%"));
        productList.add(new ProductData(R.drawable.img_8,"NIKON Z 50 Mirrorless Camera Body with 16-50mm Lens","$3899","3.9","16 reviews","-8%"));
        productList.add(new ProductData(R.drawable.img_9,"OLYMPUS TG 6 DSLR Camera Camera","$799","4.2","3 reviews","-19%"));

        productListBinding.productDataRecycler.setAdapter(new ProductAdapter(this, productList));
        productListBinding.productDataRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        productListBinding.productDataRecycler.setHasFixedSize(true);
    }
}