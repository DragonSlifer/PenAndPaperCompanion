package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 05/09/2017.
 */

public class ABFToolsSaveData implements Parcelable, Serializable {

    private static ABFCharacter character;

    public ABFToolsSaveData(){
        character = new ABFCharacter();
    }

    /**
     * Este constructor crea el objeto a partir de otro
     * @param source
     */
    public ABFToolsSaveData(Parcel source) {
        character = source.readParcelable(ABFCharacter.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(character, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ABFToolsSaveData> CREATOR = new Creator<ABFToolsSaveData>() {
        @Override
        public ABFToolsSaveData createFromParcel(Parcel in) {
            return new ABFToolsSaveData(in);
        }

        @Override
        public ABFToolsSaveData[] newArray(int size) {
            return new ABFToolsSaveData[size];
        }
    };


    public ABFCharacter getCharacter() {
        return character;
    }

    public void setCharacter(ABFCharacter character) {
        this.character = character;
    }

}
