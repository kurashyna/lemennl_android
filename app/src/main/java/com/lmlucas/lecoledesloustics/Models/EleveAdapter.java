package com.lmlucas.lecoledesloustics.Models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lmlucas.lecoledesloustics.Home.HomeActivity;
import com.lmlucas.lecoledesloustics.R;

import java.util.List;

public class EleveAdapter extends RecyclerView.Adapter<EleveAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nomEleveTextView;
        public TextView ageEleveTextView;

        public ViewHolder(View itemView){
            super(itemView);
            nomEleveTextView = itemView.findViewById(R.id.eleveViewName);
            ageEleveTextView = itemView.findViewById(R.id.eleveViewAge);
        }
    }

    private List<Eleve> listeEleves;

    public EleveAdapter(List<Eleve> liste){
        listeEleves = liste;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public EleveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.eleve_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EleveAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Eleve eleve = listeEleves.get(position);

        // Set item views based on your views and data model
        TextView nomTextView = holder.nomEleveTextView;
        TextView ageTextView = holder.ageEleveTextView;

        nomTextView.setText(eleve.getNomEleve());
        ageTextView.setText( eleve.getAgeEleve() +" ans");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                intent.putExtra("eleve", eleve);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listeEleves.size();
    }

    public void swap(List<Eleve> liste) {
        if (liste != null) {
            this.listeEleves.clear();
            this.listeEleves.addAll(liste);
        }
        notifyDataSetChanged();
    }
}
