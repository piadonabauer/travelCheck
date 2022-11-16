package com.example.holiday.result.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holiday.result.data.HotelData;
import com.example.holiday.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//viewholder for representing the information

public class ResultViewHolder extends RecyclerView.ViewHolder {

    private TextView hotelName;
    private TextView hotelStars;
    private TextView hotelPrice;
    private LinearLayout emptyContainer;
    private FloatingActionButton button;

    public ResultViewHolder(@NonNull View itemView) {
        super(itemView);
        initUI();
    }

    private void initUI() {
        hotelName = itemView.findViewById(R.id.hotel_name);
        hotelStars = itemView.findViewById(R.id.item_stars);
        hotelPrice = itemView.findViewById(R.id.hotel_price);
        emptyContainer = itemView.findViewById(R.id.empty);
        button = itemView.findViewById(R.id.item_continue_button);
    }

    public void bindView(HotelData data) {
        hotelName.setText(data.name);
        switch ((int) data.stars) {
            case 0:
                hotelStars.setText("☆");
                break;
            case 1:
                hotelStars.setText("☆☆");
                break;
            case 2:
                hotelStars.setText("☆☆☆");
                break;
            case 3:
                hotelStars.setText("☆☆☆☆");
                break;
            case 4:
                hotelStars.setText("☆☆☆☆☆");
                break;
            case 5:
                hotelStars.setText("☆☆☆☆☆☆");
                break;
        }
        hotelPrice.setText("ab " + data.price + "€ pro Person");
        emptyContainer.removeAllViewsInLayout();
    }
}
