package com.example.anphoqua.dantrinews;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MyTask extends AsyncTask<Void, Void, Void> {
    Context context;
    String diachi;
    ListView listView;
    ArrayList<Item> arrayList = new ArrayList<Item>();

    public MyTask(Context context, String diachi, ListView listView) {
        this.context = context;
        this.diachi = diachi;
        this.listView = listView;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(diachi);
            URLConnection ketnoi = url.openConnection();
            InputStream inputStream = ketnoi.getInputStream();

            MySaxParser parser = new MySaxParser();
            arrayList = parser.xmlParser(inputStream);

            Log.d("dulieu", "size = "+arrayList.size());

//            Kiem tra xem da lay duoc du lieu chua
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String line="";
//            StringBuffer stringBuffer = new StringBuffer("");
//            while ((line=bufferedReader.readLine()) != null) {
//                stringBuffer.append(line);
//            }
//            Log.d("dulieu", "doInBackground: "+stringBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        MyAdapter adapter = new MyAdapter(context, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String link = arrayList.get(i).link;
                Intent intent = new Intent(context, XemTin.class);
                intent.putExtra("link", link);
                context.startActivity(intent);
            }
        });
        super.onPostExecute(aVoid);
    }
}
