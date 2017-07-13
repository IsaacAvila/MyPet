package com.example.hobo.mypet;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PetsList> pets;
    private RecyclerView petList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        ActionBar bar = getSupportActionBar();
        if(actionBar != null) {
            bar.setDisplayShowTitleEnabled(false);
        }

        petList = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(manager);
        pets = fillPetsList();
        startAdapter(pets, this, petList);
    }

    public static void startAdapter(ArrayList<PetsList> pets, Activity activity, RecyclerView petList) {
        PetAdapter adapter = new PetAdapter(pets, activity);
        petList.setAdapter(adapter);
    }

    public static ArrayList<PetsList> fillPetsList() {
        ArrayList<PetsList> pets = new ArrayList<>();

        pets.add(new PetsList(R.drawable.pet1, 1, "Jhon"));
        pets.add(new PetsList(R.drawable.pet2, 2, "Rocky"));
        pets.add(new PetsList(R.drawable.pet3, 5, "Peque"));
        pets.add(new PetsList(R.drawable.pet4, 4, "Fellon"));
        pets.add(new PetsList(R.drawable.pet5, 1, "Rufo"));
        pets.add(new PetsList(R.drawable.pet6, 9, "StonerRabbit"));
        pets.add(new PetsList(R.drawable.pet7, 8, "Pikazo"));
        return pets;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_show_top) {
            Intent top = new Intent(MainActivity.this, PetDetail.class);
            startActivity(top);
        }
        return super.onOptionsItemSelected(item);
    }
}
