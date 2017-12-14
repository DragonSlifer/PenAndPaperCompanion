package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Jorge on 11/12/2017.
 */

public class Modifiers implements Parcelable {
    private int cm_per_level;
    private int hp_per_level;
    private int hp_mult;
    private int turn_per_level;
    private int cv_per_level;
    private int cv_interval;
    ///< Primary Abilities
    private float combat_limit;         ///< Combat Abilities
    private int atk_cost;
    private int blk_cost;
    private int arm_cost;
    private int ddg_cost;
    private int ki_cost;
    private int accum_mult_cost;
    private float supernatural_limit;   ///< Supernatural Abilities
    private int zeon_cost;
    private int zeon_add;
    private int act_mult_cost;
    private int mag_proj_cost;
    private int conv_cost;
    private int dom_cost;
    private int bind_cost;
    private int desummon_cost;
    private float psiquic_limit;        ///< Psiquic Abilities
    private int cv_mult_cost;
    private int psi_proj_cost;
    ///< Secondary Abilities
    private int atl_cost;
    private int soc_cost;
    private int per_cost;
    private int int_cost;
    private int vig_cost;
    private int sub_cost;
    private int cre_cost;
    private ArrayList<Integer> reducedCosts;        ///< This would contain the reduced cost
    private ArrayList<String> reducedCostsStrings;  ///< This would contain the database name of the reduced ability
    ///< Innate Bonuses
    private ArrayList<Integer> primaryBonuses;
    private ArrayList<String> primaryBonusesString;
    private ArrayList<Integer> secondaryBonuses;
    private ArrayList<String> secondaryBonusesString;
    ///< Special Bonuses
    private ArrayList<Integer> specialBonuses;
    private ArrayList<String> specialBonusesString;


    public Modifiers() {
    }

    public Modifiers(int cm_per_level, int hp_per_level, int hp_mult, int turn_per_level, int cv_per_level, int cv_interval, float combat_limit, int atk_cost, int blk_cost, int arm_cost, int ddg_cost, int ki_cost, int accum_mult_cost, float supernatural_limit, int zeon_cost, int zeon_add, int act_mult_cost, int mag_proj_cost, int conv_cost, int dom_cost, int bind_cost, int desummon_cost, float psiquic_limit, int cv_mult_cost, int psi_proj_cost, int atl_cost, int soc_cost, int per_cost, int int_cost, int vig_cost, int sub_cost, int cre_cost, ArrayList<Integer> reducedCosts, ArrayList<String> reducedCostsStrings, ArrayList<Integer> primaryBonuses, ArrayList<String> primaryBonusesString, ArrayList<Integer> secondaryBonuses, ArrayList<String> secondaryBonusesString, ArrayList<Integer> specialBonuses, ArrayList<String> specialBonusesString) {
        this.cm_per_level = cm_per_level;
        this.hp_per_level = hp_per_level;
        this.hp_mult = hp_mult;
        this.turn_per_level = turn_per_level;
        this.cv_per_level = cv_per_level;
        this.cv_interval = cv_interval;
        this.combat_limit = combat_limit;
        this.atk_cost = atk_cost;
        this.blk_cost = blk_cost;
        this.arm_cost = arm_cost;
        this.ddg_cost = ddg_cost;
        this.ki_cost = ki_cost;
        this.accum_mult_cost = accum_mult_cost;
        this.supernatural_limit = supernatural_limit;
        this.zeon_cost = zeon_cost;
        this.zeon_add = zeon_add;
        this.act_mult_cost = act_mult_cost;
        this.mag_proj_cost = mag_proj_cost;
        this.conv_cost = conv_cost;
        this.dom_cost = dom_cost;
        this.bind_cost = bind_cost;
        this.desummon_cost = desummon_cost;
        this.psiquic_limit = psiquic_limit;
        this.cv_mult_cost = cv_mult_cost;
        this.psi_proj_cost = psi_proj_cost;
        this.atl_cost = atl_cost;
        this.soc_cost = soc_cost;
        this.per_cost = per_cost;
        this.int_cost = int_cost;
        this.vig_cost = vig_cost;
        this.sub_cost = sub_cost;
        this.cre_cost = cre_cost;
        this.reducedCosts = reducedCosts;
        this.reducedCostsStrings = reducedCostsStrings;
        this.primaryBonuses = primaryBonuses;
        this.primaryBonusesString = primaryBonusesString;
        this.secondaryBonuses = secondaryBonuses;
        this.secondaryBonusesString = secondaryBonusesString;
        this.specialBonuses = specialBonuses;
        this.specialBonusesString = specialBonusesString;
    }

