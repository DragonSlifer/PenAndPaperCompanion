package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFToolsSaveData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.MainCharacteristics;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class ABF_CharGen_Characteristics extends AppCompatActivity {

    private ABFToolsSaveData abfToolsSaveData;
    private TextView AGI;
    private TextView CON;
    private TextView DEX;
    private TextView STR;
    private TextView INT;
    private TextView PER;
    private TextView POW;
    private TextView WP;
    private TextView AGI_BON;
    private TextView CON_BON;
    private TextView DEX_BON;
    private TextView STR_BON;
    private TextView INT_BON;
    private TextView PER_BON;
    private TextView POW_BON;
    private TextView WP_BON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abf__char_gen__characteristics);

        abfToolsSaveData = getIntent().getParcelableExtra("EISaveDataClass");
        cout(abfToolsSaveData.getCharacter().getMainCharacteristics().toString());
        this.AGI = findViewById(R.id.agi_val);
        this.CON = findViewById(R.id.con_val);
        this.DEX = findViewById(R.id.dex_val);
        this.STR = findViewById(R.id.str_val);
        this.INT = findViewById(R.id.int_val);
        this.PER = findViewById(R.id.per_val);
        this.POW = findViewById(R.id.pow_val);
        this.WP = findViewById(R.id.wp_val);

        this.AGI_BON = findViewById(R.id.agi_bon);
        this.CON_BON = findViewById(R.id.con_bon);
        this.DEX_BON = findViewById(R.id.dex_bon);
        this.STR_BON = findViewById(R.id.str_bon);
        this.INT_BON = findViewById(R.id.int_bon);
        this.PER_BON = findViewById(R.id.per_bon);
        this.POW_BON = findViewById(R.id.pow_bon);
        this.WP_BON = findViewById(R.id.wp_bon);

        if (abfToolsSaveData != null) {
            this.chargeData();
        } else {
            Log.d("INFO", "abfToolsSaveData is null");
        }
    }

    /**
     * This would charge some data for the class
     *
     */
    public void chargeData(){

        MainCharacteristics mc = abfToolsSaveData.getCharacter().getMainCharacteristics(); ///< We get the main characteristics, auto-generated the first time

        /**
         * Then set the Text Views with the default value
         */
        AGI.setText(Integer.toString(mc.getAGI()));
        CON.setText(Integer.toString(mc.getCON()));
        DEX.setText(Integer.toString(mc.getDES()));
        STR.setText(Integer.toString(mc.getFUE()));
        INT.setText(Integer.toString(mc.getINT()));
        PER.setText(Integer.toString(mc.getPER()));
        POW.setText(Integer.toString(mc.getPOD()));
        WP.setText(Integer.toString(mc.getVOL()));

        this.updateBonusTexts(mc,1);
    }

    /**
     * Sets the bonus of the character's attributes according to the
     * bonus of the characteristics or the texts that are set in the characteristics.
     * If the MainCharacteristics object is null, it would set the bonuses
     * according to the text written in the TextViews.
     *
     * @param mc        MainCharacteristics object
     * @param mode      Mode (Mode 1 = Object Attributes)
     */
    private void updateBonusTexts(MainCharacteristics mc, int mode) {
        if(mode == 1 && mc != null) {
            AGI_BON.setText(mc.getAttBonus(mc.getAGI()));
            CON_BON.setText(mc.getAttBonus(mc.getCON()));
            DEX_BON.setText(mc.getAttBonus(mc.getDES()));
            STR_BON.setText(mc.getAttBonus(mc.getFUE()));
            INT_BON.setText(mc.getAttBonus(mc.getINT()));
            PER_BON.setText(mc.getAttBonus(mc.getPER()));
            POW_BON.setText(mc.getAttBonus(mc.getPOD()));
            WP_BON.setText(mc.getAttBonus(mc.getVOL()));
        } else {
            AGI_BON.setText(mc.getAttBonus(Integer.parseInt(this.AGI.getText().toString())));
            CON_BON.setText(mc.getAttBonus(Integer.parseInt(this.CON.getText().toString())));
            DEX_BON.setText(mc.getAttBonus(Integer.parseInt(this.DEX.getText().toString())));
            STR_BON.setText(mc.getAttBonus(Integer.parseInt(this.STR.getText().toString())));
            INT_BON.setText(mc.getAttBonus(Integer.parseInt(this.INT.getText().toString())));
            PER_BON.setText(mc.getAttBonus(Integer.parseInt(this.PER.getText().toString())));
            POW_BON.setText(mc.getAttBonus(Integer.parseInt(this.POW.getText().toString())));
            WP_BON.setText(mc.getAttBonus(Integer.parseInt(this.WP.getText().toString())));
        }
    }

    public void addAgi(View view){
        this.AGI.setText(Integer.toString(Integer.parseInt(this.AGI.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subAgi(View view){
        this.AGI.setText(Integer.toString(Integer.parseInt(this.AGI.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void addFue(View view){
        this.STR.setText(Integer.toString(Integer.parseInt(this.STR.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subFue(View view){
        this.STR.setText(Integer.toString(Integer.parseInt(this.STR.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void addCon(View view){
        this.CON.setText(Integer.toString(Integer.parseInt(this.CON.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subCon(View view){
        this.CON.setText(Integer.toString(Integer.parseInt(this.CON.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void addInt(View view){
        this.INT.setText(Integer.toString(Integer.parseInt(this.INT.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subInt(View view){
        this.INT.setText(Integer.toString(Integer.parseInt(this.INT.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void addPer(View view){
        this.PER.setText(Integer.toString(Integer.parseInt(this.PER.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subPer(View view){
        this.PER.setText(Integer.toString(Integer.parseInt(this.PER.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void addVol(View view){
        this.WP.setText(Integer.toString(Integer.parseInt(this.WP.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subVol(View view){
        this.WP.setText(Integer.toString(Integer.parseInt(this.WP.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void addDex(View view){
        this.DEX.setText(Integer.toString(Integer.parseInt(this.DEX.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subDes(View view){
        this.DEX.setText(Integer.toString(Integer.parseInt(this.DEX.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void addPod(View view){
        this.POW.setText(Integer.toString(Integer.parseInt(this.POW.getText().toString())+1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void subPod(View view){
        this.POW.setText(Integer.toString(Integer.parseInt(this.POW.getText().toString())-1));
        updateBonusTexts(abfToolsSaveData.getCharacter().getMainCharacteristics(),0);
    }

    public void saveData(View view){
        MainCharacteristics mc = this.abfToolsSaveData.getCharacter().getMainCharacteristics();

        mc.setAGI(Integer.parseInt(this.AGI.getText().toString()));
        mc.setCON(Integer.parseInt(this.CON.getText().toString()));
        mc.setFUE(Integer.parseInt(this.STR.getText().toString()));
        mc.setDES(Integer.parseInt(this.DEX.getText().toString()));
        mc.setINT(Integer.parseInt(this.INT.getText().toString()));
        mc.setVOL(Integer.parseInt(this.WP.getText().toString()));
        mc.setPOD(Integer.parseInt(this.POW.getText().toString()));
        mc.setPER(Integer.parseInt(this.PER.getText().toString()));

        onBackPressed();
    }

    public void onBackPressed(){
        Intent data = new Intent();
        data.putExtra("MainCharacteristics", abfToolsSaveData.getCharacter().getMainCharacteristics());
        setResult(1,data);
        finish();
    }

    public void cout(String s){
        Log.d("INFO",s);
    }
}
