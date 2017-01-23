package es.cice.vehiculosdynamicfragments.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.cice.vehiculosdynamicfragments.CarDetailActivity;
import es.cice.vehiculosdynamicfragments.R;
import es.cice.vehiculosdynamicfragments.model.Car;

/**
 * Created by cice on 20/1/17.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private List<Car> carList;
    private Context ctx;

    public CarAdapter(Context ctx, List<Car> list){
        carList=list;
        this.ctx=ctx;
    }
    /*
    Este metodo se llama cada vez que sea necesario construir una nueva fila
     */
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Obtenemos el infater necesario para construir un fila definida en xml
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View row=inflater.inflate(R.layout.car_row,parent,false);
        ViewHolder holder=new ViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        holder.carIV.setImageResource(carList.get(position).getMiniatura());
        holder.carTV.setText(carList.get(position).getFabricante() + " " +
                carList.get(position).getModelo());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView carIV;
        private TextView carTV;

        public ViewHolder(View itemView) {
            super(itemView);
            carIV= (ImageView) itemView.findViewById(R.id.carThumbIV);
            carTV= (TextView) itemView.findViewById(R.id.carNameTV);
            carIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("CarViewHolder","old position: " + getOldPosition());
                    Log.d("CarViewHolder","layout position: " + getLayoutPosition());
                    Log.d("CarViewHolder","adapter position: " + getAdapterPosition());
                    Intent intent=new Intent(ctx,CarDetailActivity.class);
                    intent.putExtra(CarDetailActivity.IMAGEN_EXTRA,
                            carList.get(getAdapterPosition()).getImagen());
                    intent.putExtra(CarDetailActivity.DESCRIPCION_EXTRA,
                            carList.get(getAdapterPosition()).getDescripcion());
                    intent.putExtra(CarDetailActivity.FABRICANTE_EXTRA,
                            carList.get(getAdapterPosition()).getFabricante());
                    intent.putExtra(CarDetailActivity.MODELO_EXTRA,
                            carList.get(getAdapterPosition()).getModelo());
                    ctx.startActivity(intent);
                }
            });
        }
    }
}