    protected Modifiers(Parcel in) {
        cm_per_level = in.readInt();
        hp_per_level = in.readInt();
        hp_mult = in.readInt();
        turn_per_level = in.readInt();
        cv_per_level = in.readInt();
        cv_interval = in.readInt();
        combat_limit = in.readFloat();
        atk_cost = in.readInt();
        blk_cost = in.readInt();
        arm_cost = in.readInt();
        ddg_cost = in.readInt();
        ki_cost = in.readInt();
        accum_mult_cost = in.readInt();
        supernatural_limit = in.readFloat();
        zeon_cost = in.readInt();
        zeon_add = in.readInt();
        act_mult_cost = in.readInt();
        mag_proj_cost = in.readInt();
        conv_cost = in.readInt();
        dom_cost = in.readInt();
        bind_cost = in.readInt();
        desummon_cost = in.readInt();
        psiquic_limit = in.readFloat();
        cv_mult_cost = in.readInt();
        psi_proj_cost = in.readInt();
        atl_cost = in.readInt();
        soc_cost = in.readInt();
        per_cost = in.readInt();
        int_cost = in.readInt();
        vig_cost = in.readInt();
        sub_cost = in.readInt();
        cre_cost = in.readInt();
        reducedCostsStrings = in.createStringArrayList();
        primaryBonusesString = in.createStringArrayList();
        secondaryBonusesString = in.createStringArrayList();
        specialBonusesString = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cm_per_level);
        dest.writeInt(hp_per_level);
        dest.writeInt(hp_mult);
        dest.writeInt(turn_per_level);
        dest.writeInt(cv_per_level);
        dest.writeInt(cv_interval);
        dest.writeFloat(combat_limit);
        dest.writeInt(atk_cost);
        dest.writeInt(blk_cost);
        dest.writeInt(arm_cost);
        dest.writeInt(ddg_cost);
        dest.writeInt(ki_cost);
        dest.writeInt(accum_mult_cost);
        dest.writeFloat(supernatural_limit);
        dest.writeInt(zeon_cost);
        dest.writeInt(zeon_add);
        dest.writeInt(act_mult_cost);
        dest.writeInt(mag_proj_cost);
        dest.writeInt(conv_cost);
        dest.writeInt(dom_cost);
        dest.writeInt(bind_cost);
        dest.writeInt(desummon_cost);
        dest.writeFloat(psiquic_limit);
        dest.writeInt(cv_mult_cost);
        dest.writeInt(psi_proj_cost);
        dest.writeInt(atl_cost);
        dest.writeInt(soc_cost);
        dest.writeInt(per_cost);
        dest.writeInt(int_cost);
        dest.writeInt(vig_cost);
        dest.writeInt(sub_cost);
        dest.writeInt(cre_cost);
        dest.writeStringList(reducedCostsStrings);
        dest.writeStringList(primaryBonusesString);
        dest.writeStringList(secondaryBonusesString);
        dest.writeStringList(specialBonusesString);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Modifiers> CREATOR = new Creator<Modifiers>() {
        @Override
        public Modifiers createFromParcel(Parcel in) {
            return new Modifiers(in);
        }

        @Override
        public Modifiers[] newArray(int size) {
            return new Modifiers[size];
        }
    };

    public int getCm_per_level() {
        return cm_per_level;
    }

    public void setCm_per_level(int cm_per_level) {
        this.cm_per_level = cm_per_level;
    }

    public int getHp_per_level() {
        return hp_per_level;
    }

    public void setHp_per_level(int hp_per_level) {
        this.hp_per_level = hp_per_level;
    }

    public int getHp_mult() {
        return hp_mult;
    }

    public void setHp_mult(int hp_mult) {
        this.hp_mult = hp_mult;
    }

    public int getTurn_per_level() {
        return turn_per_level;
    }

    public void setTurn_per_level(int turn_per_level) {
        this.turn_per_level = turn_per_level;
    }

    public int getCv_per_level() {
        return cv_per_level;
    }

    public void setCv_per_level(int cv_per_level) {
        this.cv_per_level = cv_per_level;
    }

    public int getCv_interval() {
        return cv_interval;
    }

    public void setCv_interval(int cv_interval) {
        this.cv_interval = cv_interval;
    }

    public float getCombat_limit() {
        return combat_limit;
    }

    public void setCombat_limit(float combat_limit) {
        this.combat_limit = combat_limit;
    }

    public int getAtk_cost() {
        return atk_cost;
    }

    public void setAtk_cost(int atk_cost) {
        this.atk_cost = atk_cost;
    }

    public int getBlk_cost() {
        return blk_cost;
    }

    public void setBlk_cost(int blk_cost) {
        this.blk_cost = blk_cost;
    }

    public int getArm_cost() {
        return arm_cost;
    }

    public void setArm_cost(int arm_cost) {
        this.arm_cost = arm_cost;
    }

    public int getDdg_cost() {
        return ddg_cost;
    }

    public void setDdg_cost(int ddg_cost) {
        this.ddg_cost = ddg_cost;
    }

    public int getKi_cost() {
        return ki_cost;
    }

    public void setKi_cost(int ki_cost) {
        this.ki_cost = ki_cost;
    }

    public int getAccum_mult_cost() {
        return accum_mult_cost;
    }

    public void setAccum_mult_cost(int accum_mult_cost) {
        this.accum_mult_cost = accum_mult_cost;
    }

    public float getSupernatural_limit() {
        return supernatural_limit;
    }

