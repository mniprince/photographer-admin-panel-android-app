
package com.jovialway.professionalphotographers.pg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pg {

    @SerializedName("pg_id")
    @Expose
    private String pgId;
    @SerializedName("pg_name")
    @Expose
    private String pgName;
    @SerializedName("pg_email")
    @Expose
    private String pgEmail;
    @SerializedName("pg_location")
    @Expose
    private String pgLocation;
    @SerializedName("pg_image")
    @Expose
    private String pgImage;
    @SerializedName("pg_like")
    @Expose
    private String pgLike;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("pg_password")
    @Expose
    private String pgPassword;

    public String getPgId() {
        return pgId;
    }

    public void setPgId(String pgId) {
        this.pgId = pgId;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    public String getPgEmail() {
        return pgEmail;
    }

    public void setPgEmail(String pgEmail) {
        this.pgEmail = pgEmail;
    }

    public String getPgLocation() {
        return pgLocation;
    }

    public void setPgLocation(String pgLocation) {
        this.pgLocation = pgLocation;
    }

    public String getPgImage() {
        return pgImage;
    }

    public void setPgImage(String pgImage) {
        this.pgImage = pgImage;
    }

    public String getPgLike() {
        return pgLike;
    }

    public void setPgLike(String pgLike) {
        this.pgLike = pgLike;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPgPassword() {
        return pgPassword;
    }

    public void setPgPassword(String pgPassword) {
        this.pgPassword = pgPassword;
    }

}