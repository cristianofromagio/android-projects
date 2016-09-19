package com.example.aumentosalario;

import com.example.aumentosalario.MainActivity;
import com.example.aumentosalario.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText edcodigo, edsalario;
	Button btcalcular, btlimpar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edcodigo = (EditText) findViewById(R.id.codfunc);
		edsalario = (EditText) findViewById(R.id.salfunc);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);

		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Integer codigo;
				Double salario, novosalario, aumento;
				Boolean status = true;
				
				codigo = 0;
				salario = novosalario = aumento = 0.0;
				
				try {
					codigo = Integer.parseInt(edcodigo.getText().toString());
					salario = Double.parseDouble(edsalario.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informe os números corretamente");
					dialog.setMessage("Cálculo incompleto");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				if (codigo == 101) {
					aumento = salario * 0.1;
					novosalario = salario + aumento;
				} else if (codigo == 102) {
					aumento = salario * 0.2;
					novosalario = salario + aumento;
				} else if (codigo == 103) {
					aumento = salario * 0.3;
					novosalario = salario + aumento;
				} else {
					aumento = salario * 0.4;
					novosalario = salario + aumento;
				}
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informações:");
					dialog.setMessage(
							"Salário atual: " + String.valueOf(salario) + "\n"
									+ "Aumento: " + String.valueOf(aumento) + "\n"
									+ "Salário reajustado: " + String.valueOf(novosalario));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edcodigo.setText("");
				edsalario.setText("");
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
