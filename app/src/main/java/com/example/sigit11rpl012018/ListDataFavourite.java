package com.example.sigit11rpl012018;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ListDataFavourite extends AppCompatActivity {

    Realm realm;
    RealmHelper realmHelper;
   private RecyclerView recyclerView;
   private FavouriteAdapter adapter;
   private List<ModelMovieRealm> modelMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        recyclerView = findViewById(R.id.rvdata);

        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        modelMovie = new ArrayList<>();

        modelMovie = realmHelper.getAllMovie();

        adapter = new FavouriteAdapter(modelMovie, new FavouriteAdapter.Callback() {
            @Override
            public void onClick(int position) {
                Intent move = new Intent(getApplicationContext(), DetailFavourite.class);
                move.putExtra("judul",modelMovie.get(position).getJudul());
                move.putExtra("path",modelMovie.get(position).getPath());
                move.putExtra("date",modelMovie.get(position).getReleaseDate());
                move.putExtra("deskripsi",modelMovie.get(position).getDesc());

                startActivity(move);
            }

            @Override
            public void test() {

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}