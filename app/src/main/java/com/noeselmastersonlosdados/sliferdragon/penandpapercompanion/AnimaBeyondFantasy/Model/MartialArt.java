package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 29/09/2017.
 */

public class MartialArt implements Parcelable, Serializable{
    private String name;
    private String desc;
    private int cost;
    private int cmAdd;

    public MartialArt() {
    }

    protected MartialArt(Parcel in) {
        name = in.readString();
        desc = in.readString();
        cost = in.readInt();
        cmAdd = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(cost);
        dest.writeInt(cmAdd);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MartialArt> CREATOR = new Creator<MartialArt>() {
        @Override
        public MartialArt createFromParcel(Parcel in) {
            return new MartialArt(in);
        }

        @Override
        public MartialArt[] newArray(int size) {
            return new MartialArt[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "-" + name + "(" + cost + ")";
    } // TODO
}
