package com.jovialway.professionalphotographers.course;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.auth.UserLogin;

public class AllCourseActivity extends AppCompatActivity {
    ImageView basic,bchk,foundation,fchk,profesional,pchk;
    androidx.appcompat.widget.AppCompatButton paybtn;
    String course;
    private FirebaseAuth mAuth;
    String fee;

    String totalclass;
    String userid;
    String duartion;
    int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_all_course);
        basic=findViewById(R.id.basic);
        bchk=findViewById(R.id.bchk);
        foundation=findViewById(R.id.foundation);
        fchk=findViewById(R.id.fchk);
        profesional=findViewById(R.id.profesional);
        pchk=findViewById(R.id.pchk);
        paybtn=findViewById(R.id.paybtn);
        mAuth = FirebaseAuth.getInstance();

        bchk.setImageResource(R.drawable.uncheck);
        fchk.setImageResource(R.drawable.uncheck);
        pchk.setImageResource(R.drawable.uncheck);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bchk.setImageResource(R.drawable.check_circle);
                fchk.setImageResource(R.drawable.uncheck);
                pchk.setImageResource(R.drawable.uncheck);
                course="Basic Photography Course";
                fee="5500tk";
                totalclass="15";
                duartion="30 hrs";
                position=1;
            }
        });
        foundation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bchk.setImageResource(R.drawable.uncheck);
                fchk.setImageResource(R.drawable.check_circle);
                pchk.setImageResource(R.drawable.uncheck);
                course="Foundation Course";
                fee="10000tk";
                totalclass="20";
                duartion="40 hrs";
                position=2;
            }
        });
        profesional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bchk.setImageResource(R.drawable.uncheck);
                fchk.setImageResource(R.drawable.uncheck);
                pchk.setImageResource(R.drawable.check_circle);
                course="Professional Photography Course";
                fee="18000tk";
                totalclass="25";
                duartion="50 hrs";
                position=3;
            }
        });

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAuth.getCurrentUser()!=null) {
                    userid = mAuth.getCurrentUser().getUid();
                }else {
                    startActivity(new Intent (AllCourseActivity.this,UserLogin.class));
                }

                try {
                    FirebaseUser fuser= mAuth.getCurrentUser();
                    if (fuser!=null){
                        Intent in=new Intent(AllCourseActivity.this,CoursePaymentActivity.class);
                        in.putExtra("course", course);
                        in.putExtra("fee", fee);
                        in.putExtra("totalclass", totalclass);
                        in.putExtra("duartion", duartion);
                        in.putExtra("position", position);
                        //in.putExtra("userid", userid);
                        startActivity(in);
                    }else{
                        startActivity(new Intent(AllCourseActivity.this, UserLogin.class));
                    }
                }catch (Exception e){}




            }
        });

    }
}