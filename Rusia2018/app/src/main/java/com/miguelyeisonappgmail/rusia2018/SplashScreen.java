package com.miguelyeisonappgmail.rusia2018;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //String email = usuarioActivo;
                if (FirebaseAuth.getInstance().getCurrentUser() == null){
                    //ir a login
                    Intent intent = new Intent(    SplashScreen.this, Login.class);
                    startActivity(intent);
                }else{
                    //ir a actividad pricipal
                    Intent intent = new Intent(SplashScreen.this, ActividadInicio.class);
                    startActivity(intent);
                }
            }
        },2000);
    }
}
