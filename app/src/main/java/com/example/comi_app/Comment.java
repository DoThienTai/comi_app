package com.example.comi_app;
public class Comment {
    private String name;
    private String content;
    private float rating;

    public Comment(int id, String name, String content, float rating) {
        this.name = name;
        this.content = content;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public float getRating() {
        return rating;
    }
    @Override
    public String toString() {
        return "Name: " + name + "\nContent: " + content + "\nRating: " + rating;
    }
}
