package com.example.MyEarn11;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class CC06 extends AppCompatActivity {

    TextInputEditText CC06_resetPhoneNumber,CC06_resetOldPassword,CC06_resetNewPassword;
    Button CC06_resetNextBtn;
    ProgressBar CC06_RESETprogressBar;
    TextInputLayout resetPhoneLayout,resetOldPasswordLayout, resetNewPasswordLayout;
    String resetPHONENUMBER,status=null,number;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{8,}" +                // at least 8 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        CC06_resetPhoneNumber = findViewById(R.id.reset_phone_number);
        CC06_resetOldPassword = findViewById(R.id.reset_old_password);
        CC06_resetNewPassword = findViewById(R.id.reset_new_password);
        CC06_resetNextBtn = findViewById(R.id.reset_password_next_btn);
        resetOldPasswordLayout = findViewById(R.id.old_passwordTextInputLayout);
        resetNewPasswordLayout = findViewById(R.id.new_passwordTextInputLayout);
        resetPhoneLayout = findViewById(R.id.reset_phone_layout);
        CC06_RESETprogressBar = findViewById(R.id.resetprogressBar);

        CC06_resetNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!CC06_resetPhoneNumber.getText().toString().trim().isEmpty()) {
                    if ((CC06_resetPhoneNumber.getText().toString().trim()).length() == 10) {
                        CC06_RESETprogressBar.setVisibility(View.VISIBLE);
                        CC06_resetNextBtn.setVisibility(View.INVISIBLE);
                        resetPHONENUMBER = CC06_resetPhoneNumber.getText().toString().trim();
                        Query checkUser = FirebaseDatabase.getInstance().getReference("C_profile").orderByChild("mobile").equalTo( CC06_resetPhoneNumber.getText().toString());

                        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    if (status == null) {
//                                        Toast.makeText(Reset_Password.this, "User exists", Toast.LENGTH_SHORT).show();
                                    }
                                    status = "user exists";
                                    resetPhoneLayout.setError(null);
                                    CC06_RESETprogressBar.setVisibility(View.GONE);
                                    CC06_resetNextBtn.setVisibility(View.VISIBLE);
                                    resetOldPasswordLayout.setVisibility(View.VISIBLE);
                                    String resetOLDPASSWORD = CC06_resetOldPassword.getText().toString().trim();
                                    CC06_RESETprogressBar.setVisibility(View.VISIBLE);
                                    CC06_resetNextBtn.setVisibility(View.INVISIBLE);
                                    Query checkPassword = FirebaseDatabase.getInstance().getReference("C_profile").orderByChild("password").equalTo(resetOLDPASSWORD);
                                    checkPassword.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot passwordsSnapshot) {
                                            if (passwordsSnapshot.exists()) {
                                                status = "old password matched";
                                                if (status.equals("old password matched")) {
                                                    resetNewPasswordLayout.setVisibility(View.VISIBLE);
                                                    CC06_RESETprogressBar.setVisibility(View.GONE);
                                                    CC06_resetNextBtn.setVisibility(View.VISIBLE);
                                                    setNewCredentials();
                                                }

                                            } else {
                                                Toast.makeText(CC06.this, "Enter correct Old Password", Toast.LENGTH_SHORT).show();
                                                CC06_RESETprogressBar.setVisibility(View.GONE);
                                                CC06_resetNextBtn.setVisibility(View.VISIBLE);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {
                                            if (status.equals("user exits")) {
                                                Toast.makeText(CC06.this, "we cannot verify old passsword", Toast.LENGTH_SHORT).show();
                                            }
                                            CC06_RESETprogressBar.setVisibility(View.GONE);
                                            CC06_resetNextBtn.setVisibility(View.VISIBLE);
                                        }
                                    });


                                } else {

                                    Toast.makeText(CC06.this, "User doesn't exists", Toast.LENGTH_SHORT).show();
                                    resetPhoneLayout.setError("User doesn't exists");
                                    CC06_RESETprogressBar.setVisibility(View.GONE);
                                    CC06_resetNextBtn.setVisibility(View.VISIBLE);

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(CC06.this, "we cannot verify user", Toast.LENGTH_SHORT).show();
                                CC06_RESETprogressBar.setVisibility(View.GONE);
                                CC06_resetNextBtn.setVisibility(View.VISIBLE);
                            }
                        });

                    } else {
                        Toast.makeText(CC06.this, "please enter correct mobile number", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(CC06.this, "Enter mobile number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setNewCredentials() {
        status = "verifing password contrains";
        String resetNewPASSWORD = CC06_resetNewPassword.getText().toString().trim();

        if (resetNewPASSWORD.isEmpty()) {

            resetNewPasswordLayout.setError("Field can not be empty");
        }

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        else if (!PASSWORD_PATTERN.matcher(resetNewPASSWORD).matches()) {
            resetNewPasswordLayout.setError("Password is too weak");
        }
        //Update data in firebase
        else {
            CC06_resetNewPassword.setError(null);
            number = CC06_resetPhoneNumber.getText().toString();
            Toast.makeText(CC06.this, number, Toast.LENGTH_SHORT).show();
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("C_profile");
            reference.child(number).child("password").setValue(resetNewPASSWORD);
//            Toast.makeText(CC06.this, "Password Updated", Toast.LENGTH_SHORT).show();
            status = "password update";
            Intent intent = new Intent(CC06.this, CC00.class);
            startActivity(intent);
        }

    }

}
