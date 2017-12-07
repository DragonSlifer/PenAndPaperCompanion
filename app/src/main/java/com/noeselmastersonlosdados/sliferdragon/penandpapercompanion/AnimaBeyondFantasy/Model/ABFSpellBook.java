package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 29/09/2017.
 */

public class ABFSpellBook implements Parcelable, Serializable{
    private ArrayList<Spell> spells;
    private String path, subpath;
    private int pathLevel;

    public ABFSpellBook() {
        spells = new ArrayList<>();

    }

    protected ABFSpellBook(Parcel in) {
        spells = in.createTypedArrayList(Spell.CREATOR);
        path = in.readString();
        subpath = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(spells);
        dest.writeString(path);
        dest.writeString(subpath);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ABFSpellBook> CREATOR = new Creator<ABFSpellBook>() {
        @Override
        public ABFSpellBook createFromParcel(Parcel in) {
            return new ABFSpellBook(in);
        }

        @Override
        public ABFSpellBook[] newArray(int size) {
            return new ABFSpellBook[size];
        }
    };

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSubpath() {
        return subpath;
    }

    public void setSubpath(String subpath) {
        this.subpath = subpath;
    }
}
