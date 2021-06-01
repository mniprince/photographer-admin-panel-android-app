package com.jovialway.professionalphotographers.course;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CourseApi {
    @FormUrlEncoded
    @POST("photography/api/coursebuyapi.php")
    Call<Model> addcoursedata(@Field("course_title") String course_title, @Field("total_class") String total_class, @Field("fee") String fee,  @Field("user_id") String user_id);
}
