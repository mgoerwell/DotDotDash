package com.example.user.dotdotdash;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * File that handles the audio functionality of the morse code generation
 * In a perfect world this would allow us to programmatically play a message
 * from a morse code string, but that functionality was cut.
 */
public class Audio {
    //media player for morse code audio.
    private MediaPlayer SE;

    //Receiver for the context the audio is playing in.
    private final Context context;

    /*
     *  Constructor method. Takes the current context so that it knows which activity to limit
     *  itself to.
     *  @param c (used to determine the where it was made)
     */
    public Audio(Context c) {
        context = c;
    }

    /*
     *  Method playDot
     *  Description: a method that resets the media player and plays the tone
     *  for a dot character.
     */
    public void playDot() {
        if (SE != null) {
            SE.reset();
            SE.release();
        }
        SE = MediaPlayer.create(context,R.raw.dot);
        SE.start();
    }

    /*
     *  Method playDash
     *  Description: a method that resets the media player and plays the tone
     *  for a dash character.
     */
    public void playDash() {
        if (SE != null) {
            SE.reset();
            SE.release();
        }
        SE = MediaPlayer.create(context,R.raw.dash);
        SE.start();
    }

}
