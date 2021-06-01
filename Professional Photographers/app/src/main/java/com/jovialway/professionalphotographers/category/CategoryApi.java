package com.jovialway.professionalphotographers.category;

import com.jovialway.professionalphotographers.topbanner.AllApi;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class CategoryApi {
    private static final String option="2";

public static CategoryService categoryService=null;

public static CategoryService getCategoryService(){
    if (categoryService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        categoryService=retrofit.create(CategoryService.class);
    }
    return categoryService;
}

    public interface CategoryService {
        @GET("photography/api/categoryapi.php?option="+option)
        Call<CategoryPojo> getCategoryist();

    }
    
}
