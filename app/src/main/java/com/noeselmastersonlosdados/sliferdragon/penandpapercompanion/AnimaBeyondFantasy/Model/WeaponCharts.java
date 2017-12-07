package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 17/09/2017.
 */

public class WeaponCharts implements Parcelable, Serializable {
    private ArrayList<WeaponChart> weaponChartArrayList;
    private int modifier;   ///< If it has some modifier for the types of weapons, here it is. It would
                            ///< be used to divide the cost of the weapon charts. Initialized to 1

    public WeaponCharts() {
        modifier = 1;
    }

    protected WeaponCharts(Parcel in) {
        weaponChartArrayList = in.createTypedArrayList(WeaponChart.CREATOR);
        modifier = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(weaponChartArrayList);
        dest.writeInt(modifier);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeaponCharts> CREATOR = new Creator<WeaponCharts>() {
        @Override
        public WeaponCharts createFromParcel(Parcel in) {
            return new WeaponCharts(in);
        }

        @Override
        public WeaponCharts[] newArray(int size) {
            return new WeaponCharts[size];
        }
    };

    public ArrayList<WeaponChart> getWeaponChartArrayList() {
        return weaponChartArrayList;
    }

    public void setWeaponChartArrayList(ArrayList<WeaponChart> weaponChartArrayList) {
        this.weaponChartArrayList = weaponChartArrayList;
    }

    public void addWeaponChart (WeaponChart wp){
        if(!this.weaponChartArrayList.contains(wp)){
            this.weaponChartArrayList.add(wp);
        }
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();

        lines.add("[Weapon Charts] (" + modifier + ")");

        for (int i = 0; i < weaponChartArrayList.size(); i++){
            lines.add(weaponChartArrayList.get(i).printInfo());
        }

        return lines;
    }
}
