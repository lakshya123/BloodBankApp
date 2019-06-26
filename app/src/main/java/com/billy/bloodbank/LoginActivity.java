package com.billy.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    public EditText phoneNumber;
    public Button generateOTPButton;
    public String phoneNumberString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        phoneNumber = findViewById(R.id.phoneNumber);
        generateOTPButton = findViewById(R.id.GenerateOTPButton);
    }

    public void goToPrevious(View view){
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void toVerification(View view){
        phoneNumberString = phoneNumber.getText().toString();
        validNumber(phoneNumberString);
    }

    private void validNumber(String phoneNumberString){
        if(phoneNumberString.isEmpty()||phoneNumberString.length()!=10){
            phoneNumber.setError("Enter a valid number");
            phoneNumber.requestFocus();

        }else {
            Intent intent2 = new Intent(this, VerifyNumberActivity.class);
            intent2.putExtra("phone_number", phoneNumberString);
            startActivity(intent2);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {
            Intent intent = new Intent(LoginActivity.this, OptionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
