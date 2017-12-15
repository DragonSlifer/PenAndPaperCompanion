package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jorge on 12/12/2017.
 * Class that organizes the translations.
 * TODO Agregar lenguajes: Ucraniano, Valenciano, ...
 */

public class Translation implements Parcelable {
    private String defaultLang;
    private String es_translation;
    private boolean complete;

    public Translation() {
        defaultLang = "";
        es_translation = "";

        complete = false;
    }

    protected Translation(Parcel in) {
        defaultLang = in.readString();
        es_translation = in.readString();
        complete = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(defaultLang);
        dest.writeString(es_translation);
        dest.writeByte((byte) (complete ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Translation> CREATOR = new Creator<Translation>() {
        @Override
        public Translation createFromParcel(Parcel in) {
            return new Translation(in);
        }

        @Override
        public Translation[] newArray(int size) {
            return new Translation[size];
        }
    };

    public String getDefaultLang() {
        return defaultLang;
    }

    public void setDefaultLang(String defaultLang) {
        this.defaultLang = defaultLang;
    }

    public String getEs_translation() {
        return es_translation;
    }

    public void setEs_translation(String es_translation) {
        this.es_translation = es_translation;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
