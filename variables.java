package com.androidbootcamp.fitnessapp;

import android.app.Application;

/**
 * Created by David on 2/27/2016.
 */
public class variables extends Application{
    private int Heightft = 6;
    private int Weight = 220;
    private String Age = "22";
    private String Gender = "M";
    private String Name = "David";
    private int Heightin = 2;

    public String getName(){
        return Name;
    }
    public int getHeightft(){
        return Heightft;
    }
    public int getHeightin(){
        return Heightin;
    }
    public int getWeight(){
        return Weight;
    }
    public String getAge(){
        return Age;
    }
    public String getGender(){
        return Gender;
    }

}
