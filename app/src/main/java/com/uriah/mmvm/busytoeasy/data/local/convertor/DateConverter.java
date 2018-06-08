package com.uriah.mmvm.busytoeasy.data.local.convertor;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Ashutosh on 02/03/2018.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
