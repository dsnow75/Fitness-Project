package mattski47.databases386;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Intent dietIntent;
    private Intent exerciseIntent;
    private Intent sleepIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button diet = (Button) findViewById(R.id.diet);
        Button exercise = (Button) findViewById(R.id.exercise);
        Button sleep = (Button) findViewById(R.id.sleep);

        this.dietIntent = new Intent(this, ViewDietActivity.class);
        this.exerciseIntent = new Intent(this, ViewExerciseActivity.class);
        this.sleepIntent = new Intent(this, ViewSleepActivity.class);

        diet.setOnClickListener(this);
        exercise.setOnClickListener(this);
        sleep.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        MainActivity main = this;

        switch (v.getId()) {
            case R.id.diet:
                startActivity(main.dietIntent);
                break;
            case R.id.exercise:
                startActivity(main.exerciseIntent);
                break;
            case R.id.sleep:
                startActivity(main.sleepIntent);
                break;
        }
    }
}
