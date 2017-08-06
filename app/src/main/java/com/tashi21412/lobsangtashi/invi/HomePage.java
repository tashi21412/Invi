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

        addressList.add("TimeSquare");
        addressList.add("Brooklyn Bridge");
        addressList.add("Northern Boulveard");
        addressList.add("Manhatan");

        CustomArrayAdapter arrayAdapter = new CustomArrayAdapter(this, userList, addressList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(HomePage.this, DetailView.class);
                String userName = ((TextView)view.findViewById(R.id.loginUser)).getText().toString();
                intent.putExtra("name",userName);
                startActivity(intent);
            }
        });


    }

    public class CustomArrayAdapter extends BaseAdapter{
        public final Context context;
        public final ArrayList <String> userName;
        public final ArrayList <String> eventAddress;


        public CustomArrayAdapter(Context context, ArrayList<String> userName, ArrayList<String> eventAddress) {
            this.context = context;
            this.userName = userName;
            this.eventAddress = eventAddress;

        }

        @Override
        public int getCount() {
            return userName.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.home_page,null);

            TextView user  = (TextView) findViewById(R.id.loginUser);
            TextView address  = (TextView) findViewById(R.id.loginAddress);

            user.setText("myName");
            address.setText("YourName");

            return rowView;
        }
    }
}
