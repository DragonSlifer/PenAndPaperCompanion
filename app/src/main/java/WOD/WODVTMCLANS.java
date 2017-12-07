package WOD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class WODVTMCLANS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wodvtmclans);
    }

    public void goBack (View view){
        finish();
    }

    public void gotoCamarilla (View view){
        Intent i = new Intent(this, WODVTMCLANS_Camarilla.class);
        startActivity(i);
    }
}
