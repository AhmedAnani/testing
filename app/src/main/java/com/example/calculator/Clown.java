package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


public class Clown extends Activity implements View.OnClickListener {
    Toolbar tool;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clown);

        tool=findViewById(R.id.toolbar2);
        tool.inflateMenu(R.menu.option_clown);
        tool.setOnMenuItemClickListener(v -> {
            if (v.getItemId() == R.id.exit) {
                finish();
                System.exit(0);
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }//end switchCase ()
            return true;
        });

    }

    @Override
    public void onClick(View view) {

    }
}
