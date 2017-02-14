package es.cice.proyectofinalthemoviedatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.cice.proyectofinalthemoviedatabase.R;
import es.cice.proyectofinalthemoviedatabase.model.Pelicula;

/**
 * Created by cice on 13/2/17.
 */

public class ListaPeliculas extends BaseAdapter{

    Context context;
    List<Pelicula> pelicula;
    private LayoutInflater layoutInflater;

    public ListaPeliculas(Context context, List<Pelicula> pelicula) {
        this.context = context;
        this.pelicula = pelicula;
    }

    @Override
    public int getCount() {
        return pelicula.size();
    }

    @Override
    public Object getItem(int position) {
        return pelicula.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pelicula.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista_elemento = null;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vista_elemento = layoutInflater.inflate(R.layout.lista_peliculas, parent, false);
        ImageView imageViewImagen = (ImageView) vista_elemento.findViewById(R.id.imageViewImagen);
        TextView textViewDescripcion = (TextView) vista_elemento.findViewById(R.id.textViewDescripcion);

        imageViewImagen.setImageBitmap(pelicula.get(position).getImage());
        textViewDescripcion.setText(
                pelicula.get(position).getTitle()
                        +"\n"+pelicula.get(position).getVote_average()
                        +"\n"+pelicula.get(position).getRelease_date()
                );


        return vista_elemento;
    }
}
