package com.example.user.dotdotdash;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 02/11/2016.
 */
public class MakeMessageMorse extends AppCompatActivity{

    String morseBuffer = "";
    String currCharacter = "";
    String morseMessageConverted = "";
    String morseMessage;

    TextView message;

    private List<String> displayText = new ArrayList<String>();

    private int DOT = 0;
    private int DASH = 1;

    Audio noise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_morse);
        message = (TextView) findViewById(R.id.messageText);
        noise = new Audio(this);
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
        char[] charArray = number.toCharArray();
        String phoneNumber = "";

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                phoneNumber += charArray[i];
            }
        }
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, morseMessage, null, null);

            Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Could not send sms.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * METHOD: nextLetter
     *
     * DESCRIPTION: this method is used to validate the morse code character that the user
     *              has entered.
     *                  > if the code is a valid code it is added to the message (List)
     *                  > if the code is not a valid morse code character the user is notified
     * @param view  (isn't used but must be included)
     */
    protected void nextCharacter(View view) {
        if (!isValidMorse(morseBuffer)) {
            Toast.makeText(this, "Invalid Morse", Toast.LENGTH_SHORT).show();
            morseBuffer = "";
        } else {
            morseMessageConverted += getCurrCharacter();
            //Toast.makeText(this, "Valid Morse: " + morseMessageConverted, Toast.LENGTH_SHORT).show();
            message.setText(morseMessageConverted);
            morseBuffer = "";
        }
    }

    /**
     * METHOD: dotEntered (onClick method)
     *
     * DESCRIPTION: if the user clicks on the dot button that a 0 is added to morse buffer
     *
     * @param view (isn't used but must be included)
     */
    protected void dotEntered(View view){
        morseBuffer += DOT;
        noise.playDot();
        Toast.makeText(this, morseBuffer, Toast.LENGTH_SHORT).show();
    }

    /**
     * METHOD: dashEntered (onClick method)
     *
     * DESCRIPTION: if the user clicks on the dash button that a 1 is added to morse buffer
     *
     * @param view (isn't used but must be included)
     */
    protected void dashEntered(View view){
        morseBuffer += DASH;
        noise.playDash();
        Toast.makeText(this, morseBuffer, Toast.LENGTH_SHORT).show();
    }

    /**
     * METHOD: deleteCurrCharacter (onClick method)
     *
     * DESCRIPTION: clears the morse buffer
     *
     * @param view (isn't used but must be included)
     */
    protected void deleteCurrCharacter(View view){
        morseBuffer = "";

        if(morseMessageConverted.length() == 0) {
            Toast.makeText(this,"no characters exist", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            morseMessageConverted = morseMessageConverted.substring(0, morseMessageConverted.length() - 1);
            message.setText(morseMessageConverted);
        }
    }

    /**
     * METHOD: isValidMorse
     *
     * DESCRIPTION: Checks if the parameter value passed is a valid morse code character. it does
     *              this by check the parameter value against a list of morse code discitonary
     *              terms
     *
     *              > if matchFound then return true
     *              > if match not found then return false
     *
     * RETURN: char
     *
     * @param morseCode
     * @return
     */
    protected boolean isValidMorse(String morseCode){
        boolean matchFound = false; // checks if a match has been found
        switch(morseCode)
        {
            // checks for alphabet characters
            case "01":      // a
                matchFound = true;
                setCurrCharacter("a");
                break;
            case "1000":    // b
                matchFound = true;
                setCurrCharacter("b");
                break;
            case "1010":    // c
                matchFound = true;
                setCurrCharacter("c");
                break;
            case "100":     // d
                matchFound = true;
                setCurrCharacter("d");
                break;
            case "0":       // e
                matchFound = true;
                setCurrCharacter("e");
                break;
            case"0010":     // f
                matchFound = true;
                setCurrCharacter("f");
                break;
            case"110":      // g
                matchFound = true;
                setCurrCharacter("g");
                break;
            case "0000":    // h
                matchFound = true;
                setCurrCharacter("h");
                break;
            case "00":      // i
                matchFound = true;
                setCurrCharacter("i");
                break;
            case "0111":    // j
                matchFound = true;
                setCurrCharacter("j");
                break;
            case "101":     // k
                matchFound = true;
                setCurrCharacter("k");
                break;
            case "0100":    // l
                matchFound = true;
                setCurrCharacter("l");
                break;
            case "11":      // m
                matchFound = true;
                setCurrCharacter("m");
                break;
            case "10":      // n
                matchFound = true;
                setCurrCharacter("n");
                break;
            case "111":     // o
                matchFound = true;
                setCurrCharacter("o");
                break;
            case "0110":    // p
                matchFound = true;
                setCurrCharacter("p");
                break;
            case "1101":    // q
                matchFound = true;
                setCurrCharacter("q");
                break;
            case "010":     // r
                matchFound = true;
                setCurrCharacter("r");
                break;
            case "000":     // s
                matchFound = true;
                setCurrCharacter("s");
                break;
            case "1":       // t
                matchFound = true;
                setCurrCharacter("t");
                break;
            case "001":     // u
                matchFound = true;
                setCurrCharacter("u");
                break;
            case "0001":    // v
                matchFound = true;
                setCurrCharacter("v");
                break;
            case "011":     // w
                matchFound = true;
                setCurrCharacter("w");
                break;
            case "1001":    // x
                matchFound = true;
                setCurrCharacter("x");
                break;
            case "1011":    // y
                matchFound = true;
                setCurrCharacter("y");
                break;
            case "1100":    // z
                matchFound = true;
                setCurrCharacter("z");
                break;

            // checks for numeric characters
            case "01111":   // 1
                matchFound = true;
                setCurrCharacter("1");
                break;
            case "00111":   // 2
                matchFound = true;
                setCurrCharacter("2");
                break;
            case "00011":   // 3
                matchFound = true;
                setCurrCharacter("3");
                break;
            case "00001":   // 4
                matchFound = true;
                setCurrCharacter("4");
                break;
            case "00000":   // 5
                matchFound = true;
                setCurrCharacter("5");
                break;
            case "10000":   // 6
                matchFound = true;
                setCurrCharacter("6");
                break;
            case "11000":   // 7
                matchFound = true;
                setCurrCharacter("7");
                break;
            case "11100":   // 8
                matchFound = true;
                setCurrCharacter("8");
                break;
            case "11110":   // 9
                matchFound = true;
                setCurrCharacter("9");
                break;
            case "11111":   // 0
                matchFound = true;
                setCurrCharacter("0");
                break;

            case "": // use specifies a space
                matchFound = true;
                setCurrCharacter(" ");
                break;
        }

        return matchFound;
    }


    private void setCurrCharacter(String character){
        currCharacter = character;
    }


    private String getCurrCharacter(){
        return currCharacter;
    }
}
