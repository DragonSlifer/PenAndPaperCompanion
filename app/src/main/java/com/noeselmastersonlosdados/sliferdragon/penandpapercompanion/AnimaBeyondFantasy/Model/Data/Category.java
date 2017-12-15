package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Translation;

import java.util.List;

/**
 * Created by Jorge on 11/12/2017.
 */

public class Category implements Parcelable {
    private String name;
    private int arrayPos;   ///< This is the position in the string-array, just to translate
    private Modifiers modifiers;
    private Translation translation;
    private boolean official; ///< If original, then it's true. If it is true, then is protected.
    private List<String> archetypes;

    public Category() {
        translation = new Translation();
        modifiers = new Modifiers();
    }

    public Category(String name, int arrayPos, Modifiers modifiers, Translation translation, boolean official, List<String> archetypes) {
        this.name = name;
        this.arrayPos = arrayPos;
        this.modifiers = modifiers;
        this.translation = translation;
        this.official = official;
        this.archetypes = archetypes;
    }

    protected Category(Parcel in) {
        name = in.readString();
        arrayPos = in.readInt();
        modifiers = in.readParcelable(Modifiers.class.getClassLoader());
        translation = in.readParcelable(Translation.class.getClassLoader());
        official = in.readByte() != 0;
        archetypes = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(arrayPos);
        dest.writeParcelable(modifiers, flags);
        dest.writeParcelable(translation, flags);
        dest.writeByte((byte) (official ? 1 : 0));
        dest.writeStringList(archetypes);
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

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public List<String> getArchetypes() {
        return archetypes;
    }

    public void setArchetypes(List<String> archetypes) {
        this.archetypes = archetypes;
    }
}
