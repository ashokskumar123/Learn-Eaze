package com.example.android.learneaze;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Common_subjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_subjects);
        setTitle(" 1st Year Subjects ");

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ListView branches = (ListView) findViewById(R.id.com_sub);

        ArrayList<String> brancheNames = new ArrayList<String>();

        brancheNames.add(" Mathematics -1 ");
        brancheNames.add(" Physics ");
        brancheNames.add(" Elements of Civil Engg ");
        brancheNames.add(" Basic Electrical Engg (BEE) ");
        brancheNames.add(" Chemistry ");
        brancheNames.add(" Computer Concepts & C-Prog (CCP) ");
        brancheNames.add(" Environmental Science (ES) ");

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
