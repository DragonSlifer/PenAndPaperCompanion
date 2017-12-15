package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Constants;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Translation;

import java.util.Objects;

public class ABF_add_category_translation extends AppCompatActivity {

    private EditText enLoc, esLoc;
    private boolean valid = true;
    private Translation translation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abf_add_category_translation);

        translation = getIntent().getParcelableExtra(Constants.EIObjectData);

        enLoc = findViewById(R.id.enLoc);
        esLoc = findViewById(R.id.esLoc);

        if (translation != new Translation()) {   ///< If the translation is not new
            enLoc.setText(translation.getDefaultLang());
            enLoc.setText(translation.getEs_translation());
        }
    }

    public void validate(View view) {
        String enLocText = enLoc.getText().toString();
        String esLocText = esLoc.getText().toString();

        if (Objects.equals(enLocText, "")) {
            valid = false;
        }
        if (Objects.equals(esLocText, "")) {
            valid = false;
        }

        if (valid) {
            translation.setDefaultLang(enLocText);
            translation.setEs_translation(esLocText);

            translation.setComplete(true);
            goBack();
        } else {
            translation.setDefaultLang(enLocText);
            translation.setEs_translation(esLocText);

            translation.setComplete(false);
        }
    }

    private void goBack() {
        Intent i = new Intent();
        i.putExtra(Constants.EIObjectData, translation);
        setResult(Constants.RESULT_OK, i);
        finish();
    }
}
