
package com.jovialway.professionalphotographers.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categorytbl {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cimage")
    @Expose
    private String cimage;
    @SerializedName("cname")
    @Expose
    private String cname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCimage() {
        return cimage;
    }

    public void setCimage(String cimage) {
        this.cimage = cimage;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

}