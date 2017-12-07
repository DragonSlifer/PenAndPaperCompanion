package com.noeselmastersonlosdados.sliferdragon.penandpapercompanion.AnimaBeyondFantasy.Model.Data;

/**
 * Created by Jorge on 03/12/2017.
 */

public class ABFCatCosts {
    private int cost;
    private String cat;

    public ABFCatCosts(String cat) {
        this.cat = cat;
        this.cost = 0;
    }

    public ABFCatCosts(int cost, String cat) {
        this.cost = cost;
        this.cat = cat;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
