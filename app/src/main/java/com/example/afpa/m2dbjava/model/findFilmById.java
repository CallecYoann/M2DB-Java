package com.example.afpa.m2dbjava.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Afpa on 16/02/2017.
 */

public class findFilmById extends AsyncTask<String, Void, Film> {

    private final String link = "http://10.105.49.8:8080/api/v1/movie/";

    @Override
    protected Film doInBackground(String... params) {
        Film movie = null;
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection;

        try {
            System.out.println("Film id: " + params[0]);
            URL url = new URL(link + params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(800000);
            urlConnection.setConnectTimeout(800000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "M2DB");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                System.out.println("OK");

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

            } else {
                System.out.println("PAS OK");
            }
            urlConnection.disconnect();

            System.out.println("result: " + sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());

                int f_id = jsonObject.getInt("f_id");
                String f_name = jsonObject.getString("f_name");
                String description = jsonObject.getString("description");
                int duration = jsonObject.getInt("duration");
                int year = jsonObject.getInt("year");
                String fm_name = jsonObject.getString("fm_name");
                String fm_lastname = jsonObject.getString("fm_lastname");
                String act_name = jsonObject.getString("act_name");
                String act_lastname = jsonObject.getString("act_lastname");
                String t_name = jsonObject.getString("t_name");
                String imageURL = jsonObject.getString("imageURL");

                Film f = new Film(f_id, f_name, description, duration, year, fm_name, fm_lastname, act_name, act_lastname, t_name, imageURL);

                movie = f;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;

    }

}
