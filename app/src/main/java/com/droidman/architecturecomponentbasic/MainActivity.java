package com.droidman.architecturecomponentbasic;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.droidman.architecturecomponentbasic.db.entity.Foods;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodItemsViewModel foodItemsViewModel = ViewModelProviders.of(this).get(FoodItemsViewModel.class);

        foodItemsViewModel.addNewFoodItem(new Foods("PIZZA"));

        foodItemsViewModel.getFoodItemList().observe(this, new Observer<List<Foods>>() {
            @Override
            public void onChanged(@Nullable List<Foods> foodItems) {
                Foods foods = foodItems.get(0);
                Toast.makeText(MainActivity.this,foods.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
