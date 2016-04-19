package com.androidbootcamp.fitnessapp;

import android.app.Application;

/**
 * Created by David on 2/27/2016.
 */
public class variables extends Application{
    private int Heightft = 0;
    private int Weight = 220;
    private String Age = " ";
    private String Gender = " ";
    private String Name = " ";
    private int Heightin = 0;

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
    public String changeName(String newName){
        Name = newName;
        return Name;
    }
    public String changeAge(String newName){
        Age = newName;
        return Age;
    }
    public int changeHeightin(int newName){
        Heightin = newName;
        return Heightin;
    }
    public int changeHeightft(int newName){
        Heightft = newName;
        return Heightft;
    }
    public void changeGender(String newName){
        Gender = newName;
    }
    public int changeWeight(int newName){
        Weight = newName;
        return Weight;
    }
}
