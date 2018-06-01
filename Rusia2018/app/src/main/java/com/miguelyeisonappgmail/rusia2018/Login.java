package com.miguelyeisonappgmail.rusia2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    Button btn_Registrar;
    Button btn_Inicio;
    ImageView btn_Google;
    SignInButton button;
    FirebaseAuth mAuth;
    private GoogleApiClient mGoogleApiClient;
    private SignInButton Googlebtn;
    public static final int SIGN_IN_CODE = 777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_Registrar = findViewById(R.id.button2);
        btn_Inicio = findViewById(R.id.button);
        //btn_Google = findViewById(R.id.btn_Google);
        //button = (SignInButton) findViewById(R.id.Googlebtn);



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        Googlebtn = (SignInButton) findViewById(R.id.Googlebtn);
        Googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(intent, SIGN_IN_CODE);
            }
        });





        btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intentInicio = new Intent(Login.this, MainActivity.class);
                startActivity(intentInicio);*/
                Intent in = new Intent(Login.this, ActividadInicio.class);

                in.putExtra("BOTONPULSADO", 4);

                startActivity(in);

            }
        }


        );






        btn_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Login.this, Registrar1.class);
                Login.this.startActivity(intentReg);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSingnInResult(result);

        }
    }

    private void handleSingnInResult(GoogleSignInResult result) {

        if (result.isSuccess()){
            goMainScreen();
        }else Toast.makeText(this, R.string.not_log_in, Toast.LENGTH_LONG).show();
    }

    private void goMainScreen() {
        Intent intentLog = new Intent(this, ActividadInicio.class);
        intentLog.putExtra("BOTONPULSADO", 4);
        intentLog.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);



        startActivity(intentLog);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {








    }
}
