package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jorge on 29/09/2017.
 */

public class Spell implements Parcelable, Serializable{
    private String name;
    private String effect;
    private int spell_level;
    private int zeonCostBasic,zeonCostInter,zeonCostAdvanced,zeonCostArcane;
    private int inteNeedBasic,inteNeedInter,inteNeedAdvanced,inteNeedArcane;
    private int zeonMantBasic,zeonMantInter,zeonMantAdvanced,zeonMantArcane;
    private String effBasic,effInter,effAdvanced,effArcane;
    private boolean mant;
    private String mantType;
    private String actionType;
    private String type;
    private boolean free;


    public Spell() {
    }

    protected Spell(Parcel in) {
        name = in.readString();
        effect = in.readString();
        spell_level = in.readInt();
        zeonCostBasic = in.readInt();
        zeonCostInter = in.readInt();
        zeonCostAdvanced = in.readInt();
        zeonCostArcane = in.readInt();
        inteNeedBasic = in.readInt();
        inteNeedInter = in.readInt();
        inteNeedAdvanced = in.readInt();
        inteNeedArcane = in.readInt();
        zeonMantBasic = in.readInt();
        zeonMantInter = in.readInt();
        zeonMantAdvanced = in.readInt();
        zeonMantArcane = in.readInt();
        effBasic = in.readString();
        effInter = in.readString();
        effAdvanced = in.readString();
        effArcane = in.readString();
        mant = in.readByte() != 0;
        mantType = in.readString();
        actionType = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(effect);
        dest.writeInt(spell_level);
        dest.writeInt(zeonCostBasic);
        dest.writeInt(zeonCostInter);
        dest.writeInt(zeonCostAdvanced);
        dest.writeInt(zeonCostArcane);
        dest.writeInt(inteNeedBasic);
        dest.writeInt(inteNeedInter);
        dest.writeInt(inteNeedAdvanced);
        dest.writeInt(inteNeedArcane);
        dest.writeInt(zeonMantBasic);
        dest.writeInt(zeonMantInter);
        dest.writeInt(zeonMantAdvanced);
        dest.writeInt(zeonMantArcane);
        dest.writeString(effBasic);
        dest.writeString(effInter);
        dest.writeString(effAdvanced);
        dest.writeString(effArcane);
        dest.writeByte((byte) (mant ? 1 : 0));
        dest.writeString(mantType);
        dest.writeString(actionType);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Spell> CREATOR = new Creator<Spell>() {
        @Override
        public Spell createFromParcel(Parcel in) {
            return new Spell(in);
        }

        @Override
        public Spell[] newArray(int size) {
            return new Spell[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getSpell_level() {
        return spell_level;
    }

    public void setSpell_level(int spell_level) {
        this.spell_level = spell_level;
    }

    public int getZeonCostBasic() {
        return zeonCostBasic;
    }

    public void setZeonCostBasic(int zeonCostBasic) {
        this.zeonCostBasic = zeonCostBasic;
    }

    public int getZeonCostInter() {
        return zeonCostInter;
    }

    public void setZeonCostInter(int zeonCostInter) {
        this.zeonCostInter = zeonCostInter;
    }

    public int getZeonCostAdvanced() {
        return zeonCostAdvanced;
    }

    public void setZeonCostAdvanced(int zeonCostAdvanced) {
        this.zeonCostAdvanced = zeonCostAdvanced;
    }

    public int getZeonCostArcane() {
        return zeonCostArcane;
    }

    public void setZeonCostArcane(int zeonCostArcane) {
        this.zeonCostArcane = zeonCostArcane;
    }

    public int getInteNeedBasic() {
        return inteNeedBasic;
    }

    public void setInteNeedBasic(int inteNeedBasic) {
        this.inteNeedBasic = inteNeedBasic;
    }

    public int getInteNeedInter() {
        return inteNeedInter;
    }

    public void setInteNeedInter(int inteNeedInter) {
        this.inteNeedInter = inteNeedInter;
    }

    public int getInteNeedAdvanced() {
        return inteNeedAdvanced;
    }

    public void setInteNeedAdvanced(int inteNeedAdvanced) {
        this.inteNeedAdvanced = inteNeedAdvanced;
    }

    public int getInteNeedArcane() {
        return inteNeedArcane;
    }

    public void setInteNeedArcane(int inteNeedArcane) {
        this.inteNeedArcane = inteNeedArcane;
    }

    public int getZeonMantBasic() {
        return zeonMantBasic;
    }

    public void setZeonMantBasic(int zeonMantBasic) {
        this.zeonMantBasic = zeonMantBasic;
    }

    public int getZeonMantInter() {
        return zeonMantInter;
    }

    public void setZeonMantInter(int zeonMantInter) {
        this.zeonMantInter = zeonMantInter;
    }

    public int getZeonMantAdvanced() {
        return zeonMantAdvanced;
    }

    public void setZeonMantAdvanced(int zeonMantAdvanced) {
        this.zeonMantAdvanced = zeonMantAdvanced;
    }

    public int getZeonMantArcane() {
        return zeonMantArcane;
    }

    public void setZeonMantArcane(int zeonMantArcane) {
        this.zeonMantArcane = zeonMantArcane;
    }

    public String getEffBasic() {
        return effBasic;
    }

    public void setEffBasic(String effBasic) {
        this.effBasic = effBasic;
    }

    public String getEffInter() {
        return effInter;
    }

    public void setEffInter(String effInter) {
        this.effInter = effInter;
    }

    public String getEffAdvanced() {
        return effAdvanced;
    }

    public void setEffAdvanced(String effAdvanced) {
        this.effAdvanced = effAdvanced;
    }

    public String getEffArcane() {
        return effArcane;
    }

    public void setEffArcane(String effArcane) {
        this.effArcane = effArcane;
    }

    public boolean isMant() {
        return mant;
    }

    public void setMant(boolean mant) {
        this.mant = mant;
    }

    public String getMantType() {
        return mantType;
    }

    public void setMantType(String mantType) {
        this.mantType = mantType;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
