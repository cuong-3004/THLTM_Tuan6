package com.example.th_ltdd_tuan6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Info extends AppCompatActivity {
    private TextView nameTxt, mssvTxt, emailTxt, phoneTxt, chuyenNganhTxt, placeTxt, dayTxt, genderTxt, gpaTxt;
    private ImageView avatar;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Ánh xạ các đối tượng hiển thị thông tin sinh viên
        nameTxt = findViewById(R.id.nameTxt);
        mssvTxt = findViewById(R.id.idTxt);
        emailTxt = findViewById(R.id.emailTxt);
        phoneTxt = findViewById(R.id.phoneTxt);
        chuyenNganhTxt = findViewById(R.id.chuyenNganhTxt);
        placeTxt = findViewById(R.id.placeTxt);
        dayTxt = findViewById(R.id.dayTxt);
        genderTxt = findViewById(R.id.genderTxt);
        gpaTxt = findViewById(R.id.gpaTxt);
        avatar = findViewById(R.id.avatar);
        back = findViewById(R.id.backBtn);

        // Lấy thông tin sinh viên từ Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String mssv = intent.getStringExtra("mssv");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String chuyenNganh = intent.getStringExtra("chuyenNganh");
        String place = intent.getStringExtra("place");
        String day = intent.getStringExtra("day");
        String gender = intent.getStringExtra("gender");
        float gpa = intent.getFloatExtra("gpa", 0);
        int avatar = intent.getIntExtra("avatar", 0);

        // Hiển thị thông tin sinh viên
        nameTxt.setText(name);
        mssvTxt.setText("MSSV: " + mssv);
        emailTxt.setText("Email: " + email);
        phoneTxt.setText("Số điện thoại: " + phone);
        chuyenNganhTxt.setText("Chuyên ngành: " + chuyenNganh);
        placeTxt.setText("Nơi sinh: " + place);
        dayTxt.setText("Ngày sinh: " + day);
        genderTxt.setText("Giới tính: " + gender);
        gpaTxt.setText("GPA: " + String.valueOf(gpa));
        this.avatar.setImageResource(avatar);

        // Thêm sự kiện click cho nút quay lại
        back.setOnClickListener(v -> {
            Intent intent1 = new Intent(Info.this, MainActivity.class);
            startActivity(intent1);
        });
    }
}