package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFCharacter;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.ABFToolsSaveData;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.MainCharacteristics;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class ABF_CharGen_BasicInfo extends AppCompatActivity {

    private ABFToolsSaveData abfToolsSaveData;
    private Spinner ethnicity,nation_of_origin, gender, social_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abf_char_gen__basic_info);

        abfToolsSaveData = (ABFToolsSaveData) getIntent().getParcelableExtra("SaveDataClass");
        this.ethnicity = (Spinner) findViewById(R.id.ethnicitySpinner);
        this.nation_of_origin = (Spinner) findViewById(R.id.nationSpinner);
        this.gender = (Spinner) findViewById(R.id.genderSpinner);
        this.social_status = (Spinner) findViewById(R.id.socstatSpinner);

        ArrayAdapter<String> eth = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.ethnicity_array));
        this.ethnicity.setAdapter(eth);

        ArrayAdapter<String> nat = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.nationality_array));
        this.nation_of_origin.setAdapter(nat);
        /**
         * Listener for changing the Social Status depending on the
         * Nation of Origin Selected
         */
        this.nation_of_origin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                if(abfToolsSaveData.getCharacter().isFirstTime()) {
                    ArrayAdapter<String> soc = getSocialStatusArray(selectedItem);
                    if (soc != null)
                        social_status.setAdapter(soc);
                } else {
                    ArrayAdapter<String> soc = getSocialStatusArray(abfToolsSaveData.getCharacter().getNationality());
                    if (soc != null) {
                        social_status.setAdapter(soc);
                        social_status.setSelection(getPositionOfString(abfToolsSaveData.getCharacter().getSocial_Status(),null));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> gen = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.gender_array));
        this.gender.setAdapter(gen);


        if(!abfToolsSaveData.getCharacter().isFirstTime()){
            nation_of_origin.setSelection(getPositionOfString(abfToolsSaveData.getCharacter().getNationality(),getResources().getStringArray(R.array.nationality_array)));
            ethnicity.setSelection(getPositionOfString(abfToolsSaveData.getCharacter().getEthnicity(),getResources().getStringArray(R.array.ethnicity_array)));
            gender.setSelection(getPositionOfString(abfToolsSaveData.getCharacter().getGender(),getResources().getStringArray(R.array.gender_array)));
            ((EditText) findViewById(R.id.charNameText)).setText(abfToolsSaveData.getCharacter().getName());
            ((EditText) findViewById(R.id.ageText)).setText(Integer.toString(abfToolsSaveData.getCharacter().getAge()));
            nation_of_origin.setEnabled(false);
            ethnicity.setEnabled(false);
            gender.setEnabled(false);
            findViewById(R.id.charNameText).setEnabled(false);
        }
        else{

        }
    }

    private int getPositionOfString(String string, String[] array) {
        int position = 0;

        if(array != null)
            while (array.length > position && !array[position].equals(string))
                position++;
        else{
            ArrayAdapter<String> aux = getSocialStatusArray(abfToolsSaveData.getCharacter().getNationality());
            while (aux.getCount() > position && !aux.getItem(position).equals(string))
                position++;
        }

        return position;
    }

    /**
     * This returns the social status, depending on the selected Nation Origin
     * array as an ArrayAdapter, so it can be used by a Spinner.
     * @param selectedItem
     * @return
     */
    private ArrayAdapter<String> getSocialStatusArray(String selectedItem) {
        ArrayAdapter<String> socialStatusAdapter;
        if(selectedItem != null) {
            switch (selectedItem) {
                case "Abel":
                case "Ilmora":
                case "Togarini":
                case "Gabriel":
                case "Arabal":
                case "Dafne":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general));
                    break;
                case "Dalaborn":
                case "Remo":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_2));
                    break;
                case "Alberia":
                case "Galgados":
                case "Kanon":
                case "Argos":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_3));
                    break;
                case "Arlan":
                case "Bellafonte":
                case "Lucrecio":
                case "Espheria":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_4));
                    break;
                case "Phaion":
                case "Kushistan":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_5));
                    break;
                case "Dwanholf":
                case "Pristina":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_6));
                    break;
                case "Helenia":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_helenia));
                    break;
                case "Goldar":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_goldar));
                    break;
                case "Haufman":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_haufman));
                    break;
                case "Hendell":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_hendell));
                    break;
                case "Moth":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_moth));
                    break;
                case "Salazar":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_salazar));
                    break;
                case "The Dominion":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_dominion));
                    break;
                case "Nanwe":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_nanwe));
                    break;
                case "Kashmir":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_kashmir));
                    break;
                case "Baho":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_baho));
                    break;
                case "Lannet":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_lannet));
                    break;
                case "Shivat":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_shivat));
                    break;
                case "Manterra":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_manterra));
                    break;
                case "Corinia":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_corinia));
                    break;
                case "Ygdramar":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_ygdramar));
                    break;
                case "Elcia":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_elcia));
                    break;
                case "Itzi":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_itzi));
                    break;
                case "Bekent":
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_bekent));
                    break;
                default:
                    socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general));
                    break;
            }
        } else {
            socialStatusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general));
        }
        return socialStatusAdapter;
    }

    /**
     * This would charge some data for the class
     *
     */
    public void chargeData(){

    }

    public void gotoCharacteristics(View view){
        Intent i = new Intent(this, ABF_CharGen_Characteristics.class);
        i.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        startActivityForResult(i, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        this.abfToolsSaveData.getCharacter().setMainCharacteristics((MainCharacteristics) data.getParcelableExtra("MainCharacteristics"));
        Log.d("INFO",abfToolsSaveData.getCharacter().getMainCharacteristics().toString());
    }

    public void saveData(View view){
        EditText name_edittext = (EditText) findViewById(R.id.charNameText);
        EditText age_edittext = (EditText) findViewById(R.id.ageText);
        Spinner gender_spinner = (Spinner) findViewById(R.id.genderSpinner);
        Spinner nation_spinner = (Spinner) findViewById(R.id.nationSpinner);
        Spinner socsta_spinner = (Spinner) findViewById(R.id.socstatSpinner);
        Spinner ethnic_spinner = (Spinner) findViewById(R.id.ethnicitySpinner);

        String name;
        if(name_edittext.getText().toString() == null && name_edittext.getText().toString() == ""){
            name = "UNDEFINED";
        }else {
            name = name_edittext.getText().toString();
        }

        int age;
        if((age_edittext.getText().toString() != null) && (age_edittext.getText().toString() != "")) {
            age = Integer.parseInt(age_edittext.getText().toString());
        } else {
            age = 18;
        }
        String gender = gender_spinner.getSelectedItem().toString();
        String nation = nation_spinner.getSelectedItem().toString();
        String socsta = socsta_spinner.getSelectedItem().toString();
        String ethnic = ethnic_spinner.getSelectedItem().toString();

        ABFCharacter aux = this.abfToolsSaveData.getCharacter();

        aux.setName(name);
        aux.setAge(age);
        aux.setGender(gender);
        aux.setNationality(nation);
        aux.setSocial_Status(socsta);
        aux.setEthnicity(ethnic);
        aux.setFirstTime(false);

        abfToolsSaveData.setCharacter(aux);
        onBackPressed();
    }

    @Override
    public void onBackPressed(){
        Intent data = new Intent();
        data.putExtra("SaveDataClass", (Parcelable) abfToolsSaveData);
        data.putExtra("ActionResult","SendInfo");
        setResult(1,data);
        finish();
    }
}


