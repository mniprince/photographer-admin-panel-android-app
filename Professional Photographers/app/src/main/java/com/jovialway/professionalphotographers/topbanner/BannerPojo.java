
package com.jovialway.professionalphotographers.topbanner;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerPojo {

    @SerializedName("topbanner")
    @Expose
    private List<Topbanner> topbanner = new ArrayList<>();

    public List<Topbanner> getTopbanner() {
        return topbanner;
    }

    public void setTopbanner(List<Topbanner> topbanner) {
        this.topbanner = topbanner;
    }

}
