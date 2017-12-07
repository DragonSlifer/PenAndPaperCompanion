package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Jorge on 26/11/2017.
 */

public class EditTextFocusChangeListener implements View.OnFocusChangeListener {
    private EditText editText;
    private int first = 0;

    public EditTextFocusChangeListener(EditText editText){
        this.editText = editText;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            if(first == 0){
                first++;
            }
        } else {
            if(first != 0){
                String text = editText.getText().toString();
                if(text == null || text == ""){
                    setStyleRed(this.editText);
                }
                else{
                    setStyleBlue(this.editText);
                }
            }
        }
    }

    public void setStyleRed(EditText editText){
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setColor(Color.RED);
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(3);
        editText.setBackground(shape);
    }

    public void setStyleBlue(EditText editText){
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setColor(Color.BLUE);
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(3);
        editText.setBackground(shape);
    }
}
