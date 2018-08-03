package com.aprendiz.ragp.proyectopsp6.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.aprendiz.ragp.proyectopsp6.R;
<<<<<<< HEAD
import com.aprendiz.ragp.proyectopsp6.models.CDefectLog;

public class DefectLog extends AppCompatActivity {
=======

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefectLog extends AppCompatActivity implements View.OnClickListener {


    EditText txtFecha, txrComentarios, txtCronometro;
    Spinner spinnerType, spinnerphaseIn, spinnerphaseRe;
    Button btnFecha, btnEmpezar, btnParar, btnReiniciar;

    Thread thread;
    boolean bandera = true;
    boolean bandera1 = false;

    int []tiempo ={0,0};

>>>>>>> 8f75dcea9fe3d861cb4e33e7516fea64480dbdcd

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    //FuncionBotonCentro

                    return true;
                case R.id.navigation_dashboard:

                    //FuncionBotonDerecha

                    return true;
                case R.id.navigation_notifications:

                    //FuncionBotonIzquierda


                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        inicializar();
        llamarBotones();
        Listar();
        validar();
        chorometro();

    }

    private void chorometro() {

        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (bandera) {
                    try {
                        {
                            Thread.sleep(1000);

                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (bandera1) {
                                    tiempo[0]++;
                                    if (tiempo[0] == 60) {
                                        tiempo[1]++;
                                        tiempo[0] = 0;
                                    }

                                    if (tiempo[0] >= 10 && tiempo[0] < 10) {

                                        if (tiempo[0] >= 0 && tiempo[0] < 10) {
                                            txtCronometro.setText("0" + tiempo[1] + ":" + "0" + tiempo[0]);
                                        } else {
                                            txtCronometro.setText(tiempo[1] + ":" + "0" + tiempo[0]);
                                        }
                                    }
                                    if (tiempo[0] >= 10 && tiempo[0] < 60) {
                                        if (tiempo[0] >= 0 && tiempo[0] < 10) {
                                            txtCronometro.setText("0" + tiempo[1] + ":" + tiempo[0]);
                                        } else {

                                            txtCronometro.setText(tiempo[1] + ":" + tiempo[0]);
                                        }
                                    }

                                }


                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void validar() {
        int validar=0;

        if (txtFecha.getText().toString().length()>0){
            validar++;

        }else {
            txtFecha.setError("FaltaCampo");
        }
        if (txtCronometro.getText().toString().length()>0){
            validar++;
        }else {
            txtCronometro.setError("Cronometro En 0");
        }


    }

    private void Listar() {

        List<String> type = new ArrayList<>();
        type.add("Plannig");
        type.add("Design");
        type.add("Code");
        type.add("Compile");
        type.add("UT");
        type.add("PM");

        List<String> phsases = new ArrayList<>();
        phsases.add("Documentation");
        phsases.add("Syntax");
        phsases.add("Build");
        phsases.add("Packge");
        phsases.add("Assigment");
        phsases.add("Interface");
        phsases.add("Checking");
        phsases.add("Data");
        phsases.add("Fuction");
        phsases.add("System");
        phsases.add("Enviroment");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, type);
        ArrayAdapter<String> adapterPhase = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, phsases);

        spinnerType.setAdapter(adapter);
        spinnerphaseIn.setAdapter(adapterPhase);
        spinnerphaseRe.setAdapter(adapterPhase);

    }

    private void llamarBotones() {

        btnEmpezar.setOnClickListener(this);
        btnParar.setOnClickListener(this);
        btnReiniciar.setOnClickListener(this);
        btnFecha.setOnClickListener(this);

    }

    private void inicializar() {

        txtFecha = findViewById(R.id.txtFecha);
        txrComentarios = findViewById(R.id.txtComentarios);
        txtCronometro = findViewById(R.id.txtCronome);

        spinnerType = findViewById(R.id.spinertype);
        spinnerphaseIn = findViewById(R.id.spinnerPhaseIn);
        spinnerphaseRe = findViewById(R.id.spinertphaseRemo);

        btnEmpezar = findViewById(R.id.btnEmpezar);
        btnParar = findViewById(R.id.btnParar);
        btnFecha= findViewById(R.id.btnfecha);
        btnReiniciar = findViewById(R.id.btnReiniciar);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnfecha:
                obtenerFecha();
                break;


            case R.id.btnEmpezar:

                goCrono();


                break;

            case R.id.btnParar:
                pauseCrono();

                break;


            case R.id.btnReiniciar:

                StopCronometro();

                break;
        }

    }

    private void StopCronometro() {

        bandera1 = false;
        tiempo[0]=0;
        tiempo[1]=0;
        txtCronometro.setText("0" + tiempo[1] + ":" + "0" + tiempo[0]);
    }

    private void pauseCrono() {
        bandera1 = false;
    }

    private void goCrono() {
        bandera1 = true;

    }

<<<<<<< HEAD

    public void inputData(){
        CDefectLog cDefectLog = new CDefectLog();

    }

=======
    private void obtenerFecha() {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = format.format(date);
        txtFecha.setText(fecha);
    }
>>>>>>> 8f75dcea9fe3d861cb4e33e7516fea64480dbdcd
}
