package com.example.android.learneaze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        setTitle( "LEARN EAZE");

         Button materials = (Button) findViewById(R.id.button_material);

         Button stores = (Button) findViewById(R.id.button_stores);

         Button login = (Button) findViewById(R.id.button_login);

         materials.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent branche = new Intent(HomePage.this , Branches.class);
                 startActivity(branche);
             }
         });
        stores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent store = new Intent(HomePage.this , Stores.class);
                startActivity(store);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(HomePage.this , LogIn.class);
                startActivity(login);
            }
        });




    }
}
