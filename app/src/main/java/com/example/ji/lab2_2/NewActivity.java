package com.example.ji.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView text;
    Button go;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        text = (TextView)findViewById(R.id.textBox);
        go = (Button)findViewById(R.id.goButton);
        back = (Button)findViewById(R.id.backButton);

        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("Url");
        text.setText(passedUrl);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text.getText() != null && !(text.getText().equals("")))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + text.getText()));
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요", Toast.LENGTH_LONG).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
