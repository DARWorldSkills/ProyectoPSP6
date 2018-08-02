package com.aprendiz.ragp.proyectopsp6.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aprendiz.ragp.proyectopsp6.R;

public class Menu_proyects extends AppCompatActivity implements View.OnClickListener {

    Button btnTime, btnDefecr, btnPlans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_proyects);
        inicializar();
        llamarbotones();

    }

    private void llamarbotones() {
         btnTime.setOnClickListener(this);
         btnDefecr.setOnClickListener(this);
         btnPlans.setOnClickListener(this);

    }

    private void inicializar() {

        btnTime = findViewById(R.id.btnTime);
        btnDefecr = findViewById(R.id.btnDefect);
        btnPlans = findViewById(R.id.btnPlanS);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnTime:

                Intent intent = new Intent(Menu_proyects.this, Timer_log.class);
                startActivity(intent);

                break;

            case R.id.btnDefect:
                Intent intent2 = new Intent(Menu_proyects.this, DefectLog.class);
                startActivity(intent2);

                break;

            case R.id.btnPlanS:

                break;



        }

    }
}
