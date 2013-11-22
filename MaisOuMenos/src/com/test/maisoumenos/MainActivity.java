package com.test.maisoumenos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
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
        registerForContextMenu(botao_audio);
        configsBotao();
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Opções:");
        MenuItem toque = menu.add("Toque");
        MenuItem notificacao = menu.add("Notificação");
        MenuItem alarme = menu.add("Alarme");

        toque.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // definir como toque
            	return true;
            }
        });

        notificacao.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // definir como notificacao 
            	return true;
            }
        });
        
        alarme.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // definir como alarme
            	return true;
            }
        });
        

        super.onCreateContextMenu(menu, v, menuInfo);
    }
    
    
    
    public void configsBotao()
    {
    	 musica.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
 			
 			@Override
 			public void onCompletion(MediaPlayer mp) {
 				botao_audio.setEnabled(true);
 			}
 		});
    	 
    	 botao_audio.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!musica.isPlaying())
		    	{
		    	musica.start();
		    	botao_audio.setEnabled(false);
		    	}
			}
		});
    	 
    	
    }
    

    
}
