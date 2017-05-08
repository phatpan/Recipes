package com.app.phatpan.recipes;

import android.app.Application;

/**
 * Created by phatpan on 5/7/2017 AD.
 */

public class RecipeApplication extends Application {
    private Favorite favorite = null;

    public Favorite getFavorite() {
        if(favorite == null){
            favorite = new SharedPreferencesFavorites(this);
        }
        return favorite;
    }

}
