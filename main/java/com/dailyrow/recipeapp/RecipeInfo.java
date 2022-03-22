package com.dailyrow.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class RecipeInfo extends AppCompatActivity {

    ImageView img;
    TextView txt;
   // ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);

        img = findViewById(R.id.image);
        txt = findViewById(R.id.recipe);
        //lv = findViewById(R.id.ingredients);

        Intent intent = getIntent();

        img.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground));
        txt.setText(intent.getStringExtra("name"));
        txt.setText(intent.getStringExtra("ingredients"));
    }
}