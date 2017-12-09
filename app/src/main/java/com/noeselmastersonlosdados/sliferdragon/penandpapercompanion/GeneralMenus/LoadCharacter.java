package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.GeneralMenus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFCharacter;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Constants;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.DatabaseConnector;

import java.util.ArrayList;

public class LoadCharacter extends AppCompatActivity {
    private Object character;
    private ArrayList<Object> characters;
    private Spinner spinner;
    private DatabaseConnector databaseConnector;
    private String gameCollection;
    private String userCollection;
    private String objectType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_character);
        gameCollection = getIntent().getStringExtra(Constants.EIGameCollection);
        userCollection = getIntent().getStringExtra(Constants.EIUserCollection);
        objectType = getIntent().getStringExtra(Constants.EIObjectType);
        characters = new ArrayList<>();
        databaseConnector = new DatabaseConnector();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Log.i(Constants.DatabaseConnectorTAG, "Retrieving Characters!");
        Log.i(Constants.DatabaseConnectorTAG, "Collection: " + gameCollection + "/" + Constants.CollectionCharacterSheets + "/" + userCollection);

        db.collection(gameCollection).document(Constants.CollectionCharacterSheets).collection(userCollection)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<String> strings = new ArrayList<>();
                        for (DocumentSnapshot doc : task.getResult()) {
                            if (doc != null) {
                                Object playerCharacter;
                                switch (objectType) {
                                    case Constants.ClassABFCharacter:
                                        playerCharacter = doc.toObject(ABFCharacter.class);
                                        strings.add((doc.toObject(ABFCharacter.class)).toString());
                                        characters.add(playerCharacter);
                                        Log.i(Constants.DatabaseConnectorTAG, "Character retrieved: " + (doc.toObject(ABFCharacter.class)).toString());
                                        break;
                                }
                            }
                        }
                        setSpinner(strings);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(Constants.DatabaseConnectorTAG, "Characters not retrieved!");
                    }
                });
    }

    private void setSpinner(ArrayList<String> strings) {
        spinner = findViewById(R.id.charSpinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, strings);
        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    public void load(View view) {
        final String name = (String) spinner.getSelectedItem();
        //character = databaseConnector.retrieveCharacterDataFromName(gameCollection,userCollection,name);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Log.i(Constants.DatabaseConnectorTAG, characters.get(0).toString());

        for (Object o : characters) {
            switch (objectType) {
                case Constants.ClassABFCharacter:
                    if (((ABFCharacter) o).getName() == name) {
                        character = (ABFCharacter) o;
                    }
                    break;
            }
        }

        if (character == null) {
            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Loaded Character", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        Intent data = new Intent();
        switch (objectType) {
            case Constants.ClassABFCharacter:
                ABFCharacter abfCharacter = (ABFCharacter) character;
                data.putExtra(Constants.EIObjectData, (Parcelable) abfCharacter);
                break;
        }

        setResult(Constants.RESULT_OK, data);
        finish();
    }
}
