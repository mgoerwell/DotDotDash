package com.example.user.dotdotdash;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 02/11/2016.
 */
public class MakeMessageMorse extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_morse);
    }

    protected void howToSpell(View view) {
        Intent intent = new Intent(this,MorseDictionary.class);
        startActivity(intent);
    }

    protected void acquireTarget(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                Cursor c = null;
                try {
                    c = getContentResolver().query(uri,new String[] {
                                    ContactsContract.CommonDataKinds.Phone.NUMBER},
                            null,null,null);
                    if (c != null && c.moveToFirst()) {
                        String phoneNum = c.getString(0);
                        sendMess(phoneNum);
                    }
                } finally {
                    if (c != null) {
                        c.close();
                    }
                }
            }
        }
    }

    protected void sendMess(String number) {
        Toast.makeText(this,"Number: " + number,Toast.LENGTH_SHORT).show();
    }
}
