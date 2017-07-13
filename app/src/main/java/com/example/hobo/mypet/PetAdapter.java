package com.example.hobo.mypet;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/10/2017.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList<PetsList> pets;
    Activity activity;

    public PetAdapter(ArrayList<PetsList> pets, Activity activity) {
        this.pets     = pets;
        this.activity = activity;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pets_list, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {
        final PetsList pet = pets.get(position);
        holder.ivPhoto.setImageResource(pet.getPhoto());
        holder.tvName.setText(pet.getName());
        holder.tvCount.setText(String.valueOf(pet.getLikes()));

        holder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "You like " + pet.getName(), Toast.LENGTH_SHORT).show();
                pet.setLikes(pet.getLikes() + 1);
                holder.tvCount.setText(String.valueOf(pet.getLikes()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView tvName, tvCount;
        private ImageButton ibLike;

        public PetViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView)   itemView.findViewById(R.id.ivPhoto);
            tvName  = (TextView)    itemView.findViewById(R.id.tvName);
            tvCount = (TextView)    itemView.findViewById(R.id.tvCount);
            ibLike  = (ImageButton) itemView.findViewById(R.id.ibLike);
        }
    }
}
