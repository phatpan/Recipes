package com.app.phatpan.recipes;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recipes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecipeAdapter(new RecipeStore()));
    }
}

public class RecipeStore {

    public Recipe get(int position) {
        return new Recipe(""+ position, "Title" + position, "Description");
    }

    public int size() {
        return 20;
    }

    public Recipe getRecipe(String id) {
        if(id == null) {
            return null;
        }
        return new Recipe(id, "Title" + id, "Description");
    }
}
 public class Recipe {

    private String id;
    private String title;
    private String description;

    public Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

