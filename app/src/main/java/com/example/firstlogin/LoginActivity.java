package com.example.firstlogin;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView mGirl = findViewById(R.id.girl);
        Glide.with( this ).load(R.drawable.girl).into(mGirl);
        Button button_first = findViewById(R.id.button_first);
        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Signup.class);
                startActivity(intent);

            }
        });
    }
}
