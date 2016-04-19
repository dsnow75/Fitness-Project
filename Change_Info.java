package com.androidbootcamp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class Change_Info extends AppCompatActivity implements View.OnClickListener {

    private Intent addIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__info);
        Button Change = (Button) findViewById(R.id.button4);
        Change.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_change__info, menu);
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
        EditText Name = (EditText) findViewById(R.id.editName);
        EditText Age = (EditText) findViewById(R.id.editAge);
        EditText Heightft = (EditText) findViewById(R.id.editHeightft);
        EditText Heightin = (EditText) findViewById(R.id.editHeightin);
        EditText Weight = (EditText) findViewById(R.id.editWeight);
        EditText Gender = (EditText) findViewById(R.id.editGender);
        String newName = ((variables) this.getApplication()).changeName(Name.getText().toString());
        String newAge = ((variables) this.getApplication()).changeAge(Age.getText().toString());
        int newHeightft = ((variables) this.getApplication()).changeHeightft(Integer.parseInt(Heightft.getText().toString()));
        int newHeightin = ((variables) this.getApplication()).changeHeightin(Integer.parseInt(Heightin.getText().toString()));
        int newWeight = ((variables) this.getApplication()).changeWeight(Integer.parseInt(Weight.getText().toString()));
        String newGender = ((variables) this.getApplication()).changeAge(Gender.getText().toString());
        this.addIntent = new Intent(this, Profile_Page.class);
        startActivity(this.addIntent);
    }

}
