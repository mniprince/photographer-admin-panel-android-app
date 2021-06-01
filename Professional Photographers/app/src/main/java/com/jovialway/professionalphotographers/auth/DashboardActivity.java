package com.jovialway.professionalphotographers.auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.purchescourse.PCourse;
import com.jovialway.professionalphotographers.purchescourse.PcAdapter;
import com.jovialway.professionalphotographers.purchescourse.PcApi;
import com.jovialway.professionalphotographers.purchesphoto.PAdapter;
import com.jovialway.professionalphotographers.purchesphoto.PApi;
import com.jovialway.professionalphotographers.purchesphoto.PPhoto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView courserv,photorv;
    Toolbar toolbar;
    TextView name,mail,phone;
    androidx.appcompat.widget.AppCompatButton logout;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    String userid;
    CardView cv;
    List<PCourse> courseList=new ArrayList<>();
    PcAdapter pcAdapter;
    PAdapter pAdapter;
    List<PPhoto> ppList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        fauth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        toolbar= findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        toolbar.setTitle(R.string.dboard);
        name=findViewById(R.id.name);
        mail=findViewById(R.id.mail);
        cv=findViewById(R.id.cv);

        phone=findViewById(R.id.phone);
        logout=findViewById(R.id.logout);
        if (userid==null) {
            userid = fauth.getCurrentUser().getUid();
        }
        DocumentReference documentReference=fstore.collection("users").document(userid);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                name.setText(value.getString("name"));
                mail.setText(value.getString("email"));
                phone.setText(value.getString("phone"));

            }
        });

        getcdata(userid);
        setcourseAdapter();

        getphotodata(userid);
        setphotoAdapter();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fauth.signOut();
                startActivity(new Intent(DashboardActivity.this,UserLogin.class));
                finish();
            }
        });
    }
    private void getcdata(String key){
        Call<List<PCourse>> cplist= PcApi.getPcService().getPcourse(key);
        cplist.enqueue(new Callback<List<PCourse>>() {
            @Override
            public void onResponse(Call<List<PCourse>> call, Response<List<PCourse>> response) {
                if (response.isSuccessful()) {

                    try {
                        courseList = response.body();
                        courserv.setAdapter(new PcAdapter(DashboardActivity.this, courseList));
                        pcAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(DashboardActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<PCourse>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void setcourseAdapter() {

        courserv = (RecyclerView) findViewById(R.id.courserv);
        courserv.setHasFixedSize(true);
        courserv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, true));

    }

    private void getphotodata(String key){
        Call<List<PPhoto>> cplist= PApi.getPPhotoService().getPPhotoyist(key);
        cplist.enqueue(new Callback<List<PPhoto>>() {
            @Override
            public void onResponse(Call<List<PPhoto>> call, Response<List<PPhoto>> response) {
                if (response.isSuccessful()) {

                    try {
                        ppList = response.body();
                        photorv.setAdapter(new PAdapter(DashboardActivity.this, ppList));
                        pAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(DashboardActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<PPhoto>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setphotoAdapter() {

        photorv = (RecyclerView) findViewById(R.id.photorv);
        photorv.setHasFixedSize(true);
        photorv.setLayoutManager(new GridLayoutManager(this, 2));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}