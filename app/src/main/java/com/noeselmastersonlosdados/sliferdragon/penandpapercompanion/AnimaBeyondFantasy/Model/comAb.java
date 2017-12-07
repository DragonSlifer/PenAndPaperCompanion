package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 28/09/2017.
 */

public class comAb implements Parcelable, Serializable {
    private int total;
    private int base;
    private int mod;
    private int points;
    private int esp;
    private int cat;
    private int level;
    private int cost;

    protected comAb(Parcel in) {
        total = in.readInt();
        base = in.readInt();
        mod = in.readInt();
        points = in.readInt();
        esp = in.readInt();
        cat = in.readInt();
        level = in.readInt();
        cost = in.readInt();
    }

    public static final Creator<comAb> CREATOR = new Creator<comAb>() {
        @Override
        public comAb createFromParcel(Parcel in) {
            return new comAb(in);
        }

        @Override
        public comAb[] newArray(int size) {
            return new comAb[size];
        }
    };

    public comAb() {

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getEsp() {
        return esp;
    }

    public void setEsp(int esp) {
        this.esp = esp;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "-" + cost + "-(" + total + "," + base + "," + mod + "," + points + "," + esp + "," + cat + "," + level + ")";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(total);
        parcel.writeInt(base);
        parcel.writeInt(mod);
        parcel.writeInt(points);
        parcel.writeInt(esp);
        parcel.writeInt(cat);
        parcel.writeInt(level);
        parcel.writeInt(cost);
    }
}