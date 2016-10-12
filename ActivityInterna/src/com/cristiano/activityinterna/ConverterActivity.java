package com.cristiano.activityinterna;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConverterActivity extends Activity {

	EditText ednumero1;
	Button btnConverter, btnLimpar;
    double temp, fahrenheint;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_converter);
		
        ednumero1 = (EditText) findViewById(R.id.numero1);
        btnConverter = (Button) findViewById(R.id.btnConverter);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        temp = fahrenheint = 0.0;
        
        btnConverter.setOnClickListener(new View.OnClickListener() {
        	        	
			@Override
			public void onClick(View arg0) {
				
				boolean status = true;
				
				try {
					temp = Double.parseDouble(ednumero1.getText().toString());
				} catch (Exception e) {
					
					status = false;
					AlertDialog.Builder dialogo = new AlertDialog.Builder(ConverterActivity.this);
					dialogo.setTitle("Erro");
					dialogo.setMessage("Informe valores válidos");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
					
				}
				
				if (status) {
					fahrenheint = temp * 1.8 + 32;
					
					AlertDialog.Builder dialogo = new AlertDialog.Builder(ConverterActivity.this);
					dialogo.setTitle("Aviso");
					dialogo.setMessage(temp + " ºC é " + fahrenheint + " ºF");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				}
			}
		});
        
        btnLimpar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ednumero1.setText("");
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.converter, menu);
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
