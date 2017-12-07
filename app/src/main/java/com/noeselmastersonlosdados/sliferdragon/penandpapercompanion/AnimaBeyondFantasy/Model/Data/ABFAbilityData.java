package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data;

/**
 * Created by Jorge on 03/12/2017.
 */

public class ABFAbilityData {
    private String name;
    private String attr;
    private String set;
    private String desc;

    public ABFAbilityData() {
    }

    public ABFAbilityData(String name, String attr, String set) {
        this.name = name;
        this.attr = attr;
        this.set = set;
    }

    public ABFAbilityData(String name) {
        this.name = name;
    }

    public ABFAbilityData(String name, String attr) {
        this.name = name;
        this.attr = attr;
    }

    public ABFAbilityData(String name, String attr, String set, String desc) {
        this.name = name;
        this.attr = attr;
        this.set = set;
        this.desc = desc;
    }
}
