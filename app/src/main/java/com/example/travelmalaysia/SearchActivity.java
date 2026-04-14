package com.example.travelmalaysia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

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
import com.example.travelmalaysia.Objects.Place;
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
import com.example.travelmalaysia.Sabah.DesaDairyFarmActivity;
import com.example.travelmalaysia.Sabah.MountKinabaluActivity;
import com.example.travelmalaysia.Sabah.SepilokOrangutanRehabilitationCentreActivity;
import com.example.travelmalaysia.Sarawak.BakoNationalParkActivity;
import com.example.travelmalaysia.Sarawak.KuchingEsplanadeActivity;
import com.example.travelmalaysia.Sarawak.NiahCaveActivity;
import com.example.travelmalaysia.Selangor.BatuCavesActivity;
import com.example.travelmalaysia.Selangor.SunwayLagoonActivity;
import com.example.travelmalaysia.Selangor.ZooNegaraActivity;
import com.example.travelmalaysia.Terengganu.MasjidKristalActivity;
import com.example.travelmalaysia.Terengganu.PulauKapasActivity;
import com.example.travelmalaysia.Terengganu.PulauRedangActivity;
import com.example.travelmalaysia.object.ModelClass;
import com.example.travelmalaysia.object.PlaceAdapter;
import com.example.travelmalaysia.object.PlacesAdapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;

//    ArrayList<ModelClass> arrayList = new ArrayList<ModelClass>();
//    ArrayList<ModelClass> searchList;

    ArrayList<Place> places = new ArrayList<>();

    String[] placeList = new String[]{"Legoland", "Don Hu Jurassic", "Sea Life", "Skybridge", "Lagenda Park", "Gunung Jerai Resort",
                                        "Min Fireflies", "Muzium Negeri", "Pasar Terapung", "Jonker Street", "Melaka River", "Menara Taming Sari",
                                        "Jelita Ostrich", "Ulu Bendul", "Uncle Wong Happy Farm", "Fraser Hill", "Genting Theme Park", "Kuantan 118",
                                        "Escape Penang", "Entopia Butterfly Farm", "Tropical Spice Garden", "Lost World of Tambun", "Pangkor Island", "Ipoh World",
                                        "Al Hussain Mosque", "Gua Kelam", "Hutan Lipur Bukit Ayer", "Desa Dairy Farm", "Mount Kinabalu", "Sepilok Orang Utan Rehabilitation Centre",
                                        "Bako National Park", "Kuching Esplanade", "Niah Cave", "Batu Caves", "Sunway Lagoon", "Zoo Negara",
                                        "Masjis Kristal", "Pulau Kapas", "Pulau Redang", "Aquaria KLCC", "Petrosains", "Sultan Abdul Samad Building"};

    int[] imgList = new int[]{
            R.drawable.johorlegoland,
            R.drawable.johorjurassicpark,
            R.drawable.johorsealife,
            R.drawable.skybridge,
            R.drawable.lagendapark,
            R.drawable.gunungjerairesort,
            R.drawable.min_fireflies,
            R.drawable.muziumnegeri,
            R.drawable.pasarterapung,
            R.drawable.jonker_street,
            R.drawable.melakariver,
            R.drawable.menaratamingsari,
            R.drawable.ostrichfarm,
            R.drawable.ulubendul,
            R.drawable.happy_farm,
            R.drawable.fraserhill,
            R.drawable.genting_theme,
            R.drawable.kuantantower,
            R.drawable.escapepenang,
            R.drawable.entopiapenang,
            R.drawable.tropicalspicegardenpenang,
            R.drawable.lostwordtambun,
            R.drawable.pulaupangkor,
            R.drawable.ipohworld,
            R.drawable.alhussainmosquefloating,
            R.drawable.guakelam,
            R.drawable.hutanlipurbukitayer,
            R.drawable.desadairyfarm,
            R.drawable.mountkinabalu,
            R.drawable.sepilok,
            R.drawable.bakonationalpark,
            R.drawable.kuchingesplanade,
            R.drawable.niahcave,
            R.drawable.batucaves,
            R.drawable.sunwaylagoon,
            R.drawable.zoonegara,
            R.drawable.masjidkristal,
            R.drawable.pulaukapas,
            R.drawable.pulauredang,
            R.drawable.aquariaklcc,
            R.drawable.petrosains,
            R.drawable.sultanabdulsamad
    };

