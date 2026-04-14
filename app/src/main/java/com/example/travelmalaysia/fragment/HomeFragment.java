package com.example.travelmalaysia.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travelmalaysia.Johor.LegolandActivity;
import com.example.travelmalaysia.Kedah.SkybridgeActivity;
import com.example.travelmalaysia.Kelatan.MinFirefliesActivity;
import com.example.travelmalaysia.Melaka.JonkerStreetActivity;
import com.example.travelmalaysia.NegeriSembilan.UncleWongHappyFarmActivity;
import com.example.travelmalaysia.Pahang.GentingThemeParkActivity;
import com.example.travelmalaysia.R;
import com.example.travelmalaysia.SearchActivity;
import com.example.travelmalaysia.object.RCModel;
import com.example.travelmalaysia.object.RCadapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<RCModel> modelArrayList;
    RCadapter rCadapter;

    TextView txt_search;

    CardView legolandcv, skybridgecv, minfliescv, jonkercv, happyfarmcv, gentingcv;

    String[] title = new String[]{
            "Johor", "Kedah", "Kelantan", "Melaka", "Negeri Sembilan", "Pahang",
            "Penang", "Perak", "Perlis", "Sabah", "Sarawak", "Selangor", "Terengganu", "Kuala Lumpur"
    };

    int[] image = new int[]{
            R.drawable.johor, R.drawable.kedah, R.drawable.kelantan, R.drawable.melaka, R.drawable.negeri_sembilan,
            R.drawable.pahang, R.drawable.penang, R.drawable.perak, R.drawable.perlis, R.drawable.sabah, R.drawable.sarawak,
            R.drawable.selangor, R.drawable.terengganu, R.drawable.kuala_lumpur
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        modelArrayList = new ArrayList<>();
        rCadapter = new RCadapter(getActivity(), modelArrayList);
        recyclerView.setAdapter(rCadapter);

        legolandcv = view.findViewById(R.id.legoland_cv);
        skybridgecv = view.findViewById(R.id.skybridge_cv);
        minfliescv = view.findViewById(R.id.minfireflies_cv);
        jonkercv = view.findViewById(R.id.jonker_cv);
        happyfarmcv = view.findViewById(R.id.happyfarm_cv);
        gentingcv = view.findViewById(R.id.genting_cv);

        for (int i = 0; i < title.length; i++) {
            RCModel rcModel = new RCModel(title[i], image[i]);
            modelArrayList.add(rcModel);
        }
        rCadapter.notifyDataSetChanged();

        txt_search = view.findViewById(R.id.txt_search);
        txt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        legolandcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LegolandActivity.class);
                startActivity(intent);
            }
        });
        skybridgecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SkybridgeActivity.class);
                startActivity(intent);
            }
        });
        minfliescv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MinFirefliesActivity.class);
                startActivity(intent);
            }
        });
        jonkercv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JonkerStreetActivity.class);
                startActivity(intent);
            }
        });
        happyfarmcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UncleWongHappyFarmActivity.class);
                startActivity(intent);
            }
        });
        gentingcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GentingThemeParkActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}