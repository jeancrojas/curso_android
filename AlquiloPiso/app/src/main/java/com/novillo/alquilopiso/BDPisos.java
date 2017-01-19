package com.novillo.alquilopiso;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 14/01/2017.
 */

public class BDPisos extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE pisos (direccion TEXT, lat REAL, lng REAL, metros TEXT, habitaciones TEXT, baños TEXT, precio TEXT, telefono TEXT)";

    public BDPisos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono) VALUES ('Calle Fuentecilla, 2', 40.357643, -3.906089, '90', '3', '2', '700 Euros', '616 583 221')");
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono) VALUES ('Calle Guadarrama, 1', 40.357484, -3.905442, '80', '2', '2', '750 Euros', '656 881 642')");
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono) VALUES ('Calle Los Arcos, 4', 40.293283, -3.744734, '100', '3', '2', '800 Euros', '696 350 722')");
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono) VALUES ('Calle Jorge Manrique, 14', 40.292514, -3.747438, '110', '4', '2', '850 Euros', '636 541 820')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS pisos");

        db.execSQL(sqlCreate);
    }

    public List<Piso> listadoPisos() {

        String query = "SELECT * FROM pisos";
        List<Piso> listado = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        try{
            if (c.moveToFirst()){
                do{
                    listado.add(new Piso(c.getString(0), c.getDouble(1), c.getDouble(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7)));
                }while (c.moveToNext());
            }
            c.moveToFirst();
        }finally {
            c.close();
        }

        return listado;
    }

}
