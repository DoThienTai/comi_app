package com.example.comi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AssessComic extends AppCompatActivity {
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

        commentListView = findViewById(R.id.comment_listview);

        EditText nameEditText = findViewById(R.id.comment_name);
        EditText contentEditText = findViewById(R.id.comment_content);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button commentButton = findViewById(R.id.comment_button);
        Button backButton = findViewById(R.id.btnbutton);

        Intent intent = getIntent();
        String bookTitle = intent.getStringExtra("bookTitle");

        commentDatabase = new CommentDatabase(this);

        commentList = commentDatabase.getAllComments(); // Khôi phục danh sách bình luận từ cơ sở dữ liệu

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String content = contentEditText.getText().toString();
                float rating = ratingBar.getRating();


                // Tạo mới đối tượng Comment với tên truyện là "Comic Title"
                Comment comment = new Comment(0, name, content, rating, bookTitle);


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
                onBackPressed(); // Gọi phương thức onBackPressed() để thực hiện hành động quay lại mặc định của Activity
            }
        });

        displayComments();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        commentDatabase.close(); // Đóng kết nối cơ sở dữ liệu khi activity bị hủy
    }
}
