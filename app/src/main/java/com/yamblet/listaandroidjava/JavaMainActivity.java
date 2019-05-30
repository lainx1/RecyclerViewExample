package com.yamblet.listaandroidjava;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class JavaMainActivity extends AppCompatActivity {

    ItemAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvItems = findViewById(R.id.rvItems);

        adapter = new ItemAdapter(new ArrayList<Item>());
        new GetItems().execute();

        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        rvItems.setAdapter(adapter);

        ItemClickSupport.addTo(rvItems).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                ItemAdapter itemAdapter = (ItemAdapter) recyclerView.getAdapter();
                Item item = itemAdapter.getItem(position);

                Toast.makeText(getApplicationContext(), "Click en el item " + item.id + " nombre " + item.nombre, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class GetItems extends AsyncTask<Void, Void, List<Item>> {


        @Override
        protected List<Item> doInBackground(Void... voids) {
            List<Item> items = new ArrayList<>();

            items.add(new Item(1L, "Hola 1"));
            items.add(new Item(2L, "Hola 2"));
            items.add(new Item(3L, "Hola 3"));
            items.add(new Item(4L, "Hola 4"));
            items.add(new Item(5L, "Hola 5"));

            return items;
        }

        @Override
        protected void onPostExecute(List<Item> items) {
            super.onPostExecute(items);
            adapter.addItems(items);
        }
    }

}