    public void setSupernatural_limit(float supernatural_limit) {
        this.supernatural_limit = supernatural_limit;
    }

    public int getZeon_cost() {
        return zeon_cost;
    }

    public void setZeon_cost(int zeon_cost) {
        this.zeon_cost = zeon_cost;
    }

    public int getZeon_add() {
        return zeon_add;
    }

    public void setZeon_add(int zeon_add) {
        this.zeon_add = zeon_add;
    }

    public int getAct_mult_cost() {
        return act_mult_cost;
    }

    public void setAct_mult_cost(int act_mult_cost) {
        this.act_mult_cost = act_mult_cost;
    }

    public int getMag_proj_cost() {
        return mag_proj_cost;
    }

    public void setMag_proj_cost(int mag_proj_cost) {
        this.mag_proj_cost = mag_proj_cost;
    }

    public int getConv_cost() {
        return conv_cost;
    }

    public void setConv_cost(int conv_cost) {
        this.conv_cost = conv_cost;
    }

    public int getDom_cost() {
        return dom_cost;
    }

    public void setDom_cost(int dom_cost) {
        this.dom_cost = dom_cost;
    }

    public int getBind_cost() {
        return bind_cost;
    }

    public void setBind_cost(int bind_cost) {
        this.bind_cost = bind_cost;
    }

    public int getDesummon_cost() {
        return desummon_cost;
    }

    public void setDesummon_cost(int desummon_cost) {
        this.desummon_cost = desummon_cost;
    }

    public float getPsiquic_limit() {
        return psiquic_limit;
    }

    public void setPsiquic_limit(float psiquic_limit) {
        this.psiquic_limit = psiquic_limit;
    }

    public int getCv_mult_cost() {
        return cv_mult_cost;
    }

    public void setCv_mult_cost(int cv_mult_cost) {
        this.cv_mult_cost = cv_mult_cost;
    }

    public int getPsi_proj_cost() {
        return psi_proj_cost;
    }

    public void setPsi_proj_cost(int psi_proj_cost) {
        this.psi_proj_cost = psi_proj_cost;
    }

    public int getAtl_cost() {
        return atl_cost;
    }

    public void setAtl_cost(int atl_cost) {
        this.atl_cost = atl_cost;
    }

    public int getSoc_cost() {
        return soc_cost;
    }

    public void setSoc_cost(int soc_cost) {
        this.soc_cost = soc_cost;
    }

    public int getPer_cost() {
        return per_cost;
    }

    public void setPer_cost(int per_cost) {
        this.per_cost = per_cost;
    }

    public int getInt_cost() {
        return int_cost;
    }

    public void setInt_cost(int int_cost) {
        this.int_cost = int_cost;
    }

    public int getVig_cost() {
        return vig_cost;
    }

    public void setVig_cost(int vig_cost) {
        this.vig_cost = vig_cost;
    }

    public int getSub_cost() {
        return sub_cost;
    }

    public void setSub_cost(int sub_cost) {
        this.sub_cost = sub_cost;
    }

    public int getCre_cost() {
        return cre_cost;
    }

    public void setCre_cost(int cre_cost) {
        this.cre_cost = cre_cost;
    }

    public ArrayList<Integer> getReducedCosts() {
        return reducedCosts;
    }

    public void setReducedCosts(ArrayList<Integer> reducedCosts) {
        this.reducedCosts = reducedCosts;
    }

    public ArrayList<String> getReducedCostsStrings() {
        return reducedCostsStrings;
    }

    public void setReducedCostsStrings(ArrayList<String> reducedCostsStrings) {
        this.reducedCostsStrings = reducedCostsStrings;
    }

    public ArrayList<Integer> getPrimaryBonuses() {
        return primaryBonuses;
    }

    public void setPrimaryBonuses(ArrayList<Integer> primaryBonuses) {
        this.primaryBonuses = primaryBonuses;
    }

    public ArrayList<String> getPrimaryBonusesString() {
        return primaryBonusesString;
    }

    public void setPrimaryBonusesString(ArrayList<String> primaryBonusesString) {
        this.primaryBonusesString = primaryBonusesString;
    }

    public ArrayList<Integer> getSecondaryBonuses() {
        return secondaryBonuses;
    }

    public void setSecondaryBonuses(ArrayList<Integer> secondaryBonuses) {
        this.secondaryBonuses = secondaryBonuses;
    }

    public ArrayList<String> getSecondaryBonusesString() {
        return secondaryBonusesString;
    }

    public void setSecondaryBonusesString(ArrayList<String> secondaryBonusesString) {
        this.secondaryBonusesString = secondaryBonusesString;
    }

    public ArrayList<Integer> getSpecialBonuses() {
        return specialBonuses;
    }

    public void setSpecialBonuses(ArrayList<Integer> specialBonuses) {
        this.specialBonuses = specialBonuses;
    }

    public ArrayList<String> getSpecialBonusesString() {
        return specialBonusesString;
    }

    public void setSpecialBonusesString(ArrayList<String> specialBonusesString) {
        this.specialBonusesString = specialBonusesString;
    }
}