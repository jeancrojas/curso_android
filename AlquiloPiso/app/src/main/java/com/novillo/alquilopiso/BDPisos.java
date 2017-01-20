package com.novillo.alquilopiso;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 14/01/2017.
 */

public class BDPisos extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE pisos (direccion TEXT, lat REAL, lng REAL, metros TEXT, habitaciones TEXT, baños TEXT, precio TEXT, telefono TEXT, " +
            "foto1 TEXT, foto2 TEXT, foto3 TEXT, foto4 TEXT, foto5 TEXT, id TEXT)";

    public BDPisos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono, foto1, foto2, foto3, foto4, foto5, id) VALUES ('Calle Fuentecilla, 2', 40.357643, -3.906089, '90', '3', '2', '700 Euros', '616 583 221', " +
                "'fuentecilla_1.jpg', 'fuentecilla_2.jpg', 'fuentecilla_3.jpg', 'fuentecilla_4.jpg', 'fuentecilla_5.jpg', 'fuentecilla_')");
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono, foto1, foto2, foto3, foto4, foto5, id) VALUES ('Calle Guadarrama, 1', 40.357484, -3.905442, '80', '2', '2', '750 Euros', '656 881 642', " +
                "'guadarrama_1.jpg','guadarrama_2.jpg','guadarrama_3.jpg','guadarrama_4.jpg','guadarrama_5.jpg', 'guadarrama_')");
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono, foto1, foto2, foto3, foto4, foto5, id) VALUES ('Calle Los Arcos, 4', 40.293283, -3.744734, '100', '3', '2', '800 Euros', '696 350 722', " +
                "'arcos_1.jpg', 'arcos_2.jpg', 'arcos_3.jpg', 'arcos_4.jpg', 'arcos_5.jpg', 'arcos_')");
        db.execSQL("INSERT INTO pisos(direccion, lat, lng, metros, habitaciones, baños, precio, telefono, foto1, foto2, foto3, foto4, foto5, id) VALUES ('Calle Jorge Manrique, 14', 40.292514, -3.747438, '110', '4', '2', '850 Euros', '636 541 820', " +
                "'jorgemanrique_1.jpg', 'jorgemanrique_2.jpg', 'jorgemanrique_3.jpg', 'jorgemanrique_4.jpg', 'jorgemanrique_5.jpg', 'jorgemanrique_')");


        String path ="/storage/emulated/0/AlquiloPiso/fotos/";
        File dir = new File(path);
        dir.mkdirs();

        File f = new File(path, "alquilopiso.log");

        OutputStreamWriter fout = null;

        try {
            fout = new OutputStreamWriter(
                    new FileOutputStream(f));

        }
        catch (FileNotFoundException fnfe) {
            Log.d("tags", "error al crear archivo");
        }
        try {
            fout.write("alquilopiso creado");
            fout.close();
        }
        catch (IOException ioe){
            Log.d("tag", "error al cerrar archivo");
        }

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
                    listado.add(new Piso(c.getString(0), c.getDouble(1), c.getDouble(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11), c.getString(12), c.getString(13)));
                }while (c.moveToNext());
            }
            c.moveToFirst();
        }finally {
            c.close();
        }

        return listado;
    }

}
