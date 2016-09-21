package com.example.pedidolancheria;

import com.example.pedidolancheria.MainActivity;
import com.example.pedidolancheria.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edcodigo, edquantidade;
	Button btcalcular, btlimpar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edcodigo = (EditText) findViewById(R.id.codigo);
		edquantidade = (EditText) findViewById(R.id.quantidade);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);
		
		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Integer codigo, quantidade;
				Double preco = 0.0;
				String lanche = "";
				Boolean status = true;
				
				codigo = quantidade = 0;
				
				try {
					codigo = Integer.parseInt(edcodigo.getText().toString());
					quantidade = Integer.parseInt(edquantidade.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Cálculo incompleto");
					dialog.setMessage("Informe os números corretamente");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				switch(codigo) {
					case 100:
						lanche = "Cachorro quente";
						preco = quantidade * 1.5;
						break;
					case 101:
						lanche = "Bauru simples";
						preco = quantidade * 2.0;
						break;
					case 102:
						lanche = "Bauru c/ ovo";
						preco = quantidade * 2.3;
						break;
					case 103:
						lanche = "Hamburger";
						preco = quantidade * 2.0;
						break;
					case 104:
						lanche = "Cheseburger";
						preco = quantidade * 2.4;
						break;
					case 105:
						lanche = "Refrigerante";
						preco = quantidade * 1.5;
						break;
					default:
						status = false;
						AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
						dialog.setTitle("Código não disponível no cardápio");
						dialog.setMessage("Informe um código válido");
						dialog.setNeutralButton("OK", null);
						dialog.show();
				}
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Resultado:");
					dialog.setMessage(
							"Especificação pedido: " + lanche + "\n"
								+ "Quantidade pedido: " +  String.valueOf(quantidade) + "\n"
								+ "Valor total: " +  String.format("%.2f", preco) + "\n");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				edcodigo.setText("");
				edquantidade.setText("");
				edcodigo.requestFocus();
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
