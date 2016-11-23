package com.example.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class FiveActivity extends Activity {

	Button btprox, btsair;
	RadioGroup resposta;
	Integer acertos;
	Boolean acerto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_five);

		resposta = (RadioGroup) findViewById(R.id.rgresposta);
		btprox = (Button) findViewById(R.id.btproxima);
        btsair = (Button) findViewById(R.id.btsair);
        
        Intent intentExtras = getIntent();
		Integer acertosAcumulados  = intentExtras.getIntExtra("acertos", 0);
		acertos = acertosAcumulados;

        btprox.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				
				boolean status = true;
				
				try {
					acerto = verificarcorreto();
				} catch (Exception e) {
					
					status = false;
					AlertDialog.Builder dialogo = new AlertDialog.Builder(FiveActivity.this);
					dialogo.setTitle("Erro");
					dialogo.setMessage("Selecione uma opção");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
					
				}
				
				if (status) {
					
					if (acerto) {
						acertos++;
					}
					
					String msg = "Você acertou: " + acertos;
					msg += "\nIsso equivale a " + acertos + "/5 de acerto";
					
					AlertDialog.Builder dialogo = new AlertDialog.Builder(FiveActivity.this);
					dialogo.setTitle("PARABÉNS");
					dialogo.setMessage(msg);
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
					
				}
			}
		});
		
		btsair.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
			
		});
	}

	public boolean verificarcorreto() {
		
		int op = resposta.getCheckedRadioButtonId();
		
		if (op == R.id.p5op2)
			return true;
		
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.five, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
