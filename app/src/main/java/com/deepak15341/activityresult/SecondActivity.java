package com.deepak15341.activityresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    int num2;
    int toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        num2 = getIntent().getIntExtra("number", 0);
        toast = getIntent().getIntExtra("toast",1);
        Toast.makeText(this, "Received Number is "+num2, Toast.LENGTH_SHORT).show();
        AppCompatButton button = findViewById(R.id.receiveButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstActivity();
                finish();
            }
        });
    }
    private void openFirstActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("cpmputedValue",num2*10);
        intent.putExtra("toast",toast);
        startActivity(intent);
    }
}