package com.jovialway.professionalphotographers.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jovialway.professionalphotographers.MainActivity;
import com.jovialway.professionalphotographers.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth rAuth;
    EditText email,password,nameet,mobileet;
    androidx.appcompat.widget.AppCompatButton registrar;
    TextView luser;
    FirebaseFirestore firestore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        rAuth = FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        registrar=findViewById(R.id.register);
        luser=findViewById(R.id.luser);
        email=findViewById(R.id.emailet);
        password=findViewById(R.id.pwet);
        nameet=findViewById(R.id.nameet);
        mobileet=findViewById(R.id.mobileet);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  name=nameet.getText().toString();
                String  phone=mobileet.getText().toString();
                String  getmail=email.getText().toString().trim();
                String  getpw=password.getText().toString().trim();
                if (name.isEmpty()) {
                    nameet.setError("Enter Your Name!");
                    return;
                }
                if (phone.isEmpty()) {
                    mobileet.setError("Enter Your Mobile Number!");
                    return;
                }
                if (phone.length()!=11) {
                    mobileet.setError("Mobile Number Must be 11 Digits!");
                    return;
                }

                if (getmail.isEmpty()) {
                    email.setError("Email Is Required!");
                    return;
                }
                if (getpw.isEmpty()) {
                    password.setError("Password Is Required!");
                    return;
                }


                rAuth.createUserWithEmailAndPassword(getmail,getpw)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                userID=rAuth.getCurrentUser().getUid();
                                DocumentReference documentReference=firestore.collection("users").document(userID);
                                Map<String,Object> user=new HashMap<>();
                                user.put("name",name);
                                user.put("email",getmail);
                                user.put("phone",phone);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                startActivity(new Intent(RegistrationActivity.this, DashboardActivity.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(RegistrationActivity.this, ""+e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        luser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,UserLogin.class));
            }
        });
    }
}