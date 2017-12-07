package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.ABFTools;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.WorldOfDarkness.WOD_Menu;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.DatabaseConnector;

public class PandPMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pand_pmain_menu);
        //DatabaseConnector databaseConnector = new DatabaseConnector();
        //databaseConnector.prepareDatabase();
    }

    public void goto_WOD_Menu(View view) {
        Intent i = new Intent(this, WOD_Menu.class);
        startActivity(i);
    }

    public void not_implemented_yet(View view) {
        Toast.makeText(this, getResources().getText(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.string.not_implemented_yet), Toast.LENGTH_SHORT).show();
    }

    public void goto_BESM_Menu(View view) {
        Intent i = new Intent(this, BESM_Main_Menu.class);
        startActivity(i);
    }

    public void goto_ABFTools(View view) {
        Intent i = new Intent(this, ABFTools.class);
        startActivity(i);
    }
}
