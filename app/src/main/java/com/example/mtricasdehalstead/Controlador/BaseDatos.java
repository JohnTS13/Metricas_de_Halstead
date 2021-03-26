package com.example.mtricasdehalstead.Controlador;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.mtricasdehalstead.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseDatos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaseDatos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private TableLayout tableLayout;
    private String[]encabezado = {"ID", "N1", "n1", "N2", "n2", "N", "n", "V", "D", "L", "E", "T", "B"};
    private ArrayList<String[]> row = new ArrayList<>();
    private int totalFilas;
    private Button btnActualizar;
    public BaseDatos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BaseDatos.
     */
    // TODO: Rename and change types and number of parameters
    public static BaseDatos newInstance(String param1, String param2) {
        BaseDatos fragment = new BaseDatos();
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
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_base_datos, container, false);
        tableLayout = (TableLayout)view.findViewById(R.id.table);
        Table tabla =  new Table(tableLayout, getContext());
        tabla.addEncabezado(encabezado);

        //Traer datos de la BD
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "administracion", null, 1);
        SQLiteDatabase dataBase = admin.getWritableDatabase();
        Cursor fila = dataBase.rawQuery("select * from resultados", null);

        if (fila.moveToFirst()){

            for (int i = 0; i < fila.getCount(); i++){
                row.add(new String[]{
                        fila.getString(0),
                        fila.getString(1),
                        fila.getString(2),
                        fila.getString(3),
                        fila.getString(4),
                        fila.getString(5),
                        fila.getString(6),
                        fila.getString(7),
                        fila.getString(8),
                        fila.getString(9),
                        fila.getString(10),
                        fila.getString(11),
                        fila.getString(12)});
                fila.moveToNext();
            }

            //dataBase.close();
        } else {
            CharSequence text = "No hay resultados guardados";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getContext(), text, duration);
            toast.show();
            //dataBase.close();
        }

        tabla.addDatos(row, fila.getCount());
        dataBase.close();

        btnActualizar = (Button)view.findViewById(R.id.btnActualizar);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Traer datos de la BD
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "administracion", null, 1);
                SQLiteDatabase dataBase = admin.getWritableDatabase();
                Cursor fila = dataBase.rawQuery("select * from resultados", null);

                if (fila.moveToFirst()){

                    for (int i = 0; i < fila.getCount(); i++){
                        row.add(new String[]{
                                fila.getString(0),
                                fila.getString(1),
                                fila.getString(2),
                                fila.getString(3),
                                fila.getString(4),
                                fila.getString(5),
                                fila.getString(6),
                                fila.getString(7),
                                fila.getString(8),
                                fila.getString(9),
                                fila.getString(10),
                                fila.getString(11),
                                fila.getString(12)});
                        fila.moveToNext();
                    }

                    //dataBase.close();
                } else {
                    CharSequence text = "No hay resultados guardados";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();
                    //dataBase.close();
                }

                tabla.addDatos(row, fila.getCount());
                dataBase.close();
            }
        });

        return view;
    }

    private ArrayList<String[]> getResultados(){
        totalFilas = 9; //Aqui asignarle el numero total de registros que tiene la bd de los resultados
        for (int i = 0; i < totalFilas; i++){
            row.add(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3"});
        }
        return row;
    }


}