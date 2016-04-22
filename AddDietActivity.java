package jmda.pocketfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddDietActivity extends AppCompatActivity implements AdapterView.OnClickListener
{
    private Intent addIntent;
    private DBHandler saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        saveData = saveData.getInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diet);

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);
        this.addIntent = new Intent(this, ViewDietActivity.class);
    }

    public void onClick(View v)
    {
        EditText food = (EditText) findViewById(R.id.food);
        EditText calories = (EditText) findViewById(R.id.calories);

        DateFormat df = new SimpleDateFormat("EEE, MMM d");
        String time = df.format(Calendar.getInstance().getTime());

        if (food.getText().toString().equals("clear"))
            saveData.clearTable("Diet");
        else
            saveData.insertDiet(food.getText().toString(), (long) Integer.parseInt(calories.getText().toString()), time);

        startActivity(addIntent);
    }
}