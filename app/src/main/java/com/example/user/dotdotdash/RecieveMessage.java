package com.example.user.dotdotdash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 02/11/2016.
 */
public class RecieveMessage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_file);
    }

    protected void seeMess(View view) {
        Intent intent = new Intent(this,displayMessage.class);
        startActivity(intent);
    }
}
