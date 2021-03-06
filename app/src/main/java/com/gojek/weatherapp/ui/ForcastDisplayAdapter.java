package com.gojek.weatherapp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gojek.weatherapp.R;
import com.gojek.weatherapp.model.ModifiedWeatherResponse;

import java.util.List;

public class ForcastDisplayAdapter extends RecyclerView.Adapter<ForcastDisplayAdapter.ApplicationViewHolder> {

    private List<ModifiedWeatherResponse> modifiedWeatherResponseList;
    private Context mContext;

    public ForcastDisplayAdapter(Context context, List<ModifiedWeatherResponse> modifiedWeatherResponses) {
        this.modifiedWeatherResponseList = modifiedWeatherResponses;
        mContext = context;
    }


    @NonNull
    @Override
    public ApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ApplicationViewHolder(parent.getContext(),parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationViewHolder holder, int position) {
        ModifiedWeatherResponse modifiedWeatherResponse = modifiedWeatherResponseList.get(position);
        holder.dataTwo.setText(modifiedWeatherResponse.getTemperature());
        holder.dataOne.setText(modifiedWeatherResponse.getDay());

    }

    @Override
    public int getItemCount() {
        return modifiedWeatherResponseList == null ? 0 : modifiedWeatherResponseList.size();
    }

    static class ApplicationViewHolder extends RecyclerView.ViewHolder {

        private TextView dataOne;
        private TextView dataTwo;

        public ApplicationViewHolder(Context context, ViewGroup parent) {
            this(LayoutInflater.from(context).inflate(R.layout.forcast_item, parent,false));
        }

        private ApplicationViewHolder(@NonNull View itemView) {
            super(itemView);
            dataOne = itemView.findViewById(R.id.data_one);
            dataTwo = itemView.findViewById(R.id.data_two);
        }
    }
}
