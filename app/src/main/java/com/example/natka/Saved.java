package com.example.natka;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.natka.MainActivity.needs;
import static com.example.natka.MainActivity.services;
import static com.example.natka.MainActivity.textmoney;

public class Saved extends AppCompatActivity {
    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;

    public static void init(Context context){
        if (preferences == null){
            preferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    void save(){
        editor.putInt("money", MainActivity.coutmoney);
        editor.putInt("price1", Improve.price1);
        editor.putInt("moneyplus", MainActivity.money);
        editor.putInt("needs_price", MainActivity.needs_money);
        editor.putInt("services_price", MainActivity.services_money);
        editor.commit();
    }

    void load(){
        MainActivity.coutmoney = preferences.getInt("money", 0);
        Improve.price1 = preferences.getInt("price1", 500);
        MainActivity.money = preferences.getInt("moneyplus", 100);
        MainActivity.needs_money = preferences.getInt("services_price", 0);
        MainActivity.services_money = preferences.getInt("needs_price", 0);
        textmoney.setText(MainActivity.coutmoney + "");
        needs.setText("Потребности\n" +  MainActivity.needs_money);
        services.setText("Услуги\n" + MainActivity.services_money);
    }
}
