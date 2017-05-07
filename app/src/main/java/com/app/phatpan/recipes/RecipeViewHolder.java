package com.app.phatpan.recipes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by phatpan on 5/7/2017 AD.
 */

public class RecipeViewHolder extends RecyclerView.ViewHolder{
    public final TextView textView;
    public RecipeViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }
}
