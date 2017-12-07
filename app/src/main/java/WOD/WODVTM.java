package WOD;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class WODVTM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wod_vtm);
    }


    public void go_back (View view){
        finish();
    }

    public void goto_Clans (View view){
        Intent i = new Intent(this, WODVTMCLANS.class);
        startActivity(i);
    }

    public void goto_CharCreation (View view){
        Intent i = new Intent(this, charSheetVTM.class);
        startActivity(i);
    }

}
