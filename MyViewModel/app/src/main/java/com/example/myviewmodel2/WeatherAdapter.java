package com.example.myviewmodel2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    ArrayList<WeathersItems> list = new ArrayList<>();


    public void setData(ArrayList<WeathersItems> items){
        list.clear();
        list.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weathers_item,parent,false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity,tvDesc,tvTemp;


        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCity = itemView.findViewById(R.id.tv_city);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvTemp = itemView.findViewById(R.id.tv_temp);
        }

        public void bind(WeathersItems weathersItems){
            tvCity.setText(weathersItems.getName());
            tvDesc.setText(weathersItems.getDesc());
            tvTemp.setText(weathersItems.getTemp());
        }

    }
}
