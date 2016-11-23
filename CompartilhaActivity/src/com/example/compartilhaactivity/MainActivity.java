package com.example.compartilhaactivity;

import com.example.compartilhaactivity.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edvalor;
	Button btnEnviar;
	String valor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edvalor = (EditText) findViewById(R.id.txtvalor);
        btnEnviar = (Button) findViewById(R.id.btnenviar);
        
        btnEnviar.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				
				boolean status = true;
				
				try {
					valor = edvalor.getText().toString();
				} catch (Exception e) {
					
					status = false;
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
					dialogo.setTitle("Erro");
					dialogo.setMessage("Informe valores válidos");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
					
				}
				
				if (status) {
					Intent intentBundle = new Intent(MainActivity.this, SecondActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("valor", valor);
					intentBundle.putExtras(bundle);
					startActivity(intentBundle);
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
