package WOD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;

public class WODVTMCLANS_Camarilla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wodvtmclans__camarilla);
    }

    public void gotoBrujah (View view){
        Intent i = new Intent(this, WODVTMCLANSBrujah.class);
        startActivity(i);
    }

    public void gotoGangrel (View view){
        Intent i = new Intent(this, WODVTMCLANSGangrel.class);
        startActivity(i);
    }

    public void gotoMalkavian (View view){
        Intent i = new Intent(this, WODVTMCLANSMalkavian.class);
        startActivity(i);
    }

    public void gotoNosferatu (View view){
        Intent i = new Intent(this, WODVTMCLANSNosferatu.class);
        startActivity(i);
    }

    public void gotoToreador (View view){
        Intent i = new Intent(this, WODVTMCLANSToreador.class);
        startActivity(i);
    }

    public void gotoTremere (View view){
        Intent i = new Intent(this, WODVTMCLANSTremere.class);
        startActivity(i);
    }

    public void gotoVentrue (View view){
        Intent i = new Intent(this, WODVTMCLANSVentrue.class);
        startActivity(i);
    }
}
