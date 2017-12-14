package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data.Category;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Constants;

public class ABF_add_category extends AppCompatActivity {
    private Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abf_add_category);

        if (savedInstanceState != null) {
            category = savedInstanceState.getParcelable(Constants.ClassABFCategory);
        } else {
            category = new Category();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelable(Constants.ClassABFCategory, category);
        super.onSaveInstanceState(savedInstanceState);
    }
}
