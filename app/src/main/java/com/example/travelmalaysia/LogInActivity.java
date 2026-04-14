package com.example.travelmalaysia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelmalaysia.Objects.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {

    EditText loginEmail, loginPassword;
    Button btnLogin;
    TextView tvSignup, tvForgotPassword;



    private FirebaseAuth mFirebaseAuth;
    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loginEmail = (EditText) findViewById(R.id.et_login_email);
        loginPassword = (EditText) findViewById(R.id.et_login_password);
        btnLogin = findViewById(R.id.btn_login);
        tvSignup = findViewById(R.id.tv_signup);
        tvForgotPassword = findViewById(R.id.tv_forgot);

        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance().getReference("users");


        // Make the Sign Up text underlined
        tvSignup.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        // Implement the Log In function
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = loginPassword.getText().toString();
                String email = loginEmail.getText().toString();

                password = password.trim();
                email = email.trim();

                if (!validateEmail() || !validatePassword()){

                }
                else {

                    String finalPassword = password;
                    String finalEmail = email;
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            checkUser();
                            if (task.isSuccessful()){

                                database.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                                            User user = dataSnapshot.getValue(User.class);
                                            if ((user.getEmail()).equals(finalEmail)){

                                                database.child(user.getUsername()).child("password").setValue(finalPassword);

//                                                user.setPassword("" + finalPassword);
                                            }
                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                                Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                            }
                            else {

                                Toast.makeText(LogInActivity.this, "Error. Please check you email or password", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
//                    checkUser();
                }
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(LogInActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
                EditText emailBox = dialogView.findViewById(R.id.emailBox);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();
                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String userEmail = emailBox.getText().toString();
                        if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(LogInActivity.this, "Enter your registered email id", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mFirebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(LogInActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(LogInActivity.this, "Unable to send, failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow() != null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                dialog.show();

            }
        });


    }

    // Function to check username is empty
    public Boolean validateEmail(){

        String val = loginEmail.getText().toString();

        if (val.isEmpty()){

            loginEmail.setError("Username cannot be empty");
            return false;
        }
        else {

            loginEmail.setError(null);
            return true;
        }

    }

    // Function to check password is empty
    public Boolean validatePassword(){

        String val = loginPassword.getText().toString();

        if (val.isEmpty()){

            loginPassword.setError("Password cannot be empty");
            return false;
        }
        else {

            loginPassword.setError(null);
            return true;
        }

    }

    // Function to validate the user existence
    public void checkUser(){

        String userEmail = loginEmail.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("email").equalTo(userEmail);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    loginEmail.setError(null);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                        User user = dataSnapshot.getValue(User.class);

                        if (user.getPassword().equals(userPassword)) {
                            loginEmail.setError(null);

                        } else {
                            loginPassword.setError("Invalid Credentials");
                            loginPassword.requestFocus();
                        }

                    }

                } else {
                    loginEmail.setError("User does not exist");
                    loginEmail.requestFocus();                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}