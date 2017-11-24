package com.example.ryan.firstapidemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ryan.firstapidemo.model.CakeModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 22/11/2017.
 */

public class CakesAdapter extends RecyclerView.Adapter<CakesAdapter.MyViewHolder> {

    private List<CakeModel> cakes;
    private int row_cakes;
    private Context applicationContext;

    public CakesAdapter(List<CakeModel> cakes, int row_cakes, Context applicationContext) {
        this.cakes = cakes;
        this.row_cakes = row_cakes;
        this.applicationContext = applicationContext;
    }

    @Override
    public CakesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(applicationContext).inflate(row_cakes, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CakesAdapter.MyViewHolder holder, int position) {

        holder.cakeName.setText(cakes.get(position).getTitle());
        holder.cakeDesc.setText(cakes.get(position).getDesc());
        Picasso.with(holder.cakeImage.getContext()).load(cakes.get(position).getImage()).into(holder.cakeImage);

    }

    @Override
    public int getItemCount() {
        return cakes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cakeName, cakeDesc;
        ImageView cakeImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            cakeName=(TextView)itemView.findViewById(R.id.cakeName);
            cakeDesc=(TextView)itemView.findViewById(R.id.cakeDesc);
            cakeImage=(ImageView)itemView.findViewById(R.id.cakeImage);

        }
    }
}
