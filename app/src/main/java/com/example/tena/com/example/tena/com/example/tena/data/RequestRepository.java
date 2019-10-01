package com.example.tena.com.example.tena.com.example.tena.data;

import android.content.Context;

import androidx.room.Room;

public class RequestRepository {

    private String DB_NAME = "db_task";
    private RequestDatabase requestDatabase;

    public RequestRepository(Context context){

        requestDatabase = Room.databaseBuilder(context,RequestDatabase.class,DB_NAME).build();
    }
}
