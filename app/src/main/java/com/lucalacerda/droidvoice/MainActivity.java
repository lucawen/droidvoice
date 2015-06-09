package com.lucalacerda.droidvoice;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    protected EditText textVoice;
    ImageButton buttonListen;
    ImageButton buttonDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textVoice = (EditText) findViewById(R.id.textVoice);
        buttonListen = (ImageButton) findViewById(R.id.imageButtonListen);
        buttonDownload = (ImageButton) findViewById(R.id.imageButtonDownload);
        buttonListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(textVoice.getText().toString())) {
                    TextToVoice textToVoice = new TextToVoice(textVoice.getText().toString());
                    textToVoice.listenVoice();
                } else {
                    textNull();
                }
            }
        });
        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(textVoice.getText().toString())) {
                    textToVoice = new TextToVoice(textVoice.getText().toString());
                    //textToVoice.downloadVoice();
                } else {
                    textNull();
                }
            }
        });

    }
    private void textNull(){
        Toast.makeText(MainActivity.this, "Escreva um texto!", Toast.LENGTH_LONG).show();
        textVoice.setFocusable(true);
    }
}
