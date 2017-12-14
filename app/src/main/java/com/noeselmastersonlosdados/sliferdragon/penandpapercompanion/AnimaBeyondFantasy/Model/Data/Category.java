package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Translation;

/**
 * Created by Jorge on 11/12/2017.
 */

public class Category implements Parcelable {
    private String name;
    private int arrayPos;   ///< This is the position in the string-array, just to translate
    private Modifiers modifiers;
    private Translation translation;

    public Category() {
    }

    public Category(String name, int arrayPos, Modifiers modifiers) {
        this.name = name;
        this.arrayPos = arrayPos;
        this.modifiers = modifiers;
    }

    protected Category(Parcel in) {
        name = in.readString();
        arrayPos = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(arrayPos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrayPos() {
        return arrayPos;
    }

    public void setArrayPos(int arrayPos) {
        this.arrayPos = arrayPos;
    }

    public Modifiers getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifiers modifiers) {
        this.modifiers = modifiers;
    }
}
