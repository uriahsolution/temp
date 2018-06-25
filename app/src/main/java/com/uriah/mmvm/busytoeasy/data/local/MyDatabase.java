package com.uriah.mmvm.busytoeasy.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.uriah.mmvm.busytoeasy.data.local.convertor.DateConverter;
import com.uriah.mmvm.busytoeasy.data.local.dao.ExampleDao;
import com.uriah.mmvm.busytoeasy.data.local.entity.Datum;


@Database(entities = {Datum.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile MyDatabase INSTANCE;

    // --- DAO ---
    public abstract ExampleDao exampleDao();
}

