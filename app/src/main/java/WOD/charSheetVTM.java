package WOD;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class charSheetVTM extends AppCompatActivity {
    Spinner clanSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.layout.activity_char_sheet_vtm);

        clanSpinner = (Spinner) findViewById(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.id.clanSpinner);

        ArrayAdapter<String> clanSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.array.vtm_clans));
        clanSpinner.setAdapter(clanSpinnerAdapter);
    }

    protected void checkNumbers(View view){

    }
}
