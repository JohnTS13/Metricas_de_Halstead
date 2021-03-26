package com.example.mtricasdehalstead.Controlador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    private View view;
    private Spinner spinner;
    private TextView tv1, tv2, textCodigo;

    private EditText textN1, textn1, textN2, textn2, textN, textn, textV, textD, textL, textE, textT, textB;

    private Button btnCalcular;
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
        textCodigo = (TextView)view.findViewById(R.id.textCodigo);
        textN1 = (EditText)view.findViewById(R.id.editTextN1);
        textn1 = (EditText)view.findViewById(R.id.editTextTextn1);
        textN2 = (EditText)view.findViewById(R.id.editTextTextN2);
        textn2 = (EditText)view.findViewById(R.id.editTextTextn2);
        textN = (EditText)view.findViewById(R.id.editTextTextN);
        textn = (EditText)view.findViewById(R.id.editTextTextn);
        textV = (EditText)view.findViewById(R.id.editTextTextV);
        textD = (EditText)view.findViewById(R.id.editTextTextD);
        textL = (EditText)view.findViewById(R.id.editTextTextL);
        textE = (EditText)view.findViewById(R.id.editTextTextE);
        textT = (EditText)view.findViewById(R.id.editTextTextT);
        textB = (EditText)view.findViewById(R.id.editTextTextB);
        spinner = (Spinner)view.findViewById(R.id.codigos);

        btnCalcular = (Button)view.findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCodigo.setText("AQUI VA TODO EL CODIGO");
                textN1.setText("Aqui va N1");
                textn1.setText("Aqui va N1");
                textN2.setText("Aqui va N2");
                textn2.setText("Aqui va n2");
                textN.setText("Aqui va N");
                textn.setText("Aqui va n");
                textV.setText("Aqui va V");
                textD.setText("Aqui va D");
                textL.setText("Aqui va L");
                textE.setText("Aqui va E");
                textT.setText("Aqui va T");
                textB.setText("Aqui va B");
            }
        });
        String[] value = {"Codigo 1", "Codigo 2", "Codigo 3", "Codigo 4", "Codigo 5"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.style_spiner, arrayList);
        spinner.setAdapter(arrayAdapter);
        return view;

    }


}