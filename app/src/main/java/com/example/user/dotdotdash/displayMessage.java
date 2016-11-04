package com.example.user.dotdotdash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 03/11/2016.
 */
public class displayMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mess);
    }

    protected void getDict(View view) {
        Intent intent = new Intent(this,MorseDictionary.class);
        startActivity(intent);
    }
}
