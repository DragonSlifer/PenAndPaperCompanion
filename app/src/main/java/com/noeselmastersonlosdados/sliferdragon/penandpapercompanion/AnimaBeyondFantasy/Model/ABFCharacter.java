package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Jorge on 17/09/2017.
 */

public class ABFCharacter implements Parcelable, Serializable {

    /**
     * General aspects.
     */
    private String name;
    private int age;
    private String category;
    private String gender;
    private String race;
    private String nationality;
    private String ethnicity;
    private String social_Status;
    private int social_Status_int;
    private int level;
    private int DP_total;
    private int DP_used;
    private int CP_total;
    private int CP_used;
    private boolean firstTime;
    private AdvantagesDisadvantages advantagesDisadvantages;
    private LifePointsCounter lifePointsCounter;
    private TurnCounter turnCounter;
    private int appearance;
    private CombatAbilities combatAbilities;
    private SecondAbilities secondAbilities;
    private MainCharacteristics mainCharacteristics;
    private Inventory inventory;
    private WeaponCharts weaponCharts;
    private Resistances resistances;
    private MartialArts martialArtsCharts; ///< It has Ki, Martial Knowledge and Martial Arts
    private boolean editMode;

    /**
     * Private Classes.
     * Not every character would have some of it, so they have
     * a boolean value to check it.
     */
    private boolean psiPowers;
    private PsiPowersCharts psiPowersCharts;
    private boolean magic;
    private ABFMagic ABFMagic;
    /**
     * Some other things
     */
    private static final String version = "v.0.9";  ///< This is only for debug


    /**
     * Constructor por defecto
     */
    public ABFCharacter(){
        this.level = 1;
        this.DP_total = 600;
        this.DP_used = 0;
        this.CP_total = 3;
        this.CP_used = 0;
        this.firstTime = true;
        Log.d("INFO","Loading Main Characteristics for the first time");
        mainCharacteristics = new MainCharacteristics();
        Log.d("INFO","Loading Inventory for the first time");
        inventory = new Inventory();
        Log.d("INFO","Loading Weapon Charts for the first time");
        weaponCharts = new WeaponCharts();
        Log.d("INFO","Loading Combat Abilities for the first time");
        combatAbilities = new CombatAbilities();
        Log.d("INFO","Loading Secondary Abilities for the first time");
        secondAbilities = new SecondAbilities();
        editMode = true;
        this.category = "";
    }

