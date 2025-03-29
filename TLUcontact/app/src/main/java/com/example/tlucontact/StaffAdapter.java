package com.example.tlucontact;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Adapter cho RecyclerView hiển thị danh sách nhân viên (CBNV)
public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> {
    private Staff[] staffs; // Mảng chứa danh sách nhân viên
    private Context context; // Context để khởi chạy Intent

    // Constructor nhận vào danh sách nhân viên và Context
    public StaffAdapter(Staff[] staffs, Context context) {
        this.staffs = staffs;
        this.context = context;
    }

    // ViewHolder giúp tối ưu việc tìm kiếm View trong item layout
    static class StaffViewHolder extends RecyclerView.ViewHolder {
        private TextView txtStaffName, txtStaffPhone; // Hiển thị tên và số điện thoại nhân viên

        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ View từ layout item_staff.xml
            txtStaffName = itemView.findViewById(R.id.txtStaffname);
            txtStaffPhone = itemView.findViewById(R.id.txtStaffphone);
        }

        // Hàm này sẽ bind dữ liệu nhân viên vào item
        public void bind(Staff staff) {
            txtStaffName.setText(staff.getName()); // Gán tên nhân viên
            txtStaffPhone.setText(staff.getPhone()); // Gán số điện thoại
        }
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tạo View từ layout item_staff.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staff, parent, false);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        Staff staff = staffs[position]; // Lấy nhân viên tại vị trí hiện tại
        holder.bind(staff); // Gán dữ liệu cho ViewHolder

        // Khi người dùng bấm vào một nhân viên, mở màn hình chi tiết StaffDetailActivity
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, StaffDetailActivity.class);
            // Truyền dữ liệu nhân viên sang màn hình chi tiết
            intent.putExtra("name", staff.getName());
            intent.putExtra("position", staff.getPosition());
            intent.putExtra("phone", staff.getPhone());
            intent.putExtra("email", staff.getEmail());
            intent.putExtra("department", staff.getDepartment());
            context.startActivity(intent); // Chạy activity hiển thị thông tin chi tiết
        });
    }

    @Override
    public int getItemCount() {
        return staffs.length; // Trả về tổng số nhân viên trong danh sách
    }
}
