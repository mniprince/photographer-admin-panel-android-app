package com.jovialway.professionalphotographers.photopurches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.auth.DashboardActivity;
import com.jovialway.professionalphotographers.auth.UserLogin;
import com.jovialway.professionalphotographers.course.CourseApi;
import com.jovialway.professionalphotographers.course.CoursePaymentActivity;
import com.jovialway.professionalphotographers.course.Model;
import com.jovialway.professionalphotographers.hirecontact.HModel;
import com.jovialway.professionalphotographers.hirecontact.HireActivity;
import com.jovialway.professionalphotographers.hirecontact.HireApi;
import com.jovialway.professionalphotographers.topbanner.AllApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoBuyActivity extends AppCompatActivity {
    LinearLayout  pl;
    TextView pricetv;
    Button paybtn;
    String id,price,photourl,pgid,userid;
    ImageView pimage;
    private FirebaseAuth mAuth;
    ImageView card,cchk,rocket,rchk,bkash,bkchk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_buy);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        pricetv=findViewById(R.id.pricetv);
        pimage=findViewById(R.id.pimage);
        paybtn=findViewById(R.id.ppaybtn);
        pl=findViewById(R.id.pl);

        card=findViewById(R.id.card);
        cchk=findViewById(R.id.cchk);
        rocket=findViewById(R.id.rocket);
        rchk=findViewById(R.id.rchk);
        bkash=findViewById(R.id.bkash);
        bkchk=findViewById(R.id.bkchk);

        cchk.setImageResource(R.drawable.uncheck);
        rchk.setImageResource(R.drawable.uncheck);
        bkchk.setImageResource(R.drawable.uncheck);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cchk.setImageResource(R.drawable.check_circle);
                rchk.setImageResource(R.drawable.uncheck);
                bkchk.setImageResource(R.drawable.uncheck);

            }
        });
        rocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cchk.setImageResource(R.drawable.uncheck);
                rchk.setImageResource(R.drawable.check_circle);
                bkchk.setImageResource(R.drawable.uncheck);

            }
        });
        bkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cchk.setImageResource(R.drawable.uncheck);
                rchk.setImageResource(R.drawable.uncheck);
                bkchk.setImageResource(R.drawable.check_circle);

            }
        });


        try {
            mAuth=FirebaseAuth.getInstance();
        }catch (Exception e){}

        Intent iin= getIntent();
        id=iin.getStringExtra("id");
        pgid=iin.getStringExtra("pgid");
        photourl=iin.getStringExtra("photourl");
        price=iin.getStringExtra("price");
        pricetv.setText(price);

        Glide.with(this).load(AllApi.BASE_URL+"photography/"+photourl).into(pimage);


        if (mAuth.getCurrentUser()!=null) {
            userid = mAuth.getCurrentUser().getUid();
        }else {
            startActivity(new Intent(PhotoBuyActivity.this, UserLogin.class));
        }


        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process();
//                paybtn.setVisibility(View.GONE);
//                pl.setVisibility(View.GONE);
            }
        });
    }

    public  void  processa()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PhApi papi=retrofit.create(PhApi.class);
        Call<PModel> call=papi.addphotodata(id,pgid,photourl,price,userid);
        call.enqueue(new Callback<PModel>() {
            @Override
            public void onResponse(Call<PModel> call, Response<PModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PhotoBuyActivity.this, "Purchase Success ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PhotoBuyActivity.this, DashboardActivity.class));
                    finish();

                }
            }

            @Override
            public void onFailure(Call<PModel> call, Throwable t) {
                Toast.makeText(PhotoBuyActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void process(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PhApi papi=retrofit.create(PhApi.class);
        Call<PModel> call=papi.addphotodata(id,pgid,photourl,price,userid);
        call.enqueue(new Callback<PModel>() {
            @Override
            public void onResponse(Call<PModel> call, Response<PModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PhotoBuyActivity.this, "Purchase Success ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PhotoBuyActivity.this, DashboardActivity.class));
                    finish();

                }
            }

            @Override
            public void onFailure(Call<PModel> call, Throwable t) {
                Toast.makeText(PhotoBuyActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}