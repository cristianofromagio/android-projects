package com.example.calculadora;

import com.example.calculadora.MainActivity;
import com.example.calculadora.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	
	EditText ednum1, ednum2;
	Button btcalcular, btlimpar;
	RadioGroup rg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btcalcular = (Button) findViewById(R.id.btcalcular);
        btlimpar = (Button) findViewById(R.id.btlimpar);
		ednum1 = (EditText) findViewById(R.id.ednum1);
		ednum2 = (EditText) findViewById(R.id.ednum2);
        
        btcalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
			
				double num1, num2, resultado;
				num1 = num2 = resultado = 0;
				boolean status = true;
				
				try {
					num1 = Double.parseDouble(ednum1.getText().toString());
					num2 = Double.parseDouble(ednum2.getText().toString());
				} catch (Exception e) {
					status = false;
					AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
					dialog.setTitle("Informe os números corretamente");
					dialog.setMessage("Cálculo incompleto");
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
				
				rg = (RadioGroup) findViewById(R.id.rgopcoes);
				
				int op = rg.getCheckedRadioButtonId();
				
				if (op == R.id.soma)
					resultado = num1 + num2;
				else if (op == R.id.sub)
					resultado = num1 - num2;
				else if (op == R.id.mult)
					resultado = num1 * num2;
				else if (op == R.id.div)
					resultado = num1 / num2;
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
					dialog.setTitle("Valor calculado: ");
					dialog.setMessage("O resultado é: " + String.valueOf(resultado));
					dialog.setNeutralButton("OK", null);
					dialog.show();
				}
			}
		});
        
        btlimpar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ednum1.setText("");
				ednum2.setText("");
				
				if(rg.getCheckedRadioButtonId() == -1) {
					//verifica se há algum radio selecionado
					ednum1.requestFocus();
				} else {
					rg.clearCheck();
					ednum1.requestFocus();
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
    
}
