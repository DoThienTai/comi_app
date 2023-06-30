package com.example.comi_app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CommentDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "comments.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_COMMENTS = "comments";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CONTENT = "content";
    private static final String COLUMN_RATING = "rating";
    private static final String COLUMN_BOOK_TITLE = "book_title";

    public CommentDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_COMMENTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_CONTENT + " TEXT,"
                + COLUMN_RATING + " REAL,"
                + COLUMN_BOOK_TITLE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

    public void addComment(Comment comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, comment.getName());
        values.put(COLUMN_CONTENT, comment.getContent());
        values.put(COLUMN_RATING, comment.getRating());
        values.put(COLUMN_BOOK_TITLE, comment.getBookTitle());
        db.insert(TABLE_COMMENTS, null, values);
        db.close();
    }

    public List<Comment> getAllComments() {
        List<Comment> commentList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_COMMENTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex(COLUMN_CONTENT));
                @SuppressLint("Range") float rating = cursor.getFloat(cursor.getColumnIndex(COLUMN_RATING));
                @SuppressLint("Range") String bookTitle = cursor.getString(cursor.getColumnIndex(COLUMN_BOOK_TITLE));
                Comment comment = new Comment(id, name, content, rating, bookTitle);
                commentList.add(comment);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return commentList;
    }
}
