package com.miguelyeisonappgmail.rusia2018;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActividadInicio extends AppCompatActivity implements ComunicaMenu {


    Fragment [] misFragmentos;
    String [] miTitulo = {"Equipos", "Partidos", "Noticias" , "Más" , "Inicio" , "Sesión" , "Registrar"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_inicio);





        misFragmentos = new  Fragment[5];

        misFragmentos [0] = new Favoritos();
        misFragmentos [1] = new Envivos();
        misFragmentos [2] = new Noticias();
        misFragmentos [3] = new Mas();
        misFragmentos [4] = new Inicio();





    Bundle extras = getIntent().getExtras();
        Log.d("", "onCreate: " + extras);
    menu(extras.getInt("BOTONPULSADO"));

    }
    @Override
    public void menu(int cualboton){
        //Toast.makeText(getApplicationContext(),"N: "+ cualboton,Toast.LENGTH_LONG).show();
        FragmentManager miManejador = getFragmentManager();
        FragmentTransaction miTrasaccion = miManejador.beginTransaction();
        miTrasaccion.replace(R.id.inicio, misFragmentos[cualboton]);
        miTrasaccion.commit();
        setTitle(miTitulo[cualboton]);
    }
     WebView browser;
    @Override
    public void onBackPressed(){
        if(browser.canGoBack()){
            browser.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
