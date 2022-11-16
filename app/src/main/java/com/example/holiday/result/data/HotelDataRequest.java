package com.example.holiday.result.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/*
one of the options to get the data:
save it in an API and make belonging requests
 */

public class HotelDataRequest {

    private static final String REQUEST_URL = "";
    private static final String API_KEY = "";

    private final String city;
    private final Context context;

    public HotelDataRequest(String city, Context context) {
        this.city = city;
        this.context = context;
    }

    //Volley-Framework
    public void run(RequestListener listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = REQUEST_URL.replace("{city name}", city).replace("{API key}", API_KEY);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {
                    listener.onResult(getHotelDataFromResponse(response));
                }, error -> {
                    Log.d("HotelDataRequest", "Fehler bei Erstellung des JsonObject");
                });
        queue.add(jsonObjectRequest);
    }

    private HotelData getHotelDataFromResponse(JSONObject response) {
        try {
            String city = response.getString("city");
            String name = response.getString("name");
            double stars = response.getJSONObject("main").getDouble("category_stars");
            double price = response.getJSONObject("main").getDouble("price");
            return new HotelData(city, name, stars, price);
        } catch (JSONException exception) {
            return null;
        }
    }

    public interface RequestListener {
        void onResult(HotelData data);

        void onQueryResult(List<HotelData> dataList);
    }

}



