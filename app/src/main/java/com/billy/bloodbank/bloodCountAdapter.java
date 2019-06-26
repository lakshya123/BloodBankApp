package com.billy.bloodbank;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bloodCountAdapter extends RecyclerView.Adapter<bloodCountAdapter.bloodCountViewHolder> {

    private Context context;
    private BloodType[] data;
    public bloodCountAdapter(Context context, BloodType[] data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public bloodCountViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_layout, viewGroup, false);
        return new bloodCountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bloodCountViewHolder bloodCountViewHolder, int i) {
        BloodType bloodType = data[i];
        bloodCountViewHolder.bloodGroup.setText(bloodType.getBloodGroup());
        bloodCountViewHolder.bloodType.setText(bloodType.getComponentName());
        bloodCountViewHolder.units.setText(bloodType.getUnitsAvailable());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class bloodCountViewHolder extends RecyclerView.ViewHolder {
        TextView bloodGroup;
        TextView bloodType;
        TextView units;
        public bloodCountViewHolder(@NonNull View itemView) {
            super(itemView);
            bloodGroup = itemView.findViewById(R.id.textViewBlood_group);
            bloodType = itemView.findViewById(R.id.textViewBlood_type);
            units = itemView.findViewById(R.id.units);
        }
    }
}
