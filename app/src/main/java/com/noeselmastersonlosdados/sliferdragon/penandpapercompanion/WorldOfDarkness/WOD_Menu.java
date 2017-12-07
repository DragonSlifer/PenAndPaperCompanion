package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.WorldOfDarkness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WOD_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.layout.activity_wod_menu);
    }

    public void startVTMMode (View view){
        Intent i = new Intent(this, WODVTM.class);
        startActivity(i);
    }
}
