package com.example.ratiosalariominimo;

import com.example.ratiosalariominimo.MainActivity;
import com.example.ratiosalariominimo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText edsalariomin, edsalario;
	Button btcalcular, btlimpar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edsalariomin = (EditText) findViewById(R.id.salariominimo);
		edsalario = (EditText) findViewById(R.id.salario);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);
		
		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Double salariomin, salario, ratio;
				Boolean status = true;
				
				salariomin = salario = ratio = 0.0;
				
				try {
					salariomin = Double.parseDouble(edsalariomin.getText().toString());
					salario = Double.parseDouble(edsalario.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("C�lculo incompleto");
					dialog.setMessage("Informe os n�meros corretamente");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				ratio = salario / salariomin;
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Resultado:");
					dialog.setMessage(
							"O sal�rio corresponde a: " + String.valueOf(ratio) + " sal�rios m�nimos");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edsalariomin.setText("");
				edsalario.setText("");
				edsalariomin.requestFocus();
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
