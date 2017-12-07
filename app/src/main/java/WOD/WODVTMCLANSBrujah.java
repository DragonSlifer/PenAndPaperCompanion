package WOD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class WODVTMCLANSBrujah extends AppCompatActivity {

    private TextView historyText;
    private String history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.layout.activity_wodvtmclansbrujah);

    }

    public void hide_showHistory(View view) {
        Intent i = new Intent(this, BrujahHistoryVTM.class);
        startActivity(i);
    }

    private void startAnimationFadeInOut(TextView text, int i) {
        if (i == 0){
            Animation in = new AlphaAnimation(0.0f, 1.0f);
            in.setDuration(5000);
            text.startAnimation(in);
        } else {
            Animation out = new AlphaAnimation(1.0f, 0.0f);
            out.setDuration(5000);
            text.startAnimation(out);
        }
    }

    public void goBack(View view){
        finish();
    }
}
