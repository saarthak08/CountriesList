package com.sg.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sg.R;
import com.sg.model.Result;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolderCountry> {
    private ArrayList<Result> results;

    public CountryAdapter(ArrayList<Result> results) {
        this.results = results;
    }

    class ViewHolderCountry extends RecyclerView.ViewHolder{
        TextView countryName;

        ViewHolderCountry(@NonNull View itemView) {
            super(itemView);
            countryName=itemView.findViewById(R.id.tvCountryName);
        }
    }
    @NonNull
    @Override
    public ViewHolderCountry onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.item_country,viewGroup);
        return new ViewHolderCountry(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCountry viewHolderCountry, int i) {
        viewHolderCountry.countryName.setText(results.get(i).getName());

    }



    @Override
    public int getItemCount() {
        if(results==null)
        {
            return 0;
        }
        return results.size();
    }
}
