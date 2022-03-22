package com.dailyrow.recipeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeRowHolder> {

    ArrayList<Recipe> recipeData;
    Context context;
    MyClickInterface myClickInterface;

    public RecipeAdapter(ArrayList<Recipe> recipeData, Context context, MyClickInterface myClickInterface){
        this.context = context;
        this.recipeData = recipeData;
        this.myClickInterface = myClickInterface;

    }

    @NonNull
    @Override
    public RecipeRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recipe_row,parent,false);//setting false allows views to be added manually
            //Above creates the view using the data from context
        return new RecipeRowHolder(view);//Returns a new RecipeRowHolder from line 56
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeRowHolder holder, int position) {
        holder.txtRecipeName.setText(recipeData.get(position).getName());
        holder.imgRecipe.setImageResource(recipeData.get(position).getImage());

    }

    @Override
    public int getItemCount() {

        return recipeData.size();
    }

    class RecipeRowHolder extends RecyclerView.ViewHolder{

        TextView txtRecipeName;
        ImageView imgRecipe;

        public RecipeRowHolder(@NonNull View itemView) {
            super(itemView);

            txtRecipeName = itemView.findViewById(R.id.txt_recipe_name);
            imgRecipe = itemView.findViewById(R.id.img_recipe);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClickInterface.onItemClick(getAdapterPosition());

            }
        });

        }
    }
    interface MyClickInterface{
        void onItemClick(int positionOfRecipe);
    }
}
