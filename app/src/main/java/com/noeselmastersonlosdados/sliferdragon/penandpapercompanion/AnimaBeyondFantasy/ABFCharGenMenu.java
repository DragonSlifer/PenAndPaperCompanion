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
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.GeneralMenus.LoadCharacter;
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
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Constants.RESULT_OK) {
            switch (requestCode) {
                case Constants.REQUEST_NULL:
                    break;
                case Constants.REQUEST_SAVEDATA:
                    if (data.getExtras() != null) {
                        this.abfToolsSaveData = data.getParcelableExtra(Constants.EISaveDataClass);
                    }
                    break;
                case Constants.REQUEST_LOADCHAR:
                    if (data.getExtras() != null) {
                        abfToolsSaveData.setCharacter((ABFCharacter) data.getParcelableExtra(Constants.EIObjectData));
                    }
                    break;
            }


        }

    }

    public void goto_ClassAndRace(View view) {
        Intent i = new Intent(this, ABF_CharGen_ClassAndRace.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_CombatAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_CombatAbilities.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_MagicAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_MagicAbilities.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_PsyquicAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_KiAbilities(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_MartialArts(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Incarnations(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Grimoires(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_PsiPatrons(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Weapons(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_Inventory(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void goto_CharBackInfo(View view) {
        Intent i = new Intent(this, ABF_CharGen_BasicInfo.class);
        i.putExtra(Constants.EISaveDataClass, (Parcelable) abfToolsSaveData);
        startActivity(i);
    }

    public void saveInfo(View view) {
        if (abfToolsSaveData.getCharacter().getName() != "" || abfToolsSaveData.getCharacter().getName() != null) {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Constants.setUserIdentifier(user.getUid());
            abfToolsSaveData.getCharacter().setFirstTime(false);
            abfToolsSaveData.getCharacter().setEditMode(false);
            databaseConnector.saveCharacterData(Constants.CollectionABF, Constants.getUserIdentifierCollection(Constants.CollectionCharacterSheets), abfToolsSaveData.getCharacter());
            /*    //GeneralMethods.ShowSnackbar(R.string.succsessful_save, this.getCurrentFocus());
            } else {
                //GeneralMethods.ShowSnackbar(R.string.fail_save,this.getCurrentFocus());
            }*/
        } else {
            //GeneralMethods.ShowSnackbar(R.string.char_empty_data,this.getCurrentFocus());
        }
    }

    public void loadCharacter(View view) {
        Intent i = new Intent(this, LoadCharacter.class);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Constants.setUserIdentifier(user.getUid());
        i.putExtra(Constants.EIGameCollection, Constants.CollectionABF);
        i.putExtra(Constants.EIUserCollection, Constants.getUserIdentifierCollection(Constants.CollectionCharacterSheets));
        i.putExtra(Constants.EIObjectType, Constants.ClassABFCharacter);
        startActivityForResult(i, Constants.REQUEST_LOADCHAR);
    }

}
