package com.example.tena.com.example.tena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.tena.R;
import com.example.tena.com.example.tena.adapter.BankAdapter;

public class FundingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    protected BankAdapter bankAdapter;
    protected int flags[] = {R.drawable.express, R.drawable.paypal, R.drawable.visa, R.drawable.mastercard};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding);

        Spinner spinner = findViewById(R.id.drop_down);
        spinner.setOnItemSelectedListener(this);

        bankAdapter = new BankAdapter(getApplicationContext(), flags);
        spinner.setAdapter(bankAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
