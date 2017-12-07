package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Random;

/**
 * Created by Jorge on 17/09/2017.
 */

public class MainCharacteristics implements Parcelable{

    private int AGI,CON,FUE,DES,INT,POD,VOL,PER;
    private boolean inhumanity; ///< If this is checked, it would be possible to get higher than 10 attributes

    /**
     * The constructor will put starting characteristics,
     * that could be modified in the future.
     */
    public MainCharacteristics (){
        Random r = new Random();
        do{
            this.AGI = r.nextInt(10)+1;
            Log.d("INFO", "AGI val is" + AGI);
        } while (this.AGI <= 3);
        do{
            this.CON = r.nextInt(10)+1;
        } while (this.CON <= 3);
        do{
            this.FUE = r.nextInt(10)+1;
        } while (this.FUE <= 3);
        do{
            this.DES = r.nextInt(10)+1;
        } while (this.DES <= 3);
        do{
            this.INT = r.nextInt(10)+1;
        } while (this.INT <= 3);
        do{
            this.POD = r.nextInt(10)+1;
        } while (this.POD <= 3);
        do{
            this.VOL = r.nextInt(10)+1;
        } while (this.VOL <= 3);
        do{
            this.PER = r.nextInt(10)+1;
        } while (this.PER <= 3);
        this.inhumanity = false;
    }

    protected MainCharacteristics(Parcel in) {
        AGI = in.readInt();
        CON = in.readInt();
        FUE = in.readInt();
        DES = in.readInt();
        INT = in.readInt();
        POD = in.readInt();
        VOL = in.readInt();
        PER = in.readInt();
        inhumanity = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(AGI);
        dest.writeInt(CON);
        dest.writeInt(FUE);
        dest.writeInt(DES);
        dest.writeInt(INT);
        dest.writeInt(POD);
        dest.writeInt(VOL);
        dest.writeInt(PER);
        dest.writeByte((byte) (inhumanity ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MainCharacteristics> CREATOR = new Creator<MainCharacteristics>() {
        @Override
        public MainCharacteristics createFromParcel(Parcel in) {
            return new MainCharacteristics(in);
        }

        @Override
        public MainCharacteristics[] newArray(int size) {
            return new MainCharacteristics[size];
        }
    };


    public void setAGI(int AGI) {
        this.AGI = AGI;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public void setFUE(int FUE) {
        this.FUE = FUE;
    }

    public void setDES(int DES) {
        this.DES = DES;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public void setPOD(int POD) {
        this.POD = POD;
    }

    public void setVOL(int VOL) {
        this.VOL = VOL;
    }

    public void setPER(int PER) {
        this.PER = PER;
    }

    public void setInhumanity(boolean inhumanity){
        if(inhumanity){ ///< If actual humanity is true, it makes no sense to make it false
            this.inhumanity = inhumanity;
        }
    }

    public String toString (){
        return "(" + AGI + "," + CON + "," + FUE + "," + DES + "," + INT + "," + POD + "," + VOL + "," + PER + ")";
    }

    public int getAGI() {
        return AGI;
    }

    public int getCON() {
        return CON;
    }

    public int getFUE() {
        return FUE;
    }

    public int getDES() {
        return DES;
    }

    public int getINT() {
        return INT;
    }

    public int getPOD() {
        return POD;
    }

    public int getVOL() {
        return VOL;
    }

    public int getPER() {
        return PER;
    }

    public boolean isInhumanity() {
        return inhumanity;
    }

    public String getAttBonus(int att) {
        String bon = "0";
        switch (att){
            case 1:
                bon = "-30";
                break;
            case 2:
                bon = "-20";
                break;
            case 3:
                bon = "-10";
                break;
            case 4:
                bon = "-5";
                break;
            case 5:
                bon = "0";
                break;
            case 6:
                bon = "+5";
                break;
            case 7:
                bon = "+5";
                break;
            case 8:
                bon = "+10";
                break;
            case 9:
                bon = "+10";
                break;
            case 10:
                bon = "+15";
                break;
            case 11:
                bon = "+20";
                break;
            case 12:
                bon = "+20";
                break;
            case 13:
                bon = "+25";
                break;
            case 14:
                bon = "+25";
                break;
            case 15:
                bon = "+30";
                break;
            case 16:
                bon = "+35";
                break;
            case 17:
                bon = "+35";
                break;
            case 18:
                bon = "+40";
                break;
            case 19:
                bon = "+40";
                break;
            case 20:
                bon = "+45";
                break;
        }
        return bon;
    }
}
