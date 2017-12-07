package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 28/09/2017.
 */

public class TurnCounter implements Parcelable, Serializable {

    private int total,base,modAGI,modDES,Arm,esp,cat,lev;

    public TurnCounter() {
    }

    protected TurnCounter(Parcel in) {
        total = in.readInt();
        base = in.readInt();
        modAGI = in.readInt();
        modDES = in.readInt();
        Arm = in.readInt();
        esp = in.readInt();
        cat = in.readInt();
        lev = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(total);
        dest.writeInt(base);
        dest.writeInt(modAGI);
        dest.writeInt(modDES);
        dest.writeInt(Arm);
        dest.writeInt(esp);
        dest.writeInt(cat);
        dest.writeInt(lev);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TurnCounter> CREATOR = new Creator<TurnCounter>() {
        @Override
        public TurnCounter createFromParcel(Parcel in) {
            return new TurnCounter(in);
        }

        @Override
        public TurnCounter[] newArray(int size) {
            return new TurnCounter[size];
        }
    };

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

    public int getModAGI() {
        return modAGI;
    }

    public void setModAGI(int modAGI) {
        this.modAGI = modAGI;
    }

    public int getModDES() {
        return modDES;
    }

    public void setModDES(int modDES) {
        this.modDES = modDES;
    }

    public int getArm() {
        return Arm;
    }

    public void setArm(int arm) {
        Arm = arm;
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

    public int getLev() {
        return lev;
    }

    public void setLev(int lev) {
        this.lev = lev;
    }

    @Override
    public String toString() {
        return "[Turn] (" + total + "," + base + "," + modAGI + "," + modDES + "," + Arm + "," + esp + "," + cat + "," + lev + ')';
    }
}
