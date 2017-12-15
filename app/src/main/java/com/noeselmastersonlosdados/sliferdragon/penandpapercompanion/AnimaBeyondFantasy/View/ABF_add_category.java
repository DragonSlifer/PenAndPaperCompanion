package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data.Category;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.R;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Constants;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.DatabaseConnector;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.MultiSelectionSpinner;
import com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.model.Translation;

import java.util.ArrayList;
import java.util.List;

public class ABF_add_category extends AppCompatActivity {
    private Category category;
    private String items[] = {"10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%", "100%"};
    private ArrayList<String> catNames;
    private ArrayList<String> archetypes;
    private ArrayList<String> archetypesDefault;
    private AutoCompleteTextView categoryName;
    private MultiSelectionSpinner archetypeSpinner;
    private Spinner combatLimit, supernaturalLimit, psychicLimit;
    private EditText hpMultCost, hpPerLevel, turnPerLevel, cmPerLevel,
            cvPerIntervalLevel, cvInterval, atkCost, blkCost, ddgCost,
            armCost, kiCost, accumKiCost, zeonCost, zeonAdd, actCost, magProjCost,
            convCost, controlCost, bindCost, banishCost, cvCost, psyProjCost,
            atlCost, socCost, perCost, intCost, vigCost, subCost, creCost;
    private DatabaseConnector databaseConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abf_add_category);
        databaseConnector = new DatabaseConnector();
        if (savedInstanceState != null) {
            category = savedInstanceState.getParcelable(Constants.ClassABFCategory);
        } else {
            category = new Category();
        }
        categoryName = findViewById(R.id.catName);

        FirebaseFirestore db = (databaseConnector = new DatabaseConnector()).getDb();
        db.collection(Constants.CollectionABF).document(Constants.CollectionABFGeneralInfo)
                .collection(Constants.CollectionABFClassRelated)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot documentSnapshots) {
                        catNames = new ArrayList<>();
                        for (DocumentSnapshot documentSnapshot : documentSnapshots) {
                            if (documentSnapshot != null) {
                                catNames.add(documentSnapshot.toObject(Category.class).getName());
                            }
                        }
                        categoryName.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, catNames));
                    }
                });

        archetypeSpinner = findViewById(R.id.archetypeSpinner);
        archetypes = new ArrayList<>();
        archetypesDefault = new ArrayList<>();
        for (String arc : getResources().getStringArray(R.array.abf_archetypes)) {
            archetypes.add(arc);
        }
        /*if(Locale.getDefault() != getResources().getConfiguration().locale){    ///< This is for internal purposes
            archetypesDefault = new ArrayList<>();
            for(String arc : GeneralMethods.getArrayStringByDefaultLocal(this,R.array.abf_archetypes)){
                archetypesDefault.add(arc);
            }
        }*/
        archetypeSpinner.setItems(archetypes);

        combatLimit = findViewById(R.id.combatLimit);
        combatLimit.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items));
        supernaturalLimit = findViewById(R.id.supernaturalLimit);
        supernaturalLimit.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items));
        psychicLimit = findViewById(R.id.psychicLimit);
        psychicLimit.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items));

        hpMultCost = findViewById(R.id.hpMultCost);
        hpPerLevel = findViewById(R.id.hpPerLevel);
        turnPerLevel = findViewById(R.id.cmPerLevel);
        cmPerLevel = findViewById(R.id.cmPerLevel);
        cvPerIntervalLevel = findViewById(R.id.cvPerIntervalLevel);
        cvInterval = findViewById(R.id.cvInterval);
        atkCost = findViewById(R.id.atkCost);
        blkCost = findViewById(R.id.blkCost);
        ddgCost = findViewById(R.id.ddgCost);
        armCost = findViewById(R.id.armCost);
        kiCost = findViewById(R.id.kiCost);
        accumKiCost = findViewById(R.id.accumKiCost);
        zeonCost = findViewById(R.id.zeonCost);
        zeonAdd = findViewById(R.id.zeonAdd);
        actCost = findViewById(R.id.actCost);
        magProjCost = findViewById(R.id.magProjCost);
        convCost = findViewById(R.id.convCost);
        controlCost = findViewById(R.id.controlCost);
        bindCost = findViewById(R.id.bindCost);
        banishCost = findViewById(R.id.banishCost);
        cvCost = findViewById(R.id.cvCost);
        psyProjCost = findViewById(R.id.psyProjCost);
        atlCost = findViewById(R.id.atlCost);
        socCost = findViewById(R.id.socCost);
        perCost = findViewById(R.id.perCost);
        intCost = findViewById(R.id.intCost);
        vigCost = findViewById(R.id.vigCost);
        subCost = findViewById(R.id.subCost);
        creCost = findViewById(R.id.creCost);

        categoryName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = categoryName.getText().toString();
                if (!hasFocus) {
                    category.setName(text);
                }
            }
        });
        archetypeSpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                List<String> texts = archetypeSpinner.getSelectedStrings();
                if (!hasFocus) {
                    category.setArchetypes(texts);
                }
            }
        });
        combatLimit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = combatLimit.getSelectedItem().toString();
                if (!hasFocus) {
                    float txt = getPercentageFromText(text);
                    category.getModifiers().setCombat_limit(txt);
                }
            }
        });

        supernaturalLimit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = supernaturalLimit.getSelectedItem().toString();
                if (!hasFocus) {
                    float txt = getPercentageFromText(text);
                    category.getModifiers().setSupernatural_limit(txt);
                }
            }
        });
        psychicLimit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = psychicLimit.getSelectedItem().toString();
                if (!hasFocus) {
                    float txt = getPercentageFromText(text);
                    category.getModifiers().setPsiquic_limit(txt);
                }
            }
        });
        hpMultCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = hpMultCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setHp_mult(Integer.parseInt(text));
                }
            }
        });
        hpPerLevel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = hpPerLevel.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setHp_per_level(Integer.parseInt(text));
                }
            }
        });
        turnPerLevel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = turnPerLevel.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setTurn_per_level(Integer.parseInt(text));
                }
            }
        });
        cmPerLevel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = turnPerLevel.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setCm_per_level(Integer.parseInt(text));
                }
            }
        });
        cvPerIntervalLevel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = cvPerIntervalLevel.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setCv_per_level(Integer.parseInt(text));
                }
            }
        });
        cvInterval.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = cvInterval.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setCv_interval(Integer.parseInt(text));
                }
            }
        });
        atkCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = atkCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setAtk_cost(Integer.parseInt(text));
                }
            }
        });
        blkCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = blkCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setBlk_cost(Integer.parseInt(text));
                }
            }
        });
        ddgCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = ddgCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setDdg_cost(Integer.parseInt(text));
                }
            }
        });
        armCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = armCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setArm_cost(Integer.parseInt(text));
                }
            }
        });
        kiCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = kiCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setKi_cost(Integer.parseInt(text));
                }
            }
        });
        accumKiCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = accumKiCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setAccum_mult_cost(Integer.parseInt(text));
                }
            }
        });
        zeonCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = zeonCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setZeon_cost(Integer.parseInt(text));
                }
            }
        });
        zeonAdd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = zeonAdd.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setZeon_add(Integer.parseInt(text));
                }
            }
        });
        actCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = actCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setAct_mult_cost(Integer.parseInt(text));
                }
            }
        });
        magProjCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = magProjCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setMag_proj_cost(Integer.parseInt(text));
                }
            }
        });
        convCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = convCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setConv_cost(Integer.parseInt(text));
                }
            }
        });
        controlCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = controlCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setDom_cost(Integer.parseInt(text));
                }
            }
        });
        bindCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = bindCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setBind_cost(Integer.parseInt(text));
                }
            }
        });
        banishCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = banishCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setDesummon_cost(Integer.parseInt(text));
                }
            }
        });
        cvCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = cvCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setCv_mult_cost(Integer.parseInt(text));
                }
            }
        });
        psyProjCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = psyProjCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setPsi_proj_cost(Integer.parseInt(text));
                }
            }
        });
        atlCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = atlCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setAtl_cost(Integer.parseInt(text));
                }
            }
        });
        socCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = socCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setSoc_cost(Integer.parseInt(text));
                }
            }
        });
        perCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = perCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setPer_cost(Integer.parseInt(text));
                }
            }
        });
        intCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = intCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setInt_cost(Integer.parseInt(text));
                }
            }
        });
        vigCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = vigCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setVig_cost(Integer.parseInt(text));
                }
            }
        });
        subCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = subCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setSub_cost(Integer.parseInt(text));
                }
            }
        });
        creCost.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text = creCost.getText().toString();
                if (!hasFocus && text != "" && text != null) {
                    category.getModifiers().setCre_cost(Integer.parseInt(text));
                }
            }
        });
    }

    private float getPercentageFromText(String text) {
        float txt = 0;

        switch (text) {
            case "10%":
                txt = 0.1f;
                break;
            case "20%":
                txt = 0.2f;
                break;
            case "30%":
                txt = 0.3f;
                break;
            case "40%":
                txt = 0.4f;
                break;
            case "50%":
                txt = 0.5f;
                break;
            case "60%":
                txt = 0.6f;
                break;
            case "70%":
                txt = 0.7f;
                break;
            case "80%":
                txt = 0.8f;
                break;
            case "90%":
                txt = 0.9f;
                break;
        }

        return txt;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.REQUEST_ABF_CAT_TRANSLATION:
                this.category.setTranslation((Translation) data.getParcelableExtra(Constants.EIObjectData));
                break;
            case Constants.REQUEST_ABF_CAT_PRIMARY_MOD:
                this.category.getModifiers().setPrimaryBonuses(data.getIntegerArrayListExtra(Constants.EIArrayInteger));
                this.category.getModifiers().setPrimaryBonusesString(data.getStringArrayListExtra(Constants.EIArrayString));
                break;
            case Constants.REQUEST_ABF_CAT_SECONDARY_MOD:
                this.category.getModifiers().setSecondaryBonuses(data.getIntegerArrayListExtra(Constants.EIArrayInteger));
                this.category.getModifiers().setSecondaryBonusesString(data.getStringArrayListExtra(Constants.EIArrayString));
                break;
            case Constants.REQUEST_ABF_CAT_SPECIAL_MOD:
                this.category.getModifiers().setSpecialBonuses(data.getIntegerArrayListExtra(Constants.EIArrayInteger));
                this.category.getModifiers().setSpecialBonusesString(data.getStringArrayListExtra(Constants.EIArrayString));
                break;
        }
    }

    public void goto_abf_add_category_translation(View view) {
        Intent i = new Intent(this, ABF_add_category_translation.class);
        i.putExtra(Constants.EIObjectData, category.getTranslation());
        startActivityForResult(i, Constants.REQUEST_ABF_CAT_TRANSLATION);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelable(Constants.ClassABFCategory, category);
        super.onSaveInstanceState(savedInstanceState);
    }
}
