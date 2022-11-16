package com.example.holiday.result;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/*
one of the options to process the data:
read the csv data and save the information e.g. in lists to call them
problem: csv data is too big
 */

public class Result {

    private Context context;
    private ArrayList<HotelFileEntry> hotelList;
    private ArrayList<OfferFileEntry> offerList;

    public Result(Context context) {
        this.context = context;
        getResults();
    }

    private void getResults() {
        try {
            File csvfile = new File(Environment.getExternalStorageDirectory() + "/hotels.csv");
            CSVReader reader = new CSVReader(new FileReader(csvfile.getAbsolutePath()));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }
    }

    public class HotelFileEntry {

        private final int id;
        private final String name;
        private final double latitude;
        private final double longitude;
        private final double category_stars;

        public HotelFileEntry(int id, String name, double latitude, double longitude, double category_stars) {
            this.id = id;
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
            this.category_stars = category_stars;
        }
    }

    public class OfferFileEntry {

        private final int hotelID;
        private final String departureDate;
        private final String returnDate;
        private final int countAdults;
        private final int countChildren;
        private final int price;
        private final String inBoundDepartureAirport;
        private final String inBoundArrivalAirport;
        private final String inBoundAirline;
        private final String inBoundArrivalDatetime;
        private final String outboundDepartureAirport;
        private final String outBoundArrivalAirport;
        private final String outboundAirline;
        private final String outboundArrivalDatetime;
        private final String mealtype;
        private final boolean oceanview;
        private final String roomtype;

        public OfferFileEntry(int hotelID, String departureDate, String returnDate, int countAdults, int countChildren, int price, String inBoundDepartureAirport,
                              String inBoundArrivalAirport, String inBoundAirline, String inBoundArrivalDatetime, String outboundDepartureAirport, String outBoundArrivalAirport, String outboundAirline,
                              String outboundArrivalDatetime, String mealtype, boolean oceanview, String roomtype) {

            this.hotelID = hotelID;
            this.departureDate = departureDate;
            this.returnDate = returnDate;
            this.countAdults = countAdults;
            this.countChildren = countChildren;
            this.price = price;
            this.inBoundDepartureAirport = inBoundDepartureAirport;
            this.inBoundArrivalAirport = inBoundArrivalAirport;
            this.inBoundAirline = inBoundAirline;
            this.inBoundArrivalDatetime = inBoundArrivalDatetime;
            this.outboundDepartureAirport = outboundDepartureAirport;
            this.outBoundArrivalAirport = outBoundArrivalAirport;
            this.outboundAirline = outboundAirline;
            this.outboundArrivalDatetime = outboundArrivalDatetime;
            this.mealtype = mealtype;
            this.oceanview = oceanview;
            this.roomtype = roomtype;
        }
    }
}
