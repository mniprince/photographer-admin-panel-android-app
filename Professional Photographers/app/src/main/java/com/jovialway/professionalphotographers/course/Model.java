package com.jovialway.professionalphotographers.course;

public class Model {
   String course_title,total_class,fee,user_id;

    public Model(String course_title, String total_class, String fee, String user_id) {
        this.course_title = course_title;
        this.total_class = total_class;
        this.fee = fee;
        this.user_id = user_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getTotal_class() {
        return total_class;
    }

    public void setTotal_class(String total_class) {
        this.total_class = total_class;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
