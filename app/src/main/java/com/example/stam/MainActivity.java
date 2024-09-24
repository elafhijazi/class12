package com.example.stam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public Button btnStart, btnEnd;
    public TextView txtView;
    public Integer num = 0;
    Thread counterThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        txtView = findViewById(R.id.textView);

    }

    public void startCount(View view) {
        counterThread = new Thread(() -> {
            try {
                while (true) {
                    num++;
                    txtView.setText(num + "");
                    Thread.sleep(1000);
                }

            }
            catch (Exception e){}
        });
        counterThread.start();
    }
    public void endCount(View view){
        counterThread.interrupt();
    }
    public void setTxtView(View view){
        txtView.setText("0");
        counterThread.interrupt();
        num=0;
    }
}