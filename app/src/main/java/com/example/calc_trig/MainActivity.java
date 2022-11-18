package com.example.calc_trig;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView res;
    private Button calc;
    private RadioButton rb_11,rb_12,rb_13,rb_21,rb_22,rb_23;
    private ImageView img;
    private RadioGroup radioGroup,radioGroup2;
    double angulo;
    int op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res=(TextView)findViewById(R.id.res);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup2=findViewById(R.id.radioGroup2);
        calc=(Button)findViewById(R.id.calc);
        rb_11=(RadioButton)findViewById(R.id.rb_11);
        rb_12=(RadioButton)findViewById(R.id.rb_12);
        rb_13=(RadioButton)findViewById(R.id.rb_13);
        rb_21=(RadioButton)findViewById(R.id.rb_21);
        rb_22=(RadioButton)findViewById(R.id.rb_22);
        rb_23=(RadioButton)findViewById(R.id.rb_23);
        img=(ImageView) findViewById(R.id.img);

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {
                switch (chekedId){
                    case R.id.rb_21:
                       angulo=45;
                        img.setImageDrawable(getResources().getDrawable(R.drawable.cuarentaycico));
                        break;
                    case R.id.rb_22:
                        angulo=90;
                        img.setImageDrawable(getResources().getDrawable(R.drawable.noventa));
                        break;
                    case R.id.rb_23:
                        angulo=180;
                        img.setImageDrawable(getResources().getDrawable(R.drawable.cientochenta));
                        break;
                }
            }
        }

        );

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {
                switch (chekedId){
                    case R.id.rb_11:
                        op=1;
                        break;
                    case R.id.rb_12:
                        op=2;
                        break;
                    case R.id.rb_13:
                        op=3;
                        break;
                }
            }
        }

        );

        calc.setOnClickListener(view -> {

            double r=0,a;

            if (op==1){
                a=Math.toRadians(angulo);
                r=Math.sin(a);
            }
            else{
                if (op==2){
                    a=Math.toRadians(angulo);
                    r=Math.cos(a);
                }
                else {
                    if (op==3){
                        a=Math.toRadians(angulo);
                        r=Math.tan(a);
                    }
                }
            }
            //String finalresult = String.valueOf(r);
            String stringdouble= Double.toString(r);
            res.setText(stringdouble);
            //res.setText(finalresult);
        });

        }



    }

