package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.WorldOfDarkness;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WODVTM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.layout.activity_wod_vtm);
    }


    public void go_back (View view){
        finish();
    }

    public void goto_Clans (View view){
        Intent i = new Intent(this, WODVTMCLANS.class);
        startActivity(i);
    }

    public void goto_CharCreation (View view){
        Intent i = new Intent(this, charSheetVTM.class);
        startActivity(i);
    }

}
