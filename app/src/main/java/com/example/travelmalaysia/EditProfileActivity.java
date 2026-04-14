package com.example.travelmalaysia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileActivity extends AppCompatActivity {


    EditText editName, editEmail, editUsername, editPassword;
    TextView resetPassword;
    Button btnSave;
    String nameUser, emailUser, usernameUser, passwordUser;
    DatabaseReference databaseUser;
    FirebaseUser firebaseUser;

    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        databaseUser = FirebaseDatabase.getInstance().getReference("users");
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        btnSave = findViewById(R.id.btn_save);
        resetPassword = findViewById(R.id.tv_reset);

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    User user = dataSnapshot.getValue(User.class);
                    if ((user.getEmail()).equals(firebaseUser.getEmail())){

                        editName.setText(user.getName());
                        editEmail.setText(user.getEmail());
                        editUsername.setText(user.getUsername());
                        editPassword.setText(user.getPassword());

                        nameUser = editName.getText().toString();
                        emailUser = editEmail.getText().toString();
                        usernameUser = editUsername.getText().toString();
                        passwordUser = editPassword.getText().toString();


                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        showData();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isNameChanged() || isEmailChanged() || isPasswordChanged() || isUsernameChanged()){

                    Toast.makeText(EditProfileActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(EditProfileActivity.this, "No Changes Found", Toast.LENGTH_SHORT).show();

                }
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(EditProfileActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
                EditText emailBox = dialogView.findViewById(R.id.emailBox);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();
                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String userEmail = emailBox.getText().toString();
                        if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(EditProfileActivity.this, "Enter your registered email id", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mFirebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(EditProfileActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
//                                    dialog.dismiss();

                                    mFirebaseAuth.signOut();
                                    Intent intent = new Intent(EditProfileActivity.this, LogInActivity.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(EditProfileActivity.this, "Unable to send, failed", Toast.LENGTH_SHORT).show();
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

    public boolean isNameChanged(){

        if (!nameUser.equals(editName.getText().toString())){

            databaseUser.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEmailChanged(){

        if (!emailUser.equals(editEmail.getText().toString())){

            databaseUser.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        }
        else {
            return false;
        }
    }


    public boolean isPasswordChanged(){

        if (!passwordUser.equals(editPassword.getText().toString())){

            databaseUser.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isUsernameChanged(){

        if (!usernameUser.equals(editUsername.getText().toString())){

            databaseUser.child(usernameUser).child("username").setValue(editUsername.getText().toString());
            usernameUser = editPassword.getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    protected void onResume() {
        super.onResume();

        mFirebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = mFirebaseAuth.getCurrentUser();

        if (firebaseUser == null){

            // go to login page
            Intent intent = new Intent(EditProfileActivity.this, LogInActivity.class);
            startActivity(intent);

        }
    }

}