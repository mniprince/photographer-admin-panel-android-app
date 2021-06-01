package com.jovialway.professionalphotographers.purchesphoto;

import com.jovialway.professionalphotographers.topbanner.AllApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class PApi {


public static PService pService=null;

public static PService getPPhotoService(){
    if (pService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pService=retrofit.create(PService.class);
    }
    return pService;
}

    public interface PService {
        @GET("photography/api/photobuyapi.php")
        Call<List<PPhoto>> getPPhotoyist(@Query("key") String keyword) ;


    }
    
}
