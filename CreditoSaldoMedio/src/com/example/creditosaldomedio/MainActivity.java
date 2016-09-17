package com.example.creditosaldomedio;

import com.example.creditosaldomedio.MainActivity;
import com.example.creditosaldomedio.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edsaldo;
	Button btcalcular, btlimpar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);
		edsaldo = (EditText) findViewById(R.id.edsaldomedio);

		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				double saldo, credito;
				boolean status = true;

				saldo = credito = 0;

				try {
					saldo = Double.parseDouble(edsaldo.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informe os números corretamente");
					dialog.setMessage("Cálculo incompleto");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}

				if (saldo >= 0 && saldo <= 200)
					credito = 0;
				else if (saldo > 200 && saldo <= 400)
					credito = saldo * 0.2;
				else if (saldo > 400 && saldo <= 600)
					credito = saldo * 0.3;
				else if (saldo > 600)
					credito = saldo * 0.4;
				else {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informação insuficiente");
					dialog.setMessage("Informe um valor válido para o saldo médio");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}

				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Valor calculado: ");
					dialog.setMessage(
							"O saldo médio é: " + String.valueOf(saldo) + "\nO crédito é: " + String.valueOf(credito));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
			}
		});

		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edsaldo.setText("");
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
