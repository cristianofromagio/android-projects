package com.example.aritmeticaopcao;

import com.example.aritmeticaopcao.MainActivity;
import com.example.aritmeticaopcao.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edopcao, ednum1, ednum2;
	Button btcalcular, btlimpar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edopcao = (EditText) findViewById(R.id.opcao);
		ednum1 = (EditText) findViewById(R.id.num1);
		ednum2 = (EditText) findViewById(R.id.num2);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);

		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Integer opcao = 0;
				Double num1, num2, resultado;
				String operacao = "";
				Boolean status = true;
				
				num1 = num2 = resultado = 0.0;
				
				try {
					opcao = Integer.parseInt(edopcao.getText().toString());
					num1 = Double.parseDouble(ednum1.getText().toString());
					num2 = Double.parseDouble(ednum2.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("C�lculo incompleto");
					dialog.setMessage("Informe os n�meros corretamente");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				switch (opcao) {
					case 0:
						operacao = "SOMA";
						resultado = num1 + num2;
						break;
					case 1:
						operacao = "SUBTRA��O";
						resultado = num1 - num2;
						break;
					case 2:
						operacao = "MULTIPLICA��O";
						resultado = num1 * num2;
						break;
					case 3:
						operacao = "DIVIS�O";
						resultado = num1 / num2;
						break;
					case 4:
						operacao = "M�DIA";
						resultado = (num1 + num2) / 2;
						break;
					default:
						status = false;
						AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
						dialog.setTitle("C�digo inv�lido");
						dialog.setMessage("Informe um c�digo entre 0 e 4 para continuar com a opera��o");
						dialog.setNeutralButton("OK", null);
						dialog.show();
						edopcao.setText("");
						edopcao.requestFocus();
						break;
				}
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Resultado");
					dialog.setMessage(
							"A " + operacao +  " entre " + String.format("%.2f", num1) + " e "
							+ String.format("%.2f", num2) + " � " + String.format("%.2f", resultado));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edopcao.setText("");
				ednum1.setText("");
				ednum2.setText("");
				edopcao.requestFocus();
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
