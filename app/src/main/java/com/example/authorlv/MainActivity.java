package com.example.authorlv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ConnectPostgres connectPostgres;
    private ListView listView;
    Context context=this;
    Thread thread;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        connectPostgres=new ConnectPostgres();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        button=findViewById(R.id.get);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, connectPostgres.getAuthorArrayList().get(0).getName(), Toast.LENGTH_SHORT).show();
//                listView.setAdapter(new AuthorListAdapter(context,connectPostgres.getAuthorArrayList()));
            }
        });
        thread=new Thread(connectPostgres);
        thread.start();
        while (thread.isAlive()){
            Toast.makeText(this, "dwnld", Toast.LENGTH_SHORT).show();
        }
    }
}