package com.example.travelmalaysia.object;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelmalaysia.state.JohorActivity;
import com.example.travelmalaysia.state.KedahActivity;
import com.example.travelmalaysia.state.KelantanActivity;
import com.example.travelmalaysia.state.KualaLumpurActivity;
import com.example.travelmalaysia.state.MelakaActivity;
import com.example.travelmalaysia.state.NegeriSembilanActivity;
import com.example.travelmalaysia.state.PahangActivity;
import com.example.travelmalaysia.state.PenangActivity;
import com.example.travelmalaysia.state.PerakActivity;
import com.example.travelmalaysia.state.PerlisActivity;
import com.example.travelmalaysia.R;
import com.example.travelmalaysia.state.SabahActivity;
import com.example.travelmalaysia.state.SarawakActivity;
import com.example.travelmalaysia.state.SelangorActivity;
import com.example.travelmalaysia.state.TerengganuActivity;

import java.util.ArrayList;

public class RCadapter extends RecyclerView.Adapter<RCadapter.RCViewHolder> {

    FragmentActivity context;
    ArrayList<RCModel> modelArrayList;

    public RCadapter(FragmentActivity context, ArrayList<RCModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public RCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rc_item, parent, false);
        return new RCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCViewHolder holder, int position) {
        RCModel rcModel = modelArrayList.get(position);
        holder.rc_title.setText(rcModel.title);
        holder.rc_image.setImageResource(rcModel.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailsActivity(rcModel.title);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    private void openDetailsActivity(String selectedItemTitle) {
        Intent intent;
        switch (selectedItemTitle) {
            case "Johor":
                intent = new Intent(context, JohorActivity.class);
                context.startActivity(intent);
                break;
            case "Kedah":
                intent = new Intent(context, KedahActivity.class);
                context.startActivity(intent);
                break;
            case "Kelantan":
                intent = new Intent(context, KelantanActivity.class);
                context.startActivity(intent);
                break;
            case "Melaka":
                intent = new Intent(context, MelakaActivity.class);
                context.startActivity(intent);
                break;
            case "Negeri Sembilan":
                intent = new Intent(context, NegeriSembilanActivity.class);
                context.startActivity(intent);
                break;
            case "Pahang":
                intent = new Intent(context, PahangActivity.class);
                context.startActivity(intent);
                break;
            case "Penang":
                intent = new Intent(context, PenangActivity.class);
                context.startActivity(intent);
                break;
            case "Perak":
                intent = new Intent(context, PerakActivity.class);
                context.startActivity(intent);
                break;
            case "Perlis":
                intent = new Intent(context, PerlisActivity.class);
                context.startActivity(intent);
                break;
            case "Sabah":
                intent = new Intent(context, SabahActivity.class);
                context.startActivity(intent);
                break;
            case "Sarawak":
                intent = new Intent(context, SarawakActivity.class);
                context.startActivity(intent);
                break;
            case "Selangor":
                intent = new Intent(context, SelangorActivity.class);
                context.startActivity(intent);
                break;
            case "Terengganu":
                intent = new Intent(context, TerengganuActivity.class);
                context.startActivity(intent);
                break;
            case "Kuala Lumpur":
                intent = new Intent(context, KualaLumpurActivity.class);
                context.startActivity(intent);
                break;




        }


    }
    public class RCViewHolder extends RecyclerView.ViewHolder{
        ImageView rc_image;
        TextView rc_title;
        public RCViewHolder(@NonNull View itemView) {
            super(itemView);

            rc_image = itemView.findViewById(R.id.rc_image);
            rc_title = itemView.findViewById(R.id.rc_title);
        }
    }
}
