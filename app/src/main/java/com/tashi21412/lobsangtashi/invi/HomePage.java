package com.tashi21412.lobsangtashi.invi;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class HomePage extends AppCompatActivity {
    ListView listView;
    ArrayList <String> userList;
    ArrayList <String> addressList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        listView = (ListView) findViewById(R.id.events);

        this.userList = new ArrayList<>();
        this.addressList = new ArrayList<>();

        userList.add("pema21");
        userList.add("charlie33");
        userList.add("lhasa59");
        userList.add("x42hun");
        userList.add("Zero23");
        userList.add("Hanna_time");

        addressList.add("TimeSquare");
        addressList.add("Brooklyn Bridge");
        addressList.add("Northern Boulveard");
        addressList.add("Manhatan");
        addressList.add("43-12 Night St");
        addressList.add("Queens");




        CustomAdapter arrayAdapter = new CustomAdapter(this, userList, addressList);
        //ArrayAdapter arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                startActivity(new Intent(HomePage.this, DetailView.class));


            }
        });

    }


    public class CustomAdapter extends ArrayAdapter {
        Context context;
        ArrayList <String> userList;
        ArrayList <String>addressList;
        LayoutInflater inflter;

        public CustomAdapter(Context applicationContext, ArrayList userList, ArrayList addressList) {
            super(applicationContext, R.layout.home_page, userList);
            this.context = applicationContext;
            this.userList = userList;
            this.addressList = addressList;

        }



        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view ==null){
                inflter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflter.inflate(R.layout.home_page,null);

            }

            TextView myLoginUser = (TextView) view.findViewById(R.id.loginUser);
            TextView myAddress = (TextView) view.findViewById(R.id.loginAddress);

            myLoginUser.setText(this.userList.get(i));
            myAddress.setText(this.addressList.get(i));

            return view;
        }


    }
}
