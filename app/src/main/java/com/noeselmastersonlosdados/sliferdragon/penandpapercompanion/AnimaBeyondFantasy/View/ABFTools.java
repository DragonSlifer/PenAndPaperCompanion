package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class ABFTools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abftools);
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

    public void goto_AddCategory(View view) {
        Intent i = new Intent(this, ABF_add_category.class);
        startActivity(i);
    }

}
