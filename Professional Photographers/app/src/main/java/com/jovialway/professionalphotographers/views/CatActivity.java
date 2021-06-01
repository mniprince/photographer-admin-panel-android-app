package com.jovialway.professionalphotographers.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.jovialway.professionalphotographers.MainActivity;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.botomsheet.FullscreenDialog;
import com.jovialway.professionalphotographers.category.CategoryAdapter;
import com.jovialway.professionalphotographers.category.CategoryApi;
import com.jovialway.professionalphotographers.category.CategoryPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatActivity extends AppCompatActivity {
    CategoryPojo catlist;
    CategoryAdapter cayAdapter;
    RecyclerView categoryrv;
    BroadcastReceiver br;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkInternetConnection();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

    }

    private void checkInternetConnection(){
        if (br == null) {

            br = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {

                    Bundle extras = intent.getExtras();

                    NetworkInfo info = (NetworkInfo) extras
                            .getParcelable("networkInfo");

                    NetworkInfo.State state = info.getState();
                    if (state == NetworkInfo.State.CONNECTED) {
                        setContentView(R.layout.activity_cat);

                        getCategorydata();
                        setCategoryAdapter();
                        toolbar= findViewById(R.id.hometoolbar);
                        setSupportActionBar(toolbar);
                        toolbar.setLogo(R.mipmap.ic_launcher_round);
                        toolbar.setTitle(R.string.allcategory);


                    } else {

                        setContentView(R.layout.no_internet_screen);
                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                        Toast.makeText(getApplicationContext(), "Internet connection is Off", Toast.LENGTH_LONG).show();
                    }

                }
            };

            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver((BroadcastReceiver) br, intentFilter);
        }
    }

    private void getCategorydata(){
        Call<CategoryPojo> clist= CategoryApi.getCategoryService().getCategoryist();
        clist.enqueue(new Callback<CategoryPojo>() {
            @Override
            public void onResponse(Call<CategoryPojo> call, Response<CategoryPojo> response) {
                if (response.isSuccessful()) {

                    try {
                        catlist = response.body();
                        categoryrv.setAdapter(new CategoryAdapter(CatActivity.this, catlist.getCategorytbl()));
                        cayAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(CatActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CategoryPojo> call, Throwable t) {
                Toast.makeText(CatActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setCategoryAdapter() {
        categoryrv = (RecyclerView) findViewById(R.id.categoryrv);
        categoryrv.setHasFixedSize(true);
        categoryrv.setLayoutManager(new GridLayoutManager(this, 2));

    }
}