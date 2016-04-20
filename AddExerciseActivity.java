package mattski47.databases386;

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

public class AddExerciseActivity extends AppCompatActivity implements AdapterView.OnClickListener
{
    private Intent addIntent;
    private DBHandler saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        saveData = saveData.getInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);
        this.addIntent = new Intent(this, ViewExerciseActivity.class);
    }

    public void onClick(View v)
    {
        EditText activity = (EditText) findViewById(R.id.activity);
        EditText time_spent = (EditText) findViewById(R.id.time);

        DateFormat df = new SimpleDateFormat("EEE, MMM d");
        String time = df.format(Calendar.getInstance().getTime());

        if (activity.getText().toString().equals("clear"))
            saveData.clearTable("Exercise");
        else
            saveData.insertExercise(activity.getText().toString(), (long) Integer.parseInt(time_spent.getText().toString()), time);

        startActivity(addIntent);
    }
}
