package com.androidbootcamp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class Profile_Page extends AppCompatActivity implements View.OnClickListener  {
    String Name;
    float heightft;
    float heightin;
    float weight;
    String gender;
    String age;
    float bmi;
    String s;
    private Intent addIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__page);
        Name = ((variables) this.getApplication()).getName();
        heightft = ((variables) this.getApplication()).getHeightft();
        heightin = ((variables) this.getApplication()).getHeightin();
        weight = ((variables) this.getApplication()).getWeight();
        gender = ((variables) this.getApplication()).getGender();
        age = ((variables) this.getApplication()).getAge();
        bmi = 703 * (weight)/((heightft * 12 + heightin)*(heightft * 12 + heightin));
        s = String.format("%.2f", bmi);
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
        BMI.setText(s);
        Button Edit = (Button) findViewById(R.id.edit);
        Edit.setOnClickListener(this);
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

    public void onClick(View V){
        switch (V.getId()){
            case R.id.edit:
                this.addIntent = new Intent(this, Change_Info.class);
                break;
        }
        startActivity(this.addIntent);
    }

}
