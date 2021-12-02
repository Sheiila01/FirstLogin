package com.example.firstlogin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ImageView mMan = findViewById(R.id.hipman);
        Glide.with(this).load(R.drawable.hipman).into(mMan);

    }


        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);

        }

//        // Method for Vaccinate button
//        public void openMain(View v) {
//            Intent intent = new Intent(Login.this, Main.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//        }

//        Button button_second = findViewById(R.id.button_second);
//        button_second.setOnClickListener(new View.OnClickListener() {
//
//        });



}