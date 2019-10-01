package com.example.tena.com.example.tena.com.example.tena.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RequestDao {

    @Insert
    Long addRequest(Request request);

    @Query("SELECT * FROM REQUEST")
    LiveData<List<Request>> getAllRequest();

    @Update
    void fund (Request request);
}
