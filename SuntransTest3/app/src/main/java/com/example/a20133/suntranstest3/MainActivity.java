package com.example.a20133.suntranstest3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import Suntans.slidingmenu.view.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    private SlidingMenu mLeftMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);
    }

    public void toggleMenu(View view){

        mLeftMenu.toggle();
    }
    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
       getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }
}
