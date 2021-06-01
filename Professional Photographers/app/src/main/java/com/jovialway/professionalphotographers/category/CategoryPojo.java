
package com.jovialway.professionalphotographers.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class CategoryPojo {

    @SerializedName("categorytbl")
    @Expose
    private List<Categorytbl> categorytbl = new ArrayList<>();

    public List<Categorytbl> getCategorytbl() {
        return categorytbl;
    }

    public void setCategorytbl(List<Categorytbl> categorytbl) {
        this.categorytbl = categorytbl;
    }

}