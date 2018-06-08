package com.uriah.mmvm.busytoeasy.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.uriah.mmvm.busytoeasy.data.local.convertor.DateConverter;
import com.uriah.mmvm.busytoeasy.data.local.dao.ItemDao;
import com.uriah.mmvm.busytoeasy.data.local.entity.Item;

@Database(entities = {Item.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile MyDatabase INSTANCE;

    // --- DAO ---
    public abstract ItemDao itemDao();
}

