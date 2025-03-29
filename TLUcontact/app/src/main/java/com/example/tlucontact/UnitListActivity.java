package com.example.tlucontact;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class UnitListActivity extends AppCompatActivity {

    private RecyclerView rcvUnits;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unit_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBack = (Button) findViewById(R.id.btnBackUnit);
        rcvUnits = (RecyclerView) findViewById(R.id.recyclerViewUnits);

        Unit[] units = {
                new Unit("Phòng Đào tạo", "024 1234 5678", "Hà Nội"),
                new Unit("Phòng Công tác sinh viên", "024 8765 4321", "Hà Nội"),
                new Unit("Khoa Công Nghệ Thông Tin", "024 8765 4321", "Hà Nội"),
                new Unit("Khoa Cơ Khí", "024 8765 4321", "Hà Nội"),
                new Unit("Khoa Điện Tử", "024 8765 4321", "Hà Nội"),
                new Unit("Khoa Kinh Tế", "024 8765 4321", "Hà Nội"),
                new Unit("Khoa Nước và Môi Trường", "024 8765 4321", "Hà Nội"),
                new Unit("Khoa Hóa Học", "024 8765 4321", "Hà Nội"),
        };

        UnitAdapter myAdapter = new UnitAdapter(units, UnitListActivity.this);
        rcvUnits.setAdapter(myAdapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}