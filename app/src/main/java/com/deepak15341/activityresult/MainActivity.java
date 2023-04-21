package com.deepak15341.activityresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.getNumber);


        int receive = getIntent().getIntExtra("cpmputedValue", 0);
        count = getIntent().getIntExtra("toast", 0);
        if (count != 0) {
            Toast.makeText(this, "Received multiplication is " + receive, Toast.LENGTH_SHORT).show();
        }
        AppCompatButton button = findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String getData = mEditText.getText().toString();
            if(getData.matches("")){
                Toast.makeText(MainActivity.this, "Enter a valid data", Toast.LENGTH_SHORT).show();
            }
            else{
                int getNumber = Integer.parseInt(getData);
                opensecondActivity(getNumber);
            }



            }
        });
    }

    private void opensecondActivity(int x) {
        try {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("number", x);
            intent.putExtra("toast", 1);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Enter a valid Value", Toast.LENGTH_SHORT).show();
        }
    }
}