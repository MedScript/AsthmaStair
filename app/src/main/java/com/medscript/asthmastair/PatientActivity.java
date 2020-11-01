package com.medscript.asthmastair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class PatientActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SintomasFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_sintomas);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_consultas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ConsultasFragment()).commit();
                break;
            case R.id.nav_sintomas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SintomasFragment()).commit();
                break;
            case R.id.nav_resumo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ResumoFragment()).commit();
                break;
            case R.id.nav_terapeutica:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TerapeuticaFragment()).commit();
                break;
            case R.id.nav_exames:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ExamesFragment()).commit();
                break;
            case R.id.nav_ajuda:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AjudaFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

}