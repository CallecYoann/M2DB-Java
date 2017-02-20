package com.example.afpa.m2dbjava;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afpa.m2dbjava.model.Film;
import com.example.afpa.m2dbjava.model.ImageLoader;
import com.example.afpa.m2dbjava.model.findFilmById;

import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

public class DetailsActivity extends AppCompatActivity {

    TextView txtTitreFilm;
    TextView txtDescription;
    TextView txtYear;
    ImageView coverDetails;
    TextView txtNameReal;
    TextView txtType;
    TextView txtDuration;
    int filmId;

    private ImageLoader imageLoader = new ImageLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtTitreFilm = (TextView) findViewById(R.id.txtTitreFilm);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        txtYear = (TextView) findViewById(R.id.txtYear);
        filmId = getIntent().getExtras().getInt("liste_film");
        coverDetails = (ImageView) findViewById(R.id.coverDetails);
        txtNameReal = (TextView) findViewById(R.id.txtNameReal);
        txtType = (TextView) findViewById(R.id.txtType);
        txtDuration = (TextView) findViewById(R.id.txtDuration);

        try {
            findFilmById data = new findFilmById();
            data.execute("" + filmId);
            Film fil = data.get();
            if (fil == null) {
                System.out.println("Film is null");
                return;
            }
            txtTitreFilm.setText(fil.getF_name());
            txtDescription.setText(fil.getDescription());
            System.out.print(fil.getYear());
            txtYear.setText(((Integer)fil.getYear()).toString());
            txtNameReal.setText(fil.getFm_lastname() + " " + fil.getFm_name());
            txtType.setText(fil.getT_name());
            int minutes = fil.getDuration();
            String startTime = "00:00";
            int h = minutes / 60 + Integer.parseInt(startTime.substring(0,1));
            int m = minutes % 60 + Integer.parseInt(startTime.substring(3,4));
            String newtime = h+"h"+m;
            txtDuration.setText(newtime);

            if (fil.getImageURL() != null && !fil.getImageURL().isEmpty()) {
                Log.i("image url:", fil.getImageURL());
                Bitmap cachedImage = null;
                try {
                    cachedImage = imageLoader.loadImage(fil.getImageURL(), new ImageLoader.ImageLoadedListener() {
                        public void imageLoaded(Bitmap imageBitmap) {
                            coverDetails.setImageBitmap(imageBitmap);
                        }
                    });
                } catch (MalformedURLException e) {
                    Log.e("", "Bad remote image URL: " + fil.getImageURL(), e);
                }

                if (cachedImage != null) {
                    coverDetails.setImageBitmap(cachedImage);
                }

            }

            System.out.println("Film getted");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}

