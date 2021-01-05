package com.example.telekomlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Go back with BackButton
        ImageButton fab = (ImageButton) findViewById(R.id.BackButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getBack();

            }
        });
    }

    public void getBack()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
