package com.jovialway.professionalphotographers.hirecontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.auth.DashboardActivity;
import com.jovialway.professionalphotographers.auth.UserLogin;
import com.jovialway.professionalphotographers.course.CourseApi;
import com.jovialway.professionalphotographers.course.CoursePaymentActivity;
import com.jovialway.professionalphotographers.course.Model;
import com.jovialway.professionalphotographers.topbanner.AllApi;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HireActivity extends AppCompatActivity {
    private FirebaseAuth aAuth;
    Toolbar toolbar;
    EditText selectDate,name,contact,etype,elocation,msg;
    private int mYear, mMonth, mDay;
    Button hirebtn;
    String userid,hname,hcontact,hlocation,hetype,hmsg,hdate,pgname,pgmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        toolbar= findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        toolbar.setTitle(R.string.hp);
        selectDate=(EditText)findViewById(R.id.date);

        name=(EditText)findViewById(R.id.name);
        contact=(EditText)findViewById(R.id.contact);
        etype=(EditText)findViewById(R.id.etype);
        elocation=(EditText)findViewById(R.id.elocation);
        msg=(EditText)findViewById(R.id.msg);


        Intent intent = getIntent();
        pgname= intent.getStringExtra("pgname");
        pgmail = intent.getStringExtra("pgmail");

        hirebtn=(Button) findViewById(R.id.hirebtn);
        try {
            aAuth= FirebaseAuth.getInstance();
        }catch (Exception e){}

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(HireActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                selectDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        hirebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aAuth.getCurrentUser()!=null) {
                    userid = aAuth.getCurrentUser().getUid();

                    process();
                }else {
                    startActivity(new Intent(HireActivity.this, UserLogin.class));
                }

               // hirebtn.setVisibility(View.GONE);
            }
        });
    }

    public  void  process()
    {

        hname=name.getText().toString();
        hcontact=contact.getText().toString();
        hlocation=elocation.getText().toString();
        hetype=etype.getText().toString();
        hetype=etype.getText().toString();
        hmsg=msg.getText().toString();
        hdate=mDay+"/"+mMonth+"/"+mYear;

        if (hname.isEmpty()) {
            name.setError("Enter Your Name!");
            return;
        }
        if (hcontact.isEmpty()) {
            contact.setError("Enter Contact Number!");
            return;
        }
        if (hlocation.isEmpty()) {
            elocation.setError("Enter Event Location!");
            return;
        }
        if (hetype.isEmpty()) {
            etype.setError("Enter Event Type!");
            return;
        }
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AllApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HireApi capi=retrofit.create(HireApi.class);
        Call<HModel> call=capi.addhiredata(hname,hcontact,hlocation,hetype,hmsg,userid,hdate,pgname,pgmail);
        call.enqueue(new Callback<HModel>() {
            @Override
            public void onResponse(Call<HModel> call, Response<HModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(HireActivity.this, "WE'll Contact with YOU!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HireActivity.this, DashboardActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<HModel> call, Throwable t) {
                Toast.makeText(HireActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}