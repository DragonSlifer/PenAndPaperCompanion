package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 28/09/2017.
 */

public class ADClass implements Parcelable, Serializable {

    private String name, cost, description;

    public ADClass() {
    }

    protected ADClass(Parcel in) {
        name = in.readString();
        cost = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(cost);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ADClass> CREATOR = new Creator<ADClass>() {
        @Override
        public ADClass createFromParcel(Parcel in) {
            return new ADClass(in);
        }

        @Override
        public ADClass[] newArray(int size) {
            return new ADClass[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "-" + name + "(" + cost + "," + description + ")";
    }
}
