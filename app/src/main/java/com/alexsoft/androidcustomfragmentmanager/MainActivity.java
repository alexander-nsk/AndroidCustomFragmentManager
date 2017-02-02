package com.alexsoft.androidcustomfragmentmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ApplicationController.getInstance().getFragmentManager().getRootView());
    }

    @Override
    public void onBackPressed() {
        try {
            ApplicationController.getInstance().getFragmentManager().pop();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        if (ApplicationController.getInstance().getFragmentManager().isEmpty()) {
            finish();
        }
    }
}
