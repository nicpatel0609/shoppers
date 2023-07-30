package com.example.nishit_patel_project2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.nishit_patel_project2.R;
import com.example.nishit_patel_project2.databinding.ActivityCheckOutBinding;

public class CheckOut extends AppCompatActivity {
    ActivityCheckOutBinding checkOutBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkOutBinding = ActivityCheckOutBinding.inflate(getLayoutInflater());
        View view = checkOutBinding.getRoot();
        setContentView(view);
    }
}