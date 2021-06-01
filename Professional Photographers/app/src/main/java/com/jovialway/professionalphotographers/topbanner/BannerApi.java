package com.jovialway.professionalphotographers.topbanner;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BannerApi {
    private static final String option="2";

public static BannerService bannerService=null;

public static BannerService getBannerService(){
    if (bannerService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bannerService=retrofit.create(BannerService.class);
    }
    return bannerService;
}

    public interface BannerService {
        @GET("photography/api/topbannerapi.php?option="+option)
        Call<BannerPojo> getBannerList();

    }
    
}
