package com.example.kim.geoguessswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

// adds viewholder for the geoImage to the recyclerview
public class GeoObjectViewHolder extends RecyclerView.ViewHolder {
    public ImageView geoImage;
    public View view;

    public GeoObjectViewHolder(View itemView) {
        super(itemView);
        geoImage = itemView.findViewById(R.id.geoImageView);
        view = itemView;
    }
}
