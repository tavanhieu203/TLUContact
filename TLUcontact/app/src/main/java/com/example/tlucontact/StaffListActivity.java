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

public class StaffListActivity extends AppCompatActivity {

    private RecyclerView rcvStaff;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_staff_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBack = (Button) findViewById(R.id.btnBackStaff);
        rcvStaff = (RecyclerView) findViewById(R.id.recyclerViewStaff);

        Staff[] staffs = {
                new Staff("Nguyễn Văn A", "Giảng viên", "0123 456 789", "nva@tlu.edu.vn", "Khoa Công nghệ thông tin"),
                new Staff("Trần Thị B", "Trưởng phòng", "0987 654 321", "ttb@tlu.edu.vn", "Phòng Đào tạo"),
                new Staff("Tạ Thị C", "Giảng viên", "0456 789 012", "ttc@tlu.edu.vn", "Khoa Công nghệ thông tin"),
                new Staff("Lưu Văn D", "Trưởng phòng", "0234 456 321", "lvd@tlu.edu.vn", "Phòng Công tác sinh viên"),
                new Staff("Lại Thị E", "Giảng viên", "0987 768 987", "lte@tlu.edu.vn", "Khoa Công nghệ thông tin"),
                new Staff("Đinh Văn F", "Trưởng phòng", "0982 345 654", "dvf@tlu.edu.vn", "Phòng Đào tạo"),
                new Staff("Đỗ Thị G", "Giảng viên", "0871 782 929", "dtg@tlu.edu.vn", "Khoa Công nghệ thông tin"),
        };

        // Sử dụng Adapter để đưa dữ liệu lên View
        StaffAdapter myAdapter = new StaffAdapter(staffs, StaffListActivity.this);
        rcvStaff.setAdapter(myAdapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}