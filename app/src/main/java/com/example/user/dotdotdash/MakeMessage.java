package com.example.user.dotdotdash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 03/11/2016.
 */
public class MakeMessage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_mess);
    }

    protected void writeMorse(View view) {
        Intent intent = new Intent(this,MakeMessageMorse.class);
        startActivity(intent);
    }

    protected void writeText(View view) {
        Intent intent = new Intent(this,MakeMessageText.class);
        startActivity(intent);
    }
}
