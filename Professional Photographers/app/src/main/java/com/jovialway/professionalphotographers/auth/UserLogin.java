package com.jovialway.professionalphotographers.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.errorprone.annotations.Var;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.rpc.context.AttributeContext;
import com.jovialway.professionalphotographers.R;

public class UserLogin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email,password;
    androidx.appcompat.widget.AppCompatButton login;
    TextView cuser,fpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);
        mAuth = FirebaseAuth.getInstance();


            email = findViewById(R.id.emailet);
            password = findViewById(R.id.pwet);
            login = findViewById(R.id.login);
            cuser = findViewById(R.id.cuser);
            fpw = findViewById(R.id.fpw);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String getmail = email.getText().toString();
                    String getpw = password.getText().toString();
                    if (getmail.isEmpty()) {
                        email.setError("Email Is Required!");
                        return;
                    }
                    if (getpw.isEmpty()) {
                        password.setError("Password Is Required!");
                        return;
                    }
                    mAuth.signInWithEmailAndPassword(getmail, getpw)

                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(UserLogin.this, "Log In Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(UserLogin.this, DashboardActivity.class));
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(UserLogin.this, "Invalid Mail/ Password!", Toast.LENGTH_SHORT).show();
                                }
                            });


                }
            });


            cuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(UserLogin.this, RegistrationActivity.class));
                }
            });

            fpw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText resetmail = new EditText(v.getContext());
                    AlertDialog.Builder passwordresetdialog = new AlertDialog.Builder(v.getContext());
                    passwordresetdialog.setTitle("Reset Password?");
                    passwordresetdialog.setMessage("Enter Your mail to receive Reset Link?");
                    passwordresetdialog.setView(resetmail);

                    passwordresetdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String mail = resetmail.getText().toString();
                            mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(UserLogin.this, "Reset Link Sent to Your mail..", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(UserLogin.this, "Reset Link Not Sent! " + e.toString(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    passwordresetdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    passwordresetdialog.create().show();
                }
            });
        }

    @Override
    protected void onStart() {
        super.onStart();
       FirebaseUser fuser= mAuth.getCurrentUser();
       if (fuser!=null){
           startActivity(new Intent(UserLogin.this,DashboardActivity.class));
           finish();
       }else{

       }

    }


}