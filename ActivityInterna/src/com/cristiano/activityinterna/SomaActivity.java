package com.cristiano.activityinterna;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SomaActivity extends Activity {

	EditText ednumero1, ednumero2;
	Button btnSomar, btnLimpar;
    double num1, num2, res;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soma);

        ednumero1 = (EditText) findViewById(R.id.numero1);
        ednumero2 = (EditText) findViewById(R.id.numero2);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        num1 = num2 = res = 0.0;

        btnSomar.setOnClickListener(new View.OnClickListener() {
        	        	
			@Override
			public void onClick(View arg0) {
				
				boolean status = true;
				
				try {
					num1 = Double.parseDouble(ednumero1.getText().toString());
					num2 = Double.parseDouble(ednumero2.getText().toString());
				} catch (Exception e) {
					
					status = false;
					AlertDialog.Builder dialogo = new AlertDialog.Builder(SomaActivity.this);
					dialogo.setTitle("Erro");
					dialogo.setMessage("Informe valores válidos");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
					
				}
				
				if (status) {
					res = num1 + num2;
					
					AlertDialog.Builder dialogo = new AlertDialog.Builder(SomaActivity.this);
					dialogo.setTitle("Aviso");
					dialogo.setMessage("A soma é " + res);
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				}
			}
		});
        
        btnLimpar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ednumero1.setText("");
				ednumero2.setText("");
				
			}
		});
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.soma, menu);
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
