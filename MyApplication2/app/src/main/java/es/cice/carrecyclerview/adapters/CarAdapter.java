package es.cice.carrecyclerview.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.cice.carrecyclerview.CarDetailActivity;
import es.cice.carrecyclerview.R;
import es.cice.carrecyclerview.model.Car;

/**
 * Created by cice on 20/1/17.
 */



public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private List<Car> carList;
    private Context ctx;

    public CarAdapter(List<Car> carList, Context ctx) {
        this.carList = carList;
        this.ctx = ctx;
    }
/*
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View row =  inflater.inflate(R.layout.row_car, null);
        ViewHolder holder = new ViewHolder(row);

        holder.carIV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("Adapter", "click en imagen car...");
                Intent intent = new Intent(ctx, CarDetailActivity.class);
                int positionClick;
                intent.putExtra();
            }
        });

        holder.carTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Adapter", "click en text car...");
            }
        });

        return holder;
    }

    */

    public CarAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View row = inflater.inflate(R.layout.row_car, parent , false);
        ViewHolder holder= new ViewHolder(row);

        holder.carIV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        holder.carIV.setImageResource(carList.get(position).getMiniatura());
        holder.carTV.setText(carList.get(position).getFabricante() + " " + carList.get(position).getModelo());

    }

    @Override
    public int getItemCount () {
        return carList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView carIV;
        private TextView carTV;

        public ViewHolder ( View itemView) {
            super (itemView);
            carIV = (ImageView) itemView.findViewById(R.id.carThumbIV);
            carTV = (TextView) itemView.findViewById(R.id.carNameIV);

            carIV.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Log.d("CarViewHolder","old position: "+getOldPosition());
                    Log.d("CarViewHolder", "layout position: "+getOldPosition());
                    Log.d("CarViewHolder", "adapter position: "+getOldPosition());

                    Intent intent = new Intent(ctx,CarDetailActivity.class );

                    intent.putExtra(CarDetailActivity.IMAGE_EXTRA, carList.get(getAdapterPosition()).getImage() );
                    intent.putExtra(CarDetailActivity.DESCRIPTION_EXTRA, carList.get(getAdapterPosition()).getDescripcion() );
                    intent.putExtra(CarDetailActivity.MAKER_EXTRA, carList.get(getAdapterPosition()).getFabricante() );
                    intent.putExtra(CarDetailActivity.MODEL_EXTRA, carList.get(getAdapterPosition()).getModelo() );

                    ctx.

                }
            });


        }








    }



}
