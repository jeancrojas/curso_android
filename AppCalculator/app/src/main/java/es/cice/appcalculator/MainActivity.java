package es.cice.appcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int INTRODUCIENDO_VALORES = 0;
    public final static int INTRODUCIENDO_OPERADORES = 1;
    private TextView display;
    private Integer res;
    private Integer operando;
    private String operator;
    private int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.display);
        configurarBotonesNumericos ();
        configurarBotonesOperacion ();

    }

    private void configurarBotonesOperacion() {

        Button[] operationButton = {(Button) findViewById(R.id.btnSumar),
                (Button) findViewById(R.id.btnRestar),
                (Button) findViewById(R.id.btnMultiplicar),
                (Button) findViewById(R.id.btnDividir)

        };

        for (Button btn : operationButton) {
            btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    switch ( v.getId() ) {

                        case R.id.btnSumar:
                            display.setText(res);
                            operator = "+";
                            break;

                        case R.id.btnRestar:
                            operator = "-";
                            break;

                        case R.id.btnMultiplicar:
                            operator = "x";
                            break;

                        case R.id.btnDividir:
                            operator = "/";
                            break;

                    }


                }
            });
        }

    }

    private void configurarBotonesNumericos() {
        Button[] numericButtons = {(Button) findViewById(R.id.btn0),
                (Button) findViewById(R.id.btn1),
                (Button) findViewById(R.id.btn2),
                (Button) findViewById(R.id.btn3),
                (Button) findViewById(R.id.btn4),
                (Button) findViewById(R.id.btn5),
                (Button) findViewById(R.id.btn6),
                (Button) findViewById(R.id.btn7),
                (Button) findViewById(R.id.btn8),
                (Button) findViewById(R.id.btn9)
        };

        for (Button btn : numericButtons ) {
            btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    if ( state == MainActivity.INTRODUCIENDO_VALORES ) {
                        String value = display.getText().toString() + ((Button) v).getText().toString();

                        display.setText(value.replaceAll("^0+", ""));
                    }

                    String value = display.getText().toString() + ((Button)v).getText().toString();
                    display.setText(value.replaceAll("^0+", ""));
                }
            });
        }
    }
}
