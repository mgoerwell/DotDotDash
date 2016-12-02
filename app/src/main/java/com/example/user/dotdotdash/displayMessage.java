package com.example.user.dotdotdash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 03/11/2016.
 */
public class displayMessage extends AppCompatActivity {

    EditText decodeText;
    TextView decodedText;
    String morseCode;
    String decodedMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mess);
        decodeText = (EditText) findViewById(R.id.decodeText);
        decodedText = (TextView) findViewById((R.id.decodedText));
    }

    protected void decode(View view) {
        morseCode = decodeText.getText().toString();

        String[] codeArr = morseCode.split("\\s+");

        for(int i = 0; i < codeArr.length; i++) {
            System.out.println(codeArr[i]);
            decodedMessage += convertMorse(codeArr[i]);
        }

        decodedText.setText(decodedMessage);
        decodedMessage = "";
    }

    protected String convertMorse(String morseCode){
        boolean matchFound = false; // checks if a match has been found
        String retString = "";

        switch(morseCode) {
            // checks for alphabet characters
            case "01":      // a
                matchFound = true;
                retString = "a";
                break;
            case "1000":    // b
                matchFound = true;
                retString = "b";
                break;
            case "1010":    // c
                matchFound = true;
                retString = "c";
                break;
            case "100":     // d
                matchFound = true;
                retString = "d";
                break;
            case "0":       // e
                matchFound = true;
                retString = "e";
                break;
            case"0010":     // f
                matchFound = true;
                retString = "f";
                break;
            case"110":      // g
                matchFound = true;
                retString = "g";
                break;
            case "0000":    // h
                matchFound = true;
                retString = "h";
                break;
            case "00":      // i
                matchFound = true;
                retString = "i";
                break;
            case "0111":    // j
                matchFound = true;
                retString = "j";
                break;
            case "101":     // k
                matchFound = true;
                retString = "k";
                break;
            case "0100":    // l
                matchFound = true;
                retString = "l";
                break;
            case "11":      // m
                matchFound = true;
                retString = "m";
                break;
            case "10":      // n
                matchFound = true;
                retString = "n";
                break;
            case "111":     // o
                matchFound = true;
                retString = "o";
                break;
            case "0110":    // p
                matchFound = true;
                retString = "p";
                break;
            case "1101":    // q
                matchFound = true;
                retString = "q";
                break;
            case "010":     // r
                matchFound = true;
                retString = "r";
                break;
            case "000":     // s
                matchFound = true;
                retString = "s";
                break;
            case "1":       // t
                matchFound = true;
                retString = "t";
                break;
            case "001":     // u
                matchFound = true;
                retString = "u";
                break;
            case "0001":    // v
                matchFound = true;
                retString = "v";
                break;
            case "011":     // w
                matchFound = true;
                retString = "w";
                break;
            case "1001":    // x
                matchFound = true;
                retString = "x";
                break;
            case "1011":    // y
                matchFound = true;
                retString = "y";
                break;
            case "1100":    // z
                matchFound = true;
                retString = "z";
                break;

            // checks for numeric characters
            case "01111":   // 1
                matchFound = true;
                retString = "1";
                break;
            case "00111":   // 2
                matchFound = true;
                retString = "2";
                break;
            case "00011":   // 3
                matchFound = true;
                retString = "3";
                break;
            case "00001":   // 4
                matchFound = true;
                retString = "4";
                break;
            case "00000":   // 5
                matchFound = true;
                retString = "5";
                break;
            case "10000":   // 6
                matchFound = true;
                retString = "6";
                break;
            case "11000":   // 7
                matchFound = true;
                retString = "7";
                break;
            case "11100":   // 8
                matchFound = true;
                retString = "8";
                break;
            case "11110":   // 9
                matchFound = true;
                retString = "9";
                break;
            case "11111":   // 0
                matchFound = true;
                retString = "0";
                break;
            case "-": // space
                matchFound = true;
                retString = " ";
                break;
        }

        if(!matchFound) {
            retString = "";
            Toast.makeText(getApplicationContext(), "Incorrect Morse", Toast.LENGTH_SHORT).show();
        }

        return retString;
    }


    protected void getDict(View view) {
        Intent intent = new Intent(this,MorseDictionary.class);
        startActivity(intent);
    }
}
