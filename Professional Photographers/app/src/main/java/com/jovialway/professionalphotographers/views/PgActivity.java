package com.jovialway.professionalphotographers.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
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
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.jovialway.professionalphotographers.MainActivity;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.botomsheet.FullscreenDialog;
import com.jovialway.professionalphotographers.pg.PgAdapter;
import com.jovialway.professionalphotographers.pg.PgAdapterFAll;
import com.jovialway.professionalphotographers.pg.PgApi;
import com.jovialway.professionalphotographers.pg.PgPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PgActivity extends AppCompatActivity {
    RecyclerView pgrv;
    BroadcastReceiver br;
    PgPojo pglist;
    PgAdapterFAll pgAdapter;


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
                        setContentView(R.layout.activity_pg);

                       getpgdata();
                       setPgAdapter();



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

    private void getpgdata(){
        Call<PgPojo> pgall= PgApi.getPgService().getPgList();
        pgall.enqueue(new Callback<PgPojo>() {
            @Override
            public void onResponse(Call<PgPojo> call, Response<PgPojo> response) {
                if (response.isSuccessful()) {

                    try {
                        pglist = response.body();
                        pgrv.setAdapter(new PgAdapterFAll(PgActivity.this, pglist.getPhotographer()));
                        pgAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(PgActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<PgPojo> call, Throwable t) {
                Toast.makeText(PgActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setPgAdapter() {
        pgrv = (RecyclerView) findViewById(R.id.pgrv);
        pgrv.setHasFixedSize(true);
        pgrv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, true));

    }
}