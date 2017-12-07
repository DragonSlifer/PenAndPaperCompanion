package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 17/09/2017.
 */

public class abilitySet implements Parcelable, Serializable{

    private ArrayList<Ability> abilities;
    private int generalCost;    ///< general cost of the abilitySet Abilities
    private String set;

    public abilitySet(InputStream fis, String set){
        abilities = new ArrayList<>();
        this.set = set;
        try{
            BufferedReader bread = new BufferedReader(new InputStreamReader(fis));

            String linea;
            int i = 0;
            Ability aux = null;
            while((linea = bread.readLine()) != null){
                if(i % 2 == 0){     ///< If the line is a even number, then is the name of the ability
                    aux = new Ability();
                    aux.setSet(set);
                    aux.setName(linea);
                    i = 1;
                } else {            ///< If the line is not a even number, then is the attribute that gives the bonus
                    aux.setAttribute_bonus(linea);
                    abilities.add(aux);
                    aux = new Ability();
                    i = 0;
                }
            }
        } catch (Exception e){

        } finally{
            if (fis != null){
                try{
                    fis.close();
                } catch (IOException ignored){

                }
            }
        }
    }

    protected abilitySet(Parcel in) {
        abilities = in.createTypedArrayList(Ability.CREATOR);
        generalCost = in.readInt();
        set = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(abilities);
        dest.writeInt(generalCost);
        dest.writeString(set);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<abilitySet> CREATOR = new Creator<abilitySet>() {
        @Override
        public abilitySet createFromParcel(Parcel in) {
            return new abilitySet(in);
        }

        @Override
        public abilitySet[] newArray(int size) {
            return new abilitySet[size];
        }
    };

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getGeneralCost() {
        return generalCost;
    }

    public void setGeneralCost(int generalCost) {
        this.generalCost = generalCost;
        updateAbilityCost("all",generalCost);
    }

    /**
     * Updates the development point cost of the abilities
     * @param ability_to_update all --> update all abilities, <name of ability> updates one single ability
     * @param generalCost
     */
    private void updateAbilityCost(String ability_to_update, int generalCost) {
        if (ability_to_update == "all"){
            for (int i = 0; i < abilities.size(); i++){
                abilities.get(i).setCost(generalCost);
            }
        } else {
            int i = 0;
            boolean updated = false;
            while (updated){
                if (abilities.get(i).getName() == ability_to_update){
                    abilities.get(i).setCost(generalCost);
                    updated = true;
                }
                i++;
            }
        }
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();

        for (int i = 0; i < abilities.size(); i++){
            lines.add(abilities.toString());
        }

        return lines;
    }


}
