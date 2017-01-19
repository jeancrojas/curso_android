package cice.testdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        editText.setText("");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editText.getText().toString();

                if (texto.equalsIgnoreCase("ocultar")){
                 textView.setVisibility(View.GONE);
                }
                else {
                    String saludo = "Hola " + texto;
                    textView.setText(saludo);
                }
            }
        });
    }
}
