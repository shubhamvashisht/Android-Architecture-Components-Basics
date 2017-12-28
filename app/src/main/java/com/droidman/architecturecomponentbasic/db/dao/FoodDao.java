package com.droidman.architecturecomponentbasic.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.droidman.architecturecomponentbasic.db.entity.Foods;

import java.util.List;

/**
 * Created by droidman on 29/12/17.
 */

@Dao
public interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addFoodItem(Foods foods);

    @Query("SELECT * from Foods")
    public LiveData<List<Foods>> getAllFoodItems();

}
