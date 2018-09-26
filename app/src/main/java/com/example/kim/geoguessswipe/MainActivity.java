package com.example.kim.geoguessswipe;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<GeoObject> mGeoObjects = new ArrayList<>();
        for (int i = 0; i < GeoObject.GEO_LOCATION_NAME.length; i++) {
            mGeoObjects.add(new GeoObject(
                    GeoObject.GEO_LOCATION_NAME[i],
                    GeoObject.GEO_IMAGE_IDS[i],
                    GeoObject.IMAGE_IN_EUROPE[i]));
        }

        final RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        int position = (viewHolder.getAdapterPosition());
                        String snackbarMessage = " ";

                        if (swipeDir == ItemTouchHelper.LEFT){
                            if (mGeoObjects.get(position).getmImageInEurope() == true){
                                snackbarMessage = "Correct!";
                            } else {
                                snackbarMessage = "Wrong!";
                            }
                        } else {
                            if (mGeoObjects.get(position).getmImageInEurope() == false){
                                snackbarMessage = "Correct!";
                            } else {
                                snackbarMessage = "Wrong!";
                            }
                        }

                        Snackbar snackbar = Snackbar.make(mGeoRecyclerView, snackbarMessage, Snackbar.LENGTH_SHORT);
                        snackbar.show();

                        mGeoObjects.remove(position);
                        mAdapter.notifyItemRemoved(position);
                    }

                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);


    }
}
