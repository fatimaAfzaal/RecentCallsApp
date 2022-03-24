package com.example.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts=new ArrayList<>();
    private RecyclerContactAdapter.RecyclerViewClickListener listener;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=(TextView) findViewById(R.id.textView4);
        TextView t1=(TextView) findViewById(R.id.textView3);
        RecyclerView recyclerView=findViewById((R.id.recyclerContact));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.first,"Fatima","0310 5425910","Today",R.drawable.ic_baseline_call_made_24));
        arrContacts.add(new ContactModel(R.drawable.second,"Afzaal","0321 5220564","Yesterday",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.third,"Menahil","0310 5539826","March 16",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.four,"Momin","0310 3725836","March 14",R.drawable.ic_baseline_call_made_24));
        arrContacts.add(new ContactModel(R.drawable.six,"Ayesha","0320 5825394","March 12",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.seven,"Hajra","0336 9944429","March 10",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.fff,"Ahmed","0321 5734925","March 2",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.nine,"Dawood","0310 6825302","March 1",R.drawable.ic_baseline_call_made_24));
        arrContacts.add(new ContactModel(R.drawable.ten,"Bushra","0310 8502536","March 1",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.eleven,"Haleema","0321 7394756","February 25",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.twelve,"Maryam","0320 6482436","February 20",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.thirteen,"Ali","0330 5735372","February 15",R.drawable.ic_baseline_call_received_24));
        arrContacts.add(new ContactModel(R.drawable.fourteen,"Tooba","0310 7852636","February 2",R.drawable.ic_baseline_call_made_24));

        setOnClickListener();
        RecyclerContactAdapter adapter=new RecyclerContactAdapter(this,arrContacts,listener);
        recyclerView.setAdapter(adapter);

        CardView cd=(CardView) findViewById(R.id.card);



    }

    private void setOnClickListener() {

        listener=new RecyclerContactAdapter.RecyclerViewClickListener(){

            @Override
            public void onClick(View view, int position) {
                Intent i=new Intent(Intent.ACTION_DIAL);
               String st=arrContacts.get(position).no;
                i.setData(Uri.parse("tel: "+st));
                startActivity(i);
            }
        };
    }
}