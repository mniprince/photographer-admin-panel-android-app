package com.jovialway.professionalphotographers.photos;


import com.jovialway.professionalphotographers.topbanner.AllApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class PhotoApi {
    private static final String option="2";

public static PhotoService photoService=null;

public static PhotoService getPhotoService(){
    if (photoService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        photoService=retrofit.create(PhotoService.class);
    }
    return photoService;
}

    public interface PhotoService {
        @GET("photography/api/photosearchapi.php")
        Call<List<Photo>> getPhotoyist(@Query("key") String keyword) ;

    }
    
}
