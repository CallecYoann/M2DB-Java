package com.example.afpa.m2dbjava.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Afpa on 14/02/2017.
 */

public class MovieViewHolder {
    public TextView titre;
    public TextView description;
    public ImageView cover;

    public MovieViewHolder(TextView titre, TextView description, ImageView cover) {
        this.titre = titre;
        this.description = description;
        this.cover = cover;
    }

    public MovieViewHolder() {
    }

    public TextView getTitre() {
        return titre;
    }

    public void setTitre(TextView titre) {
        this.titre = titre;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public ImageView getCover() {
        return cover;
    }

    public void setCover(ImageView cover) {
        this.cover = cover;
    }
}
