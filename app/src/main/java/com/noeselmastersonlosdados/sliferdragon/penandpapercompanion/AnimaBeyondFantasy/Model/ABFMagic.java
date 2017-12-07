package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorge on 17/09/2017.
 */

public class ABFMagic implements Parcelable, Serializable {
    ///< [SpellBook: *Path+SubPath*]
    private ArrayList<ABFSpellBook> abfSpellBooks;
    ///< [Arcana Shepirah]
    private ArcanaSephira arcanaSephira;
    ///< [Magic] (Total,AprendizajeMagicoNatural,Comprado,Actual)
    private int magicTotal,magicApMagNat,buyed,magicActual;
    ///< [Zeon] (Total,Base,Puntos,Categoría,Nivel,Especial,Coste)
    private int zeonTotal,zeonBase,zeonBuyed,zeonCat,zeonLevel,zeonSpecial,zeonCost;
    ///< [ACT] (Total,Base,Multiplos,Especial,Coste)
    private int actTotal,actBase,actMult,actSpecial,actCost;
    ///< [Regenerate] (Total,Base,ACTPlus,Mult,Mod,Manten,Coste)
    private int regTotal,regBase,regACTPlus,regMult,regMod,regManten,regCost;
    ///< [Magic Projection] (Total,ModAtt,Puntos,Especial,DesOF,DesDEF)
    private int magproTotal,magproModAtt,magproPoints,magproSpecial,magproDesOF, magproDesDF;
    private Convocation convocation;

    public ABFMagic() {
        this.convocation = new Convocation();
    }

