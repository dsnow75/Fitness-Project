package jmda.pocketfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent profileIntent;
    private Intent dietIntent;
    private Intent exerciseIntent;
    private Intent sleepIntent;
    private Intent progressIntent;
    Button profile;
    Button diet;
    Button exercise;
    Button sleep;
    Button progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        profile = (Button) findViewById(R.id.profile);
        diet = (Button) findViewById(R.id.diet);
        exercise = (Button) findViewById(R.id.exercise);
        sleep = (Button) findViewById(R.id.sleep);
        progress = (Button) findViewById(R.id.progress);

        this.profileIntent = new Intent(this, ProfilePageActivity.class);
        this.dietIntent = new Intent(this, ViewDietActivity.class);
        this.exerciseIntent = new Intent(this, ViewExerciseActivity.class);
        this.sleepIntent = new Intent(this, ViewSleepActivity.class);
        this.progressIntent = new Intent(this, MainActivity.class);

        profile.setOnClickListener(this);
        diet.setOnClickListener(this);
        exercise.setOnClickListener(this);
        sleep.setOnClickListener(this);
        progress.setOnClickListener(this);
    }

    public void onClick(View v) {
        MainMenuActivity main = this;

        switch (v.getId()) {
            case R.id.profile:
                startActivity(main.profileIntent);
                break;
            case R.id.diet:
                startActivity(main.dietIntent);
                break;
            case R.id.exercise:
                startActivity(main.exerciseIntent);
                break;
            case R.id.sleep:
                startActivity(main.sleepIntent);
                break;
            case R.id.progress:
                startActivity(main.progressIntent);
                break;
        }

    }
}
