package com.novillo.spinner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cice on 20/12/16.
 */

public class VehiculosSQLiteHelper extends SQLiteOpenHelper {


    String sqlCreate = "CREATE TABLE DB_VEHICULOS(tipo TEXT, marca TEXT, modelo TEXT, matricula TEXT)";


    final static String nombre ="DB_VEHICULOS";
    final static SQLiteDatabase.CursorFactory factory = null;
    final static int version = 1;

    public VehiculosSQLiteHelper(Context contexto) {

        super(contexto, nombre, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL("INSERT INTO DB_VEHICULOS(tipo, marca, modelo, matricula) VALUES ('Furgoneta','Citroen', 'Jumper', '2587-BDD')");
        db.execSQL("INSERT INTO DB_VEHICULOS(tipo, marca, modelo, matricula) VALUES ('Coche','Opel', 'Astra', '9874-DDS')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Furgoneta','Citroen', 'Ducato', '3364-HJL')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Moto','Honda', 'CBR', '5555-JNO')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Moto','Yamaha', 'R1', '8910-JTS')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Ford', 'Mondeo', '4470-BZV')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Furgoneta','Mercedes', 'Vito', '6031-CCP')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Seat', 'Leon', '1183-FZN')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Toyota', 'Auris', '7814-GFF')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Moto','Ducati', 'Monster', '5083-GHT')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Furgoneta','Citroen', 'Jumper', '2587-BDD')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Moto','Yamaha', 'FZ600', '2148-DWP')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Seat', 'Ateca', '5561-JJL')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Furgoneta','Peugeot', 'Jumper', '2587-BDD')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Peugeot', '3008', '2587-BDD')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Furgoneta','Citroen', 'Berlingo', '5580-CDT')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Opel', 'Corsa', '9883-GGM')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Furgoneta','Citroen', 'Ducato', '3365-HJL')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Moto','Triumph', 'Bonneville', '5228-JNO')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Moto','Yamaha', 'R6', '7404-GHY')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Ford', 'Kugar', '8787-HLM')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Furgoneta','Mercedes', 'Vito', '5847-CXC')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Seat', 'Ibiza', '1877-DSK')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Coche','Toyota', 'Auris', '7814-GFF')");
        db.execSQL("INSERT INTO DB_VEHICULOS (tipo, marca, modelo, matricula) VALUES ('Moto','Ducati', '999R', '6099-GTP')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int iversionNueva) {
        db.execSQL("DROP TABLE IF EXISTS DB_VEHICULOS");
        //se crea la nueva version de la tabla
        db.execSQL(sqlCreate);
    }

    public List<Vehiculo> listadoVehiculos(String tipo) {

        String query = "select * from DB_VEHICULOS where tipo = '" + tipo + "'";

        List<Vehiculo> resultList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase() ;
        Cursor c = db.rawQuery(query, null);

        try{
            if (c.moveToFirst()) {
                do{
                    resultList.add(new Vehiculo(c.getString(0), c.getString(1), c.getString(2), c.getInt(3)));
                }while(c.moveToNext());
            }

            c.moveToFirst();
        }finally {
            c.close();
        }
        return resultList;
    }
}
