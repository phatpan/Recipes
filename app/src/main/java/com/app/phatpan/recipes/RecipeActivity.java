package com.app.phatpan.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.app.phatpan.recipes.presenter.RecipePresenter;

/**
 * Created by phatpan on 5/7/2017 AD.
 */

public class RecipeActivity extends AppCompatActivity implements RecipePresenter.RecipeView{
    private TextView titleTextView;
    private TextView descriptionTextView;
    private RecipeApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        titleTextView = (TextView)findViewById(R.id.title);
        descriptionTextView = (TextView)findViewById(R.id.description);

        application = (RecipeApplication) getApplication();

        final Intent intent = getIntent();
        final RecipePresenter recipePresenter = new RecipePresenter(this, application.getFavorite());
        recipePresenter.loadData(intent.getStringExtra("id"));

        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipePresenter.toggle(intent.getStringExtra("id"));
            }
        });
    }

    public void showRecipe(Recipe recipe){
        titleTextView.setVisibility(View.GONE);
        descriptionTextView.setText("Recipe not found");
        titleTextView.setSelected(application.getFavorite().get(recipe.getId()));
    }

    public void showReceipeNotFound(Recipe recipe){
        titleTextView.setText(recipe.getTitle());
        descriptionTextView.setText(recipe.getDescription());
    }
}
