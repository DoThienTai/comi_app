package com.example.comi_app;

public class Comment {
    private int id;
    private String name;
    private String content;
    private float rating;
    private String bookTitle;

    public Comment(int id, String name, String content, float rating, String bookTitle) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.rating = rating;
        this.bookTitle = bookTitle;
    }

    public Comment(int id, String name, String content, float rating) {
    }

    public int getId() {
        return id;
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

    public String getBookTitle() {
        return bookTitle;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nContent: " + content + "\nRating: " + rating +"\nBookTitle: "+bookTitle;
    }
}
