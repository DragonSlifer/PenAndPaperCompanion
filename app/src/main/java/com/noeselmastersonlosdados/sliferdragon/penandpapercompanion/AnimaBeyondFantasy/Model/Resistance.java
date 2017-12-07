package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 29/09/2017.
 */

public class Resistance implements Parcelable, Serializable{
    private String name;
    private int total,modAT, magic, special;

    public Resistance() {
    }

    protected Resistance(Parcel in) {
        name = in.readString();
        total = in.readInt();
        modAT = in.readInt();
        magic = in.readInt();
        special = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(total);
        dest.writeInt(modAT);
        dest.writeInt(magic);
        dest.writeInt(special);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Resistance> CREATOR = new Creator<Resistance>() {
        @Override
        public Resistance createFromParcel(Parcel in) {
            return new Resistance(in);
        }

        @Override
        public Resistance[] newArray(int size) {
            return new Resistance[size];
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

    public int getModAT() {
        return modAT;
    }

    public void setModAT(int modAT) {
        this.modAT = modAT;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "-" + name + " (" + total + "," + modAT + "," + magic + "," + special + ")";
    }
}
