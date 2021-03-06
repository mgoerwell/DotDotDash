package com.example.user.dotdotdash;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
    }

    /*
    *  Opens up the Make a morse Code Message menu activity
    *  @param view  (isn't used but must be included)
    */
    protected void writeMess(View view) {
        Intent intent = new Intent(this,MakeMessage.class);
        startActivity(intent);
    }

    /*
    *  Opens up the Display message activity
    *  @param view  (isn't used but must be included)
    */
    protected void getMess(View view) {
        Intent intent = new Intent(this,displayMessage.class);
        startActivity(intent);
    }
}
