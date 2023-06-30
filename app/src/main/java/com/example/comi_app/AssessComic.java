package com.example.comi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AssessComic extends AppCompatActivity {
    private Button button;
    private List<Comment> commentList = new ArrayList<>();
    private ListView commentListView;
    private CommentDatabase commentDatabase;

    private void displayComments() {
        ArrayAdapter<Comment> commentAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, commentList);

        commentListView.setAdapter(commentAdapter);
    }

    private void addCommentTo(Comment comment) {
        commentList.add(comment);
        commentDatabase.addComment(comment); // Lưu bình luận vào cơ sở dữ liệu
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);

        button = findViewById(R.id.btnbutton);
        commentListView = findViewById(R.id.comment_listview);

        EditText nameEditText = findViewById(R.id.comment_name);
        EditText contentEditText = findViewById(R.id.comment_content);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button commentButton = findViewById(R.id.comment_button);
        Button backButton = findViewById(R.id.btnbutton);

        commentDatabase = new CommentDatabase(this);

        commentList = commentDatabase.getAllComments(); // Khôi phục danh sách bình luận từ cơ sở dữ liệu

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String content = contentEditText.getText().toString();
                float rating = ratingBar.getRating();

                int id = 0;
                Comment comment = new Comment(id, name, content, rating);

                addCommentTo(comment);

                displayComments();

                nameEditText.setText("");
                contentEditText.setText("");
                ratingBar.setRating(0);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện hành động khi nhấn nút "Trở lại"
                finish(); // Kết thúc activity và quay lại activity trước đó
            }
        });

        displayComments();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AssessComic.this, Detail.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        commentDatabase.close(); // Đóng kết nối cơ sở dữ liệu khi activity bị hủy
    }
}
