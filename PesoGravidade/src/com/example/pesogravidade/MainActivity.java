package com.example.pesogravidade;

import com.example.pesogravidade.MainActivity;
import com.example.pesogravidade.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	
	EditText edpeso;
	Button btcalcular, btlimpar;
	RadioGroup rg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btcalcular = (Button) findViewById(R.id.btcalcular);
        btlimpar = (Button) findViewById(R.id.btlimpar);
		edpeso = (EditText) findViewById(R.id.edpeso);
        
        btcalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
			
				double pesoterra, pesoplaneta;
				String planeta = "";
				pesoterra = pesoplaneta = 0.0;
				boolean status = true;
				
				try {
					pesoterra = Double.parseDouble(edpeso.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
					dialog.setTitle("Cálculo incompleto");
					dialog.setMessage("Informe os números corretamente");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				rg = (RadioGroup) findViewById(R.id.rgopcoes);
				
				int planetaid = rg.getCheckedRadioButtonId();
				
				if (planetaid == R.id.p1) {
						planeta = "MERCÚRIO";
						pesoplaneta = pesoterra / 10 * 0.37;
				} else if (planetaid == R.id.p2) {
						planeta = "VÊNUS";
						pesoplaneta = pesoterra / 10 * 0.88;
				} else if (planetaid == R.id.p3) {
						planeta = "MARTE";
						pesoplaneta = pesoterra / 10 * 0.38;
				} else if (planetaid == R.id.p4) {
						planeta = "JÚPITER";
						pesoplaneta = pesoterra / 10 * 2.64;
				} else if (planetaid == R.id.p5) {
						planeta = "SATURNO";
						pesoplaneta = pesoterra / 10 * 1.15;
				} else if (planetaid == R.id.p6) {
						planeta = "URANO";
						pesoplaneta = pesoterra / 10 * 1.17;
				} else {
						status = false;
						AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
						dialog.setTitle("Escolha uma opção");
						dialog.setMessage("Cálculo incompleto");
						dialog.setNeutralButton("OK", null);
						dialog.show();
				}
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
					dialog.setTitle("Peso calculado");
					dialog.setMessage("O peso em " + planeta + " é: " + String.format("%.2f", pesoplaneta));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
			}
		});
        
        btlimpar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				edpeso.setText("");
				
				if(rg.getCheckedRadioButtonId() == -1)
					edpeso.requestFocus();
				else {
					rg.clearCheck();
					edpeso.requestFocus();
				}
				
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
