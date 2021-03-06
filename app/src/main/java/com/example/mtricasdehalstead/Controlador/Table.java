package com.example.mtricasdehalstead.Controlador;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Table {
    private TableLayout tableLayout;
    private Context context;
    private String[]encabezado;
    private ArrayList<String[]>datos;
    private TableRow tableRow;
    private TextView textCell;
    private int indexC, indexR;
    private int totalFilas;

    public Table(TableLayout tableLayout, Context context) {
        this.tableLayout = tableLayout;
        this.context = context;
    }

    public void addEncabezado (String[]encabezado){
        this.encabezado = encabezado;

    }

    public void addDatos(ArrayList<String[]>datos, int totalFilas){
        this.datos = datos;
        this.totalFilas = totalFilas;
        crearDataTable();
    }

    private void newRow(){
        tableRow = new TableRow(context);
    }

    private void newCell(){
        textCell = new TextView(context);
        textCell.setGravity(Gravity.CENTER);
        textCell.setTextSize(15);
    }

    private void crearEncabezado(){
        indexC = 0;
        newRow();
        while (indexC < encabezado.length){
            newCell();
            textCell.setText(encabezado[indexC++]);
            tableRow.addView(textCell, newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    private void crearDataTable (){
        String info;
        tableLayout.removeAllViews();
        crearEncabezado();
        for (indexR = 0; indexR < totalFilas; indexR++){
            newRow();
            for (indexC = 0; indexC < encabezado.length; indexC++){
                newCell();
                String[] colums = datos.get(indexR );
                info = (indexC < colums.length)?colums[indexC]:"";
                textCell.setText(info);
                tableRow.addView(textCell,newTableRowParams());
            }
            tableLayout.addView(tableRow);
        }
    }

    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(14,3,30,3);
        params.weight = 100;
        //params.height = 10;
        return params;
    }
}
