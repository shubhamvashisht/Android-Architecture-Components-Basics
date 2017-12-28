package com.droidman.architecturecomponentbasic.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.droidman.architecturecomponentbasic.db.dao.FoodDao;
import com.droidman.architecturecomponentbasic.db.entity.Foods;

/**
 * Created by droidman on 28/12/17.
 */

@Database(entities = {Foods.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FoodDao foodDao();

    public static AppDatabase appDatabase;

    public static synchronized AppDatabase getAppDatabase(Context context){
        if (appDatabase==null){
            appDatabase = create(context);
        }
        return appDatabase;
    }

    private static AppDatabase create(Context context){
        RoomDatabase.Builder<AppDatabase> builder = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class,
                "Foods").allowMainThreadQueries();
        return builder.build();
    }
}
