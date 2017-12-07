package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 29/09/2017.
 */

public class Resistances implements Parcelable, Serializable{
    private Resistance physicResistance,sickResistance,poissonResistance,magicResistance,psychicResistance;
    private int presence;

    public Resistances() {
    }

    protected Resistances(Parcel in) {
        physicResistance = in.readParcelable(Resistance.class.getClassLoader());
        sickResistance = in.readParcelable(Resistance.class.getClassLoader());
        poissonResistance = in.readParcelable(Resistance.class.getClassLoader());
        magicResistance = in.readParcelable(Resistance.class.getClassLoader());
        psychicResistance = in.readParcelable(Resistance.class.getClassLoader());
        presence = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(physicResistance, flags);
        dest.writeParcelable(sickResistance, flags);
        dest.writeParcelable(poissonResistance, flags);
        dest.writeParcelable(magicResistance, flags);
        dest.writeParcelable(psychicResistance, flags);
        dest.writeInt(presence);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Resistances> CREATOR = new Creator<Resistances>() {
        @Override
        public Resistances createFromParcel(Parcel in) {
            return new Resistances(in);
        }

        @Override
        public Resistances[] newArray(int size) {
            return new Resistances[size];
        }
    };

    public Resistance getPhysicResistance() {
        return physicResistance;
    }

    public void setPhysicResistance(Resistance physicResistance) {
        this.physicResistance = physicResistance;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public Resistance getSickResistance() {
        return sickResistance;
    }

    public void setSickResistance(Resistance sickResistance) {
        this.sickResistance = sickResistance;
    }

    public Resistance getPoissonResistance() {
        return poissonResistance;
    }

    public void setPoissonResistance(Resistance poissonResistance) {
        this.poissonResistance = poissonResistance;
    }

    public Resistance getMagicResistance() {
        return magicResistance;
    }

    public void setMagicResistance(Resistance magicResistance) {
        this.magicResistance = magicResistance;
    }

    public Resistance getPsychicResistance() {
        return psychicResistance;
    }

    public void setPsychicResistance(Resistance psychicResistance) {
        this.psychicResistance = psychicResistance;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();

        lines.add("[Resistances] (" + presence + ")");
        lines.add(physicResistance.toString());
        lines.add(sickResistance.toString());
        lines.add(poissonResistance.toString());
        lines.add(magicResistance.toString());
        lines.add(psychicResistance.toString());

        return lines;
    }
}
