package com.example.ormwa_lv1dz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {
ImageView FirstPersonPic, SecondPersonPic, ThirdPersonPic;
Button QuoteBtn, EditDescBtn;
RadioButton P1,P2;
RadioGroup mRadioGroup;
TextView FirstPersonDesc, SecondPersonDesc, ThirdPersonDesc;
EditText EditDesc;
private String[] quotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quotes = getResources().getStringArray(R.array.Quotes);
        initializeUI();
    }

    private void initializeUI() {
        this.FirstPersonPic = (ImageView) findViewById(R.id.FirstPersonPicture);
        this.FirstPersonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstPersonPic.setVisibility(View.INVISIBLE);
            }
        });
        this.SecondPersonPic = (ImageView) findViewById(R.id.SecondPersonPicture);
        this.SecondPersonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondPersonPic.setVisibility(View.INVISIBLE);
            }
        });
        this.ThirdPersonPic = (ImageView) findViewById(R.id.ThirdPersonImage);
        this.ThirdPersonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdPersonPic.setVisibility(View.INVISIBLE);
            }

        });
        this.mRadioGroup = (RadioGroup) findViewById(R.id.RadioGrp);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            }
        });
        this.P1 = (RadioButton) findViewById(R.id.RadioBtnFirstPerson);
        this.P2 = (RadioButton) findViewById(R.id.RadioBtnSecondPerson);
        this.EditDesc = (EditText) findViewById(R.id.DescriptionEdit);
        this.FirstPersonDesc = (TextView) findViewById(R.id.FirstPersonDescription);
        this.SecondPersonDesc = (TextView) findViewById(R.id.SecondPersonDescription);
        this.ThirdPersonDesc = (TextView) findViewById(R.id.ThirdPersonDescription);
        this.EditDescBtn = (Button) findViewById(R.id.DescBtn);
        this.QuoteBtn = (Button) findViewById(R.id.QuoteButton);
        this.QuoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randInd = new Random().nextInt(quotes.length);
                String randomQuote = quotes[randInd];
            this.displayToast(randomQuote);
            }

            private void displayToast(String randomQuote) {
                makeText(MainActivity.this, randomQuote, Toast.LENGTH_LONG).show();
            }

        });
        this.EditDescBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioBtnID = mRadioGroup.getCheckedRadioButtonId();
                int p1rad= P1.getId();
                int p2rad = P2.getId();
                if (radioBtnID==p1rad) FirstPersonDesc.setText(EditDesc.getText());
                else if (radioBtnID==p2rad) SecondPersonDesc.setText(EditDesc.getText());
                else ThirdPersonDesc.setText(EditDesc.getText());
            }
        });

    }
}