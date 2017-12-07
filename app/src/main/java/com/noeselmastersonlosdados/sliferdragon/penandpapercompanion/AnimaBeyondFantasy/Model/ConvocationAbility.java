package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 29/09/2017.
 */

public class ConvocationAbility implements Parcelable, Serializable{
    private String name;
    ///< -<name> (Total,ModAtt,Puntos,Especial,Categoría,Nivel)
    private int total,modAtt,points,special,cat,level;

    public ConvocationAbility(String name) {
        this.name = name;
    }

    protected ConvocationAbility(Parcel in) {
        name = in.readString();
        total = in.readInt();
        modAtt = in.readInt();
        points = in.readInt();
        special = in.readInt();
        cat = in.readInt();
        level = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(total);
        dest.writeInt(modAtt);
        dest.writeInt(points);
        dest.writeInt(special);
        dest.writeInt(cat);
        dest.writeInt(level);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ConvocationAbility> CREATOR = new Creator<ConvocationAbility>() {
        @Override
        public ConvocationAbility createFromParcel(Parcel in) {
            return new ConvocationAbility(in);
        }

        @Override
        public ConvocationAbility[] newArray(int size) {
            return new ConvocationAbility[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getModAtt() {
        return modAtt;
    }

    public void setModAtt(int modAtt) {
        this.modAtt = modAtt;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
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

    @Override
    public String toString() {
        return "-" + name + "(" + total + "," + modAtt + "," + points + "," + special + "," + cat + "," + level + ")";
    }
}
