package com.example.hobo.mypet;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Caleb on 7/3/2017.
 */

public class PetDetail extends AppCompatActivity {

    ArrayList<PetsList> pets, top5;
    private RecyclerView petsTop;
    public PetAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_detail);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar bar = getSupportActionBar();
        if(actionBar != null) {
            bar.setDisplayShowTitleEnabled(false);
        }

        petsTop = (RecyclerView) findViewById(R.id.rvPetsTop);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        petsTop.setLayoutManager(manager);
        pets = MainActivity.fillPetsList();
        fillTop5();
        MainActivity.startAdapter(top5, this, petsTop);

    }

    public void fillTop5() {
        top5 = new ArrayList<>();

        Collections.sort(pets, new Comparator<PetsList>() {
            @Override
            public int compare(PetsList first, PetsList second) {
                return first.getLikes() > second.getLikes() ? -1 : (first.getLikes() < second.getLikes() ) ? 1 : 0;
            }
        });

        for(int i = 0; i < 5; i++) {
            top5.add(pets.get(i));
            System.out.println(top5.get(i).getName() + top5.get(i).getLikes());
        }
    }
}
