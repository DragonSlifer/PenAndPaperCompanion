package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data;

import android.content.Context;
import android.content.res.Resources;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Ability;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

import java.util.ArrayList;

/**
 * Created by Jorge on 03/12/2017.
 */

public class GeneralInfo {
    public static ArrayList<ABFCatCosts> catCostsArrayList;
    public static ArrayList<ABFAbilityData> abilities;

    public GeneralInfo(ArrayList<Ability> abilityArrayList){
        String[] ss = (Resources.getSystem().getStringArray(R.array.ABFCategories));
        catCostsArrayList = new ArrayList<>();
        abilities = new ArrayList<>();
        for (String s : ss){
            catCostsArrayList.add(new ABFCatCosts(s));
        }
        for(Ability a : abilityArrayList){
            ABFAbilityData abfAbilityData = new ABFAbilityData(a.getName(),a.getAttribute_bonus());
            abilities.add(abfAbilityData);
        }
    }


    public static ArrayList<ABFCatCosts> getCatCostsArrayList() {
        return catCostsArrayList;
    }

    public static void setCatCostsArrayList(ArrayList<ABFCatCosts> catCostsArrayList) {
        GeneralInfo.catCostsArrayList = catCostsArrayList;
    }

    public static ArrayList<ABFAbilityData> getAbilities() {
        return abilities;
    }

    public static void setAbilities(ArrayList<ABFAbilityData> abilities) {
        GeneralInfo.abilities = abilities;
    }
}
