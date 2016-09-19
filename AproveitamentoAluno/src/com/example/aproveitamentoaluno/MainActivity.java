package com.example.aproveitamentoaluno;

import com.example.aproveitamentoaluno.R;
import com.example.aproveitamentoaluno.MainActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edcodigo, edav1, edav2, edav3, edmediatrab;
	Button btcalcular, btlimpar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edcodigo = (EditText) findViewById(R.id.codaluno);
		edav1 = (EditText) findViewById(R.id.av1);
		edav2 = (EditText) findViewById(R.id.av2);
		edav3 = (EditText) findViewById(R.id.av3);
		edmediatrab = (EditText) findViewById(R.id.mediatrab);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);
		
		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Integer codigo;
				Double av1, av2, av3, mediatrab, mediaaprov;
				String conceito, mensagem;
				Boolean status = true;
				
				codigo = 0;
				av1 = av2 = av3 = mediatrab = mediaaprov = 0.0;
				conceito = mensagem = "";
				
				try {
					codigo = Integer.parseInt(edcodigo.getText().toString());
					av1 = Double.parseDouble(edav1.getText().toString());
					av2 = Double.parseDouble(edav2.getText().toString());
					av3 = Double.parseDouble(edav3.getText().toString());
					mediatrab = Double.parseDouble(edmediatrab.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informe os números corretamente");
					dialog.setMessage("Cálculo incompleto");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				mediaaprov = (av1 + av2 * 2 + av3 * 3 + mediatrab) / 7;
				
				if (mediaaprov >= 9)
					conceito = "A";
				else if (mediaaprov >= 7.5 && mediaaprov < 9)
					conceito = "B";
				else if (mediaaprov >= 6 && mediaaprov < 7.5)
					conceito = "C";
				else if (mediaaprov >= 4 && mediaaprov < 6)
					conceito = "D";
				else if (mediaaprov >= 0 && mediaaprov < 4)
					conceito = "E";
				
				if (conceito.equals("D") || conceito.equals("E"))
					mensagem = "REPROVADO";
				else
					mensagem = "APROVADO";
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Informações:");
					dialog.setMessage(
							"Número do aluno: " + String.valueOf(codigo) + "\n"
									+ "Nota 1: " + String.valueOf(av1) + "\n"
									+ "Nota 2: " + String.valueOf(av2) + "\n"
									+ "Nota 3: " + String.valueOf(av3) + "\n"
									+ "Média exercícios: " + String.valueOf(mediatrab) + "\n"
									+ "Média de aproveitamento: " + String.format("%.2f", mediaaprov) + "\n"
									+ "Conceito final: " + String.valueOf(conceito) + "\n"
									+ "Status: " + String.valueOf(mensagem));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edcodigo.setText("");
				edav1.setText("");
				edav2.setText("");
				edav3.setText("");
				edmediatrab.setText("");
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
