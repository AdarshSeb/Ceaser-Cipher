package com.example.ceaser_cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.et1);
        t2 = (EditText) findViewById(R.id.et2);
        t3 = (EditText) findViewById(R.id.et3);

    }
    public void remove1(View v)
    {
        t1.setText("");
    }
    public void remove2(View v)
    {
        t2.setText("");
    }
    public void encrypt(View v)
    {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        String plaintext = t1.getText().toString();
        int key = Integer.parseInt(t2.getText().toString());
        plaintext  = plaintext.toLowerCase();
        String entext = "";
        for(int i=0;i<plaintext.length();i++)
        {
            int pos = abcd.indexOf(plaintext.charAt(i));
            int enpos = (key + pos)%26;
            char enchar = abcd.charAt(enpos);
            entext += enchar;
        }
        t3.setVisibility(View.VISIBLE);
        t3.setText("The cipher text is "+entext);
    }
    public void decrypt(View v)
    {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        String ciphertext = t1.getText().toString();
        int key = Integer.parseInt(t2.getText().toString());
        ciphertext  = ciphertext.toLowerCase();
        String detext = "";
        for(int i=0;i<ciphertext.length();i++)
        {
            int pos = abcd.indexOf(ciphertext.charAt(i));
            int decryptPos = (pos - key) % 26;
            if (decryptPos < 0){
                decryptPos = abcd.length() + decryptPos;
            }
            char decryptChar = abcd.charAt(decryptPos);
            detext += decryptChar;
        }
        t3.setVisibility(View.VISIBLE);
        t3.setText("The plain text is "+detext);
    }

}