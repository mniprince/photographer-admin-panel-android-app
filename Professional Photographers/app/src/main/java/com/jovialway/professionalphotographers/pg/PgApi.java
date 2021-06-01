package com.jovialway.professionalphotographers.pg;

import com.jovialway.professionalphotographers.topbanner.AllApi;
import com.jovialway.professionalphotographers.topbanner.BannerPojo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class PgApi {
    private static final String option="2";

public static PgService pgService=null;

public static PgService getPgService(){
    if (pgService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pgService=retrofit.create(PgService.class);
    }
    return pgService;
}

    public interface PgService {
        @GET("photography/api/photographerapi.php?option="+option)
        Call<PgPojo> getPgList();

    }
    
}
