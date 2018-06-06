package com.uriah.mmvm.busytoeasy.data.remote.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.uriah.mmvm.busytoeasy.data.remote.local.entity.Item;



import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ItemDao {

    @Insert(onConflict = REPLACE)
    void save(Item user);

    @Query("SELECT * FROM item ")
    LiveData<Item> load();


}
