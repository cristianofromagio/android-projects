package com.example.tabuada;

import com.example.tabuada.MainActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText ednum;
	Button btcalcular, btlimpar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ednum = (EditText) findViewById(R.id.num);
		btcalcular = (Button) findViewById(R.id.btcalcular);
		btlimpar = (Button) findViewById(R.id.btlimpar);
		
		btcalcular.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Integer num, i;
				String msg;
				Boolean status = true;
				
				num = i = 0;
				msg = "";
				
				try {
					num = Integer.parseInt(ednum.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Cálculo incompleto");
					dialog.setMessage("Informe os números corretamente");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				i = 1;
				
				while (i <= 10) {
					msg += num + " x " + i + " = " + (num * i) + "\n";
					i++;
				}
				
				if (status) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("Tabuada do número " + String.valueOf(num));
					dialog.setMessage(msg);
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
			}

		});
		
		btlimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ednum.setText("");
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
