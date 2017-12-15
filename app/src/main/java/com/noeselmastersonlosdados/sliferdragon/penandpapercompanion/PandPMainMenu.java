package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.View.ABFTools;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.WorldOfDarkness.WOD_Menu;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Constants;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.GeneralMethods;

import java.util.Arrays;

public class PandPMainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pand_pmain_menu);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            ///< Already signed in
        } else {
            ///< Not signed in
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                            .setAvailableProviders(
                                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                            .build(), Constants.RESULT_RC_SIGN_IN);
        }
    }

    public void goto_WOD_Menu(View view) {
        Intent i = new Intent(this, WOD_Menu.class);
        startActivity(i);
    }

    public void not_implemented_yet(View view) {
        Toast.makeText(this, getResources().getText(com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R.string.not_implemented_yet), Toast.LENGTH_SHORT).show();
    }

    public void goto_BESM_Menu(View view) {
        Intent i = new Intent(this, BESM_Main_Menu.class);
        startActivity(i);
    }

    public void goto_ABFTools(View view) {
        Intent i = new Intent(this, ABFTools.class);
        startActivity(i);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RESULT_RC_SIGN_IN:
                IdpResponse response = IdpResponse.fromResultIntent(data);
                if (resultCode == Constants.RESULT_OK) {
                    GeneralMethods.ShowSnackbar(R.string.successful_login, (View) getResources().getLayout(R.layout.activity_pand_pmain_menu));
                } else {
                    if (response == null) {
                        GeneralMethods.ShowSnackbar(R.string.failed_login_cancelled, (View) getResources().getLayout(R.layout.activity_pand_pmain_menu));
                    } else if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                        GeneralMethods.ShowSnackbar(R.string.failed_login_wifi, (View) getResources().getLayout(R.layout.activity_pand_pmain_menu));
                    } else if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                        GeneralMethods.ShowSnackbar(R.string.failed_login_unknown, (View) getResources().getLayout(R.layout.activity_pand_pmain_menu));
                    }
                }
                break;
        }
    }

    public void log_out(View view) {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(PandPMainMenu.this, PandPMainMenu.class));
                        finish();
                    }
                });
    }

    public void delete_account(View view) {
        AuthUI.getInstance()
                .delete(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Deletion succeeded
                        } else {
                            // Deletion failed
                        }
                    }
                });
    }

}
