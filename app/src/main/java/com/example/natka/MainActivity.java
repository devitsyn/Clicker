package com.example.natka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static int coutmoney = 0;
    public static int money          = 100,
                      needs_money    = 0,
                      services_money = 0;
    public static Button button, improve;
    public static TextView textmoney, needs, services;
    private MediaPlayer clickSound;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        improve = findViewById(R.id.improve);
        textmoney = findViewById(R.id.money);
        needs = findViewById(R.id.needs);
        services = findViewById(R.id.services);
        clickSound = MediaPlayer.create(this, R.raw.click_sound);

        Saved.init(getApplicationContext());
        new Saved().load();
        button();
    }

    void button(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlay(clickSound);
                coutmoney += money;
                textmoney.setText(coutmoney + "");
                needs_money += 25;
                services_money += 50;
                needs.setText("Потребности\n" + needs_money);
                services.setText("Услуги\n" + services_money);
                new Saved().save();
            }
        });
        improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
            }
        });
    }

    public  void soundPlay (MediaPlayer sound){
        sound.start();
    }
}