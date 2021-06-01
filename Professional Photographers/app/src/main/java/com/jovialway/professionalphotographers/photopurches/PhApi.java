package com.jovialway.professionalphotographers.photopurches;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PhApi {
    @FormUrlEncoded
    @POST("photography/api/photopayapi.php")
    Call<PModel> addphotodata(@Field("photoid") String id, @Field("pgid") String pgid, @Field("photourl") String photourl, @Field("price") String price, @Field("userid") String userid);
}
