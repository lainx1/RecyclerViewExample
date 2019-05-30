package com.yamblet.listaandroidjava;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private List<Item> items;

    public ItemAdapter(List<Item> items){
        this.items = items;
    }
    ////////////////////////////////////////////Holder///////////////////////////////////////////////////////
    public class ItemHolder extends RecyclerView.ViewHolder {
        public ItemHolder(View view){
            super(view);
        }
    }
    ////////////////////////////////////////////Adapter Methods///////////////////////////////////////////////////////

    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {
        Item item = items.get(position);
        TextView tvId = itemHolder.itemView.findViewById(R.id.tvId);
        TextView tvNombre = itemHolder.itemView.findViewById(R.id.tvName);

        tvId.setText(item.id.toString());
        tvNombre.setText(item.nombre);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    /////////////////////////////////// Get Items ////////////////////////////
    public void addItems(List<Item> items){
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public Item getItem(int pos){
        return items.get(pos);
    }

}
