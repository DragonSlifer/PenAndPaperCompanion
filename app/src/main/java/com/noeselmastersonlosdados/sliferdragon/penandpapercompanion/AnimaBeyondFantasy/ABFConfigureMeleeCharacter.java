package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFToolsSaveData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.MultiSelectionSpinner;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ABFConfigureMeleeCharacter extends AppCompatActivity {

    private static ABFToolsSaveData abfToolsSaveData;
    private static int attackValue;
    private static int deffenseValue;
    private static mod Modifiers;
    private boolean dodge;
    private mod mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abfconfigure_melee_character);

        RadioButton dodge = (RadioButton) findViewById(R.id.dodge);
        dodge.toggle();
        this.dodge = true;
        this.mod = new mod();

        MultiSelectionSpinner spinner1 = (MultiSelectionSpinner) findViewById(R.id.moddersSpinner1);
        MultiSelectionSpinner spinner2 = (MultiSelectionSpinner) findViewById(R.id.moddersSpinner2);
        String[] myResArray = getResources().getStringArray(R.array.ABFCCModifiers);
        spinner1.setItems(new ArrayList<>(Arrays.asList(myResArray)));
        spinner2.setItems(new ArrayList<>(Arrays.asList(myResArray)));
    }

    public void roll(View view){
        RadioButton dodge = (RadioButton) findViewById(R.id.dodge);

        if(dodge.isChecked()){
            this.dodge = true;
        } else{
            this.dodge = false;
        }

        MultiSelectionSpinner attackerSpinner = (MultiSelectionSpinner) findViewById(R.id.moddersSpinner1);
        MultiSelectionSpinner defenderSpinner = (MultiSelectionSpinner) findViewById(R.id.moddersSpinner2);

        ArrayList<String> attacker = new ArrayList<>(attackerSpinner.getSelectedStrings());
        ArrayList<String> defender = new ArrayList<>(defenderSpinner.getSelectedStrings());

        int[] modifiers = mod.resultOfModifiers(attacker, defender,this.dodge);

        EditText attackAb = (EditText) findViewById(R.id.attackValue);
        EditText defenseAb = (EditText) findViewById(R.id.defenseValue);

        boolean attbotch = false, defbotch = false;
        int attackRoll, defenseRoll;
        Random random = new Random();
        attackRoll = random.nextInt(100)+1;
        defenseRoll = random.nextInt(100)+1;

        if (attackRoll > 3) {
            attackRoll += modifiers[0] + Integer.parseInt(attackAb.getText().toString());
        } else {    ///< Botch
            attbotch = true;
        }
        if (defenseRoll > 3) {
            defenseRoll += modifiers[1] + Integer.parseInt(defenseAb.getText().toString());
        } else {    ///< Botch
            defbotch = true;
        }

        String result = getResources().getString(R.string.result_n);
        int botchlevel = 0;
        if((attackRoll > defenseRoll || defbotch) && !attbotch){               ///< Attacker wins

            int damage, damagePercentage;
            if(defbotch){
                result += "\n" + getResources().getString(R.string.att_win_botch);
                defenseRoll = random.nextInt(100)+1;
                botchlevel = defenseRoll;
                defenseRoll = Integer.parseInt(defenseAb.getText().toString()) - defenseRoll;

                damagePercentage = attackRoll - defenseRoll;    ///< Calculate damage Percentage
                damagePercentage = (damagePercentage/10) * 10;
                damage = Integer.parseInt(((EditText) findViewById(R.id.damageText)).getText().toString());
                damage = (damage * damagePercentage) / 100;
            } else {
                result += "\n" + getResources().getString(R.string.att_win);

                damagePercentage = attackRoll - defenseRoll;    ///< Calculate damage Percentage
                damagePercentage = (damagePercentage/10) * 10;
                damage = Integer.parseInt(((EditText) findViewById(R.id.damageText)).getText().toString());
                damage = (damage * damagePercentage) / 100;
            }


            result += Integer.toString(damage) + " " +  getResources().getString(R.string.att_dam);
            if(defbotch)
                result +=  "\n" + getResources().getString(R.string.botchlevel) + botchlevel;

        } else if (attackRoll <= defenseRoll){   ///< Defender wins
            result += "\n" + getResources().getString(R.string.att_los);
            if(attbotch){
                attackRoll = random.nextInt(100) + 1;
                result += "\n" + getResources().getString(R.string.botchlevel) + attackRoll;
            }
        }

        if(!(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)){
            TextView results = (TextView)  findViewById(R.id.textView17);
            results.setText(result);
        } else {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }

    }

    private class mod{
        ArrayList<String> modifierNames;
        ArrayList<Integer> modifierValuesAttack;
        ArrayList<Integer> modifierValuesDodge;
        ArrayList<Integer> modifierValuesBlock;

        public mod (){
            List<String> modvalAttack = Arrays.asList(getResources().getStringArray(R.array.ABFCCMValuesAttack));
            List<String> modnam = Arrays.asList(getResources().getStringArray(R.array.ABFCCModifiers));
            modifierValuesAttack = new ArrayList<>();
            modifierNames= new ArrayList<>(modnam);

            for (int i = 0; i < modvalAttack.size(); i++){
                modifierValuesAttack.add(Integer.parseInt(modvalAttack.get(i)));
            }

            for (int i = 0; i < modvalAttack.size(); i++){
                modifierValuesAttack.add(Integer.parseInt(modvalAttack.get(i)));
            }

            for (int i = 0; i < modvalAttack.size(); i++){
                modifierValuesAttack.add(Integer.parseInt(modvalAttack.get(i)));
            }
        }

        /**
         * This would add the final modifier to the attacker and defender
         *
         * @param attacker Attacker Modifiers
         * @param defender Deffender Modifiers
         * @return
         */
        public int[] resultOfModifiers (ArrayList<String> attacker, ArrayList<String> defender, boolean dodge){
            int attackMod = 0, defenseMod = 0;
            int[] result = new int[2];
            Log.d("Message","");
            if(!attacker.isEmpty()) {
                for (int i = 0; i < attacker.size(); i++) {
                    if (modifierNames.contains(attacker.get(i))) {
                        attackMod += modifierValuesAttack.get(modifierNames.indexOf(attacker.get(i)));
                    }
                }
            }
            result[0] = attackMod;
            if(!defender.isEmpty()) {
                if (dodge) {
                    for (int i = 0; i < defender.size(); i++) {
                        if (modifierNames.get(i).contains(defender.get(i))) {
                            defenseMod += modifierValuesDodge.get(modifierNames.indexOf(attacker.get(i)));
                        }
                    }
                } else {
                    for (int i = 0; i < defender.size(); i++) {
                        if (modifierNames.get(i).contains(defender.get(i))) {
                            defenseMod += modifierValuesBlock.get(modifierNames.indexOf(attacker.get(i)));
                        }
                    }
                }
            }
            result[1] = defenseMod;
            return result;
        }
    }
}
