package com.example.calculodesalario;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btcalcular = (Button) findViewById(R.id.btcalcular);
        
        btcalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
			
				double salario, novosal = 0;
				EditText edsalario = (EditText) findViewById(R.id.edsalario);
				salario = Double.parseDouble(edsalario.getText().toString());
				RadioGroup rg = (RadioGroup) findViewById(R.id.rgopcoes);
				
				int op = rg.getCheckedRadioButtonId();
				if (op == R.id.rb40)
					novosal = salario + (salario * 0.4);
				else if (op == R.id.rb45)
					novosal = salario + (salario * 0.45);
				else if (op == R.id.rb50)
					novosal = salario + (salario * 0.50);
				
				AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
				dialog.setTitle("Novo Salário: ");
				dialog.setMessage("Seu novo salário é: R$" + String.valueOf(novosal));
				dialog.setNeutralButton("OK", null);
				dialog.show();
				
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
