package com.example.navyakaree.tictactoeapp;

/**
 * Created by NavyaKaree on 11/23/16.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MeActivity extends AppCompatActivity {

    Button meFirst,computerFirst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meFirst =(Button)findViewById(R.id.me_btn);
        computerFirst =(Button)findViewById(R.id.compuetr);
        meFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MeActivity.this,MainActivity.class);
                intent.putExtra("TYP",true);
                startActivity(intent);
            }
        });
        computerFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MeActivity.this,MainActivity.class);
                intent.putExtra("TYP",false);
                startActivity(intent);

            }
        });
    }
}

