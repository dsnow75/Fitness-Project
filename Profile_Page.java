package com.androidbootcamp.fitnessapp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Profile_Page extends AppCompatActivity  {
    String Name;
    int heightft;
    int heightin;
    int weight;
    String gender;
    String age;
    int bmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Name = ((variables) this.getApplication()).getName();
        heightft = ((variables) this.getApplication()).getHeightft();
        heightin = ((variables) this.getApplication()).getHeightin();
        weight = ((variables) this.getApplication()).getWeight();
        gender = ((variables) this.getApplication()).getGender();
        age = ((variables) this.getApplication()).getAge();
        bmi = 703 * (weight)/((heightft * 12 + heightin)*(heightft * 12 + heightin));
        setContentView(R.layout.activity_profile__page);
        TextView Name2 = (TextView) findViewById(R.id.textView7);
        Name2.setText(Name);
        TextView height1 = (TextView) findViewById(R.id.textView9);
        height1.setText(String.valueOf(heightft));
        TextView height2 = (TextView) findViewById(R.id.textView11);
        height2.setText(String.valueOf(heightin));
        TextView Gender = (TextView) findViewById(R.id.textView8);
        Gender.setText(gender);
        TextView Weight = (TextView) findViewById(R.id.textView13);
        Weight.setText(String.valueOf(weight));
        TextView Age = (TextView) findViewById(R.id.textView14);
        Age.setText(age);
        TextView BMI = (TextView) findViewById(R.id.textView15);
        BMI.setText(String.valueOf(bmi));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile__page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
