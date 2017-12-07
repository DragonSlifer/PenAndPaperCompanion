package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.ABFDifficultyEffects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 06/10/2017.
 */

public class AbfPsiPowerLevel implements Parcelable, Serializable{
    private String name;
    private int level;
    private String action, modifier;
    private ABFDifficultyEffects abfDifficultyEffects;

    public AbfPsiPowerLevel() {
    }

    protected AbfPsiPowerLevel(Parcel in) {
        name = in.readString();
        level = in.readInt();
        action = in.readString();
        modifier = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(level);
        dest.writeString(action);
        dest.writeString(modifier);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AbfPsiPowerLevel> CREATOR = new Creator<AbfPsiPowerLevel>() {
        @Override
        public AbfPsiPowerLevel createFromParcel(Parcel in) {
            return new AbfPsiPowerLevel(in);
        }

        @Override
        public AbfPsiPowerLevel[] newArray(int size) {
            return new AbfPsiPowerLevel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public ABFDifficultyEffects getAbfDifficultyEffects() {
        return abfDifficultyEffects;
    }

    public void setAbfDifficultyEffects(ABFDifficultyEffects abfDifficultyEffects) {
        this.abfDifficultyEffects = abfDifficultyEffects;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<String>();

        lines.add("[Name: " + name + "]");
        lines.add("[Level: " + level + "]");
        lines.add("[Action: " + action + "]");
        lines.add("[Modifier: " + modifier + "]");
        lines.add("[Difficulty Effects]");
        lines = concatenateArrays(lines, abfDifficultyEffects.printInfo());

        return lines;
    }

    private ArrayList concatenateArrays(ArrayList one, ArrayList two){
        for (int i = 0; i < two.size(); i++){
            one.add(two.get(i));
        }
        return one;
    }
}
