package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 28/09/2017.
 */

public class LifePointsCounter implements Parcelable, Serializable {
    private int total,base,mult,esp,cat,lev,cost;

    protected LifePointsCounter(Parcel in) {
        total = in.readInt();
        base = in.readInt();
        mult = in.readInt();
        esp = in.readInt();
        cat = in.readInt();
        lev = in.readInt();
        cost = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(total);
        dest.writeInt(base);
        dest.writeInt(mult);
        dest.writeInt(esp);
        dest.writeInt(cat);
        dest.writeInt(lev);
        dest.writeInt(cost);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LifePointsCounter> CREATOR = new Creator<LifePointsCounter>() {
        @Override
        public LifePointsCounter createFromParcel(Parcel in) {
            return new LifePointsCounter(in);
        }

        @Override
        public LifePointsCounter[] newArray(int size) {
            return new LifePointsCounter[size];
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

    public void setBase(int att) {
        int base = getAttBase(att);
        this.base = base;
    }

    private int getAttBase(int att) {
        return 20 + att * 10 + Integer.parseInt(getAttBonus(att));
    }

    public String getAttBonus(int att) {
        String bon = "0";
        switch (att) {
            case 1:
                bon = "-30";
                break;
            case 2:
                bon = "-20";
                break;
            case 3:
                bon = "-10";
                break;
            case 4:
                bon = "-5";
                break;
            case 5:
                bon = "0";
                break;
            case 6:
                bon = "+5";
                break;
            case 7:
                bon = "+5";
                break;
            case 8:
                bon = "+10";
                break;
            case 9:
                bon = "+10";
                break;
            case 10:
                bon = "+15";
                break;
            case 11:
                bon = "+20";
                break;
            case 12:
                bon = "+20";
                break;
            case 13:
                bon = "+25";
                break;
            case 14:
                bon = "+25";
                break;
            case 15:
                bon = "+30";
                break;
            case 16:
                bon = "+35";
                break;
            case 17:
                bon = "+35";
                break;
            case 18:
                bon = "+40";
                break;
            case 19:
                bon = "+40";
                break;
            case 20:
                bon = "+45";
                break;
        }
        return bon;
    }

    public int getMult() {
        return mult;
    }

    public void setMult(int mult) {
        this.mult = mult;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        String retval = "(" + total + "," + base + "," + mult + "," + esp + "," + cat + "," + lev + "," + cost + ")";
        return retval;
    }
}
