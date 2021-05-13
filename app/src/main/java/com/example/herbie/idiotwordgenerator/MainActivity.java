package com.example.herbie.idiotwordgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static char[] consonants = "bcdfghjklmnprstvwyz".toCharArray();
    public static char[] vowels = "aeiou".toCharArray();
    public static String[][] middlePairs = {{"rb", "rb"}, {"ng", "nk"}, {"nk","ng"}, {"p","p"}, {"g","g"}};
    public static String[][] endPairs = {{"us","us"}, {"ey", "us"}, {"ey","le"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button becomeDumber = (Button) findViewById(R.id.becomeDumber);
        becomeDumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random generator = new Random();
                String begin1 = String.valueOf(consonants[generator.nextInt(consonants.length)]);
                String begin2 = String.valueOf(consonants[generator.nextInt(consonants.length)]);
                String vowel1 = String.valueOf(vowels[generator.nextInt(vowels.length)]);
                String vowel2 = String.valueOf(vowels[generator.nextInt(vowels.length)]);
                String[] middle = middlePairs[generator.nextInt(middlePairs.length)];
                String[] end = endPairs[generator.nextInt(endPairs.length)];
                String dumberWord1 = begin1 + vowel1 + middle[0] + end[0];
                String dumberWord2 = begin2 + vowel2 + middle[1] + end[1];
                String dumberWord = dumberWord1 + " " + dumberWord2;

                TextView dumbWord = (TextView) findViewById(R.id.dumbWord);
                dumbWord.setText(dumberWord);
            }
        });
    }
}
