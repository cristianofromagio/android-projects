package com.example.valordevido;

import com.example.valordevido.MainActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edcodigo, edquantcomprada;
	Button btcalcular, btlimpar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edcodigo = (EditText) findViewById(R.id.codproduto);
		edquantcomprada = (EditText) findViewById(R.id.quantcomprada);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);

		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Integer codigo, quant;
				Double valorTotal;
				Boolean status = true;
				
				codigo = quant = 0;
				valorTotal = 0.0;
				
				try {
					codigo = Integer.parseInt(edcodigo.getText().toString());
					quant = Integer.parseInt(edquantcomprada.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informe os números corretamente");
					dialog.setMessage("Cálculo incompleto");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				if (codigo == 1001)
					valorTotal = quant * 5.32;
				else if (codigo == 1324)
					valorTotal = quant * 6.45;
				else if (codigo == 6548)
					valorTotal = quant * 2.37;
				else if (codigo == 1987)
					valorTotal = quant * 5.32;
				else if (codigo == 7623)
					valorTotal = quant * 6.45;
				else {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Código");
					dialog.setMessage("Informe um código válido para o produto");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Preço total devido: ");
					dialog.setMessage(
							"O valor total é: " + String.valueOf(valorTotal));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edcodigo.setText("");
				edquantcomprada.setText("");
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
