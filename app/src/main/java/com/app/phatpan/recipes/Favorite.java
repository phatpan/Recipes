package com.app.phatpan.recipes;

/**
 * Created by phatpan on 5/7/2017 AD.
 */

public interface Favorite {
    boolean get(String id);
    boolean toggle(String id);
}
