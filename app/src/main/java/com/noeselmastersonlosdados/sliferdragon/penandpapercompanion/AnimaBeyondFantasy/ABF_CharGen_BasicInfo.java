package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy;

import android.annotation.SuppressLint;
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
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Constants;

import java.util.Objects;

@SuppressWarnings("unused")
public class ABF_CharGen_BasicInfo extends AppCompatActivity {

    private ABFToolsSaveData abfToolsSaveData;
    private Spinner social_status;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abf_char_gen__basic_info);

        abfToolsSaveData = getIntent().getParcelableExtra("EISaveDataClass");
        Spinner ethnicity = findViewById(R.id.ethnicitySpinner);
        Spinner nation_of_origin = findViewById(R.id.nationSpinner);
        Spinner gender = findViewById(R.id.genderSpinner);
        this.social_status = findViewById(R.id.socstatSpinner);

        ArrayAdapter<String> eth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.ethnicity_array));
        ethnicity.setAdapter(eth);

        ArrayAdapter<String> nat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.nationality_array));
        nation_of_origin.setAdapter(nat);

        Log.i("DEBUG_TAG", "Loading Character Basic Info");

        ///< Listener for changing the Social Status depending on the
        ///< Nation of Origin Selected
        nation_of_origin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                if(abfToolsSaveData.getCharacter().isFirstTime()) {
                    ArrayAdapter<String> soc = getSocialStatusArray(selectedItem);
                    if (soc != null)
                        social_status.setAdapter(soc);
                    Log.i("DEBUG_TAG", "Loading Character Basic Info");
                } else {
                    ArrayAdapter<String> soc = getSocialStatusArray(abfToolsSaveData.getCharacter().getNationality());
                    if (soc != null) {
                        social_status.setAdapter(soc);
                        Log.i("DEBUG_TAG", abfToolsSaveData.getCharacter().getSocial_Status());
                        int i = getPositionOfString(abfToolsSaveData.getCharacter().getSocial_Status(), getSocialStatusArrayList(abfToolsSaveData.getCharacter().getNationality()));
                        if (i < social_status.getCount())
                            social_status.setSelection(i);
                        else if (abfToolsSaveData.getCharacter().getSocial_Status_int() < social_status.getCount()) {
                            social_status.setSelection(abfToolsSaveData.getCharacter().getSocial_Status_int());
                        }
                    }
                    Log.i("DEBUG_TAG", "Loading Character Basic Info");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> gen = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.gender_array));
        gender.setAdapter(gen);

        Log.i("DEBUG_TAG", "Loading Character Basic Info");

        if(!abfToolsSaveData.getCharacter().isFirstTime()){
            Log.i("DEBUG_TAG", "Loading Character Basic Info");
            nation_of_origin.setSelection(getPositionOfString(abfToolsSaveData.getCharacter().getNationality(),getResources().getStringArray(R.array.nationality_array)));
            ethnicity.setSelection(getPositionOfString(abfToolsSaveData.getCharacter().getEthnicity(),getResources().getStringArray(R.array.ethnicity_array)));
            if (abfToolsSaveData.getCharacter().getGender() == "Female" || abfToolsSaveData.getCharacter().getGender() == "Mujer")
                gender.setSelection(1);
            else
                gender.setSelection(0);
            ((EditText) findViewById(R.id.charNameText)).setText(abfToolsSaveData.getCharacter().getName());
            ((EditText) findViewById(R.id.ageText)).setText(Integer.toString(abfToolsSaveData.getCharacter().getAge()));
        }
        if (!abfToolsSaveData.getCharacter().isEditMode()) {
            Log.i("DEBUG_TAG", "Loading Character Basic Info");
            nation_of_origin.setEnabled(false);
            ethnicity.setEnabled(false);
            gender.setEnabled(false);
            findViewById(R.id.charNameText).setEnabled(false);
        } else {
            Log.i("DEBUG_TAG", "Loading Character Basic Info");
            nation_of_origin.setEnabled(true);
            ethnicity.setEnabled(true);
            gender.setEnabled(true);
            findViewById(R.id.charNameText).setEnabled(true);
        }
    }

    private int getPositionOfString(String string, String[] array) {
        int position = 0;

        if(array != null)
            while (array.length > position && !array[position].equals(string))
                position++;
        else{
            ArrayAdapter<String> aux = getSocialStatusArray(abfToolsSaveData.getCharacter().getNationality());
            while (aux.getCount() > position && !Objects.equals(aux.getItem(position), string))
                position++;
        }

        return position;
    }

    /**
     * This returns the social status, depending on the selected Nation Origin
     * array as an ArrayAdapter, so it can be used by a Spinner.
     * @param selectedItem  Selected Nation
     * @return Array of social status
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
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general));
                    break;
                case "Dalaborn":
                case "Remo":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_2));
                    break;
                case "Alberia":
                case "Galgados":
                case "Kanon":
                case "Argos":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_3));
                    break;
                case "Arlan":
                case "Bellafonte":
                case "Lucrecio":
                case "Espheria":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_4));
                    break;
                case "Phaion":
                case "Kushistan":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_5));
                    break;
                case "Dwanholf":
                case "Pristina":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general_6));
                    break;
                case "Helenia":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_helenia));
                    break;
                case "Goldar":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_goldar));
                    break;
                case "Haufman":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_haufman));
                    break;
                case "Hendell":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_hendell));
                    break;
                case "Moth":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_moth));
                    break;
                case "Salazar":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_salazar));
                    break;
                case "The Dominion":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_dominion));
                    break;
                case "Nanwe":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_nanwe));
                    break;
                case "Kashmir":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_kashmir));
                    break;
                case "Baho":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_baho));
                    break;
                case "Lannet":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_lannet));
                    break;
                case "Shivat":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_shivat));
                    break;
                case "Manterra":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_manterra));
                    break;
                case "Corinia":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_corinia));
                    break;
                case "Ygdramar":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_ygdramar));
                    break;
                case "Elcia":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_elcia));
                    break;
                case "Itzi":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_itzi));
                    break;
                case "Bekent":
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_bekent));
                    break;
                default:
                    socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general));
                    break;
            }
        } else {
            socialStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.social_status_general));
        }
        return socialStatusAdapter;
    }

    /**
     * This returns the social status, depending on the selected Nation Origin
     * array as an ArrayAdapter, so it can be used by a Spinner.
     * @param selectedItem  Selected Nation
     * @return Array of social status
     */
    private String[] getSocialStatusArrayList(String selectedItem) {
        if (selectedItem != null) {
            switch (selectedItem) {
                case "Abel":
                case "Ilmora":
                case "Togarini":
                case "Gabriel":
                case "Arabal":
                case "Dafne":
                    return getResources().getStringArray(R.array.social_status_general);
                case "Dalaborn":
                case "Remo":
                    return getResources().getStringArray(R.array.social_status_general_2);
                case "Alberia":
                case "Galgados":
                case "Kanon":
                case "Argos":
                    return getResources().getStringArray(R.array.social_status_general_3);
                case "Arlan":
                case "Bellafonte":
                case "Lucrecio":
                case "Espheria":
                    return getResources().getStringArray(R.array.social_status_general_4);
                case "Phaion":
                case "Kushistan":
                    return getResources().getStringArray(R.array.social_status_general_5);
                case "Dwanholf":
                case "Pristina":
                    return getResources().getStringArray(R.array.social_status_general_6);
                case "Helenia":
                    return getResources().getStringArray(R.array.social_status_helenia);
                case "Goldar":
                    return getResources().getStringArray(R.array.social_status_goldar);
                case "Haufman":
                    return getResources().getStringArray(R.array.social_status_haufman);
                case "Hendell":
                    return getResources().getStringArray(R.array.social_status_hendell);
                case "Moth":
                    return getResources().getStringArray(R.array.social_status_moth);
                case "Salazar":
                    return getResources().getStringArray(R.array.social_status_salazar);
                case "The Dominion":
                    return getResources().getStringArray(R.array.social_status_dominion);
                case "Nanwe":
                    return getResources().getStringArray(R.array.social_status_nanwe);
                case "Kashmir":
                    return getResources().getStringArray(R.array.social_status_kashmir);
                case "Baho":
                    return getResources().getStringArray(R.array.social_status_baho);
                case "Lannet":
                    return getResources().getStringArray(R.array.social_status_lannet);
                case "Shivat":
                    return getResources().getStringArray(R.array.social_status_shivat);
                case "Manterra":
                    return getResources().getStringArray(R.array.social_status_manterra);
                case "Corinia":
                    return getResources().getStringArray(R.array.social_status_corinia);
                case "Ygdramar":
                    return getResources().getStringArray(R.array.social_status_ygdramar);
                case "Elcia":
                    return getResources().getStringArray(R.array.social_status_elcia);
                case "Itzi":
                    return getResources().getStringArray(R.array.social_status_itzi);
                case "Bekent":
                    return getResources().getStringArray(R.array.social_status_bekent);
                default:
                    return getResources().getStringArray(R.array.social_status_general);
            }
        } else {
            return getResources().getStringArray(R.array.social_status_general);
        }
    }

    public void gotoCharacteristics(View view){
        Intent i = new Intent(this, ABF_CharGen_Characteristics.class);
        i.putExtra("EISaveDataClass", (Parcelable) abfToolsSaveData);
        startActivityForResult(i, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        this.abfToolsSaveData.getCharacter().setMainCharacteristics((MainCharacteristics) data.getParcelableExtra("MainCharacteristics"));
        Log.d("INFO",abfToolsSaveData.getCharacter().getMainCharacteristics().toString());
    }

    public void saveData(View view){
        EditText name_edittext = findViewById(R.id.charNameText);
        EditText age_edittext = findViewById(R.id.ageText);
        Spinner gender_spinner = findViewById(R.id.genderSpinner);
        Spinner nation_spinner = findViewById(R.id.nationSpinner);
        Spinner socsta_spinner = findViewById(R.id.socstatSpinner);
        Spinner ethnic_spinner = findViewById(R.id.ethnicitySpinner);

        String name;
        name = name_edittext.getText().toString();

        int age;
        if (!Objects.equals(age_edittext.getText().toString(), "")) {
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
        aux.setEditMode(true);
        aux.setSocial_Status_int(socsta_spinner.getSelectedItemPosition());

        abfToolsSaveData.setCharacter(aux);
        onBackPressed();
    }

    @Override
    public void onBackPressed(){
        Intent data = new Intent();
        data.putExtra("EISaveDataClass", (Parcelable) abfToolsSaveData);
        data.putExtra("ActionResult","SendInfo");
        setResult(Constants.RESULT_OK, data);
        finish();
    }
}


