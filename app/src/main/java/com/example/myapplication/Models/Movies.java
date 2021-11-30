package com.example.myapplication.Models;

public class Movies {
    String title,lang,photo,rating;

    public Movies(String title,String lang,String photo,String rating){
        this.title=title;
        this.lang=lang;
        this.photo=photo;
        this.rating=rating;
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
}
