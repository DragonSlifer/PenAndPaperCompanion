package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 06/10/2017.
 */

public class ABFDifficultyEffects implements Parcelable, Serializable{
    private String dif_20,
                   dif_40,
                   dif_80,
                   dif_120,
                   dif_140,
                   dif_180,
                   dif_240,
                   dif_280,
                   dif_320,
                   dif_440;

    public ABFDifficultyEffects() {
    }

    protected ABFDifficultyEffects(Parcel in) {
        dif_20 = in.readString();
        dif_40 = in.readString();
        dif_80 = in.readString();
        dif_120 = in.readString();
        dif_140 = in.readString();
        dif_180 = in.readString();
        dif_240 = in.readString();
        dif_280 = in.readString();
        dif_320 = in.readString();
        dif_440 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dif_20);
        dest.writeString(dif_40);
        dest.writeString(dif_80);
        dest.writeString(dif_120);
        dest.writeString(dif_140);
        dest.writeString(dif_180);
        dest.writeString(dif_240);
        dest.writeString(dif_280);
        dest.writeString(dif_320);
        dest.writeString(dif_440);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ABFDifficultyEffects> CREATOR = new Creator<ABFDifficultyEffects>() {
        @Override
        public ABFDifficultyEffects createFromParcel(Parcel in) {
            return new ABFDifficultyEffects(in);
        }

        @Override
        public ABFDifficultyEffects[] newArray(int size) {
            return new ABFDifficultyEffects[size];
        }
    };

    public String getDif_20() {
        return dif_20;
    }

    public void setDif_20(String dif_20) {
        this.dif_20 = dif_20;
    }

    public String getDif_40() {
        return dif_40;
    }

    public void setDif_40(String dif_40) {
        this.dif_40 = dif_40;
    }

    public String getDif_80() {
        return dif_80;
    }

    public void setDif_80(String dif_80) {
        this.dif_80 = dif_80;
    }

    public String getDif_120() {
        return dif_120;
    }

    public void setDif_120(String dif_120) {
        this.dif_120 = dif_120;
    }

    public String getDif_140() {
        return dif_140;
    }

    public void setDif_140(String dif_140) {
        this.dif_140 = dif_140;
    }

    public String getDif_180() {
        return dif_180;
    }

    public void setDif_180(String dif_180) {
        this.dif_180 = dif_180;
    }

    public String getDif_240() {
        return dif_240;
    }

    public void setDif_240(String dif_240) {
        this.dif_240 = dif_240;
    }

    public String getDif_280() {
        return dif_280;
    }

    public void setDif_280(String dif_280) {
        this.dif_280 = dif_280;
    }

    public String getDif_320() {
        return dif_320;
    }

    public void setDif_320(String dif_320) {
        this.dif_320 = dif_320;
    }

    public String getDif_440() {
        return dif_440;
    }

    public void setDif_440(String dif_440) {
        this.dif_440 = dif_440;
    }

    public ArrayList<String> printInfo() {
        ArrayList<String> lines = new ArrayList<>();

        lines.add("[20: " + dif_20 + "]");
        lines.add("[40: " + dif_40 + "]");
        lines.add("[80: " + dif_80 + "]");
        lines.add("[120: " + dif_120 + "]");
        lines.add("[140: " + dif_140 + "]");
        lines.add("[180: " + dif_180 + "]");
        lines.add("[240: " + dif_240 + "]");
        lines.add("[280: " + dif_280 + "]");
        lines.add("[320: " + dif_320 + "]");
        lines.add("[440: " + dif_440 + "]");

        return lines;
    }
}
