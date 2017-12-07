package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.GeneralMenus;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.EditTextFocusChangeListener;

public class Login extends AppCompatActivity {
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        username.setOnFocusChangeListener(new EditTextFocusChangeListener(username));
        password.setOnFocusChangeListener(new EditTextFocusChangeListener(password));

        new EditTextFocusChangeListener(null).setStyleBlue(username);
        new EditTextFocusChangeListener(null).setStyleBlue(password);
    }



}
