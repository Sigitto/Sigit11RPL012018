package com.example.sigit11rpl012018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txtusername;
    EditText txtpassword;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusername = findViewById(R.id.txtusername);
        txtpassword = findViewById(R.id.txtpassword);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtusername.getText().toString().isEmpty()&& txtpassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Jangan di kosongkan", Toast.LENGTH_SHORT).show();
                }else if(txtusername.getText().toString().equals("Sigit") && txtpassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Jangan Dikosongkan", Toast.LENGTH_SHORT).show();
                }else if(txtusername.getText().toString().isEmpty() && txtpassword.getText().toString().equals("Uwaw")){
                    Toast.makeText(MainActivity.this, "Jangan Dikosongkan", Toast.LENGTH_SHORT).show();
                }else if(txtusername.getText().toString().equals("Sigit") && (txtpassword.getText().toString().equals("Uwaw")) ){
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, CardView.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}