    protected ABFCharacter(Parcel in) {
        name = in.readString();
        age = in.readInt();
        category = in.readString();
        gender = in.readString();
        race = in.readString();
        nationality = in.readString();
        ethnicity = in.readString();
        social_Status = in.readString();
        social_Status_int = in.readInt();
        level = in.readInt();
        DP_total = in.readInt();
        DP_used = in.readInt();
        CP_total = in.readInt();
        CP_used = in.readInt();
        firstTime = in.readByte() != 0;
        advantagesDisadvantages = in.readParcelable(AdvantagesDisadvantages.class.getClassLoader());
        lifePointsCounter = in.readParcelable(LifePointsCounter.class.getClassLoader());
        turnCounter = in.readParcelable(TurnCounter.class.getClassLoader());
        appearance = in.readInt();
        combatAbilities = in.readParcelable(CombatAbilities.class.getClassLoader());
        secondAbilities = in.readParcelable(SecondAbilities.class.getClassLoader());
        mainCharacteristics = in.readParcelable(MainCharacteristics.class.getClassLoader());
        inventory = in.readParcelable(Inventory.class.getClassLoader());
        weaponCharts = in.readParcelable(WeaponCharts.class.getClassLoader());
        resistances = in.readParcelable(Resistances.class.getClassLoader());
        martialArtsCharts = in.readParcelable(MartialArts.class.getClassLoader());
        editMode = in.readByte() != 0;
        psiPowers = in.readByte() != 0;
        psiPowersCharts = in.readParcelable(PsiPowersCharts.class.getClassLoader());
        magic = in.readByte() != 0;
        ABFMagic = in.readParcelable(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFMagic.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(category);
        dest.writeString(gender);
        dest.writeString(race);
        dest.writeString(nationality);
        dest.writeString(ethnicity);
        dest.writeString(social_Status);
        dest.writeInt(social_Status_int);
        dest.writeInt(level);
        dest.writeInt(DP_total);
        dest.writeInt(DP_used);
        dest.writeInt(CP_total);
        dest.writeInt(CP_used);
        dest.writeByte((byte) (firstTime ? 1 : 0));
        dest.writeParcelable(advantagesDisadvantages, flags);
        dest.writeParcelable(lifePointsCounter, flags);
        dest.writeParcelable(turnCounter, flags);
        dest.writeInt(appearance);
        dest.writeParcelable(combatAbilities, flags);
        dest.writeParcelable(secondAbilities, flags);
        dest.writeParcelable(mainCharacteristics, flags);
        dest.writeParcelable(inventory, flags);
        dest.writeParcelable(weaponCharts, flags);
        dest.writeParcelable(resistances, flags);
        dest.writeParcelable(martialArtsCharts, flags);
        dest.writeByte((byte) (editMode ? 1 : 0));
        dest.writeByte((byte) (psiPowers ? 1 : 0));
        dest.writeParcelable(psiPowersCharts, flags);
        dest.writeByte((byte) (magic ? 1 : 0));
        dest.writeParcelable(ABFMagic, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ABFCharacter> CREATOR = new Creator<ABFCharacter>() {
        @Override
        public ABFCharacter createFromParcel(Parcel in) {
            return new ABFCharacter(in);
        }

        @Override
        public ABFCharacter[] newArray(int size) {
            return new ABFCharacter[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getSocial_Status() {
        return social_Status;
    }

    public void setSocial_Status(String social_Status) {
        this.social_Status = social_Status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDP_total() {
        return DP_total;
    }

    public void setDP_total(int DP_total) {
        this.DP_total = DP_total;
    }

    public int getDP_used() {
        return DP_used;
    }

    public void setDP_used(int DP_used) {
        this.DP_used = DP_used;
    }

    public int getCP_total() {
        return CP_total;
    }

    public void setCP_total(int CP_total) {
        this.CP_total = CP_total;
    }

    public int getCP_used() {
        return CP_used;
    }

    public void setCP_used(int CP_used) {
        this.CP_used = CP_used;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getVersion() {
        return version;
    }

    public MainCharacteristics getMainCharacteristics() {
        return mainCharacteristics;
    }

    public void setMainCharacteristics(MainCharacteristics mainCharacteristics) {
        this.mainCharacteristics = mainCharacteristics;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public WeaponCharts getWeaponCharts() {
        return weaponCharts;
    }

    public void setWeaponCharts(WeaponCharts weaponCharts) {
        this.weaponCharts = weaponCharts;
    }

    public MartialArts getMartialArtsCharts() {
        return martialArtsCharts;
    }

    public void setMartialArtsCharts(MartialArts martialArtsCharts) {
        this.martialArtsCharts = martialArtsCharts;
    }

    public boolean isPsiPowers() {
        return psiPowers;
    }

    public void setPsiPowers(boolean psiPowers) {
        this.psiPowers = psiPowers;
    }

    public PsiPowersCharts getPsiPowersCharts() {
        return psiPowersCharts;
    }

    public void setPsiPowersCharts(PsiPowersCharts psiPowersCharts) {
        this.psiPowersCharts = psiPowersCharts;
    }

    public boolean isMagic() {
        return magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    public ABFMagic getABFMagic() {
        return ABFMagic;
    }

    public void setABFMagic(ABFMagic ABFMagic) {
        this.ABFMagic = ABFMagic;
    }

    public CombatAbilities getCombatAbilities() {
        return combatAbilities;
    }

    public void setCombatAbilities(CombatAbilities combatAbilities) {
        this.combatAbilities = combatAbilities;
    }

    public SecondAbilities getSecondAbilities() {
        return secondAbilities;
    }

    public void setSecondAbilities(SecondAbilities secondAbilities) {
        this.secondAbilities = secondAbilities;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public AdvantagesDisadvantages getAdvantagesDisadvantages() {
        return advantagesDisadvantages;
    }

    public void setAdvantagesDisadvantages(AdvantagesDisadvantages advantagesDisadvantages) {
        this.advantagesDisadvantages = advantagesDisadvantages;
    }

    public LifePointsCounter getLifePointsCounter() {
        return lifePointsCounter;
    }

    public void setLifePointsCounter(LifePointsCounter lifePointsCounter) {
        this.lifePointsCounter = lifePointsCounter;
    }

    public TurnCounter getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(TurnCounter turnCounter) {
        this.turnCounter = turnCounter;
    }

    public Resistances getResistances() {
        return resistances;
    }

    public void setResistances(Resistances resistances) {
        this.resistances = resistances;
    }

    public int getSocial_Status_int() {
        return social_Status_int;
    }

    public void setSocial_Status_int(int social_Status_int) {
        this.social_Status_int = social_Status_int;
    }

    private void processWeaponChartStrings(ArrayList<String> auxiliarArrayListStrings) {
        WeaponChart aux;
        String nameAux, lineAux, weapon = "";
        int cost;
        ArrayList<String> auxStrings = new ArrayList<>();
        this.weaponCharts = new WeaponCharts();

        for (int i = 0; i < auxiliarArrayListStrings.size(); i++){
            aux = new WeaponChart();
            lineAux = auxiliarArrayListStrings.get(i);
            nameAux = lineAux.substring(0, lineAux.indexOf("-")-1);
            cost = Integer.parseInt(lineAux.substring(lineAux.indexOf("-")+1, lineAux.indexOf("- (")-1));
            lineAux = lineAux.substring(lineAux.indexOf("- (")+3);

            for (int j = 0; j < lineAux.length(); j++){
                if(lineAux.charAt(j) != ',' || lineAux.charAt(j) != ')'){
                    weapon += lineAux.charAt(j);
                } else {
                    auxStrings.add(weapon);
                }
            }

            aux.setName(nameAux);
            aux.setCost(cost);
            aux.setWeapons(auxiliarArrayListStrings);
            auxiliarArrayListStrings.clear();
            auxiliarArrayListStrings = new ArrayList<>();
            this.weaponCharts.addWeaponChart(aux);
        }
    }

    private void processAdvantagesDisadvantages(ArrayList<String> info) {
        String mode = info.get(0);
        ArrayList<ADClass> advdis = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            ADClass aux = new ADClass();

            String line = info.get(i);
            String name = line.substring(0,line.indexOf("(")-1);
            String cost = line.substring(line.indexOf("(")+1,line.indexOf(",")-1);
            String desc = line.substring(line.indexOf(",")+1,line.indexOf(")")-1);

            aux.setName(name);
            aux.setCost(cost);
            aux.setDescription(desc);

            advdis.add(aux);
        }
        if(mode == "[Advantages]"){
            advantagesDisadvantages.setAdvantagesArrayList(advdis);
        } else {
            advantagesDisadvantages.setDisadvantagesArrayList(advdis);
        }
    }

    private void processCombatArrayList(ArrayList<String> combatArrayList) {
        if(!combatArrayList.isEmpty() && combatArrayList.size() == 4){
            processCombatString(combatArrayList.get(0).substring(5),1);
            processCombatString(combatArrayList.get(1).substring(5),2);
            processCombatString(combatArrayList.get(2).substring(5),3);
            processCombatString(combatArrayList.get(3).substring(5),4);
        }
    }

    private void processCombatString(String substring, int tag){
        String actual = "";
        int j = 0;
        for(int i = 0; i < substring.length(); i++){
            if(substring.charAt(i) != '-' || substring.charAt(i) != '(' || substring.charAt(i) != ')' || substring.charAt(i) != ','){
                actual += substring.charAt(i);
            } else {
                int value = Integer.parseInt(actual);
                actual = "";
                comAb aux = new comAb();

                if(j == 0){
                    aux.setTotal(value);
                } else if (j == 1){
                    aux.setBase(value);
                } else if (j == 2){
                    aux.setMod(value);
                } else if (j == 3){
                    aux.setPoints(value);
                } else if (j == 4){
                    aux.setEsp(value);
                } else if (j == 5){
                    aux.setCat(value);
                } else if (j == 6){
                    aux.setLevel(value);
                }
                j++;
                if(j == 7) {
                    switch (tag) {
                        case 1:
                            this.combatAbilities.setATK(aux);
                            break;
                        case 2:
                            this.combatAbilities.setDDG(aux);
                            break;
                        case 3:
                            this.combatAbilities.setBLK(aux);
                            break;
                        case 4:
                            this.combatAbilities.setARM(aux);
                            break;
                    }
                }
            }
        }
    }

    private void processLifePoints(String lifePoints) {
        String points = "NONE";
        int attibuteCount = 0;
        for(int i = 0; (i < lifePoints.length()) && attibuteCount != 8; i++){
            if((lifePoints.charAt(i) == '(') || (lifePoints.charAt(i) == ',') || (lifePoints.charAt(i) == ')')){
                if(!Objects.equals(points, "NONE")){
                    switch (attibuteCount){
                        case 0:
                            this.lifePointsCounter.setTotal(Integer.parseInt(points));
                            break;
                        case 1:
                            this.lifePointsCounter.setBase(Integer.parseInt(points));
                            break;
                        case 2:
                            this.lifePointsCounter.setMult(Integer.parseInt(points));
                            break;
                        case 3:
                            this.lifePointsCounter.setEsp(Integer.parseInt(points));
                            break;
                        case 4:
                            this.lifePointsCounter.setCat(Integer.parseInt(points));
                            break;
                        case 5:
                            this.lifePointsCounter.setLev(Integer.parseInt(points));
                            break;
                        case 6:
                            this.lifePointsCounter.setCost(Integer.parseInt(points));
                            break;
                    }
                }
                points = "";
                attibuteCount++;
            } else {
                points += lifePoints.charAt(i);
            }
        }
    }

    private void processAttributes (String attributes){
        String attribute = "NONE";
        int attibuteCount = 0;
        for(int i = 0; (i < attributes.length()) && attibuteCount != 8; i++){
            if((attributes.charAt(i) == '(') || (attributes.charAt(i) == ',') || (attributes.charAt(i) == ')')){
                if(!Objects.equals(attribute, "NONE")){
                    switch (attibuteCount){
                        case 0:
                            this.mainCharacteristics.setAGI(Integer.parseInt(attribute));
                            break;
                        case 1:
                            this.mainCharacteristics.setCON(Integer.parseInt(attribute));
                            break;
                        case 2:
                            this.mainCharacteristics.setFUE(Integer.parseInt(attribute));
                            break;
                        case 3:
                            this.mainCharacteristics.setDES(Integer.parseInt(attribute));
                            break;
                        case 4:
                            this.mainCharacteristics.setINT(Integer.parseInt(attribute));
                            break;
                        case 5:
                            this.mainCharacteristics.setPOD(Integer.parseInt(attribute));
                            break;
                        case 6:
                            this.mainCharacteristics.setVOL(Integer.parseInt(attribute));
                            break;
                        case 7:
                            this.mainCharacteristics.setPER(Integer.parseInt(attribute));
                            break;
                    }
                }
                attribute = "";
                attibuteCount++;
            } else {
                attribute += attributes.charAt(i);
            }
        }
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    @NonNull
    private String deleteTag (String taggedInfo){
        return taggedInfo.substring(taggedInfo.indexOf("]") + 2);
    }

    @NonNull
    private String getTag (String taggedInfo){
        int x, y;
        x = taggedInfo.indexOf("[");
        y = taggedInfo.indexOf("]");
        if(x < 0 || y < 0)
            return "";
        else
            return taggedInfo.substring(x++,y--);
    }

    private ArrayList concatenateArrays(ArrayList one, ArrayList two){
        for (int i = 0; i < two.size(); i++){
            one.add(two.get(i));
        }
        return one;
    }

    public String toString(){
        return this.getName();
    }

    public boolean similar(ABFCharacter aux2) {
        ///< TODO similar character sheet method (Checks name and stats)
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ABFCharacter that = (ABFCharacter) o;

        return (getName() != null ? !getName().equals(that.getName()) : that.getName() != null);
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getRace() != null ? getRace().hashCode() : 0);
        result = 31 * result + (getNationality() != null ? getNationality().hashCode() : 0);
        result = 31 * result + (getEthnicity() != null ? getEthnicity().hashCode() : 0);
        result = 31 * result + (getSocial_Status() != null ? getSocial_Status().hashCode() : 0);
        result = 31 * result + getSocial_Status_int();
        result = 31 * result + getLevel();
        result = 31 * result + getDP_total();
        result = 31 * result + getDP_used();
        result = 31 * result + getCP_total();
        result = 31 * result + getCP_used();
        result = 31 * result + (isFirstTime() ? 1 : 0);
        result = 31 * result + (getAdvantagesDisadvantages() != null ? getAdvantagesDisadvantages().hashCode() : 0);
        result = 31 * result + (getLifePointsCounter() != null ? getLifePointsCounter().hashCode() : 0);
        result = 31 * result + (getTurnCounter() != null ? getTurnCounter().hashCode() : 0);
        result = 31 * result + getAppearance();
        result = 31 * result + (getCombatAbilities() != null ? getCombatAbilities().hashCode() : 0);
        result = 31 * result + (getSecondAbilities() != null ? getSecondAbilities().hashCode() : 0);
        result = 31 * result + (getInventory() != null ? getInventory().hashCode() : 0);
        result = 31 * result + (getWeaponCharts() != null ? getWeaponCharts().hashCode() : 0);
        result = 31 * result + (getResistances() != null ? getResistances().hashCode() : 0);
        result = 31 * result + (getMartialArtsCharts() != null ? getMartialArtsCharts().hashCode() : 0);
        result = 31 * result + (isEditMode() ? 1 : 0);
        result = 31 * result + (isPsiPowers() ? 1 : 0);
        result = 31 * result + (getPsiPowersCharts() != null ? getPsiPowersCharts().hashCode() : 0);
        result = 31 * result + (isMagic() ? 1 : 0);
        result = 31 * result + (getABFMagic() != null ? getABFMagic().hashCode() : 0);
        return result;
    }
}
