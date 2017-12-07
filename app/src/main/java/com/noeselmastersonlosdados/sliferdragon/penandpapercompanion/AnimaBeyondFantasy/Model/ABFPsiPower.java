package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 06/10/2017.
 */

public class ABFPsiPower implements Parcelable, Serializable{
    private ArrayList<AbfPsiPowerLevel> abfPsiPowerLevels;
    private String name;

    public ABFPsiPower() {
    }

    protected ABFPsiPower(Parcel in) {
        abfPsiPowerLevels = in.createTypedArrayList(AbfPsiPowerLevel.CREATOR);
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(abfPsiPowerLevels);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ABFPsiPower> CREATOR = new Creator<ABFPsiPower>() {
        @Override
        public ABFPsiPower createFromParcel(Parcel in) {
            return new ABFPsiPower(in);
        }

        @Override
        public ABFPsiPower[] newArray(int size) {
            return new ABFPsiPower[size];
        }
    };

    public ArrayList<AbfPsiPowerLevel> getAbfPsiPowerLevels() {
        return abfPsiPowerLevels;
    }

    public void setAbfPsiPowerLevels(ArrayList<AbfPsiPowerLevel> abfPsiPowerLevels) {
        this.abfPsiPowerLevels = abfPsiPowerLevels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> printInfo(){
        sortPowers();
        ArrayList<String> lines = new ArrayList<String>();

        lines.add("[Power Chart: " + name + "]");

        for (int i = 0; i < abfPsiPowerLevels.size(); i++){
            lines = concatenateArrays(lines,abfPsiPowerLevels.get(i).printInfo());
        }

        return lines;
    }

    private ArrayList concatenateArrays(ArrayList one, ArrayList two){
        for (int i = 0; i < two.size(); i++){
            one.add(two.get(i));
        }
        return one;
    }

    public void sortPowers (){
        quicksort(abfPsiPowerLevels);
    }

    private void quicksort (ArrayList<AbfPsiPowerLevel> v){
        if(v.size() != 0 || !v.isEmpty()){
            sort(v,0,v.size()-1);
        }
    }

    private void sort(ArrayList<AbfPsiPowerLevel> v, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        AbfPsiPowerLevel pivot = v.get(lowerIndex + (higherIndex - lowerIndex)/2);

        while (i <= j){
            while (v.get(i).getLevel() < pivot.getLevel()){
                i++;
            }

            while (v.get(j).getLevel() > pivot.getLevel()){
                j--;
            }
            if (i <= j){
                exchangeObjects(v,i,j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j){
            sort(v,lowerIndex,j);
        }
        if (i < higherIndex){
            sort (v,i,higherIndex);
        }
    }

    private void exchangeObjects(ArrayList<AbfPsiPowerLevel> v, int i, int j) {
        AbfPsiPowerLevel temp = v.get(i);
        v.set(i,v.get(j));
        v.set(j,temp);
    }
}
