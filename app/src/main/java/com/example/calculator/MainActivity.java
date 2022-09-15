package com.example.calculator;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


public class MainActivity extends  Activity implements View.OnClickListener {
TextView t1,t3;
Button button0,button1, button2, button3, button4, button5, button6, button7, button8, button9,
        buttonclear, buttonEqual, buttonadd, buttonsub, buttondiv, buttonmul;
Toolbar tool;
    int  num1,num2,Re;
boolean  add =false,sub=false, div=false ,mul=false;
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0=findViewById(R.id.button9);// 0
        button1=findViewById(R.id.button10);// 1
        button2=findViewById(R.id.button11);// 2
        button3=findViewById(R.id.button12);// 3
        button4=findViewById(R.id.button5);// 4
        button5=findViewById(R.id.button6);// 5
        button6=findViewById(R.id.button7);// 6
        button7=findViewById(R.id.button8);// 7
        button8=findViewById(R.id.button);// 8
        button9=findViewById(R.id.button2);// 9

        buttonclear=findViewById(R.id.button3clear);//Clear
        buttonclear.setOnClickListener(this);

        buttonEqual =findViewById(R.id.button4equal);//Equal
        buttonEqual.setOnClickListener(this);

        buttonadd =findViewById(R.id.button1add);//add
        buttonadd.setOnClickListener(this);

        buttonsub =findViewById(R.id.button1sub);//sub
        buttonsub.setOnClickListener(this);

        buttondiv =findViewById(R.id.button1div);//div
        buttondiv.setOnClickListener(this);

        buttonmul =findViewById(R.id.button1mul);//mul
        buttonmul.setOnClickListener(this);

        tool = findViewById(R.id.toolbar);
        tool.inflateMenu(R.menu.option_menu);
        tool.setOnMenuItemClickListener(v->
        {
            switch (v.getItemId()){
                case R.id.helpp:
                    Intent s=new Intent(this,Clown.class); 
                    startActivity(s);
                    Toast.makeText(this, " :)", Toast.LENGTH_LONG).show();
                    break;
                case R.id.exit:
                    Toast.makeText(this, "Bye", Toast.LENGTH_LONG).show();
                    finish();
                    System.exit(0);
                    break;
                default:
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                    break;
            }//end switchCase ()
            return true;
        });//end setOnMenuItemClickListener ()


        t1=findViewById(R.id.t);
        t3=findViewById(R.id.t3);

        button0.setOnClickListener((v) -> t1.setText(t1.getText() + "0"));
        button1.setOnClickListener((v) -> t1.setText(t1.getText() + "1"));
        button2.setOnClickListener((v) -> t1.setText(t1.getText() + "2"));
        button3.setOnClickListener((v) -> t1.setText(t1.getText() + "3"));
        button4.setOnClickListener((v) -> t1.setText(t1.getText() + "4"));
        button5.setOnClickListener((v) -> t1.setText(t1.getText() + "5"));
        button6.setOnClickListener((v) -> t1.setText(t1.getText() + "6"));
        button7.setOnClickListener((v) -> t1.setText(t1.getText() + "7"));
        button8.setOnClickListener((v) -> t1.setText(t1.getText() + "8"));
        button9.setOnClickListener((v) -> t1.setText(t1.getText() + "9"));




    }//end onCreate ()

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {

            case R.id.button1add:
                num1=Integer.parseInt(t1.getText().toString());
                t1.setText("");
                  add=true;
                    break;
            case R.id.button1sub:
                num1=Integer.parseInt(t1.getText().toString());
                t1.setText("");
                sub=true;
                break;
            case R.id.button1div:
               num1=Integer.parseInt(t1.getText().toString());
                    t1.setText("");
                    div=true;
                break;
            case R.id.button1mul:
                num1=Integer.parseInt(t1.getText().toString());
                t1.setText("");
                mul=true;
                break;
            case R.id.button4equal:
                num2=Integer.parseInt(t1.getText().toString());

                if ( add){
                   Re=num1+num2;
                   t3.setText(num1 + " + " + num2 + " = "+Re);
                }//end add ()

                else if(sub){
                   Re=num1-num2;
                    t3.setText(num1 + " - " + num2 + " = "+Re);
                }//end sub ()

                else if(div){
                    Re=num1/num2;
                    t3.setText( num1 + " / " + num2 + " = " + Re);

                }//end div
                else if(mul){
                    Re=num1*num2;
                    t3.setText( num1 + " * " + num2 + " = " + Re);
                }
                break;

            case R.id.button3clear:
                t1.setText("");
                t3.setText("");
                add=sub=mul=false;
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                break;

        }//end switchCase ()

    }//end onClick ()


}//end class