package com.example.travelmalaysia.object;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelmalaysia.R;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyHolder>{

    Context context;
    ArrayList<ModelClass> arrayList;
    LayoutInflater layoutInflater;
    private OnItemClickListener mListener;
    private ArrayList<ModelClass> dataset;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public PlaceAdapter(Context context, ArrayList<ModelClass> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PlaceAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_file, parent, false);
        return new MyHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.MyHolder holder, int position) {
        holder.placeName.setText(arrayList.get(position).getPlaceName());
        holder.img.setImageResource(arrayList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView placeName;
        ImageView img;
        public MyHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            placeName = itemView.findViewById(R.id.txt);
            img = itemView.findViewById(R.id.img);

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

    public ArrayList<ModelClass> getDataset() {
        return dataset;
    }
}
