package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Jorge on 17/09/2017.
 */

public class PsiPowersCharts implements Parcelable {
    private ArrayList<ABFPsiPower> psiPowers;   ///< Psychic powers
    ///< TODO more stuff about psi powers

    protected PsiPowersCharts(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PsiPowersCharts> CREATOR = new Creator<PsiPowersCharts>() {
        @Override
        public PsiPowersCharts createFromParcel(Parcel in) {
            return new PsiPowersCharts(in);
        }

        @Override
        public PsiPowersCharts[] newArray(int size) {
            return new PsiPowersCharts[size];
        }
    };

    public void sortPowers (){
        quicksort(psiPowers);
    }

    private void quicksort (ArrayList<ABFPsiPower> v){
        if(v.size() != 0 || !v.isEmpty()){
            sort(v,0,v.size()-1);
        }
    }

    private void sort(ArrayList<ABFPsiPower> v, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        ABFPsiPower pivot = v.get(lowerIndex + (higherIndex - lowerIndex)/2);

        while (i <= j){
            while (v.get(i).getName().compareTo(pivot.getName()) < 0){
                i++;
            }

            while (v.get(j).getName().compareTo(pivot.getName()) > 0){
                j--;
            }
            if (i <= j){
                exchangeObjects(v,i,j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j){
            sort(v,lowerIndex,j);
        }
        if (i < higherIndex){
            sort (v,i,higherIndex);
        }
    }

    private void exchangeObjects(ArrayList<ABFPsiPower> v, int i, int j) {
        ABFPsiPower temp = v.get(i);
        v.set(i,v.get(j));
        v.set(j,temp);
    }


    private ArrayList concatenateArrays(ArrayList one, ArrayList two){
        for (int i = 0; i < two.size(); i++){
            one.add(two.get(i));
        }
        return one;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<String>();

        sortPowers();
        lines.add("[Psi Powers]");
        ///< TODO more stuff about psi powers writting
        for (int i = 0; i < psiPowers.size(); i++) {
            lines = concatenateArrays(lines, psiPowers.get(i).printInfo());
        }

        return lines;
    }
}
