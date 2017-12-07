package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Jorge on 17/09/2017.
 */

public class SecondAbilities implements Parcelable, Serializable {

    private abilitySet athletics;
    private abilitySet socials;
    private abilitySet perception;
    private abilitySet vigor;
    private abilitySet intellectual;
    private abilitySet creative;
    private abilitySet specials;
    private String language;

    public SecondAbilities() {
        language = Locale.getDefault().getLanguage();/*
        if (language.contains("es")){       ///< Spanish
            try {
                this.athletics     = new abilitySet(Resources.getSystem().openRawResource(R.raw.atleticas),"athletics");
                this.socials       = new abilitySet(Resources.getSystem().openRawResource(R.raw.sociales),"socials");
                this.perception    = new abilitySet(Resources.getSystem().openRawResource(R.raw.percepcion),"perception");
                this.vigor         = new abilitySet(Resources.getSystem().openRawResource(R.raw.vigor_es),"vigor");
                this.intellectual  = new abilitySet(Resources.getSystem().openRawResource(R.raw.intelectuales),"intellectual");
                this.creative      = new abilitySet(Resources.getSystem().openRawResource(R.raw.creativas),"creative");
                this.specials      = new abilitySet(Resources.getSystem().openRawResource(R.raw.especiales),"specials");
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {                            ///< English by default
            try {
                this.athletics     = new abilitySet(Resources.getSystem().openRawResource(R.raw.athletics),"athletics");
                this.socials       = new abilitySet(Resources.getSystem().openRawResource(R.raw.socials),"socials");
                this.perception    = new abilitySet(Resources.getSystem().openRawResource(R.raw.perception),"perception");
                this.vigor         = new abilitySet(Resources.getSystem().openRawResource(R.raw.vigor),"vigor");
                this.intellectual  = new abilitySet(Resources.getSystem().openRawResource(R.raw.intellectual),"intellectual");
                this.creative      = new abilitySet(Resources.getSystem().openRawResource(R.raw.creative),"creative");
                this.specials      = new abilitySet(Resources.getSystem().openRawResource(R.raw.specials),"specials");
            } catch (Exception e){
                e.printStackTrace();
            }
        }*/

    }

    protected SecondAbilities(Parcel in) {
        athletics = in.readParcelable(abilitySet.class.getClassLoader());
        socials = in.readParcelable(abilitySet.class.getClassLoader());
        perception = in.readParcelable(abilitySet.class.getClassLoader());
        vigor = in.readParcelable(abilitySet.class.getClassLoader());
        intellectual = in.readParcelable(abilitySet.class.getClassLoader());
        creative = in.readParcelable(abilitySet.class.getClassLoader());
        specials = in.readParcelable(abilitySet.class.getClassLoader());
        language = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(athletics, flags);
        dest.writeParcelable(socials, flags);
        dest.writeParcelable(perception, flags);
        dest.writeParcelable(vigor, flags);
        dest.writeParcelable(intellectual, flags);
        dest.writeParcelable(creative, flags);
        dest.writeParcelable(specials, flags);
        dest.writeString(language);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SecondAbilities> CREATOR = new Creator<SecondAbilities>() {
        @Override
        public SecondAbilities createFromParcel(Parcel in) {
            return new SecondAbilities(in);
        }

        @Override
        public SecondAbilities[] newArray(int size) {
            return new SecondAbilities[size];
        }
    };

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<>();
        lines.add("[Secondary Abilities]");
        lines.add("-Athletics-" + this.athletics.getGeneralCost());
        aux = this.athletics.printInfo();
        lines = concatenateArrays(lines,aux);
        lines.add("-Socials-" + this.socials.getGeneralCost());
        aux = this.socials.printInfo();
        lines = concatenateArrays(lines,aux);
        lines.add("-Perception-" + this.perception.getGeneralCost());
        aux = this.perception.printInfo();
        lines = concatenateArrays(lines,aux);
        lines.add("-Vigor-" + this.vigor.getGeneralCost());
        aux = this.vigor.printInfo();
        lines = concatenateArrays(lines,aux);
        lines.add("-Intellectual-" + this.intellectual.getGeneralCost());
        aux = this.intellectual.printInfo();
        lines = concatenateArrays(lines,aux);
        lines.add("-Creative-" + this.creative.getGeneralCost());
        aux = this.creative.printInfo();
        lines = concatenateArrays(lines,aux);
        lines.add("-Specials-" + this.specials.getGeneralCost());
        aux = this.specials.printInfo();
        lines = concatenateArrays(lines,aux);

        return lines;
    }

    private ArrayList concatenateArrays(ArrayList one, ArrayList two){
        for (int i = 0; i < two.size(); i++){
            one.add(two.get(i));
        }
        return one;
    }

    public abilitySet getAthletics() {
        return athletics;
    }

    public void setAthletics(abilitySet athletics) {
        this.athletics = athletics;
    }

    public abilitySet getSocials() {
        return socials;
    }

    public void setSocials(abilitySet socials) {
        this.socials = socials;
    }

    public abilitySet getPerception() {
        return perception;
    }

    public void setPerception(abilitySet perception) {
        this.perception = perception;
    }

    public abilitySet getVigor() {
        return vigor;
    }

    public void setVigor(abilitySet vigor) {
        this.vigor = vigor;
    }

    public abilitySet getIntellectual() {
        return intellectual;
    }

    public void setIntellectual(abilitySet intellectual) {
        this.intellectual = intellectual;
    }

    public abilitySet getCreative() {
        return creative;
    }

    public void setCreative(abilitySet creative) {
        this.creative = creative;
    }

    public abilitySet getSpecials() {
        return specials;
    }

    public void setSpecials(abilitySet specials) {
        this.specials = specials;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
