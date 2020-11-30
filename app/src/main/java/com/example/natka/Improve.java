package com.example.natka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Improve extends AppCompatActivity {
    Button improvement_buy, needs_price, services_price, cat;
    public static int price1 = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        improvement_buy = findViewById(R.id.improvement_buy);
        needs_price = findViewById(R.id.needs_price);
        cat = findViewById(R.id.cat_button);
        services_price = findViewById(R.id.services_price);

        improvement_buy.setText("Купить улучшение за " + price1);
        improvement_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= price1) {
                    MainActivity.money += 100;
                    MainActivity.coutmoney -= price1;
                    price1+=200;
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    improvement_buy.setText("Купить улучшение за " + price1);

                    Toast toast = Toast.makeText(getApplicationContext(), "Вы преобрели улучшение", Toast.LENGTH_SHORT);
                    toast.show();

                    new Saved().save();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Не хватает денег", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Improve.this, Cat.class);
                startActivity(intent);
            }
        });

        services_price.setText("Оплатить услуги " + MainActivity.services_money);
        services_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.services_money){
                    MainActivity.coutmoney -= MainActivity.services_money;
                    MainActivity.services_money = 0;
                    MainActivity.services.setText("Услуги\n" + MainActivity.services_money);
                    services_price.setText("Оплатить услуги " + MainActivity.services_money);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    new Saved().save();
                }
            }
        });

        needs_price.setText("Оплатить потребности " + MainActivity.needs_money * 1);
        needs_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.needs_money){
                    MainActivity.coutmoney -= MainActivity.needs_money * 1;
                    MainActivity.needs_money = 0;
                    needs_price.setText("Оплатить потребности " + MainActivity.needs_money * 2);
                    MainActivity.needs.setText("Потребности\n" +  MainActivity.needs_money);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    new Saved().save();
                }
            }
        });
    }
}
