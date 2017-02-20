package com.example.afpa.m2dbjava;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.afpa.m2dbjava.model.Film;
import com.example.afpa.m2dbjava.model.MovieAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    List<Film> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView1 = (ListView) findViewById(R.id.listView1);
        registerForContextMenu(listView1);

        FindAllMovies data = new FindAllMovies();
        data.execute();
        try {
            movies = data.get();
            final MovieAdapter adapter = new MovieAdapter(this, movies);
            listView1.setAdapter(adapter);
            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Film film = adapter.getItem(position);

                    Log.i("selected id film:", String.valueOf(film.getF_id()));
                    Intent i = new Intent(getApplicationContext(), DetailsActivity.class);
                    System.out.println("Film id: " + film.getF_id());
                    i.putExtra("liste_film", film.getF_id());
                    startActivity(i);
                }
            });


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contect_menu, menu);
        menu.setHeaderTitle("Options");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);

        if (item.getTitle() == "Click here") {
            Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
        }

        return true;
    }

}
