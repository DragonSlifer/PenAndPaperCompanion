package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFCharacter;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFToolsSaveData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Constants;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.DatabaseConnector;

public class ABFCharGenMenu extends AppCompatActivity {

    private static Context c;
    private ABFToolsSaveData abfToolsSaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abfchar_gen_menu);
        abfToolsSaveData = new ABFToolsSaveData();
    }

    public void goto_BasicInfo(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data.getExtras() != null) {
            String actionResult = data.getStringExtra("ActionResult");
            if (actionResult == "SendingInfo") {
                this.abfToolsSaveData = data.getParcelableExtra("SaveDataClass");
            } else if (actionResult == "LoadCharacter") {
                ABFCharacter abfCharacter = data.getParcelableExtra("CharacterSheet");
                this.abfToolsSaveData.setCharacter(abfCharacter);
            }
        }
    }

    public void goto_ClassAndRace(View view) {
        Intent i = new Intent(this, ABF_CharGen_ClassAndRace.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_CombatAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_CombatAbilities.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_MagicAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_MagicAbilities.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_PsyquicAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_KiAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_MartialArts(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Incarnations(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Grimoires(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_PsiPatrons(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Weapons(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Inventory(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_CharBackInfo(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void saveInfo(View view){
        DatabaseConnector databaseConnector = new DatabaseConnector();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Constants.setUserIdentifier(user.getUid());
        abfToolsSaveData.getCharacter().setFirstTime(false);
        databaseConnector.setData(abfToolsSaveData.getCharacter(), Constants.getUserIdentifierCollection(Constants.CollectionABFCharacterSheets));
    }

    public void loadCharacter(View view){
        DatabaseConnector databaseConnector = new DatabaseConnector();
    }
}
