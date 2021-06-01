
package com.jovialway.professionalphotographers.topbanner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topbanner {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bannerimage")
    @Expose
    private String bannerimage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBannerimage() {
        return bannerimage;
    }

    public void setBannerimage(String bannerimage) {
        this.bannerimage = bannerimage;
    }

}
