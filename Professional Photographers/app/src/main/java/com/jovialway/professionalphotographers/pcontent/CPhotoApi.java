package com.jovialway.professionalphotographers.pcontent;
import com.jovialway.professionalphotographers.topbanner.AllApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class CPhotoApi {


public static CPhotoService cphotoService=null;

public static CPhotoService getCPhotoService(){
    if (cphotoService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cphotoService=retrofit.create(CPhotoService.class);
    }
    return cphotoService;
}

    public interface CPhotoService {
        @GET("photography/api/photocontent.php")
        Call<List<CPhoto>> getCPhotoyist(@Query("key") String keyword) ;


    }
    
}
