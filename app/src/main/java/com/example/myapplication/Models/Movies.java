package com.example.myapplication.Models;

public class Movies {
    String title,lang,photo,rating,release_date,overview;

    public Movies(String title,String lang,String photo,String rating,String release_date,String overview){
        this.title=title;
        this.lang=lang;
        this.photo=photo;
        this.rating=rating;
        this.release_date=release_date;
        this.overview=overview;
    }

    public Movies(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
