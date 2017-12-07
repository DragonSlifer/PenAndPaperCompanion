package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Jorge on 17/09/2017.
 * This class saves the information of every ability that the character has.
 * For the ability information, check thge ABFAbilityData class.
 */

public class Ability implements Parcelable, Serializable {

    private String name;
    private int cost;
    private int base_value;
    private int bonus_value;
    private int class_value;
    private int speci_value;
    private int final_value;
    private String attribute_bonus;
    private String language;
    private String set;

    public Ability(){
        language = Locale.getDefault().getLanguage();
    }

    protected Ability(Parcel in) {
        name = in.readString();
        cost = in.readInt();
        base_value = in.readInt();
        bonus_value = in.readInt();
        class_value = in.readInt();
        speci_value = in.readInt();
        final_value = in.readInt();
        attribute_bonus = in.readString();
        language = in.readString();
        set = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(cost);
        dest.writeInt(base_value);
        dest.writeInt(bonus_value);
        dest.writeInt(class_value);
        dest.writeInt(speci_value);
        dest.writeInt(final_value);
        dest.writeString(attribute_bonus);
        dest.writeString(language);
        dest.writeString(set);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ability> CREATOR = new Creator<Ability>() {
        @Override
        public Ability createFromParcel(Parcel in) {
            return new Ability(in);
        }

        @Override
        public Ability[] newArray(int size) {
            return new Ability[size];
        }
    };

    public String getAttribute_bonus() {
        String att_bon;

        if(!language.contains("es")){
            att_bon = convertAttributeBonusToSpanish(this.attribute_bonus);
        } else {
            att_bon = this.attribute_bonus;
        }

        return att_bon;
    }

    private String convertAttributeBonusToSpanish(String attribute_bonus) {
        String result = null;

        if(language.contains("en")){
            switch (attribute_bonus){
                case "POW":
                    result = "POW";
                    break;
                case "WP":
                    result = "VOL";
                    break;
                case "DEX":
                    result = "DEX";
                    break;
                case "STR":
                    result = "FUE";
                    break;
                default:
                    result = this.attribute_bonus;
                    break;
            }
        }

        return result;
    }

    public void setAttribute_bonus(String attribute_bonus) {
        this.attribute_bonus = attribute_bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getBase_value() {
        return base_value;
    }

    public void setBase_value(int base_value) {
        this.base_value = base_value;
    }

    public int getBonus_value() {
        return bonus_value;
    }

    public void setBonus_value(int bonus_value) {
        this.bonus_value = bonus_value;
    }

    public int getClass_value() {
        return class_value;
    }

    public void setClass_value(int class_value) {
        this.class_value = class_value;
    }

    public int getFinal_value() {
        return final_value;
    }

    public void setFinal_value(int final_value) {
        this.final_value = final_value;
    }

    public int getSpeci_value() {
        return speci_value;
    }

    public void setSpeci_value(int speci_value) {
        this.speci_value = speci_value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "-[" + name + "]" + "-" + cost + "-(" + base_value + "," + bonus_value + "," + class_value + "," + speci_value + "," + final_value + "," + attribute_bonus + ")";
    }
}
