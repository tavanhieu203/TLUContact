package com.example.tlucontact;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitsViewHolder> {
    private Unit[] units;
    private Context context;
    public UnitAdapter(Unit[] units, Context context){
        this.units = units;
        this.context = context;
    }



    static  class UnitsViewHolder extends RecyclerView.ViewHolder{
        private TextView txtUnitName, txtUnitPhone;


        public UnitsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUnitName = itemView.findViewById(R.id.txtUnitname);
            txtUnitPhone = itemView.findViewById(R.id.txtUnitphone);
        }

        public void bin(Unit unit){
            txtUnitName.setText(unit.getName());
            txtUnitPhone.setText(unit.getPhone());
        }
    }

    @NonNull
    @Override
    public UnitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_units,parent,false);
        return new UnitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitsViewHolder holder, int position) {
        Unit unit = units[position];
        holder.bin(unit);

        // Khi bấm vào một unit, mở UnitDetailActivity
        holder.itemView.setOnClickListener(view ->{
            Intent intent = new Intent(context, UnitsDetailAvtivity.class);
            intent.putExtra("name", unit.getName());
            intent.putExtra("phone", unit.getPhone());
            intent.putExtra("address", unit.getAddress());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return units.length;
    }
}
