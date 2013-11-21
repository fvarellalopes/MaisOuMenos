package com.test.maisoumenos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.maisoumenos.R;

public class MainActivity extends Activity {

	private MediaPlayer musica;
	private BootstrapButton botao_audio;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        botao_audio =  (BootstrapButton) findViewById(R.id.btn_play);
        
        musica = MediaPlayer.create(this, R.drawable.mais_ou_menos);
        
        musica.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				Toast.makeText(MainActivity.this, "Teste funfou", 3000).show();
				botao_audio.setBootstrapType("primary");
			}
		});
		
    }
    
    public void executarAudio(View v)
    {
    	if (!musica.isPlaying())
    	{
    	musica.start();
    	botao_audio.setBootstrapType("warning");
    	}
    }


    
}
