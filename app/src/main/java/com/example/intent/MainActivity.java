package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email, theme, message;
    private Button sent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        email = findViewById(R.id.tiet_edit);
        theme = findViewById(R.id.tiet_edit2);
        message = findViewById(R.id.tiet_edit3);
        sent = findViewById(R.id.sent);
      sent.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             sentMail();
          }
      });
    }
    private  void sentMail(){
        String rList=email.getText().toString();
        String [] r=rList.split(",");

        String subject =theme.getText().toString();
        String thisMessage=message.getText().toString();

        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("pain/text");
        intent.putExtra(Intent.EXTRA_EMAIL,r);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,thisMessage);
        startActivity(Intent.createChooser(intent,"Send massage..."));
    }


}