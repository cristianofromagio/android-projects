package com.example.calculosfuncionario;

import com.example.calculosfuncionario.MainActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edcodigo, edsalario, edtempo;
	Button btcalcular, btlimpar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edcodigo = (EditText) findViewById(R.id.codfunc);
		edsalario = (EditText) findViewById(R.id.salariobase);
		edtempo = (EditText) findViewById(R.id.temposervico);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);

		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				Integer codigo;
				Double salariobase, temposervico, imposto, gratificacao, salarioliquido;
				Boolean status = true;
				String categoria = "";

				codigo = 0;
				salariobase = temposervico = imposto = gratificacao = salarioliquido = 0.0;

				try {
					codigo = Integer.parseInt(edcodigo.getText().toString());
					salariobase = Double.parseDouble(edsalario.getText().toString());
					temposervico = Double.parseDouble(edtempo.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Cálculo incompleto");
					dialog.setMessage("Informe os dados corretamente");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}

				if (status) {

					if (salariobase >= 0 && salariobase < 200)
						imposto = 0.0;
					else if (salariobase >= 200 && salariobase <= 450)
						imposto = salariobase * 0.03;
					else if (salariobase > 450 && salariobase < 700)
						imposto = salariobase * 0.08;
					else if (salariobase >= 700)
						imposto = salariobase * 0.12;
					else {
						status = false;
						AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
						dialog.setTitle("Dado incorreto");
						dialog.setMessage("Informe um salário positivo");
						dialog.setNeutralButton("OK", null);
						dialog.show();
					}

					if (status) {

						if (salariobase >= 0 && salariobase <= 500) {

							if (temposervico >= 0 && temposervico <= 3)
								gratificacao = 23.0;
							else if (temposervico > 3 && temposervico < 6)
								gratificacao = 35.0;
							else if (temposervico >= 6)
								gratificacao = 33.0;

						} else if (salariobase > 500) {

							if (temposervico >= 0 && temposervico <= 3)
								gratificacao = 20.0;
							else if (temposervico > 3)
								gratificacao = 30.0;

						} else {
							status = false;
							AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
							dialog.setTitle("Dado incorreto");
							dialog.setMessage("Informe um tempo de serviço positivo");
							dialog.setNeutralButton("OK", null);
							dialog.show();
						}

						if (status) {

							salarioliquido = salariobase - imposto + gratificacao;

							if (salarioliquido >= 0 && salarioliquido <= 350)
								categoria = "A";
							else if (salarioliquido > 350 && salarioliquido <= 600)
								categoria = "B";
							else if (salarioliquido > 600)
								categoria = "C";

							AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
							dialog.setTitle("Informações:");
							dialog.setMessage("Código: " + String.valueOf(codigo) + "\n" + "Salário base: "
									+ String.valueOf(salariobase) + "\n" + "Imposto: " + String.valueOf(imposto) + "\n"
									+ "Gratificação: " + String.valueOf(gratificacao) + "\n" + "Salário líquido: "
									+ String.valueOf(salarioliquido) + "\n" + "Categoria: " + categoria);
							dialog.setNeutralButton("OK", null);
							dialog.show();
						}
					}
				}

			}

		});

		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edcodigo.setText("");
				edsalario.setText("");
				edtempo.setText("");
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
