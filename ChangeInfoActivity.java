package jmda.pocketfitness;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class ChangeInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent addIntent;
    EditText Name;
    EditText Age;
    EditText Heightft;
    EditText Heightin;
    EditText Weight;
    EditText Gender;
    Button Change;
    public static final String PREFS_NAME = "PF_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);

        Change = (Button) findViewById(R.id.button4);
        this.addIntent = new Intent(this, ProfilePageActivity.class);
        Change.setOnClickListener(this);
    }

    public void onClick(View V){
        SharedPreferences prof_info = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Editor editor = prof_info.edit();

        Name = (EditText) findViewById(R.id.editName);
        Age = (EditText) findViewById(R.id.editAge);
        Heightft = (EditText) findViewById(R.id.editHeightft);
        Heightin = (EditText) findViewById(R.id.editHeightin);
        Weight = (EditText) findViewById(R.id.editWeight);
        Gender = (EditText) findViewById(R.id.editGender);

        String newName = Name.getText().toString().trim();
        String newAge = Age.getText().toString().trim();
        String newHeightft = Heightft.getText().toString().trim();
        String newHeightin = Heightin.getText().toString().trim();
        String newWeight = Weight.getText().toString().trim();
        String newGender = Gender.getText().toString().trim();

        if(Name.length() > 0)
            editor.putString("name", newName);
        if(Age.length() > 0)
            editor.putInt("age", Integer.parseInt(newAge));
        if(newHeightft.length() > 0)
            editor.putInt("heightft", Integer.parseInt(newHeightft));
        if(newHeightin.length() > 0)
            editor.putInt("heightin", Integer.parseInt(newHeightin));
        if(newWeight.length() > 0)
            editor.putInt("weight", Integer.parseInt(newWeight));
        if(newGender.length() > 0)
            editor.putString("gender", newGender);

        editor.commit();
        startActivity(this.addIntent);
    }
}
