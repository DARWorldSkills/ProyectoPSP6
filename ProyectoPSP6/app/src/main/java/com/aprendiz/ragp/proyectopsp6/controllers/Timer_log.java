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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Timer_log extends AppCompatActivity implements View.OnClickListener {

    Spinner spinnerPhase;
    EditText horaStart, interrupcion, horaStop, delta, Etxtcoments;
    Button btnrun, btnhoraFin;

    Date dateStart = new Date();
    Date dateStop = new Date();


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_log);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        inicializar();
        ListaPhase();
        validarCampos();
        EscucharBotones();

    }

    private void EscucharBotones() {
        btnrun.setOnClickListener(this);
        btnhoraFin.setOnClickListener(this);
    }

    private void validarCampos() {
        int validar =0;
        if (horaStart.getText().toString().length()>0){
            validar =1;
        }else {
            horaStart.setError("Falta ingresar campo");
        }

        if (horaStop.getText().toString().length()>0){
            validar=1;

        }else {
            horaStop.setError("Falta ingresar campo");

        }

    }

    private void ListaPhase() {

        List<String> phase = new ArrayList<>();
        phase.add("PLAN");
        phase.add("DLC");
        phase.add("CODE");
        phase.add("COMPILE");
        phase.add("UT");
        phase.add("PM");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, phase);
        spinnerPhase.setAdapter(adapter);


    }

    private void inicializar() {

        spinnerPhase = findViewById(R.id.spinnerPhase);

        horaStart = findViewById(R.id.horastar);
        horaStop = findViewById(R.id.horastop);
        interrupcion = findViewById(R.id.interrupcion);
        delta = findViewById(R.id.delta);
        Etxtcoments = findViewById(R.id.EtxtComments);

        btnrun = findViewById(R.id.btnRun);
        btnhoraFin = findViewById(R.id.btnhorafin);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnRun:

                obtenerHora();


                break;

            case R.id.btnhorafin:



                break;
        }

    }

    private void obtenerHora() {

        dateStart = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateA = format.format(dateStart);
        horaStart.setText(dateA);

    }
}
