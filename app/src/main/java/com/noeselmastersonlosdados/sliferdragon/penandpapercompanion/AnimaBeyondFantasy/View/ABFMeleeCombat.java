package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class ABFMeleeCombat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abfmelee_combat);
    }

    public void goto_MeleeAttacker(View view) {
        Intent i = new Intent(this, ABFConfigureMeleeCharacter.class);
        i.putExtra("CHAR_ROLE",1);
        startActivity(i);
    }

    public void goto_MeleeDefender(View view) {
        Intent i = new Intent(this, ABFConfigureMeleeCharacter.class);
        i.putExtra("CHAR_ROLE",2);
        startActivity(i);
    }
}
