package com.example.novosalario;

import com.example.novosalario.MainActivity;
import com.example.novosalario.R;

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

	EditText edsalario;
	Button btcalcular, btlimpar;
	RadioGroup rg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btcalcular = (Button) findViewById(R.id.btcalcular);
        btlimpar = (Button) findViewById(R.id.btlimpar);
		edsalario = (EditText) findViewById(R.id.salario);
        
        btcalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
			
				Double salario, novosalario;
				salario = novosalario = 0.0;
				boolean status = true;
				
				try {
					salario = Double.parseDouble(edsalario.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
					dialog.setTitle("Cálculo incompleto");
					dialog.setMessage("Informe os números corretamente");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				rg = (RadioGroup) findViewById(R.id.rgopcoes);
				
				int op = rg.getCheckedRadioButtonId();
				
				if (op == R.id.p1)
					novosalario = salario + (salario * 0.015);
				else if (op == R.id.p2)
					novosalario = salario + (salario * 0.013);
				else if (op == R.id.p3)
					novosalario = salario + (salario * 0.011);
				else {
						status = false;
						AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
						dialog.setTitle("Escolha uma opção");
						dialog.setMessage("Cálculo incompleto");
						dialog.setNeutralButton("OK", null);
						dialog.show();
				}
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
					dialog.setTitle("Reajuste calculado");
					dialog.setMessage("O novo salário é: " + String.format("%.2f", novosalario));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
			}
		});
        
        btlimpar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				edsalario.setText("");
				
				if(rg.getCheckedRadioButtonId() == -1)
					edsalario.requestFocus();
				else {
					rg.clearCheck();
					edsalario.requestFocus();
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
