package com.dailyrow.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.MyClickInterface {

    RecyclerView recyclerView;
    ArrayList<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_RecipeApp);//Allows splashscreen to run before the main activity
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        recipes = new ArrayList<>();

        recipes.add(new Recipe( "Golden syrup flapjacks","250g Jumbo porridge oats, 125g butter, 2-3tbsp golden syrup.",R.drawable.flapjacks));
        recipes.add(new Recipe( "Creamy tomato courgetti","4 slices of parma ham, 12 basil leaves, 350g Tomato and mascapone sauce, 250g Courgette.",R.drawable.corgetti));
        recipes.add(new Recipe( "Butter bean & chorizo stew","200g chorizo, 400g chopped tomatoes, 400g drained butter beans, 20g of pesto.",R.drawable.chorizo));
        recipes.add(new Recipe( "Prawn & leek frittata","3 large leeks, 150g raw peeled king prawns, 5 large eggs, 120g garlic & herb cream cheese.",R.drawable.frittata));

        RecipeAdapter recipeAdapter = new RecipeAdapter(recipes,this, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recipeAdapter);

    }

    @Override
    public void onItemClick(int positionOfRecipe) {
        Toast.makeText(this, "Clicked"+recipes.get(positionOfRecipe).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,RecipeInfo.class);
        intent.putExtra("image",recipes.get(positionOfRecipe).getImage());
        intent.putExtra("name",recipes.get(positionOfRecipe).getName());
        intent.putExtra("ingredients",recipes.get(positionOfRecipe).getIngredients());
        startActivity(intent);

    }
}
//David MacDonald