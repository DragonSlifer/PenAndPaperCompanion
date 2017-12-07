package WOD;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

import static com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.id.clanSpinner;

public class charSheetFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_sheet_first);
        /*
        clanSpinner = (Spinner) findViewById(clanSpinner);

        ArrayAdapter<String> clanSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.array.vtm_clans));
        clanSpinner.setAdapter(clanSpinnerAdapter);
        */
    }
}
