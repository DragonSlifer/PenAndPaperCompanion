package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;


import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Jorge on 07/12/2017.
 */

public class GeneralMethods {
    public static void ShowSnackbar(String message, View view) {
        if (message != null) {
            Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).show();
        }
    }

    public static void ShowSnackbar(int message, View view) {
        if (view.getContext().getResources().getString(message) != null) {
            ShowSnackbar(view.getContext().getResources().getString(message), view);
        }
    }
}
