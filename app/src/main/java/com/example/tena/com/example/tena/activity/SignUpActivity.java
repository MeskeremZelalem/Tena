package com.example.tena.com.example.tena.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tena.R;
import com.example.tena.com.example.tena.com.example.tena.data.User;
import com.example.tena.com.example.tena.com.example.tena.data.UserDao;
import com.example.tena.com.example.tena.com.example.tena.data.UserDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText phoneNo;
    private EditText password;
    private EditText passwordConfirm;
    private Button signUp;

    private UserDao userDao;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        name = findViewById(R.id.nameS);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phone_no);
        password = findViewById(R.id.passwordS);
        passwordConfirm = findViewById(R.id.password_confirm);
        signUp = findViewById(R.id.btn_sign_up);


        userDao = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emptyValidation()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(name.getText().toString(), email.getText().toString(), password.getText().toString(), phoneNo.getText().toString());
                            userDao.insertUser(user);
                            progressDialog.dismiss();
                            Intent I = new Intent(SignUpActivity.this, LoginActivity.class);

                            startActivity(I);


                        }
                    }, 1000);
                } else {
                    Toast.makeText(SignUpActivity.this, "Empty Field ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(name.getText().toString())
                || TextUtils.isEmpty(email.getText().toString())
                || TextUtils.isEmpty(phoneNo.getText().toString())
                || TextUtils.isEmpty(password.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }
}
