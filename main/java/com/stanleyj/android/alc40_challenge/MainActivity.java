package com.stanleyj.android.alc40_challenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonALC, buttonProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       finding the toolbar from the xml and setting it as the support actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ALC 4.0 Phase 1g");

//        finding AboutALC and MyProfile button in the xml
        buttonALC = (Button) findViewById(R.id.about_alc);
        buttonProfile = (Button) findViewById(R.id.my_profile);

//        adding onClickListener to the both buttons
        buttonALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                an intent to call the ActivityB class containg about ALC
                startActivity(new Intent(MainActivity.this, ActivityB.class));
            }
        });
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               an intent to call the ActivityC class containing MyProfile
                startActivity(new Intent(MainActivity.this, ActivityC.class));

            }
        });

    }
}
