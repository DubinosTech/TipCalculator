package com.example.ramzy2.tipcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Settings extends AppCompatActivity implements View.OnClickListener {
    private TextView total;
    private TextView tip;
    private TextView eachAmount;
    private Button reset;
    private Button back;
    Session session;

    Helper hp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        total =  findViewById(R.id.totalAmount);
        tip =findViewById(R.id.tipAmount);
        eachAmount =  findViewById(R.id.eachPay);
        reset =  findViewById(R.id.sReset);
        back = findViewById(R.id.sBack);

        hp= new Helper();

        total.setText("Total amount to pay is: " +hp.getBill()+"$");
        tip.setText("Tip amount given is: " +hp.getTip_amount()+"$");
        eachAmount.setText("Each person pays: " +hp.getEach_amount()+"$");

        session = new Session(this);
        back.setOnClickListener(this);
        reset.setOnClickListener(this);

        session.setLoggedin(true);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.sBack:
                startActivity(new Intent(Settings.this,MainActivity.class));
                break;
            case R.id.sReset:
                startActivity(new Intent(Settings.this, MainActivity.class));
        }


    }
}
