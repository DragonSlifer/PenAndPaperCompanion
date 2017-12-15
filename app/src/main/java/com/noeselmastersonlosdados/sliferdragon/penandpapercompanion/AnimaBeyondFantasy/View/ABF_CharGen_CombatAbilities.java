package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFToolsSaveData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.comAb;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

import java.util.ArrayList;

public class ABF_CharGen_CombatAbilities extends AppCompatActivity {

    TextView attack_base, block_base, dodge_base, armour_base;
    TextView attack_total, block_total, dodge_total, armour_total;
    TextView pdText;
    Button addAT, addBL, addDO, addAR;
    Button subAT, subBL, subDO, subAR;
    EditText multiple;
    ArrayList<String> info;
    ABFToolsSaveData abfToolsSaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abf__char_gen__combat_abilities);
        this.abfToolsSaveData = getIntent().getParcelableExtra("EISaveDataClass");

        attack_base  = (TextView) findViewById(R.id.atBase);
        block_base   = (TextView) findViewById(R.id.blBase);
        dodge_base   = (TextView) findViewById(R.id.doBase);
        armour_base  = (TextView) findViewById(R.id.arBase);

        attack_total = (TextView) findViewById(R.id.atTotal);
        block_total  = (TextView) findViewById(R.id.blTotal);
        dodge_total  = (TextView) findViewById(R.id.doTotal);
        armour_total = (TextView) findViewById(R.id.arTotal);

        pdText       = (TextView) findViewById(R.id.PDTextView);

        multiple     = (EditText) findViewById(R.id.multText);

        info = new ArrayList<>();

        initializeToZero();
        loadBasicData();

        addAT = (Button) findViewById(R.id.addAT);
        addBL = (Button) findViewById(R.id.addBL);
        addDO = (Button) findViewById(R.id.addDO);
        addAR = (Button) findViewById(R.id.addAR);

        subAT = (Button) findViewById(R.id.subAT);
        subBL = (Button) findViewById(R.id.subBL);
        subDO = (Button) findViewById(R.id.subDO);
        subAR = (Button) findViewById(R.id.subAR);
    }

    private void loadBasicData() {
        if (!abfToolsSaveData.getCharacter().isFirstTime()) {
            comAb ATK = abfToolsSaveData.getCharacter().getCombatAbilities().getATK();
            comAb BLK = abfToolsSaveData.getCharacter().getCombatAbilities().getBLK();
            comAb DDG = abfToolsSaveData.getCharacter().getCombatAbilities().getDDG();
            comAb ARM = abfToolsSaveData.getCharacter().getCombatAbilities().getARM();

            int baseATK = ATK.getBase();
            int baseBLK = BLK.getBase();
            int baseDDG = DDG.getBase();
            int baseARM = ARM.getBase();

            int totalATK = ATK.getTotal();
            int totalBLK = BLK.getTotal();
            int totalDDG = DDG.getTotal();
            int totalARM = ARM.getTotal();

            attack_base.setText(baseATK);
            block_base.setText(baseBLK);
            dodge_base.setText(baseDDG);
            armour_base.setText(baseARM);

            attack_total.setText(totalATK);
            block_total.setText(totalBLK);
            dodge_total.setText(totalDDG);
            armour_total.setText(totalARM);
        } else {
            attack_base.setText(0);
            block_base.setText(0);
            dodge_base.setText(0);
            armour_base.setText(0);
            attack_total.setText(0);
            block_total.setText(0);
            dodge_total.setText(0);
            armour_total.setText(0);
        }
    }

    private void initializeToZero() {
        attack_base.setText("0");
        block_base.setText("0");
        dodge_base.setText("0");
        armour_base.setText("0");
    }

    public void onClickButton(View view) {
        int i = Integer.parseInt(multiple.getText().toString());
        if (i <= 0 || ((RadioButton)findViewById(R.id.oneByOneRadio)).isChecked())
            i = 1;
        TextView total = null;
        TextView base  = null;
        int miT  = 0;
        int miB  = 0;
        int cost = 0;
        Log.i("INFO", "Button pushed");
        switch (view.getId()){
            case R.id.addAT:
                base  = attack_base;
                total = attack_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getCost();
                break;
            case R.id.addBL:
                base  = block_base;
                total = block_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getCost();
                break;
            case R.id.addDO:
                base  = dodge_base;
                total = dodge_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getCost();
                break;
            case R.id.addAR:
                base  = armour_base;
                total = armour_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getCost();
                break;
            case R.id.subAT:
                base  = attack_base;
                total = attack_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getATK().getCost();
                i = -i;
                break;
            case R.id.subBL:
                base  = block_base;
                total = block_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getBLK().getCost();
                i = -i;
                break;
            case R.id.subDO:
                base  = dodge_base;
                total = dodge_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getDDG().getCost();
                i = -i;
                break;
            case R.id.subAR:
                base  = armour_base;
                total = armour_total;
                miT = abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getCat() + abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getLevel() + abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getBase();
                miB = abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getBase();
                cost = abfToolsSaveData.getCharacter().getCombatAbilities().getARM().getCost();

                i = -i;
                break;
        }
        if(total != null && miT > 0 && miB > 0){
            int tot = Integer.parseInt(total.getText().toString());
            int bas = Integer.parseInt(base.getText().toString());

            if((tot + i) >= miT && (bas + i) >= miB){
                tot += i;
                bas += i;

                total.setText(Integer.toString(tot));
                base.setText(Integer.toString(bas));

                int points = Integer.parseInt(pdText.getText().toString().substring(0,pdText.getText().toString().indexOf("/")-1));
                points += cost * i;
                String text = Integer.toString(points) + pdText.getText().toString().substring(pdText.getText().toString().indexOf("/")+1);
                pdText.setText(text);

            } else {
                Toast.makeText(getApplicationContext(),"El total o la base no puede disminuir más",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
