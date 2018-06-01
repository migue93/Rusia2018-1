package com.miguelyeisonappgmail.rusia2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements ComunicaMenu {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu(4);



    }



    @Override
    public  void menu (int cualboton){

        Intent in = new Intent(this, ActividadInicio.class);

        in.putExtra("BOTONPULSADO", cualboton);

        startActivity(in);
        finish();
    }
}
