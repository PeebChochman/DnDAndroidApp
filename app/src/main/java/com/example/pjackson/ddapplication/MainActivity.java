package com.example.pjackson.ddapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnTRand);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Character character = new Character();
                TextView summaryView = findViewById(R.id.txtSummary);
                summaryView.setText(character.getCharacterSummary());
                Toast.makeText(MainActivity.this, "Success",Toast.LENGTH_LONG).show();
            }
        });
    }
}
