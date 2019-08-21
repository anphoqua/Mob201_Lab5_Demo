package com.example.anphoqua.dantrinews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class TinTheoLoaiActivity extends AppCompatActivity {
    String link;
    ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_theo_loai);
        listView2 = findViewById(R.id.listView2ID);
        link = getIntent().getStringExtra("link");
        Toast.makeText(TinTheoLoaiActivity.this, link, Toast.LENGTH_SHORT).show();

        MyTask task = new MyTask(TinTheoLoaiActivity.this, link, listView2);
        task.execute();



    }
}
