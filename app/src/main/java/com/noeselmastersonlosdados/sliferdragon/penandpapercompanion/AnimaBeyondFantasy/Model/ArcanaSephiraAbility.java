package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 29/09/2017.
 */

public class ArcanaSephiraAbility implements Parcelable, Serializable{
    private int req_level, cost;
    private String name, effect;

    public ArcanaSephiraAbility() {
    }

    protected ArcanaSephiraAbility(Parcel in) {
        req_level = in.readInt();
        cost = in.readInt();
        name = in.readString();
        effect = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(req_level);
        dest.writeInt(cost);
        dest.writeString(name);
        dest.writeString(effect);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArcanaSephiraAbility> CREATOR = new Creator<ArcanaSephiraAbility>() {
        @Override
        public ArcanaSephiraAbility createFromParcel(Parcel in) {
            return new ArcanaSephiraAbility(in);
        }

        @Override
        public ArcanaSephiraAbility[] newArray(int size) {
            return new ArcanaSephiraAbility[size];
        }
    };

    public int getReq_level() {
        return req_level;
    }

    public void setReq_level(int req_level) {
        this.req_level = req_level;
    }

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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }


}
