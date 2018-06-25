package com.uriah.mmvm.busytoeasy.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.uriah.mmvm.busytoeasy.data.local.entity.Datum;

import java.util.Date;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ExampleDao {

    @Insert(onConflict = REPLACE)
    void save(Datum datum);

    @Query("SELECT * FROM datum ")
    LiveData<Datum> load();

    @Query("SELECT * FROM datum WHERE lastRefresh > :lastRefreshMax LIMIT 1")
    Datum hasUser(Date lastRefreshMax);


}
