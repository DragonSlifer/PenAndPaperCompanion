package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 29/09/2017.
 */

public class KiAbility implements Parcelable, Serializable{
    private int cost;
    private String name;
    private String description;
    private String kiCost;

    public KiAbility() {
    }

    protected KiAbility(Parcel in) {
        cost = in.readInt();
        name = in.readString();
        description = in.readString();
        kiCost = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cost);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(kiCost);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<KiAbility> CREATOR = new Creator<KiAbility>() {
        @Override
        public KiAbility createFromParcel(Parcel in) {
            return new KiAbility(in);
        }

        @Override
        public KiAbility[] newArray(int size) {
            return new KiAbility[size];
        }
    };

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKiCost() {
        return kiCost;
    }

    public void setKiCost(String kiCost) {
        this.kiCost = kiCost;
    }

    @Override
    public String toString() {
        return "-" + name + "(" +  cost + "," + description + "," + kiCost + ')';
    }
}
