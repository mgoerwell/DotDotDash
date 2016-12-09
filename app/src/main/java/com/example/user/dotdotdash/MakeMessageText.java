package com.example.user.dotdotdash;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 02/11/2016.
 */
public class MakeMessageText extends AppCompatActivity {

    EditText userInput;
    String morseToSend = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_text);
        userInput = (EditText) findViewById(R.id.unCodedMsg);
    }

    /*
    *  Opens up the built in contact list to get a phone number for SMS
    *  @param view  (isn't used but must be included)
    */
    protected void acquireTarget(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(intent,1);
    }

    /*
     *  Processes the contact selected by acquire target for sending an SMS
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                Cursor c = null;
                try {
                    c = getContentResolver().query(uri,new String[] {
                            ContactsContract.CommonDataKinds.Phone.NUMBER,
                            ContactsContract.CommonDataKinds.Phone.LABEL},
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

    protected void convertMessage(View view){
        morseToSend = "";

        String temp = userInput.getText().toString().toLowerCase();
        String temp2;

        for(int i = 0; i < temp.length(); i++)
        {
            temp2 = "" + temp.charAt(i);
            morseToSend += convertToMorse(temp2);
        }
        Toast.makeText(this, morseToSend,Toast.LENGTH_SHORT).show();
    }

    protected void sendMess(String number) {
        char[] charArray = number.toCharArray();
        String phoneNumber = "";

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                phoneNumber += charArray[i];
            }
        }
        convertMessage(userInput);
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, morseToSend, null, null);
            //Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Could not send sms.", Toast.LENGTH_SHORT).show();
        }
    }

    protected String convertToMorse(String character){
        boolean matchFound = false; // checks if a match has been found
        String retString = "";

        switch(character) {
            // checks for alphabet characters
            case "a":      // 01
                matchFound = true;
                retString = "01 ";
                break;
            case "b":    // 1000
                matchFound = true;
                retString = "1000 ";
                break;
            case "c":    // 1010
                matchFound = true;
                retString = "1010 ";
                break;
            case "d":     // 100
                matchFound = true;
                retString = "100 ";
                break;
            case "e":       // 0
                matchFound = true;
                retString = "0 ";
                break;
            case"f":     // 0010
                matchFound = true;
                retString = "0010 ";
                break;
            case"g":      // 110
                matchFound = true;
                retString = "110 ";
                break;
            case "h":    // 0000
                matchFound = true;
                retString = "0000 ";
                break;
            case "i":      // 00
                matchFound = true;
                retString = "00 ";
                break;
            case "j":    // 0111
                matchFound = true;
                retString = "0111 ";
                break;
            case "k":     // 101
                matchFound = true;
                retString = "101 ";
                break;
            case "l":    // 0100
                matchFound = true;
                retString = "0100 ";
                break;
            case "m":      // 11
                matchFound = true;
                retString = "11 ";
                break;
            case "n":      // 10
                matchFound = true;
                retString = "10 ";
                break;
            case "o":     // 111
                matchFound = true;
                retString = "111 ";
                break;
            case "p":    // 0110
                matchFound = true;
                retString = "0110 ";
                break;
            case "q":    // 1101
                matchFound = true;
                retString = "1101 ";
                break;
            case "r":     // 010
                matchFound = true;
                retString = "010 ";
                break;
            case "s":     // 000
                matchFound = true;
                retString = "000 ";
                break;
            case "t":       // 1
                matchFound = true;
                retString = "1 ";
                break;
            case "u":     // 001
                matchFound = true;
                retString = "001 ";
                break;
            case "v":    // 0001
                matchFound = true;
                retString = "0001 ";
                break;
            case "w":     // 011
                matchFound = true;
                retString = "011 ";
                break;
            case "x":    // 1001
                matchFound = true;
                retString = "1001 ";
                break;
            case "y":    // 1011
                matchFound = true;
                retString = "1011 ";
                break;
            case "z":    // 1100
                matchFound = true;
                retString = "1100 ";
                break;
            case " ": // space
                matchFound = true;
                retString = "- ";
                break;

            // checks for numeric characters
            case "1":   // 01111
                matchFound = true;
                retString = "01111 ";
                break;
            case "2":   // 00111
                matchFound = true;
                retString = "00111 ";
                break;
            case "3":   // 00011
                matchFound = true;
                retString = "00011 ";
                break;
            case "4":   // 00001
                matchFound = true;
                retString = "00001 ";
                break;
            case "5":   // 00000
                matchFound = true;
                retString = "00000 ";
                break;
            case "6":   // 10000
                matchFound = true;
                retString = "10000 ";
                break;
            case "7":   // 11000
                matchFound = true;
                retString = "11000 ";
                break;
            case "8":   // 11100
                matchFound = true;
                retString = "11100 ";
                break;
            case "9":   // 11110
                matchFound = true;
                retString = "11110 ";
                break;
            case "0":   // 11111
                matchFound = true;
                retString = "11111 ";
                break;
        }

        if(!matchFound) {
            Toast.makeText(this, "Cannot contain special characters",Toast.LENGTH_SHORT).show();

            return retString;
        }

        return retString;
    }
}
