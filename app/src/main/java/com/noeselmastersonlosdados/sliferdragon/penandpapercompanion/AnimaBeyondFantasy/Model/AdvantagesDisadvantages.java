package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 28/09/2017.
 */

public class AdvantagesDisadvantages implements Parcelable, Serializable {

    private ArrayList<ADClass> advantagesArrayList;
    private ArrayList<ADClass> disadvantagesArrayList;

    public AdvantagesDisadvantages() {
    }

    protected AdvantagesDisadvantages(Parcel in) {
        advantagesArrayList = in.createTypedArrayList(ADClass.CREATOR);
        disadvantagesArrayList = in.createTypedArrayList(ADClass.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(advantagesArrayList);
        dest.writeTypedList(disadvantagesArrayList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AdvantagesDisadvantages> CREATOR = new Creator<AdvantagesDisadvantages>() {
        @Override
        public AdvantagesDisadvantages createFromParcel(Parcel in) {
            return new AdvantagesDisadvantages(in);
        }

        @Override
        public AdvantagesDisadvantages[] newArray(int size) {
            return new AdvantagesDisadvantages[size];
        }
    };

    public void AddAdvantage (ADClass advantage){
        this.advantagesArrayList.add(advantage);
    }

    public void AddDisadvantage (ADClass disadvantage){
        this.disadvantagesArrayList.add(disadvantage);
    }

    public void DeleteAdvantageDisadvantage (ADClass advantage){
        if(advantagesArrayList.contains(advantage)){
            ArrayList<ADClass> aux1, aux2;
            aux1 = (ArrayList<ADClass>) (advantagesArrayList.subList(0,advantagesArrayList.indexOf(advantage)-1));
            aux2 = (ArrayList<ADClass>) (advantagesArrayList.subList(advantagesArrayList.indexOf(advantage)+1,advantagesArrayList.size()));

            for (int i = 0; i < aux2.size(); i++)
                aux1.add(aux2.get(i));

            advantagesArrayList = aux1;
        } else if (disadvantagesArrayList.contains(advantage)){
            ArrayList<ADClass> aux1, aux2;
            aux1 = (ArrayList<ADClass>) (disadvantagesArrayList.subList(0,disadvantagesArrayList.indexOf(advantage)-1));
            aux2 = (ArrayList<ADClass>) (disadvantagesArrayList.subList(disadvantagesArrayList.indexOf(advantage)+1,disadvantagesArrayList.size()));

            for (int i = 0; i < aux2.size(); i++)
                aux1.add(aux2.get(i));

            disadvantagesArrayList = aux1;
        }
    }

    public ArrayList<ADClass> getAdvantagesArrayList() {
        return advantagesArrayList;
    }

    public void setAdvantagesArrayList(ArrayList<ADClass> advantagesArrayList) {
        this.advantagesArrayList = advantagesArrayList;
    }

    public ArrayList<ADClass> getDisadvantagesArrayList() {
        return disadvantagesArrayList;
    }

    public void setDisadvantagesArrayList(ArrayList<ADClass> disadvantagesArrayList) {
        this.disadvantagesArrayList = disadvantagesArrayList;
    }

    public ArrayList<String> printInfo() {
        ArrayList<String> info = new ArrayList<>();
        if(!advantagesArrayList.isEmpty() || !disadvantagesArrayList.isEmpty()) {
            info.add("[Advantages and Disadvantages]");
            if(!advantagesArrayList.isEmpty()) {
                info.add("[Advantages]");

                for (int i = 0; i < advantagesArrayList.size(); i++)
                    info.add(advantagesArrayList.get(i).toString());
            }
            if(!disadvantagesArrayList.isEmpty()) {
                info.add("[Disadvantages]");

                for (int i = 0; i < disadvantagesArrayList.size(); i++) {
                    info.add(disadvantagesArrayList.get(i).toString());
                }
            }
        }
        return info;
    }

}
