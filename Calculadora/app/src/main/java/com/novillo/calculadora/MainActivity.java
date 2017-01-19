package com.novillo.calculadora;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    //Botones de operaciones
    private final String MULTIPLICAR    = "MULTIPLICAR";
    private final String DIVIDIR        = "DIVIDIR";
    private final String RESTAR         = "RESTAR";
    private final String SUMAR          = "SUMAR";
    private final String IGUAL          = "IGUAL";
    private final String PUNTO          = "PUNTO";

    private String stringOperando   = "";
    private Double operando1        = 0.0, resultado = 0.0;
    private String operacion        = "";
    private boolean existeDecimal   = false;

    //estados
    private final String INICIO    = "INICIO";
    private String estado = INICIO;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Salvamos el estado para cuando gira la pantalla
        if (savedInstanceState!=null){
            estado = savedInstanceState.getString("estado");
            stringOperando = savedInstanceState.getString("stringOperando");
            operando1 = savedInstanceState.getDouble("operando1");
            resultado = savedInstanceState.getDouble("resultado");
            operacion = savedInstanceState.getString("operacion");
            existeDecimal = savedInstanceState.getBoolean("existeDecimal");

            if (estado.equals(INICIO)){
                mostrarPantalla(resultado.toString());
            }
            else mostrarPantalla(stringOperando);
        }


        Button boton0 = (Button)findViewById(R.id.boton0);
        boton0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("0");  }
        } );

        Button boton1 = (Button)findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("1");  }
        } );

        Button boton2 = (Button)findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("2");  }
        } );

        Button boton3 = (Button)findViewById(R.id.boton3);
        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("3");  }
        } );

        Button boton4 = (Button)findViewById(R.id.boton4);
        boton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("4");  }
        } );

        Button boton5 = (Button)findViewById(R.id.boton5);
        boton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("5");  }
        } );

        Button boton6 = (Button)findViewById(R.id.boton6);
        boton6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("6");  }
        } );

        Button boton7 = (Button)findViewById(R.id.boton7);
        boton7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("7");  }
        } );

        Button boton8 = (Button)findViewById(R.id.boton8);
        boton8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("8");  }
        } );

        Button boton9 = (Button)findViewById(R.id.boton9);
        boton9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton ("9");  }
        } );


        Button sumar = (Button)findViewById(R.id.botonSumar);
        sumar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton (SUMAR);  }
        } );

        Button restar = (Button)findViewById(R.id.botonRestar);
        restar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton (RESTAR);  }
        } );

        Button multiplicar = (Button)findViewById(R.id.botonMultiplicar);
        multiplicar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ capturaBoton (MULTIPLICAR);  }
        } );

        Button dividir = (Button)findViewById(R.id.botonDividir);
        dividir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                capturaBoton (DIVIDIR);
            }
        } );

        Button punto = (Button)findViewById(R.id.botonPunto);
        punto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                capturaBoton (PUNTO);
            }
        } );

        Button igual = (Button)findViewById(R.id.botonIgual);
        igual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                capturaBoton (IGUAL);
            }
        } );

        /*SharedPreferences sharedPreferences;
        sharedPreferences.getString(getColor())*/
    }



    private void capturaBoton(String botonPulsado){

        //Numero máximo de dígitos permitidos
        final int MAX_DIGITOS = 16;

        //valores de los numeros y operacion
        final String OPERANDO1 = "OPERANDO1";
        final String OPERACION = "OPERACION";
        final String OPERANDO2 = "OPERANDO2";

        switch (botonPulsado) {

            case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9": {

                if (estado.equals(INICIO)){
                    estado = OPERANDO1;
                }

                if (estado.equals(OPERACION)) {
                    estado = OPERANDO2;
                }

                if (stringOperando.length()>=MAX_DIGITOS){
                    Toast.makeText(context,R.string.max_superado,Toast.LENGTH_SHORT).show();
                }
                else{
                    stringOperando += botonPulsado;
                }

                mostrarPantalla(stringOperando);
                break;
            }

            case DIVIDIR: case MULTIPLICAR: case SUMAR: case RESTAR: {
                if (estado.equals(OPERANDO1)) {

                    operando1 = Double.parseDouble(stringOperando);
                    stringOperando="";
                    estado = OPERACION;
                    existeDecimal = false;
                    operacion = botonPulsado;
                }
                break;
            }

            case PUNTO:{

                if (!existeDecimal){
                    stringOperando += ".";
                    existeDecimal = true;
                    mostrarPantalla(stringOperando);
                }
                break;
            }

            case IGUAL: {
                if (estado.equals(OPERANDO2)) {

                    Double operando2 = Double.parseDouble(stringOperando);
                    stringOperando="";
                    estado = INICIO;
                    existeDecimal = false;
                    resultado = calcular (operando1,operando2,operacion);
                    mostrarPantalla(resultado.toString());
                    operacion = String.valueOf("");
                }
                break;
            }
        }
    }

    private void mostrarPantalla (String text){

        TextView pantalla = (TextView)findViewById(R.id.pantalla);
        pantalla.setText(text);
    }

    private double calcular (double num1, double num2, String operacion){

        double resultado=0.0;

        switch (operacion){

            case DIVIDIR:
                resultado =  num1 / num2;
                break;

            case MULTIPLICAR:

                resultado =  num1 * num2;
                break;

            case SUMAR:

                resultado = num1 + num2;
                break;

            case RESTAR:

                resultado = num1 - num2;
                break;

        }

        return resultado;
    }



    //Salvamos el estado para cuando gira la pantalla

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putString("estado",estado);
        savedInstanceState.putString("stringOperando",stringOperando);
        savedInstanceState.putDouble("operando1",operando1);
        savedInstanceState.putDouble("resultado",resultado);
        savedInstanceState.putString("operacion", (operacion));
        savedInstanceState.putBoolean("existeDecimal", existeDecimal);

        super.onSaveInstanceState(savedInstanceState);
    }

    //Para el menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.config:
                startActivity(new Intent(context, Main2Activity.class));
        }


        return true;
    }
}

