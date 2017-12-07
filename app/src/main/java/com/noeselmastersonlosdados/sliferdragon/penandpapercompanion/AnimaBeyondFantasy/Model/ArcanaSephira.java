package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 29/09/2017.
 */

public class ArcanaSephira implements Parcelable, Serializable{
    private ArrayList<ArcanaSephiraAbility> arcanaSephiraAbilities;
    private int ArcanaSephiraLevels;

    public ArcanaSephira() {
    }

    protected ArcanaSephira(Parcel in) {
        arcanaSephiraAbilities = in.createTypedArrayList(ArcanaSephiraAbility.CREATOR);
        ArcanaSephiraLevels = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(arcanaSephiraAbilities);
        dest.writeInt(ArcanaSephiraLevels);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArcanaSephira> CREATOR = new Creator<ArcanaSephira>() {
        @Override
        public ArcanaSephira createFromParcel(Parcel in) {
            return new ArcanaSephira(in);
        }

        @Override
        public ArcanaSephira[] newArray(int size) {
            return new ArcanaSephira[size];
        }
    };

    public ArrayList<ArcanaSephiraAbility> getArcanaSephiraAbilities() {
        return arcanaSephiraAbilities;
    }

    public void setArcanaSephiraAbilities(ArrayList<ArcanaSephiraAbility> arcanaSephiraAbilities) {
        this.arcanaSephiraAbilities = arcanaSephiraAbilities;
    }

    public int getArcanaSephiraLevels() {
        return ArcanaSephiraLevels;
    }

    public void setArcanaSephiraLevels(int arcanaSephiraLevels) {
        ArcanaSephiraLevels = arcanaSephiraLevels;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();

        if (ArcanaSephiraLevels != 0){
            lines.add("[Arcana Sephira]");
            for (int i = 0; i < arcanaSephiraAbilities.size(); i++){
                lines.add(arcanaSephiraAbilities.get(i).getName());
            }
        }

        return lines;
    }

}
