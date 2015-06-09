package com.lucalacerda.droidvoice;

import android.app.Activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.media.AudioManager;
import android.media.MediaPlayer;



public class TextToVoice extends Activity {
    String textString;

    public TextToVoice(String s) {
        textString = s;
    }

    public void listenVoice() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(makeUrl());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    private String makeUrl() {
        String linkFormat = "http://translate.google.com/translate_tts?q=%s&tl=%s";
        String textEncoded = null;
        try {
            textEncoded = URLEncoder.encode(textString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format(linkFormat, textEncoded, "pt-BR");
    }

}
