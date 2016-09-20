package com.example.consumomedio;

import com.example.consumomedio.MainActivity;
import com.example.consumomedio.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText eddistancia, edconsumo;
	Button btcalcular, btlimpar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		eddistancia = (EditText) findViewById(R.id.distancia);
		edconsumo = (EditText) findViewById(R.id.consumo);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);
		
		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Double distancia, consumo, autonomia;
				Boolean status = true;
				
				distancia = consumo = autonomia = 0.0;
				
				try {
					distancia = Double.parseDouble(eddistancia.getText().toString());
					consumo = Double.parseDouble(edconsumo.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informe os números corretamente");
					dialog.setMessage("Cálculo incompleto");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				autonomia = distancia / consumo;
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informações:");
					dialog.setMessage(
							"Autonomia: " + String.valueOf(autonomia) + " Km/L");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				eddistancia.setText("");
				edconsumo.setText("");
			}

		});		
		
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
