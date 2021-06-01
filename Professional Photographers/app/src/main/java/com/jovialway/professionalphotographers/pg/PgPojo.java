
package com.jovialway.professionalphotographers.pg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PgPojo {
    @SerializedName("photographer")
    @Expose
    private List<Pg> photographer = new ArrayList<>();

    public List<Pg> getPhotographer() {
        return photographer;
    }

    public void setPhotographer(List<Pg> photographer) {
        this.photographer = photographer;
    }

}

