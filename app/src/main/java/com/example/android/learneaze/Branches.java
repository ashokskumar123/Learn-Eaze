package com.example.android.learneaze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Branches extends AppCompatActivity {

    ListView branches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches);

        setTitle( " Branches ");

        if(getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        branches = (ListView) findViewById(R.id.list_branches);

        ArrayList<String> brancheNames = new ArrayList<String>();

        brancheNames.add(" Computer Science Engineering (CSE) ");
        brancheNames.add(" Mechanical Engineering ");
        brancheNames.add(" Civil Engineering");
        brancheNames.add(" Electrical Engineering (ECE)");
        brancheNames.add(" Electronics Engineering (EEE) ");
        brancheNames.add(" General (1st year) ");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, brancheNames);

        branches.setAdapter(adapter);

        branches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {

                    Intent i = new Intent(Branches.this , Cse_subjects.class );
                    startActivity(i);

                } else
                    if(position == 1) {

                    Intent j = new Intent(Branches.this , Mech_subjects.class );
                        startActivity(j);

                } else
                    if(position == 2) {

                    Intent k = new Intent(Branches.this , Civil_subjects.class );
                        startActivity(k);

                } else
                    if(position == 3) {

                    Intent l = new Intent(Branches.this , Ece_subjects.class );
                        startActivity(l);

                } else
                    if(position == 4) {

                        Intent m = new Intent(Branches.this , Eee_subjects.class );
                        startActivity(m);

                    } else
                    if(position == 5) {

                        Intent n = new Intent(Branches.this , Common_subjects.class );
                        startActivity(n);

                    }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }
}
