package com.example.mtricasdehalstead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mtricasdehalstead.Controlador.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class  MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2, tab3;
    private PagerController pagerAdapter;
    private View btn;
    private int n1=0, n2=0, N1=0, N2=0;
    List<String> Operadores = new ArrayList<String>();
    List<String> Operandos = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpage);

        tab1 = findViewById(R.id.tabcalcular);
        tab2 = findViewById(R.id.tabbd);
        tab3 = findViewById(R.id.tabcreditos);

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition() == 2) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    public void Boton_Seleccionado(View view) {

        String cadena = "";

            cadena = "public class ejercicio52 { ++ class ";
            Log.d("Cadena", "Cadena: "+cadena);
            Imprime(cadena);
            Saltos(cadena);
            N1 = UnaVez(Operadores);
            N2 = UnaVez(Operandos);
            Calcular_méticas (n1,n2,N1,N2);
            Log.d("n1", "n1: "+n1);
            Log.d("n1", "n2: "+n2);
            Log.d("N1", "N1: "+N1);
            Log.d("N2", "N2: "+N2);
    }

    private void Calcular_méticas(int n1, int n2, int n11, int n21) {

    }

    private int UnaVez(List<String> operandos) {
        Set<String> hashSet = new HashSet<String>(operandos);
        operandos.clear();
        operandos.addAll(hashSet);
        Log.d("vector", "Vector sin repetición");
        for (String s : operandos) {
            Log.d("imprimir V", "Vec: "+s);
        }
        return operandos.size();
    }

    private void Saltos(String cadena) {
        StringTokenizer cad = new StringTokenizer(cadena, "\n");
        String txtTemp = "";
        String pal="",pala="";
        String comentario="";
        while (cad.hasMoreElements()) {
            txtTemp = cad.nextToken();
            pal=Caracteres(txtTemp);
        }
    }

    private String Caracteres(String txtTemp) {
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

    private String token(String txtTemp1) {
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

    private void Imprime(String cadena) {
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

}