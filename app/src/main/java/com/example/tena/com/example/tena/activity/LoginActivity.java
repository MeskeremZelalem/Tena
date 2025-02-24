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
import android.widget.TextView;
import android.widget.Toast;

import com.example.tena.R;
import com.example.tena.com.example.tena.com.example.tena.data.User;
import com.example.tena.com.example.tena.com.example.tena.data.UserDao;
import com.example.tena.com.example.tena.com.example.tena.data.UserDatabase;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private TextView sign_up;
    private EditText name;
    private EditText password;

    private UserDatabase database;
    private UserDao userDao;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Checking User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(1);

        database = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDao();

        login = findViewById(R.id.btn_login);
        sign_up = findViewById(R.id.sign_up);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!emptyValidation()){
                   progressDialog.show();
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           User user = userDao.getUser(name.getText().toString(), password.getText().toString());
                           if (user != null){
                               Intent I = new Intent(LoginActivity.this,FundingActivity.class);
                               I.putExtra("user",user);
                               startActivity(I);
                               finish();
                           }else {
                               Toast.makeText(LoginActivity.this,"Unregister user or Incorrect ",Toast.LENGTH_SHORT).show();
                           }
                           progressDialog.dismiss();
                       }
                   },1000);
               }else{
                   Toast.makeText(LoginActivity.this,"Empty Field ",Toast.LENGTH_SHORT).show();
               }

            }
        });
    }
    private boolean emptyValidation(){
        if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
            return true;
        }else {
            return false;
        }
    }
}
