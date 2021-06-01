package com.jovialway.professionalphotographers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jovialway.professionalphotographers.auth.DashboardActivity;
import com.jovialway.professionalphotographers.auth.UserLogin;
import com.jovialway.professionalphotographers.category.CategoryAdapter;
import com.jovialway.professionalphotographers.category.CategoryApi;
import com.jovialway.professionalphotographers.category.CategoryPojo;
import com.jovialway.professionalphotographers.course.AllCourseActivity;
import com.jovialway.professionalphotographers.pg.PgAdapter;
import com.jovialway.professionalphotographers.pg.PgApi;
import com.jovialway.professionalphotographers.pg.PgPojo;
import com.jovialway.professionalphotographers.topbanner.BannerApi;
import com.jovialway.professionalphotographers.topbanner.BannerPojo;
import com.jovialway.professionalphotographers.topbanner.TopBannerAdapter;
import com.jovialway.professionalphotographers.views.CatActivity;
import com.jovialway.professionalphotographers.views.PgActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private long backpresstime;
    BroadcastReceiver br;
    Toolbar toolbar;
    RecyclerView topbannerRV,pgrv,categoryrv;
    BannerPojo list;
    TopBannerAdapter topBannerAdapter;
    ImageView payment;
    TextView pgtv,cttv;
    PgPojo pglist;
    PgAdapter pgAdapter;
    CategoryPojo catlist;
    CategoryAdapter cayAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkInternetConnection();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

        try {
            FirebaseUser fuser= mAuth.getCurrentUser();
            if (fuser!=null){
                fab.setImageDrawable(getDrawable(R.drawable.logedin));
            }else{
                fab.setImageDrawable(getDrawable(R.drawable.loginfltbtn));
            }
        }catch (Exception e){}


    }
    private void checkInternetConnection(){
        if (br == null) {

            br = new BroadcastReceiver() {

                @SuppressLint("UseCompatLoadingForDrawables")
                @Override
                public void onReceive(Context context, Intent intent) {

                    Bundle extras = intent.getExtras();

                    NetworkInfo info = (NetworkInfo) extras
                            .getParcelable("networkInfo");

                    NetworkInfo.State state = info.getState();
                    if (state == NetworkInfo.State.CONNECTED) {
                        setContentView(R.layout.activity_main);
                        mAuth = FirebaseAuth.getInstance();
                        getdata();
                        setAdapter();

                        getpgdata();
                        setPgAdapter();

                        getCategorydata();
                        setCategoryAdapter();

                        toolbar= findViewById(R.id.hometoolbar);
                        setSupportActionBar(toolbar);
                        toolbar.setLogo(R.mipmap.ic_launcher_round);
                        toolbar.setTitle(R.string.app_name);
                        pgtv=findViewById(R.id.pgtv);
                        cttv=findViewById(R.id.cttv);
                        fab = findViewById(R.id.fab);
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intfab=new Intent(MainActivity.this, UserLogin.class);
                                startActivity(intfab);
                            }
                        });




                        cttv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(MainActivity.this, CatActivity.class);
                                startActivity(intent);
                            }
                        });

                        pgtv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(MainActivity.this, PgActivity.class);
                                startActivity(intent);
                            }
                        });

                        payment=findViewById(R.id.payment);
                        payment.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent inte=new Intent(MainActivity.this, AllCourseActivity.class);
                                startActivity(inte);