//    int b = LegolandActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.recyclerView);
//        searchView = findViewById(R.id.searchView);

        for(int i = 0; i < placeList.length; i++) {
//            ModelClass model = new ModelClass();
//            model.setPlaceName(placeList[i]);
//            model.setImg(imgList[i]);
//            arrayList.add(model);

            Place place = new Place();
            place.setImageResource(imgList[i]);
            place.setTitle(placeList[i]);
            place.setKey_id(String.valueOf(i));
            place.setFavStatus("0");
            places.add(place);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
        recyclerView.setLayoutManager(layoutManager);

//        PlaceAdapter placeAdapter = new PlaceAdapter(SearchActivity.this, arrayList);
        PlacesAdapter placeAdapter = new PlacesAdapter( SearchActivity.this, places);
        recyclerView.setAdapter(placeAdapter);

        placeAdapter.setOnItemClickListener(new PlacesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click here
                String selectedPlace = places.get(position).getTitle();
//                String selectedPlace = places.get(position).getKey_id();


//                for (int i = 0; i  < 40; i++){
//                    if (String.valueOf(i) == selectedPlace){
//
//                    }
//                }
                // Example: launch different activities based on the clicked item
                if ("Legoland".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, LegolandActivity.class));
                }
                else if ("Don Hu Jurassic".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, JurassicActivity.class));
                }
                else if ("Sea Life".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, SeaLifeActivity.class));
                }
                else if ("Skybridge".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, SkybridgeActivity.class));
                }
                else if ("Lagenda Park".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, LagendaParkActivity.class));
                }
                else if ("Gunung Jerai Resort".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, GunungJeraiResortActivity.class));
                }
                else if ("Min Fireflies".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, MinFirefliesActivity.class));
                }
                else if ("Muzium Negeri".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, MuziumNegeriActivity.class));
                }
                else if ("Pasar Terapung".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, PasarTerapungActivity.class));
                }
                else if ("Jonker Street".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, JonkerStreetActivity.class));
                }
                else if ("Melaka River".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, MelakaRiverActivity.class));
                }
                else if ("Menara Taming Sari".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, MenaraTamingSariActivity.class));
                }
                else if ("Jelita Ostrich".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, JelitaOstrichActivity.class));
                }
                else if ("Ulu Bendul".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, UluBendulActivity.class));
                }
                else if ("Uncle Wong Happy Farm".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, UncleWongHappyFarmActivity.class));
                }
                else if ("Fraser Hill".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, FraserHIllActivity.class));
                }
                else if ("Genting Theme Parm".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, GentingThemeParkActivity.class));
                }
                else if ("Kuantan 118".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, Kuantan118Activity.class));
                }
                else if ("Escape Penang".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, EscapeActivity.class));
                }
                else if ("Entopia Butterfly Farm".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, EntopiaActivity.class));
                }
                else if ("Tropical Spice Garden".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, TropicalSpiceGardenActivity.class));
                }
                else if ("Lost World of Tambun".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, LostWorldTambunActivity.class));
                }
                else if ("Pangkor Island".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, PangkorIslandActivity.class));
                }
                else if ("Ipoh World".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, IpohWorldActivity.class));
                }
                else if ("Al Hussain Mosque".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, AlHussainMosqueActivity.class));
                }
                else if ("Gua Kelam".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, GuaKelamActivity.class));
                }
                else if ("Hutan Lipur Bukit Ayer".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, HutanLipurBukitAyerActivity.class));
                }
                else if ("Desa Dairy Farm".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, DesaDairyFarmActivity.class));
                }
                else if ("Mount Kinabalu".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, MountKinabaluActivity.class));
                }
                else if ("Sepilok Orang Utan Rehabilitation Centre".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, SepilokOrangutanRehabilitationCentreActivity.class));
                }
                else if ("Bako National Park".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, BakoNationalParkActivity.class));
                }
                else if ("Kuching Espalanade".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, KuchingEsplanadeActivity.class));
                }
                else if ("Niah Cave".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, NiahCaveActivity.class));
                }
                else if ("Batu Caves".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, BatuCavesActivity.class));
                }
                else if ("Sunway Lagoon".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, SunwayLagoonActivity.class));
                }
                else if ("Zoo Negara".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, ZooNegaraActivity.class));
                }
                else if ("Masjid Kristal".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, MasjidKristalActivity.class));
                }
                else if ("Pulau Kapas".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, PulauKapasActivity.class));
                }
                else if ("Pulau Redang".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, PulauRedangActivity.class));
                }
                else if ("Aquaria KLCC".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, AquariaActivity.class));
                }
                else if ("Petrosains".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, PetrosainsActivity.class));
                }
                else if ("Sultan Abdul Samad Building".equals(selectedPlace)) {
                    startActivity(new Intent(SearchActivity.this, SultanAbdulSamadActivity.class));
                }




                // Add more conditions for other places

                // Optionally, you can also close the SearchActivity after launching the new activity
                finish();
            }
        });//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
