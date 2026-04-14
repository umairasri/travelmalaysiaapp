package com.example.travelmalaysia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.travelmalaysia.Objects.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    EditText etSignUpName, etSignUpEmail, etSignUpUsername, etSignUpPassword;
    Button btnSignUp;

    // a list to store all the user from firebase
    List<User> users;

    // reference for Firebase Database
    FirebaseAuth mFirebaseAuth;

    // our database reference object
    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etSignUpName = findViewById(R.id.et_name);
        etSignUpEmail = findViewById(R.id.et_email);
        etSignUpUsername = findViewById(R.id.et_username);
        etSignUpPassword = findViewById(R.id.et_password);
        btnSignUp = findViewById(R.id.btn_signup);

        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();


        // Implement the Sign Up function
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Initialized Firebase
//                database = FirebaseDatabase.getInstance();
                //
//                databaseUsers = database.getReference("users");

                databaseUsers = FirebaseDatabase.getInstance().getReference("users");

                String name = etSignUpName.getText().toString();
                String email = etSignUpEmail.getText().toString();
                String username = etSignUpUsername.getText().toString();
                String password = etSignUpPassword.getText().toString();

                // Check the form if there any empty information
                if (!validateName() || !validateEmail() || !validateUsername() || !validatePassword()){

                }
                else {

                    String id = databaseUsers.push().getKey();

                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                User newUser = new User(id, name, email, username, password);
                                databaseUsers.child(username).setValue(newUser);

                                Toast.makeText(SignUpActivity.this, "You have sign up successfully", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                startActivity(intent);
                            }
                            else {

                                Toast.makeText(SignUpActivity.this, "Error", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

//                    User newUser = new User(id, name, email, username, password);
//                    databaseUsers.child(username).setValue(newUser);
//
//                    Toast.makeText(SignUpActivity.this, "You have sign up successfully", Toast.LENGTH_SHORT).show();
//
//                    Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
//                    startActivity(intent);

                }

            }
        });

    }

    // Function to check name is empty
    public Boolean validateName(){

        String val = etSignUpName.getText().toString();

        if (val.isEmpty()){

            etSignUpName.setError("Name cannot be empty");
            return false;
        }
        else {

            etSignUpName.setError(null);
            return true;
        }

    }

    // Function to check email is empty
    public Boolean validateEmail(){

        String val = etSignUpEmail.getText().toString();

        if (val.isEmpty()){

            etSignUpEmail.setError("Email cannot be empty");
            return false;
        }
        else {

            etSignUpEmail.setError(null);
            return true;
        }

    }

    // Function to check username is empty
    public Boolean validateUsername(){

        String val = etSignUpUsername.getText().toString();

        if (val.isEmpty()){

            etSignUpUsername.setError("Username cannot be empty");
            return false;
        }
        else {

            etSignUpUsername.setError(null);
            return true;
        }

    }

    // Function to check password is empty
    public Boolean validatePassword(){

        String val = etSignUpPassword.getText().toString();

        if (val.isEmpty()){

            etSignUpPassword.setError("Password cannot be empty");
            return false;
        }
        else {

            etSignUpPassword.setError(null);
            return true;
        }

    }


}