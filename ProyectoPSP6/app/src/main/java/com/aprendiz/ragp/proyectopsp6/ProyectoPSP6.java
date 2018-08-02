package com.aprendiz.ragp.proyectopsp6;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.aprendiz.ragp.proyectopsp6.controllers.Menu_proyects;
import com.aprendiz.ragp.proyectopsp6.models.AdapterP;
import com.aprendiz.ragp.proyectopsp6.models.ManagerDB;
import com.aprendiz.ragp.proyectopsp6.models.Project;

import java.util.List;

public class ProyectoPSP6 extends AppCompatActivity {
    RecyclerView recyclerView;
    public static Project project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto_psp6);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton btninput = findViewById(R.id.btnInput);
        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProyectoPSP6.this);
                View item = LayoutInflater.from(ProyectoPSP6.this).inflate(R.layout.item_aproyecto,null);
                final EditText txtName = item.findViewById(R.id.txtNamePA);
                builder.setView(item);
                builder.setTitle("Agregar Proyecto");
                final ManagerDB managerDB = new ManagerDB(ProyectoPSP6.this);
                builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Project project = new Project();
                        if (txtName.getText().toString().length()>0) {
                            project.setName(txtName.getText().toString());
                            managerDB.inputProject(project);
                        }else {
                            Snackbar.make(view, "Para poder agregar un proyecto no deje el campo vacio",Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });

        recyclerView= findViewById(R.id.recyclerViewM);
        inputAdapter();
    }

    private void inputAdapter() {
        ManagerDB managerDB = new ManagerDB(this);
        final List<Project> projectList = managerDB.projectList();
        AdapterP adapterP = new AdapterP(projectList);
        recyclerView.setAdapter(adapterP);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        adapterP.setMlistener(new AdapterP.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                project = projectList.get(position);
                Intent intent = new Intent(ProyectoPSP6.this, Menu_proyects.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proyecto_psp6, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
