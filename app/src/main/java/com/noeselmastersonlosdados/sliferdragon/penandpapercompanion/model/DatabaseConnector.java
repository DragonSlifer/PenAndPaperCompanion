package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFCharacter;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Ability;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data.ABFAbilityData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data.GeneralInfo;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.SecondAbilities;

import java.util.ArrayList;

/**
 * Created by Jorge on 26/11/2017.
 */

public class DatabaseConnector {
    private static FirebaseFirestore db;

    public DatabaseConnector(){
        if (db == null){
            db = FirebaseFirestore.getInstance();
        }
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Constants.setUserIdentifier(user.getUid());
    }

    /**
     * public void setData(Object data, String collection)
     * Used to update the data on the database. If the document
     * exists, it will merge the data.
     * @param data
     * @param collection
     */
    public boolean setData(Object data, String collection) {
        final boolean[] ok = {false};
        if(data != null) {
            db.collection(collection).document(data.toString())
                    .set(data, SetOptions.merge())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(Constants.DatabaseConnectorTAG, "DocumentSnapshot successfully written!");
                            ok[0] = true;
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(Constants.DatabaseConnectorTAG, "Error writing document", e);
                        }
                    });
        }
        return ok[0];
    }

    public void addData(Object data, String collection){
        if(data != null) {
            db.collection(collection)
                    .add(data)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(Constants.DatabaseConnectorTAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(Constants.DatabaseConnectorTAG, "Error adding document", e);
                        }
                    });
        }
    }

    public ArrayList<MapMod> retrieveData(String collection){
        final ArrayList<MapMod> data = new ArrayList<>();
        db.collection(collection)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d("INFO", document.getId() + " => " + document.getData());
                                MapMod map = new MapMod();
                                map.uid = document.getId();
                                map.map = document.toObject(Object.class);
                                data.add(map);
                            }
                        } else {
                            Log.w("ERROR", "Error getting documents.", task.getException());
                        }
                    }
                });
        if(data.size() == 0) {
            MapMod map = new MapMod();
            map.uid = "-1";
            map.map = null;
            data.add(map);
        }
        return data;
    }

    public boolean contains(final Object o, String collection){
        return contains(o, collection,"none");
    }

    public boolean contains(final Object o, String collection, final String objectConversion){
        final boolean[] retval = {false};
        db.collection(collection)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot document : task.getResult()){
                                if (document != null){
                                    if(document.toObject(Object.class) == o)
                                        retval[0] = true;
                                }
                            }
                        }
                    }
                });
        return retval[0];
    }

    public void prepareDatabase() {
        ABFCharacter abfCharacter = new ABFCharacter();
        SecondAbilities secondAbilities = abfCharacter.getSecondAbilities();
        ArrayList<Ability> abilities = new ArrayList<>();
        abilities.addAll(secondAbilities.getAthletics().getAbilities());
        abilities.addAll(secondAbilities.getSocials().getAbilities());
        abilities.addAll(secondAbilities.getPerception().getAbilities());
        abilities.addAll(secondAbilities.getVigor().getAbilities());
        abilities.addAll(secondAbilities.getIntellectual().getAbilities());
        abilities.addAll(secondAbilities.getCreative().getAbilities());
        abilities.addAll(secondAbilities.getSpecials().getAbilities());
        GeneralInfo generalInfo = new GeneralInfo(abilities);
        ArrayList<ABFAbilityData> abfAbilityDataArrayList = GeneralInfo.getAbilities();

        db.collection(Constants.CollectionABF).document(Constants.CollectionABFGeneralInfo)
                .collection(Constants.CollectionABFClassRelated).document(Constants.CollectionABFAbilities)
                .set(abfAbilityDataArrayList)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(Constants.DatabaseConnectorTAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(Constants.DatabaseConnectorTAG, "Error writing document", e);
                    }
                });
    }

    /**
     * public ArrayList<String> retrieveCharacterNames(final String gameCollection, String userIdentifierCollection) **
     * This retrieves all the character names from the personal collection of the user.
     *
     * @param gameCollection           Game collection from which the names would be retrieved
     * @param userIdentifierCollection EIUser EICollection from which the names would be retrieved
     * @return Names of all the user's characters
     */
    public ArrayList<String> retrieveCharacterNames(final String gameCollection, String userIdentifierCollection) {
        final ArrayList<String> characterNames = new ArrayList<>();

        db.collection(gameCollection).document(Constants.CollectionCharacterSheets).collection(userIdentifierCollection)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot doc : task.getResult()) {
                            if (doc != null) {
                                switch (gameCollection) {
                                    case Constants.CollectionABF:
                                        characterNames.add((doc.toObject(ABFCharacter.class)).toString());  ///< We only need the names
                                        Log.i(Constants.DatabaseConnectorTAG, "Character retrieved: " + (doc.toObject(ABFCharacter.class)).toString());
                                        break;
                                }
                            }
                        }
                    }
                });
        return characterNames;
    }

    public void saveCharacterData(String gameCollection, String userIdentifierCollection, Object data) {
        db.collection(gameCollection).document(Constants.CollectionCharacterSheets)
                .collection(userIdentifierCollection)
                .document(data.toString())
                .set(data, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(Constants.DatabaseConnectorTAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(Constants.DatabaseConnectorTAG, "Error writing document", e);
                    }
                });
    }

    public Object retrieveCharacterDataFromName(String gameCollection, String userIdentifierCollection, final String selected) {
        final Object[] character = {new Object()};
        final boolean[] end = {false};
        db.collection(gameCollection).document(Constants.CollectionCharacterSheets).collection(userIdentifierCollection)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot documentSnapshots) {
                        for (DocumentSnapshot documentSnapshot : documentSnapshots) {
                            if (documentSnapshot.toString() == selected)
                                character[0] = documentSnapshot.toObject(Object.class);
                        }
                        end[0] = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        character[0] = null;
                        end[0] = true;
                    }
                });
        return character[0];
    }
}
