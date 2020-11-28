package com.example.sskyu_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String[] burgerNames ={"쫩쫩버거","치킨버거","치즈버거"};
    int[] burgerPrices ={5000,4600,3000};
    int[] burgerDegree ={0,0,0};
    int[] addedPrices ={0,0,0};

    int total_money = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView total_money_tv = (TextView)findViewById(R.id.total_money_tv);
        total_money_tv.setText(total_money + "원");

        Button add_jjap_btn = (Button)findViewById(R.id.add_jjap_btn);
        Button add_chicken_btn = (Button)findViewById(R.id.add_chicken_btn);
        Button add_cheese_btn = (Button)findViewById(R.id.add_cheese_btn);

        Button cancel_btn = (Button)findViewById(R.id.cancel_btn);
        Button payment_btn = (Button)findViewById(R.id.payment_btn);


        add_jjap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView jjapDegree = (TextView)findViewById(R.id.jjapDegree);
                TextView jjapTotalPrice = (TextView)findViewById(R.id.jjapTotalPrice);

                burgerDegree[0]++;
                total_money += burgerPrices[0];
                addedPrices[0] += burgerPrices[0];

                TextView total_money_tv = (TextView)findViewById(R.id.total_money_tv);
                total_money_tv.setText(total_money + "원");

                jjapDegree.setText(Integer.toString(burgerDegree[0]));
                jjapTotalPrice.setText( Integer.toString(addedPrices[0]));

            }
        });

        add_chicken_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView chickenDegree = (TextView)findViewById(R.id.chickenDegree);
                TextView chickenTotalPrice = (TextView)findViewById(R.id.chickenTotalPrice);

                burgerDegree[1]++;
                total_money += burgerPrices[1];
                addedPrices[1] += burgerPrices[1];

                TextView total_money_tv = (TextView)findViewById(R.id.total_money_tv);
                total_money_tv.setText(total_money + "원");

                chickenDegree.setText(Integer.toString(burgerDegree[1]));
                chickenTotalPrice.setText(Integer.toString(addedPrices[1]));

            }
        });
        add_cheese_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView cheeseDegree = (TextView)findViewById(R.id.cheeseDegree);
                TextView cheeseTotalPrice = (TextView)findViewById(R.id.cheeseTotalPrice);

                burgerDegree[2]++;
                total_money += burgerPrices[2];
                addedPrices[2] += burgerPrices[2];
                TextView total_money_tv = (TextView)findViewById(R.id.total_money_tv);
                total_money_tv.setText(total_money + "원");

                cheeseDegree.setText(Integer.toString(burgerDegree[2]));
                cheeseTotalPrice.setText(Integer.toString(addedPrices[2]));

            }
        });


        cancel_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                burgerDegree[0] = 0;
                burgerDegree[1] = 0;
                burgerDegree[2] = 0;

                addedPrices[0] = 0;
                addedPrices[1] = 0;
                addedPrices[2] = 0;

                total_money = 0;

                TextView total_money_tv = (TextView)findViewById(R.id.total_money_tv);
                total_money_tv.setText(total_money + "원");

                TextView jjapDegree = (TextView)findViewById(R.id.jjapDegree);
                TextView jjapTotalPrice = (TextView)findViewById(R.id.jjapTotalPrice);
                TextView chickenDegree = (TextView)findViewById(R.id.chickenDegree);
                TextView chickenTotalPrice = (TextView)findViewById(R.id.chickenTotalPrice);
                TextView cheeseDegree = (TextView)findViewById(R.id.cheeseDegree);
                TextView cheeseTotalPrice = (TextView)findViewById(R.id.cheeseTotalPrice);

                jjapDegree.setText(Integer.toString(burgerDegree[0]));
                chickenDegree.setText(Integer.toString(burgerDegree[1]));
                cheeseDegree.setText(Integer.toString(burgerDegree[2]));

                jjapTotalPrice.setText(Integer.toString(addedPrices[0]));
                chickenTotalPrice.setText(Integer.toString(addedPrices[1]));
                cheeseTotalPrice.setText(Integer.toString(addedPrices[2]));

            }
        });

        payment_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogShow();
            }
        });
    }


    void DialogShow()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("JJAPJJAP Payment");
        builder.setMessage("총 금액을 결제합니다.");
        builder.setPositiveButton("결제",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"결제완료 되었습니다.(가짜)",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"결제를 취소했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
}
