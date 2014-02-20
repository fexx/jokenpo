package com.santy.jokenpo;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JokenpoActivity extends Activity {
	
	private Random numeroAleatorio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jokenpo);
		
		numeroAleatorio = new Random();
		
		Button pedra = (Button) findViewById(R.id.button1);
		
		pedra.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				findViewById(R.id.imageView1).setBackgroundResource(R.drawable.pedra);
				realizaJogadaPc(1);
			}
		});
		
		Button papel = (Button) findViewById(R.id.button2);
		
		papel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				findViewById(R.id.imageView1).setBackgroundResource(R.drawable.papel);
				realizaJogadaPc(2);
			}
		});
		
		Button tesoura = (Button) findViewById(R.id.button3);
		
		tesoura.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				findViewById(R.id.imageView1).setBackgroundResource(R.drawable.tesoura);
				realizaJogadaPc(3);
			}
		});
	}
	
	public void realizaJogadaPc(int jogadaPlayer){
		int jogadaPC;
		
		jogadaPC = numeroAleatorio.nextInt(3) + 1;
		
		if(jogadaPC == 1){
			findViewById(R.id.imageView3).setBackgroundResource(R.drawable.pedra);
				if(jogadaPlayer == 1){
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.empatou);
				}else if(jogadaPlayer == 2){
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.venceu);
				}else{
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.perdeu);
				}
		}else if(jogadaPC == 2){
			findViewById(R.id.imageView3).setBackgroundResource(R.drawable.papel);
				if(jogadaPlayer == 1){
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.perdeu);
				}else if(jogadaPlayer == 2){
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.empatou);
				}else{
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.venceu);
				}
			
		}else if(jogadaPC == 3){
			findViewById(R.id.imageView3).setBackgroundResource(R.drawable.tesoura);
				if(jogadaPlayer == 1){
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.venceu);
				}else if(jogadaPlayer == 2){
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.perdeu);
				}else{
					findViewById(R.id.imageView2).setBackgroundResource(R.drawable.empatou);
				}
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.jokenpo, menu);
		return true;
	}

}
