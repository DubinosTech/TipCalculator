package com.example.ramzy2.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class suggestTip_Activity extends AppCompatActivity implements View.OnClickListener {


    private RatingBar ratingBar;
    private Button submitbtn;
    private TextView rating;
    private Button backbtn;
    Helper save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_tip);
        submitbtn = (Button) findViewById(R.id.submit);
        backbtn = (Button) findViewById(R.id.back);
        rating = (TextView) findViewById(R.id.rating_display_text_View);
        ratingBar = (RatingBar) findViewById(R.id.rating_rating_bar);

        save = new Helper();
        submitbtn.setOnClickListener((View.OnClickListener) this);
        backbtn.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                float rate = ratingBar.getRating();
                double tip = 10 + (2 * rate);
                rating.setText("Based on your rating, you should give a TIP of: \n" + tip + "%");
                save.setTips_percent((int) tip);
                break;
            case R.id.back:
                startActivity(new Intent(suggestTip_Activity.this, MainActivity.class));
                break;

        }
    }
}
