package com.example.ramzy2.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private  EditText billAmount;
    public static  EditText tipfield;
    private  EditText numberOfPeople;
    private ImageButton help;
    private Button calculate;



    static Helper saver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        billAmount = (EditText) findViewById(R.id.billAmount);
        tipfield = (EditText) findViewById(R.id.Tip);
        numberOfPeople = (EditText) findViewById(R.id.NumberOfPeople);
        help = (ImageButton) findViewById(R.id.Help);
        calculate = (Button) findViewById(R.id.Calculate);

        help.setOnClickListener((View.OnClickListener) this);
        calculate.setOnClickListener((View.OnClickListener) this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }



    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Help:
                startActivity(new Intent(MainActivity.this,suggestTip_Activity.class));
                break;
            case R.id.Calculate:
                if (checkInput()==true)
                    calculate();
                    startActivity(new Intent(MainActivity.this,summary.class));

                break;
        }
    }
    private  void calculate(){
        saver.setTip_amount(saver.getBill_amount()*saver.getTips_percent()/100);
        saver.setBill(saver.getBill_amount()+saver.getTip_amount());

        saver.setEach_amount(saver.getBill()/saver.getNumberOfpeople());

    }
     private boolean checkInput()
     {
         int bill, tipInt, people;
             String a=billAmount.getText().toString();
             bill =Integer.valueOf(a);
             String b=tipfield.getText().toString();
             tipInt =Integer.valueOf(b);
             String c=numberOfPeople.getText().toString();
             people =Integer.valueOf(c);
             saver = new Helper(bill, tipInt, people);

         boolean state =false;
         if(bill>0 && bill<=10000)
             state=true ;
         else
             Toast.makeText(getApplicationContext(), " Amount must be less than 10000 ",Toast.LENGTH_SHORT).show();
         if(tipInt>0 && tipInt<=100)
             state=true;
         else
             Toast.makeText(getApplicationContext(), " Tip must be less than 100 ",Toast.LENGTH_SHORT).show();
         if(people>0 && people<=100)
             state=true ;
         else
             Toast.makeText(getApplicationContext(), " number of People must be less than 100 ",Toast.LENGTH_SHORT).show();

         return state;



     }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, Currency.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_manage) {
            startActivity(new Intent(MainActivity.this, Currency.class));

        } else if (id == R.id.nav_share) {
            startActivity(new Intent(MainActivity.this, contact_us.class));
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

