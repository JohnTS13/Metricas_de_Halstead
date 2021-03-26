package com.example.mtricasdehalstead.Controlador;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mtricasdehalstead.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

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
    private static String Codigo= "";
    private static int n1=0, n2=0, N1=0, N2=0;
    private static List<String> Operadores = new ArrayList<String>();
    private static List<String> Operandos = new ArrayList<String>();
    private static int n = 0, N = 0;
    private static double V = 0,  D = 0, L = 0, E = 0, T = 0, B = 0;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private Spinner spinner;
    private TextView tv1, tv2, textCodigo;

    private EditText textN1, textn1, textN2, textn2, textN, textn, textV, textD, textL, textE, textT, textB;

    private Button btnCalcular, btnGuardar;
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

    public static void Boton() {
        String cadena = "";
        Limpiar();
        cadena = "public class ejercicio52 { ++ class ";
        Log.d("Cadena", "Cadena: "+cadena);
        Imprime(cadena);
        Saltos(cadena);
        N1 = UnaVez(Operadores);
        N2 = UnaVez(Operandos);
        Log.d("n1", "n1: "+n1);
        Log.d("n1", "n2: "+n2);
        Log.d("N1", "N1: "+N1);
        Log.d("N2", "N2: "+N2);
        Log.d("titulo", "*** MÉTRICAS **");
        Calcular_méticas ();

    }

    private static void Limpiar() {
        n1=0;
        n2=0;
        N1=0;
        N2=0;
        n=0;
        N=0;
        V=0;
        D=0;
        L=0;
        E=0;
        T=0;
        B=0;
        Operadores.clear();
        Operandos.clear();
    }

    private static void Calcular_méticas() {
        n = n1 + n2; //Vocabulario del programa P
        N = N1 + N2; // Longitud del programa P
        V = N * (Math.log(n) / Math.log(2)); // Volumen del programa P
        D = (n1/2) * (N2/n2); // Dificultad del programa
        L = 1/D ; // Nivel del programa
        E = D * V;//Esfuerzo de implementación
        T = E/18; // Tiempo de implementación
        B = (Math.pow(E, (2/3)))/3000; // N° de bugs liberados

        Log.d("n", "n(Vocabulario) = "+n);
        Log.d("N", "N(Longitud) = "+N);
        Log.d("V", "V(Volumen) = "+V);
        Log.d("D", "D(Dificultad) = "+D);
        Log.d("L", "L(Nivel) = "+L);
        Log.d("E", "E(Esfuerzo) = "+N1);
        Log.d("T", "T(Tiempo) = "+N2);
        Log.d("B", "B(Bugs) = "+N2);
    }

    private static int UnaVez(List<String> operadores) {
        Set<String> hashSet = new HashSet<String>(operadores);
        operadores.clear();
        operadores.addAll(hashSet);
        Log.d("vector", "Vector sin repetición");
        for (String s : operadores) {
            Log.d("imprimir V", "Vec: "+s);
        }
        return operadores.size();
    }

    private static void Saltos(String cadena) {
        StringTokenizer cad = new StringTokenizer(cadena, "\n");
        String txtTemp = "";
        String pal="",pala="";
        String comentario="";
        while (cad.hasMoreElements()) {
            txtTemp = cad.nextToken();
            pal=Caracteres(txtTemp);
        }
    }

    private static String Caracteres(String txtTemp) {
        StringTokenizer cade = new StringTokenizer(txtTemp, " ");
        String txtTemp1 = "";
        String palabra = "",pala="";
        while (cade.hasMoreElements()) {
            txtTemp1 = cade.nextToken();
            txtTemp1 = txtTemp1.replaceAll(" ", "");
            txtTemp1 = txtTemp1.replaceAll("	", "");
            txtTemp1 = txtTemp1.replaceAll("\r", "");
            txtTemp1 = txtTemp1.replaceAll("\n", "");
            txtTemp1 = txtTemp1.replaceAll("\t", "");
            txtTemp1 = txtTemp1.replaceAll("\n ", "");
            palabra = token(txtTemp1);

        }
        return txtTemp1;
    }

    private static String token(String txtTemp1) {
        String token = "";

        if((txtTemp1.matches("^printf.*$")) || (txtTemp1.matches("\\);")) || (txtTemp1.matches("public")) || (txtTemp1.matches("class")) || (txtTemp1.matches("static")) || (txtTemp1.matches("printf")) ||
                (txtTemp1.matches("System")) || (txtTemp1.matches("int")) || (txtTemp1.matches("boolean")) || (txtTemp1.matches(".*^void.*$")) || (txtTemp1.matches("float")) ||
                (txtTemp1.matches("\\+")) || (txtTemp1.matches("\\-")) || (txtTemp1.matches("\\/")) || (txtTemp1.matches("\\*")) || (txtTemp1.matches("\\++")) || (txtTemp1.matches("\\--")) ||
                txtTemp1.matches("\\{") || txtTemp1.matches("\\}") || txtTemp1.matches("\\=") || txtTemp1.matches("\\==") || txtTemp1.matches("\\!=") ||
                (txtTemp1.matches("\\<")) || (txtTemp1.matches("\\>") || (txtTemp1.matches("\\<=")) || (txtTemp1.matches("\\>="))) || txtTemp1.matches("\\+=") || txtTemp1.matches("\\%") ||
                (txtTemp1.matches("\\&&")) || (txtTemp1.matches("\\||")) || (txtTemp1.matches("\\(")) || (txtTemp1.matches("\\)")) || txtTemp1.matches("Scanner") ||
                (txtTemp1.matches("^/*.$")) || txtTemp1.matches(".*/$") ||  txtTemp1.matches("^'.*") || txtTemp1.matches(".*'") ||
                txtTemp1.matches(".*;$") || (txtTemp1.matches("main.*$")) || (txtTemp1.matches("^.*args.*$")) || txtTemp1.matches("import") || txtTemp1.matches("new") ||
                (txtTemp1.matches("^if")) || (txtTemp1.matches("^else")) || (txtTemp1.matches("^while")) || (txtTemp1.matches("^for")) ||
                (txtTemp1.matches("null")) || (txtTemp1.matches("false")) || (txtTemp1.matches("true")) || (txtTemp1.matches("this"))){

            Log.d("Operado", "OPERADORES = " +txtTemp1);
            Operadores.add(txtTemp1);
            n1= n1+1;
        }
        else if((txtTemp1.matches("(?:([a-z]||[A-Z])([a-z0-9_]||[A-Z0-9])*)"))){
            Log.d("Operando", "OPERANDOS = " +txtTemp1);
            Operandos.add(txtTemp1);
            n2= n2+1;
        }
        return token;
    }



    private static void Imprime(String cadena) {
        String txt;
        txt = cadena;
        int i=0;
        int j=0;
        String impresion="";
        for (i = 0; i < txt.length(); i++) {
            if ((txt.charAt(i) == 'p') && (txt.charAt(i + 1) == 'r') && (txt.charAt(i + 2) == 'i')&& (txt.charAt(i + 3) == 'n')&& (txt.charAt(i + 4) == 't') && (txt.charAt(i + 5) == 'f')&& (txt.charAt(i + 6) == '(')){
                j = i + 8;
                while ((txt.charAt(j) != ')') && (txt.charAt(j + 1) != ';')) {
                    impresion = impresion + txt.charAt(j);
                    j++;
                    if ((txt.charAt(j) == ')') && (txt.charAt(j + 1) == ';')) {
                        cadena = cadena.replace(impresion, " '");
                        impresion = "";
                    }
                }
            }
        }
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

        btnGuardar = (Button)view.findViewById(R.id.btnGuardar);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularMetricas.Boton();
                //textCodigo.setText(""+Codigo);
                textN1.setText(""+N1);
                textn1.setText(""+n1);
                textN2.setText(""+N2);
                textn2.setText(""+n2);
                textN.setText(""+N);
                textn.setText(""+n);
                textV.setText(""+V);
                textD.setText(""+D);
                textL.setText(""+L);
                textE.setText(""+E);
                textT.setText(""+T);
                textB.setText(""+B);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "administracion", null, 1);
                SQLiteDatabase dataBase = admin.getWritableDatabase();

                String N1 = textN1.getText().toString();
                String n1 = textn1.getText().toString();
                String N2 = textN2.getText().toString();
                String n2 = textn2.getText().toString();
                String N = textN.getText().toString();
                String n = textn.getText().toString();
                String V = textV.getText().toString();
                String D = textD.getText().toString();
                String L = textL.getText().toString();
                String E = textE.getText().toString();
                String T = textT.getText().toString();
                String B = textB.getText().toString();

                if (!N1.isEmpty()){
                    ContentValues registro = new ContentValues();

                    //registro.put("ID", 0);
                    registro.put("N1", N1);
                    registro.put("n_1", n1);
                    registro.put("N2", N2);
                    registro.put("n_2", n2);
                    registro.put("N", N);
                    registro.put("n_", n);
                    registro.put("V", V);
                    registro.put("D", D);
                    registro.put("L", L);
                    registro.put("E", E);
                    registro.put("T", T);
                    registro.put("B", B);

                    dataBase.insert("resultados", null, registro);
                    dataBase.close();

                    //limpiar campos

                    textCodigo.setText("");
                    textN1.setText("");
                    textn1.setText("");
                    textN2.setText("");
                    textn2.setText("");
                    textN.setText("");
                    textn.setText("");
                    textV.setText("");
                    textD.setText("");
                    textL.setText("");
                    textE.setText("");
                    textT.setText("");
                    textB.setText("");


                    CharSequence text = "Métricas guardadas exitosamente";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();
                } else {
                    CharSequence text = "Seleccione un código a analizar";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();
                }
            }
        });
        String[] value = {"Codigo 1", "Codigo 2", "Codigo 3", "Codigo 4", "Codigo 5"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.style_spiner, arrayList);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private String Programa;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(parent.getContext(),
                        "Seleccionado"+parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();*/
                Programa = parent.getItemAtPosition(position).toString();
                Selec_Archivo(Programa);

            }

            private void Selec_Archivo(String codigo) {
                Codigo = " CÓDIGO ";
                textCodigo.setText(""+Codigo);
                switch(codigo)
                {
                    case "Codigo 1" :
                        Codigo = "ARCHIVO 1";
                        textCodigo.setText(""+Codigo);
                        break; // break es opcional

                    case "Codigo 2" :
                        Codigo = "ARCHIVO 2";
                        textCodigo.setText(""+Codigo);
                        break; // break es opcional
                    case "Codigo 3" :
                        Codigo = "ARCHIVO 3";
                        textCodigo.setText(""+Codigo);
                        break; // break es opcional
                    case "Codigo 4" :
                        Codigo = "ARCHIVO 4";
                        textCodigo.setText(""+Codigo);
                        break; // break es opcional
                    case "Codigo 5" :
                        Codigo = "ARCHIVO 5";
                        textCodigo.setText(""+Codigo);
                        break; // break es opcional

                    default :
                        // Declaraciones
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }

}