package com.jovialway.professionalphotographers.hirecontact;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HireApi {
    @FormUrlEncoded
    @POST("photography/api/hireapi.php")
    Call<HModel> addhiredata(@Field("hname") String hname, @Field("hcontact") String hcontact, @Field("hlocation") String hlocation,@Field("hetype") String hetype,@Field("hmsg") String hmsg, @Field("userid") String userid, @Field("hdate") String hdate, @Field("pgname") String pgname, @Field("pgmail") String pgmail);
}
