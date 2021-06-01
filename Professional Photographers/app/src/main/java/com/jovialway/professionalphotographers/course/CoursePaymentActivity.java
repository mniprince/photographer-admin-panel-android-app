package com.jovialway.professionalphotographers.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.auth.DashboardActivity;
import com.jovialway.professionalphotographers.auth.UserLogin;
import com.jovialway.professionalphotographers.photopurches.PhotoBuyActivity;
import com.jovialway.professionalphotographers.topbanner.AllApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursePaymentActivity extends AppCompatActivity {
    LinearLayout pl;
    TextView textitle, textfee,dutext,textotal;
    Button paybtn;
    String course,fee,totalclass,duartion,user_id;
    ImageView pimage;
    private FirebaseAuth aAuth;
    int position;
    ImageView card,cchk,rocket,rchk,bkash,bkchk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_course_payment);
        paybtn=findViewById(R.id.paybtn);
        pimage=findViewById(R.id.pimage);
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
            aAuth=FirebaseAuth.getInstance();
        }catch (Exception e){}
        textitle=findViewById(R.id.textitle);
        textfee=findViewById(R.id.textfee);
        dutext=findViewById(R.id.dutext);
        textotal=findViewById(R.id.textotal);

        Intent iin= getIntent();
        course =iin.getStringExtra("course");
        textitle.setText(course);

        fee =iin.getStringExtra("fee");
        textfee.setText(fee);

        totalclass =iin.getStringExtra("totalclass");
        textotal.setText(totalclass);


        position =iin.getIntExtra("position",1);
//        userid =iin.getStringExtra("userid");
        duartion =iin.getStringExtra("duartion");
        dutext.setText(duartion);

        if (position==1){
            pimage.setImageResource(R.drawable.basic);
        }else if (position==2){
            pimage.setImageResource(R.drawable.foundationcourse);
        }else {
            pimage.setImageResource(R.drawable.professional);
        }

        //Toast.makeText(this, j, Toast.LENGTH_SHORT).show();
        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aAuth.getCurrentUser()!=null) {
                    user_id = aAuth.getCurrentUser().getUid();
                }else {
                    startActivity(new Intent(CoursePaymentActivity.this, UserLogin.class));
                }
                Toast.makeText(CoursePaymentActivity.this, "Payment Success!", Toast.LENGTH_SHORT).show();
            process();
            paybtn.setVisibility(View.GONE);
                pl.setVisibility(View.GONE);
            }
        });
    }
    public  void  process()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CourseApi capi=retrofit.create(CourseApi.class);
        Call<Model> call=capi.addcoursedata(course,totalclass,fee,user_id);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.isSuccessful()){
                    Toast.makeText(CoursePaymentActivity.this, "Purchase Success ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CoursePaymentActivity.this, DashboardActivity.class));
                finish();
                }
                }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(CoursePaymentActivity.this, "Failed to Pay,Try again.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CoursePaymentActivity.this, AllCourseActivity.class));
                finish();
            }
        });

    }
}