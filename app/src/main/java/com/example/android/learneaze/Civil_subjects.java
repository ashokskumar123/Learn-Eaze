package com.example.android.learneaze;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Civil_subjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_subjects);

        setTitle(" Civil Subjects ");

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ListView branches = (ListView) findViewById(R.id.civ_sub);

        ArrayList<String> brancheNames = new ArrayList<String>();

        brancheNames.add(" 1 ");
        brancheNames.add(" 2 ");
        brancheNames.add(" 3 ");
        brancheNames.add(" 4 ");
        brancheNames.add(" 5 ");
        brancheNames.add(" 6 ");
        brancheNames.add(" 7  ");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, brancheNames);

        branches.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }
}
