package com.example.afpa.m2dbjava.model;

/**
 * Created by Afpa on 09/02/2017.
 */

public class Film {

    int f_id;
    String f_name;
    String description;
    int duration;
    int year;

    String fm_lastname;
    String fm_name;

    String act_name;
    String act_lastname;

    String t_name;

    String imageURL;

    public Film(int f_id, String f_name, String description, int duration, int year, String fm_lastname, String fm_name, String act_name, String act_lastname, String t_name, String imageURL) {
        this.f_id = f_id;
        this.f_name = f_name;
        this.description = description;
        this.duration = duration;
        this.year = year;
        this.fm_lastname = fm_lastname;
        this.fm_name = fm_name;
        this.act_name = act_name;
        this.act_lastname = act_lastname;
        this.t_name = t_name;
        this.imageURL = imageURL;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFm_lastname() {
        return fm_lastname;
    }

    public void setFm_lastname(String fm_lastname) {
        this.fm_lastname = fm_lastname;
    }

    public String getFm_name() {
        return fm_name;
    }

    public void setFm_name(String fm_name) {
        this.fm_name = fm_name;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getAct_lastname() {
        return act_lastname;
    }

    public void setAct_lastname(String act_lastname) {
        this.act_lastname = act_lastname;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return this.f_name + " (" + this.year + ")" ;
    }
}