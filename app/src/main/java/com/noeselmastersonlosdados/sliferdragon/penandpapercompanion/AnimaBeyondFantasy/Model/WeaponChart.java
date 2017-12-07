package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 29/09/2017.
 */

public class WeaponChart implements Parcelable, Serializable{
    private String name;
    private ArrayList<String> weapons;
    private int cost;

    public WeaponChart() {
    }

    protected WeaponChart(Parcel in) {
        name = in.readString();
        weapons = in.createStringArrayList();
        cost = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeStringList(weapons);
        dest.writeInt(cost);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeaponChart> CREATOR = new Creator<WeaponChart>() {
        @Override
        public WeaponChart createFromParcel(Parcel in) {
            return new WeaponChart(in);
        }

        @Override
        public WeaponChart[] newArray(int size) {
            return new WeaponChart[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<String> weapons) {
        this.weapons = weapons;
    }

    public void addWeapon (String weapon){
        if(!this.weapons.contains(weapon))
            this.weapons.add(weapon);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String printInfo(){
        String line = name + "-" + cost + "- (";

        for (int i = 0; i < weapons.size(); i++){
            if(i != 0)
                line += ("," + weapons.get(i));
            else
                line += (weapons.get(i));
        }

        line += ")";

        return line;
    }
}
