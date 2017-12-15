package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

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

    @NonNull
    public static String getStringByDefaultLocal(Activity context, int resId) {
        Locale defaultLocale = Locale.getDefault();
        return getStringByLocal(context, resId, defaultLocale.toString());
    }

    @NonNull
    public static String[] getArrayStringByDefaultLocal(Activity context, int resId) {
        Locale defaultLocale = Locale.getDefault();
        return getArrayStringByLocal(context, resId, defaultLocale.toString());
    }

    @NonNull
    public static String[] getArrayStringByLocal(Activity context, int resId, String locale) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            return getArrayStringByLocalPlus17(context, resId, locale);
        else
            return getArrayStringByLocalBefore17(context, resId, locale);
    }

    @NonNull
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static String[] getArrayStringByLocalPlus17(Activity context, int resId, String locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        return context.createConfigurationContext(configuration).getResources().getStringArray(resId);
    }

    private static String[] getArrayStringByLocalBefore17(Context context, int resId, String language) {
        Resources currentResources = context.getResources();
        AssetManager assets = currentResources.getAssets();
        DisplayMetrics metrics = currentResources.getDisplayMetrics();
        Configuration config = new Configuration(currentResources.getConfiguration());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        config.locale = locale;
        /**
         * Note: This (temporarily) changes the devices locale! TODO find a
         * better way to get the string in the specific locale
         */
        Resources defaultLocaleResources = new Resources(assets, metrics, config);
        String string[] = defaultLocaleResources.getStringArray(resId);
        // Restore device-specific locale
        new Resources(assets, metrics, currentResources.getConfiguration());
        return string;
    }

    @NonNull
    public static String getStringByLocal(Activity context, int resId, String locale) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            return getStringByLocalPlus17(context, resId, locale);
        else
            return getStringByLocalBefore17(context, resId, locale);
    }


    @NonNull
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static String getStringByLocalPlus17(Activity context, int resId, String locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        return context.createConfigurationContext(configuration).getResources().getString(resId);
    }

    private static String getStringByLocalBefore17(Context context, int resId, String language) {
        Resources currentResources = context.getResources();
        AssetManager assets = currentResources.getAssets();
        DisplayMetrics metrics = currentResources.getDisplayMetrics();
        Configuration config = new Configuration(currentResources.getConfiguration());
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        config.locale = locale;
        /**
         * Note: This (temporarily) changes the devices locale! TODO find a
         * better way to get the string in the specific locale
         */
        Resources defaultLocaleResources = new Resources(assets, metrics, config);
        String string = defaultLocaleResources.getString(resId);
        // Restore device-specific locale
        new Resources(assets, metrics, currentResources.getConfiguration());
        return string;
    }
}
