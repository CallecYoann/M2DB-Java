package com.example.afpa.m2dbjava.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.afpa.m2dbjava.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static android.R.attr.bitmap;

/**
 * Created by Afpa on 14/02/2017.
 */

public class MovieAdapter extends ArrayAdapter<Film> {

    private ImageLoader imageLoader = new ImageLoader();

    String s;


    public MovieAdapter(Context context, List<Film> films) {
        super(context, 0, films);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Film film = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_description, parent, false);
        }

        TextView txtTitre = (TextView) convertView.findViewById(R.id.titre);
        TextView txtType = (TextView) convertView.findViewById(R.id.type);
        final ImageView image = (ImageView) convertView.findViewById(R.id.cover);

        if (film.getImageURL() != null && !film.getImageURL().isEmpty()) {
            Log.i("image url:", film.getImageURL());
            Bitmap cachedImage = null;
            try {
                cachedImage = imageLoader.loadImage(film.getImageURL(), new ImageLoader.ImageLoadedListener() {
                    public void imageLoaded(Bitmap imageBitmap) {
                        image.setImageBitmap(imageBitmap);
                        notifyDataSetChanged();
                    }
                });
            } catch (MalformedURLException e) {
                Log.e("", "Bad remote image URL: " + film.getImageURL(), e);
            }

            if (cachedImage != null) {
                image.setImageBitmap(cachedImage);
            }

        }



        //ImageView imgCover = (ImageView) convertView.findViewById(R.id.cover);
        //        imgCover.setImageBitmap(BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.interstellar));

        s = film.getF_name() + " (" + film.getYear() + ") ";
        SpannableString ss = new SpannableString(s);
        ss.setSpan(new RelativeSizeSpan(2f), 0, film.getF_name().length(), 0); // set size
        txtTitre.setText(ss);
        txtType.setText(film.getT_name());

        return convertView;
    }

}