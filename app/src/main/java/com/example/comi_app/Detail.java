package com.example.comi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Detail extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comicdetail);
        CollapsingToolbarLayout collapsingToolbarLayout =findViewById(R.id.collapsingtoolbar);
        ImageView imageView=findViewById(R.id.img_detail);
        TextView name=findViewById(R.id.name_detail);
        TextView author=findViewById(R.id.author_detail);
        TextView content=findViewById(R.id.desc_detail);

        Bundle bundle =getIntent().getExtras();

        String nameDetail =bundle.getString("name");
        String authorDetail =bundle.getString("author");
        String contentDetail =bundle.getString("content");
        String imgDetail =bundle.getString("img");

        Glide.with(this).load(imgDetail).into(imageView);
        name.setText(nameDetail);
        author.setText(authorDetail);
        content.setText(contentDetail);
        collapsingToolbarLayout.setTitle(nameDetail);

        button = (Button) findViewById(R.id.button);
        button2 =(Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detail.this,AssessComic.class);
                intent.putExtra("bookTitle", nameDetail);

                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detail.this,Home.class);
                startActivity(intent);
            }
        });
        //loadContent();

    }

}