////                searchList = new ArrayList<>();
//                searchPlace = new ArrayList<>();
//
//                if(query.length()>0){
////                    for(int i = 0; i <arrayList.size() ; i++){
////                        if(arrayList.get(i).getPlaceName().toUpperCase().contains(query.toUpperCase())){
////                            ModelClass modelClass = new ModelClass();
////                            modelClass.setPlaceName(arrayList.get(i).getPlaceName());
////                            modelClass.setImg(arrayList.get(i).getImg());
////                            searchList.add(modelClass);
////                        }
////                    }
//
//                    for(int i = 0; i <places.size() ; i++){
//                        if(places.get(i).getTitle().toUpperCase().contains(query.toUpperCase())){
//                            Place place = new Place();
//                            place.setTitle(places.get(i).getTitle());
//                            place.setImageResource(places.get(i).getImageResource());
//                            searchPlace.add(place);
//                        }
//                    }
//
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
//                    recyclerView.setLayoutManager(layoutManager);
//
////                    PlaceAdapter placeAdapter = new PlaceAdapter(SearchActivity.this, searchList);
//                    PlacesAdapter placeAdapter = new PlacesAdapter(searchPlace, SearchActivity.this);
//
//                    recyclerView.setAdapter(placeAdapter);
//                }
//                else{
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
//                    recyclerView.setLayoutManager(layoutManager);
//
////                    PlaceAdapter placeAdapter = new PlaceAdapter(SearchActivity.this, arrayList);
//                    PlacesAdapter placeAdapter = new PlacesAdapter(places, SearchActivity.this);
//
//                    recyclerView.setAdapter(placeAdapter);
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                searchList = new ArrayList<>();
//                searchPlace = new ArrayList<>();
//
//                if(newText.length()>0){
////                    for(int i = 0; i <arrayList.size() ; i++){
////                        if(arrayList.get(i).getPlaceName().toUpperCase().contains(newText.toUpperCase())){
////                            ModelClass modelClass = new ModelClass();
////                            modelClass.setPlaceName(arrayList.get(i).getPlaceName());
////                            modelClass.setImg(arrayList.get(i).getImg());
////                            searchList.add(modelClass);
////                        }
////                    }
//
//                    for(int i = 0; i <places.size() ; i++){
//                        if(places.get(i).getTitle().toUpperCase().contains(newText.toUpperCase())){
//                            Place place = new Place();
//                            place.setTitle(places.get(i).getTitle());
//                            place.setImageResource(places.get(i).getImageResource());
//                            searchPlace.add(place);
//                        }
//                    }
//
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
//                    recyclerView.setLayoutManager(layoutManager);
//
////                    PlaceAdapter placeAdapter = new PlaceAdapter(SearchActivity.this, searchList);
//                    PlacesAdapter placeAdapter = new PlacesAdapter(searchPlace, SearchActivity.this);
//
//                    recyclerView.setAdapter(placeAdapter);
//                }
//                else{
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
//                    recyclerView.setLayoutManager(layoutManager);
//
////                    PlaceAdapter placeAdapter = new PlaceAdapter(SearchActivity.this, arrayList);
//                    PlacesAdapter placeAdapter = new PlacesAdapter(places, SearchActivity.this);
//
//                    recyclerView.setAdapter(placeAdapter);
//                }
//                return false;
//            }
//        });
    }
}