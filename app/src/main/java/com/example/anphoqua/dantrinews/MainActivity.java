package com.example.anphoqua.dantrinews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String danhmuc[] = new String[]
            {
                    "Thoi su",
                    "The gioi",
                    "Giai tri",
                    "The thao"
            };
    String diachi[] = new String[]
            {
                "https://vnexpress.net/rss/thoi-su.rss",
                "https://vnexpress.net/rss/the-gioi.rss",
                "https://vnexpress.net/rss/giai-tri.rss",
                "https://vnexpress.net/rss/the-thao.rss"
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewID);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_expandable_list_item_1, danhmuc);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, TinTheoLoaiActivity.class);
                intent.putExtra("link", diachi[i]);
                startActivity(intent);
            }
        });
    }
}
