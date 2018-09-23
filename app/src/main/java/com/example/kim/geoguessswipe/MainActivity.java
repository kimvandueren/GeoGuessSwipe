package com.example.kim.geoguessswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<GeoObject> mGeoObjects = new ArrayList<>();
        for (int i = 0; i < GeoObject.GEO_LOCATION_NAME.length; i++) {
            mGeoObjects.add(new GeoObject(GeoObject.GEO_LOCATION_NAME[i],
                    GeoObject.GEO_IMAGE_IDS[i]));
        }

        for (int i = 0; i < mGeoObjects.size(); i++) {
            GeoObject test = mGeoObjects.get(i);
            System.out.println(test.getmGeoName());
            System.out.println(test.getmGeoImageName());
        }

        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);
    }
}
