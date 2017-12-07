package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Jorge on 17/09/2017.
 */

public class MartialArts implements Parcelable {
    private ArrayList<MartialArt> martialArtArrayList;
    private Ki ki;
    private int CM;

    public MartialArts() {
    }

    protected MartialArts(Parcel in) {
        martialArtArrayList = in.createTypedArrayList(MartialArt.CREATOR);
        ki = in.readParcelable(Ki.class.getClassLoader());
        CM = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(martialArtArrayList);
        dest.writeParcelable(ki, flags);
        dest.writeInt(CM);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MartialArts> CREATOR = new Creator<MartialArts>() {
        @Override
        public MartialArts createFromParcel(Parcel in) {
            return new MartialArts(in);
        }

        @Override
        public MartialArts[] newArray(int size) {
            return new MartialArts[size];
        }
    };

    public ArrayList<MartialArt> getMartialArtArrayList() {
        return martialArtArrayList;
    }

    public void setMartialArtArrayList(ArrayList<MartialArt> martialArtArrayList) {
        this.martialArtArrayList = martialArtArrayList;
    }

    public Ki getKi() {
        return ki;
    }

    public void setKi(Ki ki) {
        this.ki = ki;
    }

    public int getCM() {
        return CM;
    }

    public void setCM(int CM) {
        this.CM = CM;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();
        lines.add("[Martial Arts] (" + CM + ")");
        for (int i = 0; i < martialArtArrayList.size(); i++){
            lines.add(martialArtArrayList.get(i).toString());
        }

        ArrayList<String> aux = ki.printInfo();
        lines = concatenateArrays(lines,aux);

        return lines;
    }

    private ArrayList concatenateArrays(ArrayList one, ArrayList two){
        for (int i = 0; i < two.size(); i++){
            one.add(two.get(i));
        }
        return one;
    }
}
