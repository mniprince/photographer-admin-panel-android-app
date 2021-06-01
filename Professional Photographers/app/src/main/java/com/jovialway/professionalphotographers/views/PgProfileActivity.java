package com.jovialway.professionalphotographers.views;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.auth.UserLogin;
import com.jovialway.professionalphotographers.hirecontact.HireActivity;
import com.jovialway.professionalphotographers.pcontent.CPhoto;
import com.jovialway.professionalphotographers.pcontent.CPhotoAdapter;
import com.jovialway.professionalphotographers.pcontent.CPhotoApi;
import com.jovialway.professionalphotographers.topbanner.AllApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PgProfileActivity extends AppCompatActivity {
    ImageView pgimage,likebtn;
    TextView nametv,locationtv,cattv,liketv;
    String imageurl,uid,userid,pgmail;
    Button hire;
    String pgid,name;
    RecyclerView photorv;
    List<CPhoto> cphotolist;
    CPhotoAdapter photoAdapter;
    private FirebaseAuth fauth;
    FirebaseUser fuser;
    DatabaseReference reference,referenc;
    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg_profile);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        pgimage=(ImageView)findViewById(R.id.pgimage);
        likebtn = (ImageView)findViewById(R.id.favimage);
        liketv=findViewById(R.id.liketv);
        fauth=FirebaseAuth.getInstance();
        fuser= fauth.getCurrentUser();
        if (fuser!=null){
            uid=fuser.getUid();
        }else {
            startActivity(new Intent(this,UserLogin.class));
        }
        getdata();
        getphotodata(pgid);
        setphotoAdapter();

       

        reference= FirebaseDatabase.getInstance().getReference().child("likes");
        referenc= FirebaseDatabase.getInstance().getReference().child("likes").child(pgid);
        referenc.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid=(snapshot.getChildrenCount());
                    liketv.setText(maxid +" Likes");

                    for (DataSnapshot snapshots : snapshot.getChildren() ){
                        userid= snapshots.getValue().toString();
                    }
                    button();
                    }else {
                    btnclick();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



    }

    private void button() {

            if (userid.equals(uid)){
                likebtn.setImageResource(R.drawable.like);
                }else if(userid.isEmpty()){}else{
                likebtn.setImageResource(R.drawable.unlike);
                btnclick();
                 }

    }

    private void btnclick(){
        likebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=referenc.push().getKey();

                reference.child(pgid).child(key).setValue(uid);
                likebtn.setImageResource(R.drawable.like);
                Toast.makeText(PgProfileActivity.this, "Thanks for like "+name, Toast.LENGTH_SHORT).show();
            likebtn.setClickable(false);
            }
        });

    }


    private void getdata() {
        hire=findViewById(R.id.hire);
        nametv=findViewById(R.id.nametv);
        cattv=findViewById(R.id.cattv);
        locationtv=findViewById(R.id.locationtv);

        Intent intent = getIntent();
        pgid= intent.getStringExtra("pgid");
        imageurl = intent.getStringExtra("pgimage");
        name=intent.getStringExtra("pgname");
        pgmail=intent.getStringExtra("pgmail");
        nametv.setText(name);
        cattv.setText(intent.getStringExtra("category"));
        locationtv.setText(intent.getStringExtra("location"));
        Glide.with(this).load(AllApi.BASE_URL+"photography/"+imageurl).into(pgimage);



        hire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent intnt=new Intent(PgProfileActivity.this, HireActivity.class);
                intnt.putExtra("pgname",name ).toString();
                intnt.putExtra("pgmail", pgmail).toString();
                startActivity(intnt);
            finish();
            }
        });
    }

    private void getphotodata(String key){
        Call<List<CPhoto>> cplist= CPhotoApi.getCPhotoService().getCPhotoyist(key);
        cplist.enqueue(new Callback<List<CPhoto>>() {
            @Override
            public void onResponse(Call<List<CPhoto>> call, Response<List<CPhoto>> response) {
                if (response.isSuccessful()) {

                    try {
                        cphotolist = response.body();
                        photorv.setAdapter(new CPhotoAdapter(PgProfileActivity.this, cphotolist));
                        photoAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(PgProfileActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<CPhoto>> call, Throwable t) {
                Toast.makeText(PgProfileActivity.this, "SERVER Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setphotoAdapter() {

        photorv = (RecyclerView) findViewById(R.id.photorv);
        photorv.setHasFixedSize(true);
        photorv.setLayoutManager(new GridLayoutManager(this, 2));

    }




}