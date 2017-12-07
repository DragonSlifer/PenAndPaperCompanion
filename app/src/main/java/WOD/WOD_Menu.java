package WOD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class WOD_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wod_menu);
    }

    public void startVTMMode (View view){
        Intent i = new Intent(this, WODVTM.class);
        startActivity(i);
    }
}
