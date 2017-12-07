package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 07/10/2017.
 */

public class Item implements Parcelable, Serializable{
    private String name;
    private String quality;
    private int quantity;
    private int unit_value;
    private String description;
    private boolean hasEffects;
    private String effects;
    private int weight;

    public Item() {
    }

    protected Item(Parcel in) {
        name = in.readString();
        quality = in.readString();
        quantity = in.readInt();
        unit_value = in.readInt();
        description = in.readString();
        hasEffects = in.readByte() != 0;
        effects = in.readString();
        weight = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(quality);
        dest.writeInt(quantity);
        dest.writeInt(unit_value);
        dest.writeString(description);
        dest.writeByte((byte) (hasEffects ? 1 : 0));
        dest.writeString(effects);
        dest.writeInt(weight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnit_value() {
        return unit_value;
    }

    public void setUnit_value(int unit_value) {
        this.unit_value = unit_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasEffects() {
        return hasEffects;
    }

    public void setHasEffects(boolean hasEffects) {
        this.hasEffects = hasEffects;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<String>();

        lines.add("[Item: " + name + " (" + quality + ")]");
        lines.add("Quantity: " + quantity);
        lines.add("Description: " + description);
        if(hasEffects) {
            lines.add("Effects: " + effects);
        }
        lines.add("Unit Weight: " + weight);
        lines.add("Total Weight: " + Integer.toString((weight  * quantity)));
        lines.add("Unit Value: " + unit_value);
        lines.add("Total Value: " + Integer.toString((unit_value  * quantity)));

        return lines;
    }
}
