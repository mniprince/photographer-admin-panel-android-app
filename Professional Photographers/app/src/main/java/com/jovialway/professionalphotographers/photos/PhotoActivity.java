package com.jovialway.professionalphotographers.photos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.Toast;
import com.jovialway.professionalphotographers.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {
    RecyclerView photorv;
    BroadcastReceiver br;
    Toolbar toolbar;



    List<Photo> photolist;
    PhotoAdapter photoAdapter;
    String s;

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
                        setContentView(R.layout.activity_photo);
                        Intent intentc = getIntent();
                        s=intentc.getStringExtra("cname");

                        getphotodata(s);
                        setphotoAdapter();
                        toolbar= findViewById(R.id.hometoolbar);
                        setSupportActionBar(toolbar);
                        toolbar.setLogo(R.mipmap.ic_launcher_round);
                        toolbar.setTitle(s);





                    } else {

                        setContentView(R.layout.no_internet_screen);
                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                   }

                }
            };

            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver((BroadcastReceiver) br, intentFilter);
        }
    }

    private void getphotodata(String key){
        Call <List<Photo>> plist= PhotoApi.getPhotoService().getPhotoyist(key);
        plist.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photolist=response.body();
                photoAdapter=new PhotoAdapter(PhotoActivity.this,photolist);
                photorv.setAdapter(photoAdapter);
                photoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });


    }

    private void setphotoAdapter() {
        photorv = (RecyclerView) findViewById(R.id.photorv);
        photorv.setHasFixedSize(true);
        photorv.setLayoutManager(new GridLayoutManager(this, 2));

    }
}