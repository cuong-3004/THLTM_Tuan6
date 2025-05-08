package com.example.th_ltdd_tuan6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView studentList;
    Adapter adapter;
    DatabaseHelper dbHelper;
    ArrayList<Student> students;

    String[] names;
    String[] mssv;
    String[] email;
    String[] phone;
    String[] chuyenNganh;
    String[] place;
    String[] day;
    String[] gender;
    float[] gpa;

    // Danh sách ảnh đại diện cho sinh viên
    int[] avatars = {R.drawable.man, R.drawable.man1, R.drawable.man2, R.drawable.man3, R.drawable.man4,
            R.drawable.man5, R.drawable.man6, R.drawable.man7, R.drawable.man8, R.drawable.woman1,
            R.drawable.woman2, R.drawable.woman3, R.drawable.woman4};

    // Khởi tạo dữ liệu và hiển thị danh sách sinh viên
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentList = findViewById(R.id.studentList);

        dbHelper = new DatabaseHelper(this);
        students = dbHelper.getAllStudents();

        // Lấy dữ liệu từ danh sách sinh viên và lưu vào các mảng tương ứng
        names = new String[students.size()];
        mssv = new String[students.size()];
        email = new String[students.size()];
        phone = new String[students.size()];
        chuyenNganh = new String[students.size()];
        place = new String[students.size()];
        day = new String[students.size()];
        gender = new String[students.size()];
        gpa = new float[students.size()];

        for (int i = 0; i < students.size(); i++) {
            names[i] = students.get(i).getName();
            mssv[i] = students.get(i).getId();
            email[i] = students.get(i).getEmail();
            phone[i] = students.get(i).getPhone();
            chuyenNganh[i] = students.get(i).getChuyenNganh();
            place[i] = students.get(i).getPlace();
            day[i] = students.get(i).getDay();
            gender[i] = students.get(i).getGender();
            gpa[i] = students.get(i).getGpa();
        }

        // Khởi tạo adapter và gắn vào ListView
        adapter = new Adapter(this, names, mssv, avatars);
        studentList.setAdapter(adapter);

        // Xử lý sự kiện khi click vào item trong ListView
        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Info.class);
                intent.putExtra("name", names[position]);
                intent.putExtra("mssv", mssv[position]);
                intent.putExtra("avatar", avatars[position]);
                intent.putExtra("email", email[position]);
                intent.putExtra("phone", phone[position]);
                intent.putExtra("chuyenNganh", chuyenNganh[position]);
                intent.putExtra("place", place[position]);
                intent.putExtra("day", day[position]);
                intent.putExtra("gender", gender[position]);
                intent.putExtra("gpa", gpa[position]);
                startActivity(intent);
            }
        });
    }
}