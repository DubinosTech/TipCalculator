package com.example.ramzy2.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class contact_us extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    private TextView txt9;
    private TextView txt10;

    private ImageView email;
    private ImageButton phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        txt1 =findViewById(R.id.text1);
        txt2 =findViewById(R.id.text2);
        txt3 =findViewById(R.id.text3);
        txt4 =findViewById(R.id.text4);
        txt5 =findViewById(R.id.text5);
        txt6 =findViewById(R.id.text6);
        txt7 =findViewById(R.id.text7);
        txt8 =findViewById(R.id.text8);
        txt9 =findViewById(R.id.text9);
        txt10 =findViewById(R.id.text10);

        email=findViewById(R.id.btn1);
        phone=findViewById(R.id.btn2);

    }
}
