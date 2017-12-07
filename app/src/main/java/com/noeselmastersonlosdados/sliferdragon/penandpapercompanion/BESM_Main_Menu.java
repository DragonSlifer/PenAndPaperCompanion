package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BESM_Main_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.layout.activity_besm__main__menu);
    }

    public void gotoCharCreation(View view){
        Intent i = new Intent(this, charBESM.class);
        startActivity(i);
    }
}
