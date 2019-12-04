package com.example.addpointfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.addpointfinder.R;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1,b2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1=findViewById(R.id.e1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t1=findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String add=e1.getText().toString();

                Geocoder geocoder=new Geocoder(getApplicationContext());

                try {
                    List<Address> data=geocoder.getFromLocationName(add,1);
                    for (Address a:data)
                    {
                        double lat=a.getLatitude();
                        double log=a.getLongitude();
                        t1.append(lat + "," + log);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });



    }
}
