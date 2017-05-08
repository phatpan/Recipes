package com.app.phatpan.recipes;

/**
 * Created by phatpan on 5/7/2017 AD.
 */

public class TestRecipeApplication extends RecipeApplication{
    private final Favorite favorite = new InMemoryFavortite();

    @Override
    public Favorite getFavorite() {
        return favorite;
    }
}
