package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dangky extends AppCompatActivity {
    EditText txtEmail, txtMatK;
    Button btnDangNhap, btnDangKy;
    Intent intent;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        intent = getIntent();
        mAuth = FirebaseAuth.getInstance();
        Anhxa();
        Event();
    }
    private void Event() {
        //dang ký tài khoản
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtMatK.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
                            Toast.makeText(getApplicationContext(), "Dang ky thanh cong", Toast.LENGTH_LONG).show();
                            intent = new Intent(Dangky.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }

    private void Anhxa() {
        txtEmail = findViewById(R.id.taikhoan);
        txtMatK = findViewById(R.id.matkhau);
        btnDangNhap = findViewById(R.id.dangnhap);
        btnDangKy = findViewById(R.id.dangky);
    }
}