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

public class UnitsDetailAvtivity extends AppCompatActivity {

    private TextView txtUnitName, txtUnitPhone, txtUnitAddress;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_units_detail_avtivity);

        txtUnitName = (TextView) findViewById(R.id.txtUnitsName);
        txtUnitPhone = (TextView) findViewById(R.id.txtUnitsPhone);
        txtUnitAddress = (TextView) findViewById(R.id.txtUnitAddress);
        btnBack = (Button) findViewById(R.id.btnBackUnit);

        // Lấy dữ liệu từ Intent
        Intent intent = getIntent();
        txtUnitName.setText(intent.getStringExtra("name"));
        txtUnitPhone.setText("Phone: " + intent.getStringExtra("phone"));
        txtUnitAddress.setText("Address: " + intent.getStringExtra("address"));


        btnBack.setOnClickListener(v -> finish());

    }
}