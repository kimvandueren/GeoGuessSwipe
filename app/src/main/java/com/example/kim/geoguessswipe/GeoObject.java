package com.example.kim.geoguessswipe;

//sets the data model for the app
public class GeoObject {
    private String mGeoName;
    private int mGeoImageName;
    private boolean mImageInEurope;

    public GeoObject(String mGeoName, int mGeoImageName, boolean mImageInEurope) {
        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;
        this.mImageInEurope = mImageInEurope;
    }

    public String getmGeoName() {
        return mGeoName;
    }

    public void setmGeoName(String mGeoName) {
        this.mGeoName = mGeoName;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }

    public boolean getmImageInEurope() {
        return mImageInEurope;
    }

    public static final String[] GEO_LOCATION_NAME = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public static final int[] GEO_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static final boolean[] IMAGE_IN_EUROPE = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };
}
