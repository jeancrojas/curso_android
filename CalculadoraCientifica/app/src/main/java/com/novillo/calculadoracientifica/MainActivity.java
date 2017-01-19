package com.novillo.calculadoracientifica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.novillo.calculadoracientifica.R.id.parender;
import static com.novillo.calculadoracientifica.R.id.pareniz;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean decimal         = false;
    boolean parentiz        = false;
    boolean parentder       = false;
    boolean restar          = false;
    boolean sumar           = false;
    boolean dividir         = false;
    boolean multiplicar     = false;
    boolean pi              = false;
    boolean raizCuad        = false;
    boolean tangente        = false;
    boolean coseno          = false;
    boolean seno            = false;
    boolean logaritmo       = false;
    boolean exponente       = false;
    boolean porcentaje      = false;

    double[] numeros = new double[20];
    double resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cero = (Button)findViewById(R.id.num0);
        cero.setOnClickListener(this);

        Button uno = (Button)findViewById(R.id.num1);
        uno.setOnClickListener(this);

        Button dos = (Button)findViewById(R.id.num2);
        dos.setOnClickListener(this);

        Button tres = (Button)findViewById(R.id.num3);
        tres.setOnClickListener(this);

        Button cuatro = (Button)findViewById(R.id.num4);
        cuatro.setOnClickListener(this);

        Button cinco = (Button)findViewById(R.id.num5);
        cinco.setOnClickListener(this);

        Button seis = (Button)findViewById(R.id.num6);
        seis.setOnClickListener(this);

        Button siete = (Button)findViewById(R.id.num7);
        siete.setOnClickListener(this);

        Button ocho = (Button)findViewById(R.id.num8);
        ocho.setOnClickListener(this);

        Button nueve = (Button)findViewById(R.id.num9);
        nueve.setOnClickListener(this);

        Button der = (Button)findViewById(R.id.parender);
        der.setOnClickListener(this);

        Button izq = (Button)findViewById(pareniz);
        izq.setOnClickListener(this);

        Button raiz = (Button)findViewById(R.id.raizcuad);
        raiz.setOnClickListener(this);

        Button tan = (Button)findViewById(R.id.tangente);
        tan.setOnClickListener(this);

        Button cos = (Button)findViewById(R.id.coseno);
        cos.setOnClickListener(this);

        Button sen = (Button)findViewById(R.id.seno);
        sen.setOnClickListener(this);

        Button log = (Button)findViewById(R.id.logaritmo);
        log.setOnClickListener(this);

        Button exp = (Button)findViewById(R.id.exponencial);
        exp.setOnClickListener(this);

        Button porc = (Button)findViewById(R.id.porciento);
        porc.setOnClickListener(this);

        Button del = (Button)findViewById(R.id.borrar);
        del.setOnClickListener(this);

        Button multiplicar = (Button)findViewById(R.id.multiplicacion);
        multiplicar.setOnClickListener(this);

        Button dividir = (Button)findViewById(R.id.division);
        dividir.setOnClickListener(this);

        Button sumar = (Button)findViewById(R.id.suma);
        sumar.setOnClickListener(this);

        Button restar = (Button)findViewById(R.id.menos);
        restar.setOnClickListener(this);

        Button igual = (Button)findViewById(R.id.igual);
        igual.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        TextView pantalla   = (TextView)findViewById(R.id.resultado);
        int seleccion       = v.getId();
        String a            = pantalla.getText().toString();// aqui guardamos lo introducido en pantalla
        try{

            switch (seleccion){
                case R.id.num0:
                    pantalla.setText(a+"0");
                    break;
                case R.id.num1:
                    pantalla.setText(a+"1");
                    break;
                case R.id.num2:
                    pantalla.setText(a+"2");
                    break;
                case R.id.num3:
                    pantalla.setText(a+"3");
                    break;
                case R.id.num4:
                    pantalla.setText(a+"4");
                    break;
                case R.id.num5:
                    pantalla.setText(a+"5");
                    break;
                case  R.id.num6:
                    pantalla.setText(a+"6");
                    break;
                case  R.id.num7:
                    pantalla.setText(a+"7");
                    break;
                case R.id.num8:
                    pantalla.setText(a+"8");
                    break;
                case R.id.num9:
                    pantalla.setText(a+"9");
                    break;
                case R.id.punto:
                    if(decimal == false){
                        pantalla.setText(a+".");
                        decimal = true;
                    }else return;
                    break;
                case R.id.parender:
                    if(parentder == false){
                        pantalla.setText(a+")");
                        parentder = true;
                    }else return;
                    break;
                case pareniz:
                    if(parentiz == false){
                        pantalla.setText(a+"(");
                        parentiz = true;
                    }else return;
                    break;
                case R.id.menos:
                    restar = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.suma:
                    sumar = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.division:
                    dividir = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.multiplicacion:
                    multiplicar = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.exponencial:
                    exponente = true;
                    numeros[0] = Double.parseDouble(a);
                    numeros[1] = Double.parseDouble(a);
                    pantalla.setText("^");
                    resultado = Math.pow(numeros[0], numeros[1]);
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.raizcuad:
                    raizCuad = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    resultado = Math.sqrt(numeros[0]);
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.tangente:
                    tangente = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    resultado = Math.tan(numeros[0]*Math.PI/180);
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.coseno:
                    coseno = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    resultado = Math.cos(numeros[0]*Math.PI/180);
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.seno:
                    seno = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    resultado = Math.sin(numeros[0]*Math.PI/180);
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.logaritmo:
                    logaritmo = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    resultado = Math.log(numeros[0]);
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.pi:
                    pi = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    resultado = Math.PI*numeros[0];
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.porciento:
                    porcentaje = true;
                    numeros[0] = Double.parseDouble(a);
                    pantalla.setText("");
                    resultado = numeros[0]*100/numeros[1];
                    pantalla.setText(String.valueOf(resultado));
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    break;
                case R.id.igual:
                    if(restar == true){
                        resultado = numeros[1] - numeros[2];
                        pantalla.setText((String.valueOf(resultado)));
                    }else if(sumar == true){
                        resultado = numeros[0] + numeros[1];
                        pantalla.setText((String.valueOf(resultado)));
                    }else if(dividir == true){
                        resultado = numeros[0] / numeros[1];
                        pantalla.setText((String.valueOf(resultado)));
                    }else if(multiplicar == true){
                        resultado = numeros[0]*numeros[1];
                        pantalla.setText((String.valueOf(resultado)));
                    }
                    decimal     = false;
                    parentder   = false;
                    parentiz    = false;
                    restar      = false;
                    sumar       = false;
                    dividir     = false;
                    multiplicar = false;
                    logaritmo   = false;
                    pi          = false;
                    seno        = false;
                    coseno      = false;
                    raizCuad    = false;
                    tangente    = false;
                    exponente   = false;
                    break;
                case R.id.borrar:
                    pantalla.setText("");
                    decimal     = false;
                    parentiz    = false;
                    parentder   = false;
                    break;
            }
        }catch (Exception e){
            pantalla.setText("Error");
        }

    }
}






















