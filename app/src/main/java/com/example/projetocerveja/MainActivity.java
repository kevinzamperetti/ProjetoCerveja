package com.example.projetocerveja;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    TextView txtSeiscentos;
    EditText edtSeiscentos;
    TextView txtQuatrocentos;
    EditText edtQuatrocentos;
    TextView txtTrezentos;
    EditText edtTrezentos;
    Button btnCalcular;
    TextView edtAlerta;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide(); //esconde actionBar com nome do projeto

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSeiscentos = findViewById(R.id.edtSeiscentos);
        edtSeiscentos = (EditText) findViewById(R.id.edtSeiscentos);
        txtQuatrocentos = findViewById(R.id.txtQuatrocentos);
        edtQuatrocentos = (EditText) findViewById(R.id.edtQuatrocentos);
        txtTrezentos = findViewById(R.id.edtTrezentos);
        edtTrezentos = (EditText) findViewById(R.id.edtTrezentos);
        edtAlerta = (TextView) findViewById(R.id.edtAlerta);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1, num2, num3;
                double resultado1=999, resultado2=999, resultado3=999;

                if ( edtSeiscentos.getText().toString().trim().equals("") ) {
                    num1 = 0;
                } else {
                    num1 = Double.parseDouble(edtSeiscentos.getText().toString());
                }

                if ( edtQuatrocentos.getText().toString().trim().equals("") ) {
                    num2 = 0;
                } else {
                    num2 = Double.parseDouble(edtQuatrocentos.getText().toString());
                }

                if ( edtTrezentos.getText().toString().trim().equals("") ) {
                    num3 = 0;
                } else {
                    num3 = Double.parseDouble(edtTrezentos.getText().toString());
                }

                if ( num1 == 0 && num2 == 0 && num3 == 0) {
                    Toast.makeText(getApplicationContext(), getString(R.string.alerta_nenhum_valor_informado), Toast.LENGTH_LONG).show();
                }

                if( num1 > 0 ) {
                     resultado1 = num1 / 600;
                }
                if( num2 > 0 ) {
                     resultado2 = num2 / 473;
                }
                if( num3 > 0 ) {
                     resultado3 = num3 / 350;
                }

                if ( ( resultado1 < resultado2 ) && ( resultado1 < resultado3 ) ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this );
                    builder.setTitle( getString(R.string.atencao) );
                    builder.setMessage( getString(R.string.melhor_opcao_garrafa) );

                    builder.setPositiveButton( getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.show();
                }

                if ( ( resultado2 < resultado1 ) && ( resultado2 < resultado3 ) ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle( getString(R.string.atencao) );
                    builder.setMessage( getString(R.string.melhor_opcao_latao) );

                    builder.setPositiveButton( getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.show();
                }

                if ( ( resultado3 < resultado1 ) && ( resultado3 < resultado2 ) ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle( getString(R.string.atencao) );
                    builder.setMessage( getString(R.string.melhor_opcao_lata) );

                    builder.setPositiveButton( getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.show();
                }
            }
        });
    }
 }
