package com.example.comi_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicHolder> implements Filterable {

    private Context context;
    private List<Comic> comicList;
    private List<Comic> comicListOld;

    public ComicAdapter(Context context, List<Comic> comicList) {
        this.context = context;
        this.comicList = comicList;
        this.comicListOld= comicList;
    }

    @NonNull
    @Override
    public ComicAdapter.ComicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemcomic,parent, false);
        return new ComicHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicAdapter.ComicHolder holder, int position) {
        Comic comic =comicList.get(position);

        holder.name.setText(comic.getName());
        holder.author.setText(comic.getAuthor());
        holder.content.setText(comic.getContent());
        Glide.with(context).load(comic.getImage()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, Detail.class);

                Bundle bundle=new Bundle();
                bundle.putString("name",comic.getName());
                bundle.putString("author",comic.getAuthor());
                bundle.putString("img",comic.getImage());
                bundle.putString("content",comic.getContent());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()) {
                    comicList=comicListOld;
                }else{
                    List<Comic> listcomics = new ArrayList<>();
                    for (Comic comic: comicListOld){
                        if(comic.getName().toLowerCase().contains(strSearch.toLowerCase())){
                            listcomics.add(comic);
                        }
                    }
                    comicList = listcomics;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = comicList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                comicList = (List<Comic>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public static class ComicHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,author,content;
        LinearLayout linearLayout;
        public ComicHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageview);
            name=itemView.findViewById(R.id.name);
            author=itemView.findViewById(R.id.author);
            content=itemView.findViewById(R.id.content);
            linearLayout=itemView.findViewById(R.id.container);
        }
    }
}
