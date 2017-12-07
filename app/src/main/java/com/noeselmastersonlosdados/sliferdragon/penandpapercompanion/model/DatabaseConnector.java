package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;

import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
import java.util.Random;

/**
 * Created by Jorge on 26/11/2017.
 */

public class DatabaseConnector {
    private String user_name = "TESTING";
    private String user_pass = "TESTING";
    private String user_emai = "dragonslifer45@gmail.com";
    public static String user_id;
    private static FirebaseFirestore db;
    private String userCollection;
    private int firstTimePromted = 0;

    public DatabaseConnector(){
        if (db == null){
            db = FirebaseFirestore.getInstance();
        }

        User user = new User(user_name,user_pass);
        //user.setUser_pass((generateUserPass(user)));
        //generateUserID(user);
        retrieveUserData(user);
        addNewUser(user);
        user.setUser_pass(user_pass);
        //if(user == null){
        //    while(promptLoginOutput());
        //    user_id = user.getUserId();
        //}
    }

    private void retrieveUserData(final User user) {
        db.collection(STRING_CONSTS.CollectionUserData)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot documentSnapshot : task.getResult()){
                            if(documentSnapshot.toObject(User.class).getUser_name() == user.getUser_name()){
                                user.setSalt(documentSnapshot.toObject(User.class).getSalt());
                                user.setUser_id(documentSnapshot.toObject(User.class).getUser_id());
                            }
                        }
                    }
                });
    }

    public String getUser_id(){
        return user_id;
    }

    private void generateUserID(User u){
        if(u.getUser_id() != null && !pertainsToUser(u.getUser_id(),u.getUser_name(),u.getSalt())){
            ///< TODO LOGIN AGAIN AND NOTIFICATE USER
        } else if (u.getUser_id() == null){
            u.setUser_id(Base64.encode(( u.getSalt().substring(0,15) +
                    Base64.encode(u.getUser_name().getBytes(),Base64.DEFAULT).toString() +
                    u.getSalt().substring(16)).getBytes(),Base64.DEFAULT).toString());
            Log.i(STRING_CONSTS.DatabaseConnectorTAG,u.getUser_id());
        }
    }

    private boolean pertainsToUser(String user_id, String user_name, String salt) {
        String leftChars, rightChars;
        leftChars = salt.substring(0,15);
        rightChars = salt.substring(16);

        String key = leftChars + Base64.encode(user_name.getBytes(),Base64.DEFAULT).toString() + rightChars;
        key = Base64.encode(key.getBytes(),Base64.DEFAULT).toString();

        return key == user_id;
    }

    private User check_userData(){
        final User[] user = new User[1];

        db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (DocumentSnapshot document : task.getResult()) {
                                if(document.toObject(User.class).checkInfo(user_name, user_pass)){
                                    user[0] = document.toObject(User.class);
                                    break;
                                } else {
                                    user[0] = null;
                                }
                            }
                        } else {
                            Log.w("ERROR", "Error getting documents.", task.getException());
                        }
                    }
                });
        return user[0];
    }

    private boolean checkUserPass(){
        String pass = user_pass;
        boolean retval;

        pass = Base64.encode(pass.getBytes(),Base64.DEFAULT).toString();

        ArrayList<MapMod> mapModArrayList = retrieveData(STRING_CONSTS.CollectionUserData);
        MapMod mapMod = new MapMod();
        for (MapMod m : mapModArrayList){
            if(((User)m.map).getUser_name() == user_name){
                mapMod = m;
                pass += ((User) m.map).getSalt();
                break;
            }
        }
        pass = Base64.encode(pass.getBytes(),Base64.DEFAULT).toString();

        if(mapMod != null && pass == ((User)mapMod.map).getUser_pass())
            retval = true;
        else
            retval = false;

        return retval;
    }

    public String generateUserPass(User u){
        String key = u.getUser_pass();
        key = Base64.encode(key.getBytes(),Base64.DEFAULT).toString();
        String salt = "";
        char[] alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r = new Random();
        for(int i = 0; i < 32; i++){
            int pos = r.nextInt(31 - 0 + 1);
            salt += alphanumeric[pos];
        }
        key += salt;
        u.setSalt(salt);
        key = Base64.encode(key.getBytes(),Base64.DEFAULT).toString();
        return key;
    }

    public void addNewUser(User u){
        if(!containsUser(u)){
            //String key = generateUserPass(u);
            //String local_key = u.getUser_pass();
            //u.setUser_pass(key);
            addData(u,STRING_CONSTS.CollectionUserData);
            //u.setUser_pass(local_key);
        }
    }

    private boolean containsUser(final User u) {
        final boolean[] containsUser = {false};
        Log.i(STRING_CONSTS.DatabaseConnectorTAG,"Checking user");

        db.collection("UserData")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot querySnapshot = task.getResult();
                        for (DocumentSnapshot documentSnapshot : querySnapshot){
                            Log.i(STRING_CONSTS.DatabaseConnectorTAG,"UserId = " + u.getUser_id() + " checked user id = " + documentSnapshot.toObject(User.class).getUser_id());
                            if (documentSnapshot.getId() == u.getUser_id()){
                                containsUser[0] = true;
                            }
                            else{
                                containsUser[0] = false;
                            }
                        }
                    }
                });
        Log.i(STRING_CONSTS.DatabaseConnectorTAG,"User checked");

        return containsUser[0];
    }

    private boolean promptLoginOutput() {
        boolean result = true;
        if(firstTimePromted == 0){
            firstTimePromted++;
        }

        if(firstTimePromted > 0){

        }

        return result;
    }

    /**
     * public void setData(Object data, String collection)
     * Used to update the data on the database. If the document
     * exists, it will merge the data.
     * @param data
     * @param collection
     */
    public void setData(Object data, String collection){
        if(data != null) {
            db.collection(collection).document(data.toString())
                    .set(data, SetOptions.merge())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(STRING_CONSTS.DatabaseConnectorTAG, "DocumentSnapshot successfully written!");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(STRING_CONSTS.DatabaseConnectorTAG, "Error writing document", e);
                        }
                    });
        }
    }

    public void addData(Object data, String collection){
        if(data != null) {
            db.collection(collection)
                    .add(data)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(STRING_CONSTS.DatabaseConnectorTAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(STRING_CONSTS.DatabaseConnectorTAG, "Error adding document", e);
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
        ArrayList<ABFAbilityData> abfAbilityDataArrayList = generalInfo.getAbilities();

        db.collection(STRING_CONSTS.CollectionABF).document(STRING_CONSTS.CollectionABFGeneralInfo)
                .collection(STRING_CONSTS.CollectionABFClassRelated).document(STRING_CONSTS.CollectionABFAbilities)
                .set(abfAbilityDataArrayList)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(STRING_CONSTS.DatabaseConnectorTAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(STRING_CONSTS.DatabaseConnectorTAG, "Error writing document", e);
                    }
                });
    }
}
