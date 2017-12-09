package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFToolsSaveData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class ABFTools extends AppCompatActivity {

    private static ABFToolsSaveData abfToolsSaveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abftools);
        //abfToolsSaveData = new ABFToolsSaveData();
    }

    public void goto_CharGenMenu(View view) {
        Intent i = new Intent(this, ABFCharGenMenu.class);
        startActivity(i);
    }

    public void goto_CombatMenu(View view) {
        Intent i = new Intent(this, ABFCombatTools.class);
        //i.putExtra("EISaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

}
