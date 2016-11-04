package com.example.user.dotdotdash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 02/11/2016.
 */
public class MakeMessageText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_text);
    }

    protected void acquireTarget(View view) {
        Intent intent = new Intent(this,SelectRecipient.class);
        startActivity(intent);
    }
}
