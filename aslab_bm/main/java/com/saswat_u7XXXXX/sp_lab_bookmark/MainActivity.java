package com.saswat_u7156387.sp_lab_bookmark;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    EditText urls;


    ArrayAdapter<String> mAdapter;
    ArrayList<String> my_arr;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lstview);
        Intent intent = getIntent();
        User u = (User) Objects.requireNonNull(intent.getExtras()).getSerializable("USER");
        my_arr = new ArrayList<>();
        ArrayList<UrlList> urlLists = new ArrayList<UrlList>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.data), "UTF-8"));
            String line;
            int i=0;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length==2) {//checking if the number of tokens in each line is correct
                    assert u != null;
                    if(tokens[0].equals(u.getId())){
                        urlLists.add(new UrlList(tokens[0],tokens[1]));

                        i++;
//                        my_arr.add(tokens[1]);
                    }
                }
            }
            for(int j=0;j<i;j++){
                my_arr.add(urlLists.get(j).getUrl());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

//        my_arr.add("https://www.anu.edu.au/");
//        my_arr.add("https://www.google.com/");

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, my_arr);


        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);


    }


    public void Added(View view) {
        urls = (EditText) findViewById(R.id.editTextTextPersonName);
        my_arr.add(urls.getText().toString());
        urls.setText("");
        Toast.makeText(getApplicationContext(), urls.getText().toString(), Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), ActivityWeb.class);
        intent.putExtra("url", adapterView.getItemAtPosition(i).toString());
        startActivity(intent);


    }

}