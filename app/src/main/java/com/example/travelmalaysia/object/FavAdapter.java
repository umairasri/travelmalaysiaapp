package com.example.travelmalaysia.object;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelmalaysia.FavDB;
import com.example.travelmalaysia.Johor.JurassicActivity;
import com.example.travelmalaysia.Johor.LegolandActivity;
import com.example.travelmalaysia.Johor.SeaLifeActivity;
import com.example.travelmalaysia.Kedah.GunungJeraiResortActivity;
import com.example.travelmalaysia.Kedah.LagendaParkActivity;
import com.example.travelmalaysia.Kedah.SkybridgeActivity;
import com.example.travelmalaysia.Kelatan.MinFirefliesActivity;
import com.example.travelmalaysia.Kelatan.MuziumNegeriActivity;
import com.example.travelmalaysia.Kelatan.PasarTerapungActivity;
import com.example.travelmalaysia.KualaLumpur.AquariaActivity;
import com.example.travelmalaysia.KualaLumpur.PetrosainsActivity;
import com.example.travelmalaysia.KualaLumpur.SultanAbdulSamadActivity;
import com.example.travelmalaysia.Melaka.JonkerStreetActivity;
import com.example.travelmalaysia.Melaka.MelakaRiverActivity;
import com.example.travelmalaysia.Melaka.MenaraTamingSariActivity;
import com.example.travelmalaysia.NegeriSembilan.JelitaOstrichActivity;
import com.example.travelmalaysia.NegeriSembilan.UluBendulActivity;
import com.example.travelmalaysia.NegeriSembilan.UncleWongHappyFarmActivity;
import com.example.travelmalaysia.Objects.FavPlace;
import com.example.travelmalaysia.Pahang.FraserHIllActivity;
import com.example.travelmalaysia.Pahang.GentingThemeParkActivity;
import com.example.travelmalaysia.Pahang.Kuantan118Activity;
import com.example.travelmalaysia.Penang.EntopiaActivity;
import com.example.travelmalaysia.Penang.EscapeActivity;
import com.example.travelmalaysia.Penang.TropicalSpiceGardenActivity;
import com.example.travelmalaysia.Perak.IpohWorldActivity;
import com.example.travelmalaysia.Perak.LostWorldTambunActivity;
import com.example.travelmalaysia.Perak.PangkorIslandActivity;
import com.example.travelmalaysia.Perlis.AlHussainMosqueActivity;
import com.example.travelmalaysia.Perlis.GuaKelamActivity;
import com.example.travelmalaysia.Perlis.HutanLipurBukitAyerActivity;
import com.example.travelmalaysia.R;
import com.example.travelmalaysia.Sabah.DesaDairyFarmActivity;
import com.example.travelmalaysia.Sabah.MountKinabaluActivity;
import com.example.travelmalaysia.Sabah.SepilokOrangutanRehabilitationCentreActivity;
import com.example.travelmalaysia.Sarawak.BakoNationalParkActivity;
import com.example.travelmalaysia.Sarawak.KuchingEsplanadeActivity;
import com.example.travelmalaysia.Sarawak.NiahCaveActivity;
import com.example.travelmalaysia.SearchActivity;
import com.example.travelmalaysia.Selangor.BatuCavesActivity;
import com.example.travelmalaysia.Selangor.SunwayLagoonActivity;
import com.example.travelmalaysia.Selangor.ZooNegaraActivity;
import com.example.travelmalaysia.Terengganu.MasjidKristalActivity;
import com.example.travelmalaysia.Terengganu.PulauKapasActivity;
import com.example.travelmalaysia.Terengganu.PulauRedangActivity;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    private Context context;
    private List<FavPlace> favPlaceList;
    private FavDB favDB;



    public FavAdapter(Context context, List<FavPlace> favPlaceList){
        this.context = context;
        this.favPlaceList = favPlaceList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_place, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        favDB = new FavDB(context);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, int position) {
        holder.favTextView.setText(favPlaceList.get(position).getPlace_title());
        holder.favImageView.setImageResource(favPlaceList.get(position).getPlace_image());


    }

    @Override
    public int getItemCount() {
        return favPlaceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView favTextView;
        ImageButton favBtn;
        ImageView favImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favTextView = itemView.findViewById(R.id.favTextView);
            favImageView = itemView.findViewById(R.id.favImageView);
            favBtn = itemView.findViewById(R.id.favBtn);

            itemView.setOnClickListener(this);

            //remove from fav after click
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final FavPlace favPlace = favPlaceList.get(position);
                    favDB.remove_fav(favPlace.getKey_id());
                    removeItem(position);
                }
            });
        }

        @Override
        public void onClick(View v) {
            String selectedPlace = favPlaceList.get(getAdapterPosition()).getPlace_title();

            if ("Legoland".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), LegolandActivity.class));
            }
            else if ("Don Hu Jurassic".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), JurassicActivity.class));
            }
            else if ("Sea Life".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), SeaLifeActivity.class));
            }
            else if ("Skybridge".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), SkybridgeActivity.class));
            }
            else if ("Lagenda Park".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), LagendaParkActivity.class));
            }
            else if ("Gunung Jerai Resort".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), GunungJeraiResortActivity.class));
            }
            else if ("Min Fireflies".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), MinFirefliesActivity.class));
            }
            else if ("Muzium Negeri".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), MuziumNegeriActivity.class));
            }
            else if ("Pasar Terapung".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), PasarTerapungActivity.class));
            }
            else if ("Jonker Street".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), JonkerStreetActivity.class));
            }
            else if ("Melaka River".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), MelakaRiverActivity.class));
            }
            else if ("Menara Taming Sari".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), MenaraTamingSariActivity.class));
            }
            else if ("Jelita Ostrich".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), JelitaOstrichActivity.class));
            }
            else if ("Ulu Bendul".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), UluBendulActivity.class));
            }
            else if ("Uncle Wong Happy Farm".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), UncleWongHappyFarmActivity.class));
            }
            else if ("Fraser Hill".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), FraserHIllActivity.class));
            }
            else if ("Genting Theme Parm".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), GentingThemeParkActivity.class));
            }
            else if ("Kuantan 118".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), Kuantan118Activity.class));
            }
            else if ("Escape Penang".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), EscapeActivity.class));
            }
            else if ("Entopia Butterfly Farm".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), EntopiaActivity.class));
            }
            else if ("Tropical Spice Garden".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), TropicalSpiceGardenActivity.class));
            }
            else if ("Lost World of Tambun".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), LostWorldTambunActivity.class));
            }
            else if ("Pangkor Island".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), PangkorIslandActivity.class));
            }
            else if ("Ipoh World".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), IpohWorldActivity.class));
            }
            else if ("Al Hussain Mosque".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), AlHussainMosqueActivity.class));
            }
            else if ("Gua Kelam".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), GuaKelamActivity.class));
            }
            else if ("Hutan Lipur Bukit Ayer".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), HutanLipurBukitAyerActivity.class));
            }
            else if ("Desa Dairy Farm".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), DesaDairyFarmActivity.class));
            }
            else if ("Mount Kinabalu".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), MountKinabaluActivity.class));
            }
            else if ("Sepilok Orang Utan Rehabilitation Centre".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), SepilokOrangutanRehabilitationCentreActivity.class));
            }
            else if ("Bako National Park".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), BakoNationalParkActivity.class));
            }
            else if ("Kuching Espalanade".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), KuchingEsplanadeActivity.class));
            }
            else if ("Niah Cave".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), NiahCaveActivity.class));
            }
            else if ("Batu Caves".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), BatuCavesActivity.class));
            }
            else if ("Sunway Lagoon".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), SunwayLagoonActivity.class));
            }
            else if ("Zoo Negara".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), ZooNegaraActivity.class));
            }
            else if ("Masjid Kristal".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), MasjidKristalActivity.class));
            }
            else if ("Pulau Kapas".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), PulauKapasActivity.class));
            }
            else if ("Pulau Redang".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), PulauRedangActivity.class));
            }
            else if ("Aquaria KLCC".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), AquariaActivity.class));
            }
            else if ("Petrosains".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), PetrosainsActivity.class));
            }
            else if ("Sultan Abdul Samad Building".equals(selectedPlace)) {
                v.getContext().startActivity(new Intent(v.getContext(), SultanAbdulSamadActivity.class));
            }
            else if (v.getContext() == null){

            }


        }
    }

    private void removeItem(int position) {
        favPlaceList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,favPlaceList.size());
    }

}
