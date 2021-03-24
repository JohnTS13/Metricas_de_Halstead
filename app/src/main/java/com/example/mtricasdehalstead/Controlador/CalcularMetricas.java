package com.example.mtricasdehalstead.Controlador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mtricasdehalstead.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalcularMetricas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalcularMetricas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private  View view;
    private Spinner spinner;
    private TextView tv1, tv2;
    public CalcularMetricas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalcularMetricas.
     */
    // TODO: Rename and change types and number of parameters
    public static CalcularMetricas newInstance(String param1, String param2) {
        CalcularMetricas fragment = new CalcularMetricas();
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

        view = inflater.inflate(R.layout.fragment_calcular_metricas, container, false);
        spinner = (Spinner)view.findViewById(R.id.codigos);

        String[] value = {"Codigo 1", "Codigo 2", "Codigo 3", "Codigo 4", "Codigo 5"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.style_spiner, arrayList);
        spinner.setAdapter(arrayAdapter);
        return view;

    }
}