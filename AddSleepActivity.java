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

public class AddSleepActivity extends AppCompatActivity implements AdapterView.OnClickListener
{
    private Intent addIntent;
    private DBHandler saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        saveData = saveData.getInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sleep);

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);
        this.addIntent = new Intent(this, ViewSleepActivity.class);
    }

    public void onClick(View v)
    {
        EditText sleep = (EditText) findViewById(R.id.sleep);

        DateFormat df = new SimpleDateFormat("EEE, MMM d");
        String time = df.format(Calendar.getInstance().getTime());

        if (sleep.getText().toString().equals("clear"))
            saveData.clearTable("Sleep");
        else
            saveData.insertSleep((long) Integer.parseInt(sleep.getText().toString()), time);

        startActivity(addIntent);
    }
}