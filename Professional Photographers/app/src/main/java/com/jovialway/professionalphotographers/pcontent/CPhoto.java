
package com.jovialway.professionalphotographers.pcontent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CPhoto {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pg_id")
    @Expose
    private String pgId;
    @SerializedName("photourl")
    @Expose
    private String photourl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPgId() {
        return pgId;
    }

    public void setPgId(String pgId) {
        this.pgId = pgId;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

}