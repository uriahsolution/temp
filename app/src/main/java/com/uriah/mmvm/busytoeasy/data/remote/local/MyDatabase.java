package com.uriah.mmvm.busytoeasy.data.remote.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.uriah.mmvm.busytoeasy.data.remote.local.convertor.DateConverter;
import com.uriah.mmvm.busytoeasy.data.remote.local.dao.ItemDao;
import com.uriah.mmvm.busytoeasy.data.remote.local.entity.Item;

@Database(entities = {Item.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile MyDatabase INSTANCE;

    // --- DAO ---
    public abstract ItemDao itemDao();
}

