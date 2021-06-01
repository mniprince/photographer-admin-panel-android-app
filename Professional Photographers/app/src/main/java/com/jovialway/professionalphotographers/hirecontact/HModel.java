package com.jovialway.professionalphotographers.hirecontact;

public class HModel {
    String hname,hcontact,hlocation,hetype,hmsg,userid,hdate,pgname,pgmail;

    public HModel(String hname, String hcontact, String hlocation, String hetype, String hmsg, String userid, String hdate, String pgname, String pgmail) {
        this.hname = hname;
        this.hcontact = hcontact;
        this.hlocation = hlocation;
        this.hetype = hetype;
        this.hmsg = hmsg;
        this.userid = userid;
        this.hdate = hdate;
        this.pgname = pgname;
        this.pgmail = pgmail;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHcontact() {
        return hcontact;
    }

    public void setHcontact(String hcontact) {
        this.hcontact = hcontact;
    }

    public String getHlocation() {
        return hlocation;
    }

    public void setHlocation(String hlocation) {
        this.hlocation = hlocation;
    }

    public String getHetype() {
        return hetype;
    }

    public void setHetype(String hetype) {
        this.hetype = hetype;
    }

    public String getHmsg() {
        return hmsg;
    }

    public void setHmsg(String hmsg) {
        this.hmsg = hmsg;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public String getPgname() {
        return pgname;
    }

    public void setPgname(String pgname) {
        this.pgname = pgname;
    }

    public String getPgmail() {
        return pgmail;
    }

    public void setPgmail(String pgmail) {
        this.pgmail = pgmail;
    }
}
