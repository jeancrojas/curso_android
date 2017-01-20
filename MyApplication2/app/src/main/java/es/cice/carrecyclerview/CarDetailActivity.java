package es.cice.carrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CarDetailActivity extends AppCompatActivity {

    public static final String IMAGE_EXTRA = "image";
    public static final String MODEL_EXTRA = "model";
    public static final String MAKER_EXTRA = "maker";
    public static final String DESCRIPTION_EXTRA = "description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        Intent intent = getIntent();

        int imageResource = intent.getIntExtra(IMAGE_EXTRA, 0);
        String modelo = intent.getStringExtra(MODEL_EXTRA);
        String fabricante = intent.getStringExtra(MAKER_EXTRA);
        String descripcion = intent.getStringExtra(DESCRIPTION_EXTRA);

        ImageView carImage = (ImageView) findViewById(R.id.carImage);
        TextView carDescription = (TextView) findViewById(R.id.carDetails);

        if ( imageResource != 0 ) {
            carImage.setImageResource(imageResource);
            carDescription.setText("Fabricante: "+fabricante+"\nModelo: "+modelo+"\nDescripcion: "+descripcion);
        }

    }
}