    protected ABFMagic(Parcel in) {
        abfSpellBooks = in.createTypedArrayList(ABFSpellBook.CREATOR);
        arcanaSephira = in.readParcelable(ArcanaSephira.class.getClassLoader());
        magicTotal = in.readInt();
        magicApMagNat = in.readInt();
        buyed = in.readInt();
        magicActual = in.readInt();
        zeonTotal = in.readInt();
        zeonBase = in.readInt();
        zeonBuyed = in.readInt();
        zeonCat = in.readInt();
        zeonLevel = in.readInt();
        zeonSpecial = in.readInt();
        zeonCost = in.readInt();
        actTotal = in.readInt();
        actBase = in.readInt();
        actMult = in.readInt();
        actSpecial = in.readInt();
        actCost = in.readInt();
        regTotal = in.readInt();
        regBase = in.readInt();
        regACTPlus = in.readInt();
        regMult = in.readInt();
        regMod = in.readInt();
        regManten = in.readInt();
        regCost = in.readInt();
        magproTotal = in.readInt();
        magproModAtt = in.readInt();
        magproPoints = in.readInt();
        magproSpecial = in.readInt();
        magproDesOF = in.readInt();
        magproDesDF = in.readInt();
        convocation = in.readParcelable(Convocation.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(abfSpellBooks);
        dest.writeParcelable(arcanaSephira, flags);
        dest.writeInt(magicTotal);
        dest.writeInt(magicApMagNat);
        dest.writeInt(buyed);
        dest.writeInt(magicActual);
        dest.writeInt(zeonTotal);
        dest.writeInt(zeonBase);
        dest.writeInt(zeonBuyed);
        dest.writeInt(zeonCat);
        dest.writeInt(zeonLevel);
        dest.writeInt(zeonSpecial);
        dest.writeInt(zeonCost);
        dest.writeInt(actTotal);
        dest.writeInt(actBase);
        dest.writeInt(actMult);
        dest.writeInt(actSpecial);
        dest.writeInt(actCost);
        dest.writeInt(regTotal);
        dest.writeInt(regBase);
        dest.writeInt(regACTPlus);
        dest.writeInt(regMult);
        dest.writeInt(regMod);
        dest.writeInt(regManten);
        dest.writeInt(regCost);
        dest.writeInt(magproTotal);
        dest.writeInt(magproModAtt);
        dest.writeInt(magproPoints);
        dest.writeInt(magproSpecial);
        dest.writeInt(magproDesOF);
        dest.writeInt(magproDesDF);
        dest.writeParcelable(convocation, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ABFMagic> CREATOR = new Creator<ABFMagic>() {
        @Override
        public ABFMagic createFromParcel(Parcel in) {
            return new ABFMagic(in);
        }

        @Override
        public ABFMagic[] newArray(int size) {
            return new ABFMagic[size];
        }
    };

    public ArrayList<ABFSpellBook> getAbfSpellBooks() {
        return abfSpellBooks;
    }

    public void setAbfSpellBooks(ArrayList<ABFSpellBook> abfSpellBooks) {
        this.abfSpellBooks = abfSpellBooks;
    }

    public ArcanaSephira getArcanaSephira() {
        return arcanaSephira;
    }

    public void setArcanaSephira(ArcanaSephira arcanaSephira) {
        this.arcanaSephira = arcanaSephira;
    }

    public int getMagicTotal() {
        return magicTotal;
    }

    public void setMagicTotal(int magicTotal) {
        this.magicTotal = magicTotal;
    }

    public int getMagicApMagNat() {
        return magicApMagNat;
    }

    public void setMagicApMagNat(int magicApMagNat) {
        this.magicApMagNat = magicApMagNat;
    }

    public int getBuyed() {
        return buyed;
    }

    public void setBuyed(int buyed) {
        this.buyed = buyed;
    }

    public int getMagicActual() {
        return magicActual;
    }

    public void setMagicActual(int magicActual) {
        this.magicActual = magicActual;
    }

    public int getZeonTotal() {
        return zeonTotal;
    }

    public void setZeonTotal(int zeonTotal) {
        this.zeonTotal = zeonTotal;
    }

    public int getZeonBase() {
        return zeonBase;
    }

    public void setZeonBase(int zeonBase) {
        this.zeonBase = zeonBase;
    }

    public int getZeonBuyed() {
        return zeonBuyed;
    }

    public void setZeonBuyed(int zeonBuyed) {
        this.zeonBuyed = zeonBuyed;
    }

    public int getZeonCat() {
        return zeonCat;
    }

    public void setZeonCat(int zeonCat) {
        this.zeonCat = zeonCat;
    }

    public int getZeonLevel() {
        return zeonLevel;
    }

    public void setZeonLevel(int zeonLevel) {
        this.zeonLevel = zeonLevel;
    }

    public int getZeonSpecial() {
        return zeonSpecial;
    }

    public void setZeonSpecial(int zeonSpecial) {
        this.zeonSpecial = zeonSpecial;
    }

    public int getZeonCost() {
        return zeonCost;
    }

    public void setZeonCost(int zeonCost) {
        this.zeonCost = zeonCost;
    }

    public int getActTotal() {
        return actTotal;
    }

    public void setActTotal(int actTotal) {
        this.actTotal = actTotal;
    }

    public int getActBase() {
        return actBase;
    }

    public void setActBase(int actBase) {
        this.actBase = actBase;
    }

    public int getActMult() {
        return actMult;
    }

    public void setActMult(int actMult) {
        this.actMult = actMult;
    }

    public int getActSpecial() {
        return actSpecial;
    }

    public void setActSpecial(int actSpecial) {
        this.actSpecial = actSpecial;
    }

    public int getActCost() {
        return actCost;
    }

    public void setActCost(int actCost) {
        this.actCost = actCost;
    }

    public int getRegTotal() {
        return regTotal;
    }

    public void setRegTotal(int regTotal) {
        this.regTotal = regTotal;
    }

    public int getRegBase() {
        return regBase;
    }

    public void setRegBase(int regBase) {
        this.regBase = regBase;
    }

    public int getRegACTPlus() {
        return regACTPlus;
    }

    public void setRegACTPlus(int regACTPlus) {
        this.regACTPlus = regACTPlus;
    }

    public int getRegMult() {
        return regMult;
    }

    public void setRegMult(int regMult) {
        this.regMult = regMult;
    }

    public int getRegMod() {
        return regMod;
    }

    public void setRegMod(int regMod) {
        this.regMod = regMod;
    }

    public int getRegManten() {
        return regManten;
    }

    public void setRegManten(int regManten) {
        this.regManten = regManten;
    }

    public int getRegCost() {
        return regCost;
    }

    public void setRegCost(int regCost) {
        this.regCost = regCost;
    }

    public int getMagproTotal() {
        return magproTotal;
    }

    public void setMagproTotal(int magproTotal) {
        this.magproTotal = magproTotal;
    }

    public int getMagproModAtt() {
        return magproModAtt;
    }

    public void setMagproModAtt(int magproModAtt) {
        this.magproModAtt = magproModAtt;
    }

    public int getMagproPoints() {
        return magproPoints;
    }

    public void setMagproPoints(int magproPoints) {
        this.magproPoints = magproPoints;
    }

    public int getMagproSpecial() {
        return magproSpecial;
    }

    public void setMagproSpecial(int magproSpecial) {
        this.magproSpecial = magproSpecial;
    }

    public int getMagproDesOF() {
        return magproDesOF;
    }

    public void setMagproDesOF(int magproDesOF) {
        this.magproDesOF = magproDesOF;
    }

    public int getMagproDesDF() {
        return magproDesDF;
    }

    public void setMagproDesDF(int magproDesDF) {
        this.magproDesDF = magproDesDF;
    }

    public Convocation getConvocation() {
        return convocation;
    }

    public void setConvocation(Convocation convocation) {
        this.convocation = convocation;
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> lines = new ArrayList<String>();

        String line;
        ///< [Magic] (Total,AprendizajeMagicoNatural,Comprado,Actual)
        line = "[Magic] (" + magicTotal + "," + magicApMagNat + "," +  buyed +"," +  magicActual + ")";
        lines.add(line);
        ///< [Zeon] (Total,Base,Puntos,Categoría,Nivel,Especial,Coste)
        line = "[Zeon] (" + zeonTotal + "," + zeonBase + "," + zeonCat + "," + zeonLevel + "," + zeonSpecial + "," + zeonBuyed + ")";
        lines.add(line);
        ///< [ACT] (Total,Base,Multiplos,Especial,Coste)
        line = "[ACT] (" + actTotal + "," + actBase + "," + actMult + "," + actSpecial + "," + actCost + ")";
        lines.add(line);
        ///< [Regenerate] (Total,Base,ACTPlus,Mult,Mod,Manten,Coste)
        line = "[Regenerate] (" + regTotal + "," + regBase + "," + regACTPlus + "," + regMult + "," + regMod + "," + regManten + "," + regCost + ")";
        lines.add(line);
        ///< [Magic Projection] (Total,ModAtt,Puntos,Especial,DesOF,DesDEF)
        line = "[Magic Projection] (" + magproTotal + "," + magproModAtt + "," + magproPoints + "," + magproSpecial + "," + magproDesOF + "," + magproDesDF + ")";
        lines.add(line);

        for (int i = 0; i < abfSpellBooks.size(); i++){
            if(abfSpellBooks.get(i).getSubpath() != null)
                lines.add("[Spell Book: " + abfSpellBooks.get(i).getPath() + "-" + abfSpellBooks.get(i).getSubpath() + "]");
            else
                lines.add("[Spell Book: " + abfSpellBooks.get(i).getPath() + "]");
            ArrayList<Spell> aux = abfSpellBooks.get(i).getSpells();
            for (int j = 0; j < aux.size(); j++){
                lines.add("-" + aux.get(i).getName() + "(" + aux.get(i).getSpell_level() +")");
            }
        }

        lines = concatenateArrays(lines,arcanaSephira.printInfo());

        lines = concatenateArrays(lines,convocation.printInfo());

        return lines;
    }

    private ArrayList concatenateArrays(ArrayList one, ArrayList two){
        for (int i = 0; i < two.size(); i++){
            one.add(two.get(i));
        }
        return one;
    }
}
