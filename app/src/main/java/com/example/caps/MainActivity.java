package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static Object mContext;
    Button T1,T2;
    LinearLayout lin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       T1 = (Button)findViewById(R.id.button1_3);
       lin1 = (LinearLayout)findViewById(R.id.lin2);

       T1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, beaconGps.class);
               startActivity(intent);
           }
       });

    }

}




