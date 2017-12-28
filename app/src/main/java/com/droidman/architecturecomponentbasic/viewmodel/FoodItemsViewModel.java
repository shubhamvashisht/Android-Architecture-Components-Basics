package com.droidman.architecturecomponentbasic;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.droidman.architecturecomponentbasic.db.AppDatabase;
import com.droidman.architecturecomponentbasic.db.dao.FoodDao;
import com.droidman.architecturecomponentbasic.db.entity.Foods;

import java.util.List;

/**
 * Created by droidman on 26/12/17.
 */

public class FoodItemsViewModel extends AndroidViewModel{
    private LiveData<List<Foods>> foodItemList;

    private FoodDao foodDao;

    public FoodItemsViewModel(@NonNull Application application) {
        super(application);
        foodDao = AppDatabase.getAppDatabase(application).foodDao();
        foodItemList = foodDao.getAllFoodItems();
    }

    public LiveData<List<Foods>> getFoodItemList(){
        return foodItemList;
    }

    public void addNewFoodItem(Foods foods){
        foodDao.addFoodItem(foods);
    }
}
