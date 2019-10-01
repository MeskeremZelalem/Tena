package com.example.tena.com.example.tena.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.tena.R;
import com.example.tena.com.example.tena.adapter.FundAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewFundActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FundAdapter fundAdapter;
    List<RequestItem> data;
    EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fund);

        searchBar = findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                fundAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        recyclerView = findViewById(R.id.recycler);
        data = new  ArrayList<>();
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("kebede","blood cancer","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("kebede","blood cancer","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe debebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));
        data.add(new RequestItem("Abebe","Heart case","Age:20","300000 USD",R.drawable.child));

        fundAdapter = new FundAdapter(this,data);
        recyclerView.setAdapter(fundAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }



    public void openFundingActivity(View view) {

        Intent intent =new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
