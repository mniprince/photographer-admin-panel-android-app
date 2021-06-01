
package com.jovialway.professionalphotographers.purchescourse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PCourse {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("fee")
        @Expose
        private String fee;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("total_class")
        @Expose
        private String totalClass;
        @SerializedName("course_title")
        @Expose
        private String courseTitle;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getTotalClass() {
            return totalClass;
        }

        public void setTotalClass(String totalClass) {
            this.totalClass = totalClass;
        }

        public String getCourseTitle() {
            return courseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

    }