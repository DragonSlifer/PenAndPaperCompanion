package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFToolsSaveData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class ABFCombatTools extends AppCompatActivity {

    private static ABFToolsSaveData abfToolsSaveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abfcombat_tools);
        //abfToolsSaveData = (ABFToolsSaveData) getIntent().getParcelableExtra("SaveDataClass");
    }

    public void goto_MeleeCombat(View view) {
        Intent i = new Intent(this, ABFMeleeCombat.class);
        //i.putExtra("SaveDataClass",(Parcelable) abfToolsSaveData);
        startActivity(i);
    }
}