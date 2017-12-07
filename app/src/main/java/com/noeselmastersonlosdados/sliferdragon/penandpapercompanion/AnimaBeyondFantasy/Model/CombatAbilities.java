package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 17/09/2017.
 */

public class CombatAbilities implements Parcelable, Serializable {

    private comAb ATK, DDG, BLK, ARM;

    public CombatAbilities() {
        this.ATK = new comAb();
        this.DDG = new comAb();
        this.BLK = new comAb();
        this.ARM = new comAb();
    }

    protected CombatAbilities(Parcel in) {
        ATK = in.readParcelable(comAb.class.getClassLoader());
        DDG = in.readParcelable(comAb.class.getClassLoader());
        BLK = in.readParcelable(comAb.class.getClassLoader());
        ARM = in.readParcelable(comAb.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(ATK, flags);
        dest.writeParcelable(DDG, flags);
        dest.writeParcelable(BLK, flags);
        dest.writeParcelable(ARM, flags);
    }

    public comAb getATK() {
        return ATK;
    }

    public void setATK(comAb ATK) {
        this.ATK = ATK;
    }

    public comAb getDDG() {
        return DDG;
    }

    public void setDDG(comAb DDG) {
        this.DDG = DDG;
    }

    public comAb getBLK() {
        return BLK;
    }

    public void setBLK(comAb BLK) {
        this.BLK = BLK;
    }

    public comAb getARM() {
        return ARM;
    }

    public void setARM(comAb ARM) {
        this.ARM = ARM;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CombatAbilities> CREATOR = new Creator<CombatAbilities>() {
        @Override
        public CombatAbilities createFromParcel(Parcel in) {
            return new CombatAbilities(in);
        }

        @Override
        public CombatAbilities[] newArray(int size) {
            return new CombatAbilities[size];
        }
    };

    public ArrayList<String> printInfo() {
        ArrayList<String> retVal = new ArrayList<>();

        retVal.add("-ATK" + ATK.toString());
        retVal.add("-DDG" + DDG.toString());
        retVal.add("-BLK" + BLK.toString());
        retVal.add("-ARM" + ARM.toString());

        return retVal;
    }
}
