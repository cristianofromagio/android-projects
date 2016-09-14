package com.example.calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText ednumero1, ednumero2;
	Button btnSomar, btnLimpar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //usando a classe R para fazer a ligação java -- xml
        ednumero1 = (EditText) findViewById(R.id.numero1);
        ednumero2 = (EditText) findViewById(R.id.numero2);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        //registrando o botão no seu listenner (interface)
        btnSomar.setOnClickListener(new View.OnClickListener() {
        	        	
			@Override
			public void onClick(View arg0) {
				double num1 = Double.parseDouble(ednumero1.getText().toString());
				double num2 = Double.parseDouble(ednumero2.getText().toString());
				double res = num1 + num2;
				
				AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
				dialogo.setTitle("Aviso");
				dialogo.setMessage("A soma é " + res);
				dialogo.setNeutralButton("OK", null);
				dialogo.show();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
