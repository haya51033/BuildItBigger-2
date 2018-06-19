package com.example.yousef.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Intent intent = getIntent();
        if(intent.hasExtra("joke")){
            String joke = intent.getStringExtra("joke");
            TextView jokeHolderTextView = findViewById(R.id.tv_joke_holder);

            jokeHolderTextView.setText(joke);
        }
    }
}
