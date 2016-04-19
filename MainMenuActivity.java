package com.example.alexj.gym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        defineButtons();
    }

    public void defineButtons(){
        findViewById(R.id.profileButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.dietButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.exerciseButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.sleepButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.progressButton).setOnClickListener(buttonClickListener);
    }
}
    private  View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent;
            switch(view.getId()){
                case R.id.profileButton:
                     intent = new Intent(this, )
                    break;
                case R.id.dietButton:
                    intent = new Intent(this, )
                    break;
                case R.id.exerciseButton:
                    intent = new Intent(this, )
                    break;
                case R.id.sleepButton
                    intent = new Intent(this, )
                    break;
                case R.id.progressButton
                    intent = new Intent(this, )
                    break;
            }

        }
}
