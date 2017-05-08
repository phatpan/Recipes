package com.app.phatpan.recipes.presenter;

import android.view.View;

import com.app.phatpan.recipes.Favorite;
import com.app.phatpan.recipes.Recipe;
import com.app.phatpan.recipes.RecipeActivity;
import com.app.phatpan.recipes.RecipeApplication;
import com.app.phatpan.recipes.RecipeStore;

/**
 * Created by phatpan on 5/7/2017 AD.
 */

public class RecipePresenter {
    private final RecipeView recipeView;
    private final Favorite favorite;

    public RecipePresenter(RecipeView recipeView, Favorite favorite) {
        this.recipeView = recipeView;
        this.favorite = favorite;

    }

    public void loadData(String id){
        RecipeStore store = new RecipeStore();
        final Recipe recipe = store.getRecipe(id);
        if(recipe == null){
            recipeView.showRecipeNotFound();
        } else {
            recipeView.showRecipe(recipe);
            recipeView.showFavorite(favorite.get(id));
        }
    }

    public void toggle(String id){
        recipeView.showFavorite(favorite.toggle(id));
    }

    public interface RecipeView {
        void showRecipe(Recipe recipe);
        void showRecipeNotFound();
        void showFavorite(boolean isFavorite);
    }
}
