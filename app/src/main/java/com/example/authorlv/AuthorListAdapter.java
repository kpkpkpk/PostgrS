package com.example.authorlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AuthorListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList<Author> authorArrayList;
    public AuthorListAdapter(Context context,ArrayList<Author> authors){
    layoutInflater=LayoutInflater.from(context);
    authorArrayList=authors;
    }
    @Override
    public int getCount() {
        return authorArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        Author author=authorArrayList.get(position);
        if(author!=null){
            return author.getId();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item,parent,false);
        }
        TextView authorTextView=convertView.findViewById(R.id.authorName);
        authorTextView.setText(authorArrayList.get(position).getName());
        return convertView;
    }
}
