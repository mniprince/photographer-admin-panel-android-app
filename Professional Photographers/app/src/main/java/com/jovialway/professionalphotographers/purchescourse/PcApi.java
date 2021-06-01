package com.jovialway.professionalphotographers.purchescourse;

import com.jovialway.professionalphotographers.pcontent.CPhoto;
import com.jovialway.professionalphotographers.topbanner.AllApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class PcApi {


public static PcService pcService=null;

public static PcService getPcService(){
    if (pcService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pcService=retrofit.create(PcService.class);
    }
    return pcService;
}

    public interface PcService {
        @GET("photography/api/courseapi.php")
        Call<List<PCourse>> getPcourse(@Query("key") String keyword) ;


    }
    
}
