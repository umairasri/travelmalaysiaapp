package com.example.travelmalaysia.object;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelmalaysia.FavDB;
import com.example.travelmalaysia.Objects.Place;
import com.example.travelmalaysia.R;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    ArrayList<Place> places;
    Context context;
    FavDB favDB;
    LayoutInflater layoutInflater;

    private OnItemClickListener mListener;
    private ArrayList<Place> dataset;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public PlacesAdapter(Context context, ArrayList<Place> places){

        this.places = places;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file,
                parent,false);

        favDB = new FavDB(context);
        //create table on first
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart) {
            createTableOnFirstStart();
        }

        return new ViewHolder(view, (OnItemClickListener) mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesAdapter.ViewHolder holder, int position) {
        final  Place place = places.get(position);

        readCursorData(place, holder);
        holder.imageView.setImageResource(place.getImageResource());
        holder.titleTextView.setText(place.getTitle());

//        holder.imageView.setImageResource(places.get(position).getImageResource());
//        holder.titleTextView.setText(places.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView;
        ImageButton favBtn;
        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            titleTextView = itemView.findViewById(R.id.txt);
            favBtn = itemView.findViewById(R.id.favBtn);

            //add to fav btn
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positon = getAdapterPosition();
                    Place place = places.get(positon);

                    if (place.getFavStatus().equals("0")){
                        place.setFavStatus("1");
                        favDB.insertIntoTheDatabase(place.getTitle(), place.getImageResource(),
                        place.getKey_id(), place.getFavStatus());

                        favBtn.setBackgroundResource(R.drawable.baseline_favorite_red_24);
                    }
                    else {
                        place.setFavStatus("0");
                        favDB.remove_fav(place.getKey_id());
                        favBtn.setBackgroundResource(R.drawable.baseline_favorite_border_24);
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    private void createTableOnFirstStart() {
        favDB.insertEmpty();

        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    private void readCursorData(Place place, ViewHolder viewHolder) {
        Cursor cursor = favDB.read_all_data(place.getKey_id());
        SQLiteDatabase db = favDB.getReadableDatabase();
        try {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVOURTIE_STATUS));
                place.setFavStatus(item_fav_status);

                //check fav status
                if (item_fav_status != null && item_fav_status.equals("1")) {
                    viewHolder.favBtn.setBackgroundResource(R.drawable.baseline_favorite_red_24);
                } else if (item_fav_status != null && item_fav_status.equals("0")) {
                    viewHolder.favBtn.setBackgroundResource(R.drawable.baseline_favorite_border_24);
                }
            }

        }
        finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }
    }

    public ArrayList<Place> getDataset() {
        return dataset;
    }


}
