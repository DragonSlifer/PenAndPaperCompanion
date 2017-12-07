package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 29/09/2017.
 */

public class Convocation implements Parcelable, Serializable{
    private ConvocationAbility summon;
    private ConvocationAbility domination;
    private ConvocationAbility binding;
    private ConvocationAbility call_off;

    public Convocation() {
        this.summon = new ConvocationAbility("Summon");
        this.domination = new ConvocationAbility("Domination");
        this.binding = new ConvocationAbility("Binding");
        this.call_off = new ConvocationAbility("Call Off");
    }

    public ConvocationAbility getSummon() {
        return summon;
    }

    public void setSummon(ConvocationAbility summon) {
        this.summon = summon;
    }

    public ConvocationAbility getDomination() {
        return domination;
    }

    public void setDomination(ConvocationAbility domination) {
        this.domination = domination;
    }

    public ConvocationAbility getBinding() {
        return binding;
    }

    public void setBinding(ConvocationAbility binding) {
        this.binding = binding;
    }

    public ConvocationAbility getCall_off() {
        return call_off;
    }

    public void setCall_off(ConvocationAbility call_off) {
        this.call_off = call_off;
    }

    protected Convocation(Parcel in) {
        summon = in.readParcelable(ConvocationAbility.class.getClassLoader());
        domination = in.readParcelable(ConvocationAbility.class.getClassLoader());
        binding = in.readParcelable(ConvocationAbility.class.getClassLoader());
        call_off = in.readParcelable(ConvocationAbility.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(summon, flags);
        dest.writeParcelable(domination, flags);
        dest.writeParcelable(binding, flags);
        dest.writeParcelable(call_off, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Convocation> CREATOR = new Creator<Convocation>() {
        @Override
        public Convocation createFromParcel(Parcel in) {
            return new Convocation(in);
        }

        @Override
        public Convocation[] newArray(int size) {
            return new Convocation[size];
        }
    };

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();

        lines.add(summon.toString());
        lines.add(domination.toString());
        lines.add(binding.toString());
        lines.add(call_off.toString());

        return lines;
    }
}
