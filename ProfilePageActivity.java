package jmda.pocketfitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class ProfilePageActivity extends AppCompatActivity implements View.OnClickListener  {
    TextView nameView;
    TextView heightView;
    TextView genderView;
    TextView weightView;
    TextView ageView;
    TextView BMIView;
    Button edit;

    private Intent addIntent;
    public static final String PREFS_NAME = "PF_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        SharedPreferences prof_info = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String name = prof_info.getString("name", "");
        int heightft = prof_info.getInt("heightft", 0);
        int heightin = prof_info.getInt("heightin", 0);
        int weight = prof_info.getInt("weight", 0);
        String gender = prof_info.getString("gender", "");
        int age = prof_info.getInt("age", 0);
        float bmi = 0;

        if(heightft != 0)
            bmi = 703 * (weight) / ((heightft * 12 + heightin) * (heightft * 12 + heightin));

        String s = String.format("%.2f", bmi);
        String heightStr = heightft + " Ft. " + heightin + " In.";
        String weightStr = weight + " lbs.";

        nameView = (TextView) findViewById(R.id.textView7);
        nameView.setText(name);
        heightView = (TextView) findViewById(R.id.textView9);
        heightView.setText(heightStr);
        genderView = (TextView) findViewById(R.id.textView8);
        genderView.setText(gender);
        weightView = (TextView) findViewById(R.id.textView13);
        weightView.setText(weightStr);
        ageView = (TextView) findViewById(R.id.textView14);
        ageView.setText(String.valueOf(age));
        BMIView = (TextView) findViewById(R.id.textView15);
        BMIView.setText(s);
        edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(this);
    }

    public void onClick(View V){
        switch (V.getId()){
            case R.id.edit:
                this.addIntent = new Intent(this, ChangeInfoActivity.class);
                break;
        }
        startActivity(this.addIntent);
    }
}