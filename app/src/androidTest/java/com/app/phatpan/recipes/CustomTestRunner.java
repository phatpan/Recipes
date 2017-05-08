package com.app.phatpan.recipes;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by phatpan on 5/7/2017 AD.
 */

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}
