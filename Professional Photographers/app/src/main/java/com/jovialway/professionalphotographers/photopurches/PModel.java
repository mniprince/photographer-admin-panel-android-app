package com.jovialway.professionalphotographers.photopurches;

public class PModel {
    String id,pgid,photourl,price,userid;

    public PModel(String id, String pgid, String photourl, String price, String userid) {
        this.id = id;
        this.pgid = pgid;
        this.photourl = photourl;
        this.price = price;
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPgid() {
        return pgid;
    }

    public void setPgid(String pgid) {
        this.pgid = pgid;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
