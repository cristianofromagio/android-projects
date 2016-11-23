package com.example.quiz;

import com.example.quiz.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	
	Button btprox, btsair;
	RadioGroup resposta;
	Integer acertos = 0;
	Boolean acerto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		resposta = (RadioGroup) findViewById(R.id.rgresposta);
		btprox = (Button) findViewById(R.id.btproxima);
        btsair = (Button) findViewById(R.id.btsair);

        btprox.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				
				boolean status = true;
				
				try {
					acerto = verificarcorreto();
				} catch (Exception e) {
					
					status = false;
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
					dialogo.setTitle("Erro");
					dialogo.setMessage("Selecione uma opção");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
					
				}
				
				if (status) {
					
					if (acerto) {
						acertos++;
					}
					
					Intent intentBundle = new Intent(MainActivity.this, TwoActivity.class);
					Bundle bundle = new Bundle();
					bundle.putInt("acertos", acertos);
					intentBundle.putExtras(bundle);
					startActivity(intentBundle);
					
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
		
		if (op == R.id.p1op3)
			return true;
		
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
