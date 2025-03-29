package com.example.tlucontact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StaffDetailActivity extends AppCompatActivity {


    private TextView txtStaffName, txtStaffPosition, txtStaffPhone, txtStaffEmail, txtStaffDepartment;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_staff_detail);


        txtStaffName = (TextView) findViewById(R.id.txtStaffNames);
        txtStaffPosition = (TextView) findViewById(R.id.txtStaffPosition);
        txtStaffPhone = (TextView) findViewById(R.id.txtStaffPhones);
        txtStaffEmail = (TextView) findViewById(R.id.txtStaffEmail);
        txtStaffDepartment = (TextView) findViewById(R.id.txtStaffDepartment);
        btnBack = (Button) findViewById(R.id.btnBack);

        // Lấy dữ liệu từ Intent
        Intent intent = getIntent();
        txtStaffName.setText(intent.getStringExtra("name"));
        txtStaffPosition.setText(intent.getStringExtra("position"));
        txtStaffPhone.setText("Phone: " + intent.getStringExtra("phone"));
        txtStaffEmail.setText("Email: " + intent.getStringExtra("email"));
        txtStaffDepartment.setText("Department: " + intent.getStringExtra("department"));

        // Quay về trang danh sách
        btnBack.setOnClickListener(v -> finish());
    }
}