//                                    DialogFragment dialog = FullscreenDialog.newInstance();
//                                    dialog.show(getSupportFragmentManager(), "tag");

                            }
                        });



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

    private void getdata(){
        Call<BannerPojo> bannerlist= BannerApi.getBannerService().getBannerList();
        bannerlist.enqueue(new Callback<BannerPojo>() {
            @Override
            public void onResponse(Call<BannerPojo> call, Response<BannerPojo> response) {
                if (response.isSuccessful()) {

                    try {
                        list = response.body();
                        topbannerRV.setAdapter(new TopBannerAdapter(MainActivity.this, list.getTopbanner()));
                        topBannerAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<BannerPojo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                try {
                    FirebaseUser fuser= mAuth.getCurrentUser();
                    if (fuser!=null){
                        fab.setImageDrawable(getDrawable(R.drawable.logedin));
                    }else{
                        fab.setImageDrawable(getDrawable(R.drawable.loginfltbtn));
                    }
                }catch (Exception e){}

            }
        });
    }



    private void getpgdata(){
        Call<PgPojo> pgall= PgApi.getPgService().getPgList();
        pgall.enqueue(new Callback<PgPojo>() {
            @Override
            public void onResponse(Call<PgPojo> call, Response<PgPojo> response) {
                if (response.isSuccessful()) {

                    try {
                        pglist = response.body();
                        pgrv.setAdapter(new PgAdapter(MainActivity.this, pglist.getPhotographer()));
                        pgAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<PgPojo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void getCategorydata(){
        Call<CategoryPojo> clist= CategoryApi.getCategoryService().getCategoryist();
        clist.enqueue(new Callback<CategoryPojo>() {
            @Override
            public void onResponse(Call<CategoryPojo> call, Response<CategoryPojo> response) {
                if (response.isSuccessful()) {

                    try {
                        catlist = response.body();
                        categoryrv.setAdapter(new CategoryAdapter(MainActivity.this, catlist.getCategorytbl()));
                        cayAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CategoryPojo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setCategoryAdapter() {
        categoryrv = (RecyclerView) findViewById(R.id.categoryrv);
        categoryrv.setHasFixedSize(true);
        categoryrv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));

    }

    private void setPgAdapter() {
        pgrv = (RecyclerView) findViewById(R.id.pgrv);
        pgrv.setHasFixedSize(true);
        pgrv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));

        final int time=3000;
        Handler handlerpg=new Handler();
        Runnable runnablepg=new Runnable() {
            int count=0;
            @Override
            public void run() {
                if (pglist != null){
                    if (count<pglist.getPhotographer().size()){
                        pgrv.scrollToPosition(count++);
                        handlerpg.postDelayed(this, time);
                    }
                    if (count==pglist.getPhotographer().size()){
                        count=0;
                    }
                    RecyclerView.ViewHolder vh=pgrv.findViewHolderForAdapterPosition(count);

                }else {

                }
            }
        };
        handlerpg.postDelayed(runnablepg,time);
    }

    private void setAdapter() {
        topbannerRV = (RecyclerView) findViewById(R.id.topbannerRV);
        topbannerRV.setHasFixedSize(true);
        topbannerRV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));

        final int time=2000;
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            int count=0;
            @Override
            public void run() {
                if (list != null){
                    if (count<list.getTopbanner().size()){
                        topbannerRV.scrollToPosition(count++);
                        handler.postDelayed(this, time);
                    }
                    if (count==list.getTopbanner().size()){
                        count=0;
                    }
                    RecyclerView.ViewHolder vh=topbannerRV.findViewHolderForAdapterPosition(count);

                }
            }
        };
        handler.postDelayed(runnable,time);

    }


    @Override
    public void onBackPressed() {
        if (backpresstime + 2000 > System.currentTimeMillis()) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setTitle("Confirmation Warning!");
            builder.setCancelable(true);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.finish();
                    finish();
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        } else {
            Toast.makeText(getApplicationContext(), "Press again to exit!", Toast.LENGTH_SHORT).show();
        }
        backpresstime = System.currentTimeMillis();

    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            FirebaseUser fuser= mAuth.getCurrentUser();
            if (fuser!=null){
                fab.setImageDrawable(getDrawable(R.drawable.logedin));
            }else{
                fab.setImageDrawable(getDrawable(R.drawable.loginfltbtn));
            }
        }catch (Exception e){}

    }
}