package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 29/09/2017.
 */

public class Ki implements Parcelable, Serializable{
    private int kiAcumFUE, kiAcumAGI, kiAcumCON, kiAcumDES, kiAcumVOL, kiAcumPOD;
    private int kiFUE, kiAGI,kiCOM,kiDES,kiVOL,kiPOD;
    private ArrayList<KiAbility> kiAbilitiesArrayList;
    private int ki_total;

    public Ki() {
    }

    protected Ki(Parcel in) {
        kiAcumFUE = in.readInt();
        kiAcumAGI = in.readInt();
        kiAcumCON = in.readInt();
        kiAcumDES = in.readInt();
        kiAcumVOL = in.readInt();
        kiAcumPOD = in.readInt();
        kiFUE = in.readInt();
        kiAGI = in.readInt();
        kiCOM = in.readInt();
        kiDES = in.readInt();
        kiVOL = in.readInt();
        kiPOD = in.readInt();
        kiAbilitiesArrayList = in.createTypedArrayList(KiAbility.CREATOR);
        ki_total = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(kiAcumFUE);
        dest.writeInt(kiAcumAGI);
        dest.writeInt(kiAcumCON);
        dest.writeInt(kiAcumDES);
        dest.writeInt(kiAcumVOL);
        dest.writeInt(kiAcumPOD);
        dest.writeInt(kiFUE);
        dest.writeInt(kiAGI);
        dest.writeInt(kiCOM);
        dest.writeInt(kiDES);
        dest.writeInt(kiVOL);
        dest.writeInt(kiPOD);
        dest.writeTypedList(kiAbilitiesArrayList);
        dest.writeInt(ki_total);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ki> CREATOR = new Creator<Ki>() {
        @Override
        public Ki createFromParcel(Parcel in) {
            return new Ki(in);
        }

        @Override
        public Ki[] newArray(int size) {
            return new Ki[size];
        }
    };

    public int getKiAcumFUE() {
        return kiAcumFUE;
    }

    public void setKiAcumFUE(int kiAcumFUE) {
        this.kiAcumFUE = kiAcumFUE;
    }

    public int getKiAcumAGI() {
        return kiAcumAGI;
    }

    public void setKiAcumAGI(int kiAcumAGI) {
        this.kiAcumAGI = kiAcumAGI;
    }

    public int getKiAcumCON() {
        return kiAcumCON;
    }

    public void setKiAcumCON(int kiAcumCON) {
        this.kiAcumCON = kiAcumCON;
    }

    public int getKiAcumDES() {
        return kiAcumDES;
    }

    public void setKiAcumDES(int kiAcumDES) {
        this.kiAcumDES = kiAcumDES;
    }

    public int getKiAcumVOL() {
        return kiAcumVOL;
    }

    public void setKiAcumVOL(int kiAcumVOL) {
        this.kiAcumVOL = kiAcumVOL;
    }

    public int getKiAcumPOD() {
        return kiAcumPOD;
    }

    public void setKiAcumPOD(int kiAcumPOD) {
        this.kiAcumPOD = kiAcumPOD;
    }

    public int getKiFUE() {
        return kiFUE;
    }

    public void setKiFUE(int kiFUE) {
        this.kiFUE = kiFUE;
    }

    public int getKiAGI() {
        return kiAGI;
    }

    public void setKiAGI(int kiAGI) {
        this.kiAGI = kiAGI;
    }

    public int getKiCOM() {
        return kiCOM;
    }

    public void setKiCOM(int kiCOM) {
        this.kiCOM = kiCOM;
    }

    public int getKiDES() {
        return kiDES;
    }

    public void setKiDES(int kiDES) {
        this.kiDES = kiDES;
    }

    public int getKiVOL() {
        return kiVOL;
    }

    public void setKiVOL(int kiVOL) {
        this.kiVOL = kiVOL;
    }

    public int getKiPOD() {
        return kiPOD;
    }

    public void setKiPOD(int kiPOD) {
        this.kiPOD = kiPOD;
    }

    public ArrayList<KiAbility> getKiAbilitiesArrayList() {
        return kiAbilitiesArrayList;
    }

    public void setKiAbilitiesArrayList(ArrayList<KiAbility> kiAbilitiesArrayList) {
        this.kiAbilitiesArrayList = kiAbilitiesArrayList;
    }

    public int getKi_total() {
        return ki_total;
    }

    public void setKi_total(int ki_total) {
        this.ki_total = ki_total;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<>();

        lines.add("[Ki] (" + ki_total
                + "," + kiAGI
                + "," + kiCOM
                + "," + kiDES
                + "," + kiFUE
                + "," + kiVOL
                + "," + kiPOD
                + "," + kiAcumAGI
                + "," + kiAcumCON
                + "," + kiAcumDES
                + "," + kiAcumFUE
                + "," + kiAcumVOL
                + "," + kiAcumPOD
                + ")");

        if(!kiAbilitiesArrayList.isEmpty()){
            for (int i = 0; i < kiAbilitiesArrayList.size();i++)
                lines.add(kiAbilitiesArrayList.get(i).toString());
        }

        return lines;
    }
}
