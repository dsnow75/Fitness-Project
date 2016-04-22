package jmda.pocketfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.profile_button_id);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intent_go_to_profile = new Intent(MainActivity.this, MainMenuActivity.class);
                startActivity(intent_go_to_profile);
            }
        });

    }
}
