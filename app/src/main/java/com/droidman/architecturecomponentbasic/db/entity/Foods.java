package com.droidman.architecturecomponentbasic.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by droidman on 28/12/17.
 */

@Entity(tableName = "Foods")
public class Foods implements FoodImpl {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "fname")
    private String name;

    public Foods(){

    }
    @Ignore
    public Foods(String name){
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
