package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class splash extends Activity implements View.OnClickListener {
    Button sav,ex;
    TextView user,pas;


    String Name="Yasso", Password="123";
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_layout);

        sav=findViewById(R.id.savebtn);
        sav.setOnClickListener(this);

        ex=findViewById(R.id.exit);
        ex.setOnClickListener(this);

        user=findViewById(R.id.username);
        pas=findViewById(R.id.password);



    }//end onCreate

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String na=user.getText().toString();
        String pass=pas.getText().toString();
        switch (view.getId()){
            case R.id.savebtn:
                if (na.equals(Name) && pass.equals(Password)){
                    Toast.makeText(this, "Success Login ", Toast. LENGTH_SHORT).show();
                    Intent i=new Intent(this,MainActivity.class);
                    startActivity(i);
                    ///////////

                    SharedPreferences preferences=getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("User",na);
                    editor.putString("Password",pass);
                    editor.commit();
                    ////

                    SharedPreferences sharedPreferences=getPreferences(Context.MODE_PRIVATE);
                    String Save=  sharedPreferences.getString("User","");
                    String pa=sharedPreferences.getString("Password","");
                    Toast.makeText(this,"User Name Is : "+Save,Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"Password Is : "+pa,Toast.LENGTH_LONG).show();
                    user.setText("");
                    pas.setText("");

                }//end if
                else if(na.isEmpty() && pass.isEmpty()){
                    Toast.makeText(this, "Enter Account Data  ", Toast.LENGTH_SHORT).show();
                }//end else if () 1
                else if(!na.isEmpty() && pass.isEmpty()){

                    Toast.makeText(this, "Enter Password   ", Toast.LENGTH_SHORT).show();
                }//end else if () 2
                else if(na.isEmpty() && !pass.isEmpty()){
                    Toast.makeText(this, "Enter UserName   ", Toast.LENGTH_SHORT).show();
                }//end else if () 3
                else{
                    Toast.makeText(this, "Access Denied ", Toast.LENGTH_LONG).show();
                }//end else ()
                break;
            case R.id.exit:
                finish();
              System.exit(0);
            break;
        }//end switch()

    }//end onClick


}//end class
