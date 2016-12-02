package com.example.user.dotdotdash;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by user on 02/11/2016.
 */
public class Audio {
    //media player for morse code audio.
    private MediaPlayer SE;

    //Receiver for the context the audio is playing in.
    private final Context context;

    public Audio(Context c) {
        context = c;
    }

    public void playDot() {
        SE = MediaPlayer.create(context,R.raw.dot);
        SE.start();
        SE.setOnCompletionListener(done);
    }

    public void playDash() {
        SE = MediaPlayer.create(context,R.raw.dash);
        SE.start();
        SE.setOnCompletionListener(done);
    }

    public void makeSpace() {
        SE = MediaPlayer.create(context,R.raw.letterspace);
        SE.start();
        SE.setOnCompletionListener(finish);
    }

    private final MediaPlayer.OnCompletionListener done = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            if (mp == SE) {
                SE.reset();
                SE.release();
                SE = MediaPlayer.create(context,R.raw.bitspace);
                SE.setOnCompletionListener(finish);
            }
        }
    };

    private final MediaPlayer.OnCompletionListener finish = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            if (mp == SE) {
                SE.reset();
                SE.release();
            }
        }
    };

    public void playMorse(String morseCode) {
        //enable string to be processed char by char
        final char[] morse = morseCode.toCharArray();
        //thread to enable waiting for sounds to resolve between characters
        Thread messThread = new Thread(){
            //required method to run thread
            public void run() {

                //for each loop for character processing
                for (char c : morse) {
                    switch (c) {
                        case '0':   // dot character
                            playDot();
                            try {
                                sleep(208); // length of dot.mp3 and bitspace.mp3 combined
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case '1': //dash character
                            playDash();
                            try {
                                sleep(391); // length of dash.mp3 and bitspace.mp3 combined
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        default: //
                            makeSpace();
                            try {
                                sleep(183);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                }
            }
        };
        messThread.start();
    }
}
