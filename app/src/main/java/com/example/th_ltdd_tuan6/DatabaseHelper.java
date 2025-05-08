package com.example.th_ltdd_tuan6;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Tạo bảng
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" +
                "id TEXT PRIMARY KEY," +
                "name TEXT," +
                "email TEXT," +
                "phone TEXT," +
                "chuyenNganh TEXT," +
                "place TEXT," +
                "day TEXT," +
                "gpa REAL," +
                "gender TEXT)";

        db.execSQL(sql);

        // Thêm dữ liệu mẫu
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Nguyễn Văn A', '21200001', 'a@example.com', '0987654321', 'Điện tử', 'TPHCM', '01/01/2003', 9.5, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Trần Văn B', '21200002', 'b@example.com', '0987654322', 'MT-HTN', 'Hà Nội', '02/02/2003', 9.0, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Lê Văn C', '21200003', 'c@example.com', '0987654323', 'Viễn thông', 'Đà Nẵng', '03/03/2003', 8.5, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Phạm Văn D', '21200004', 'd@example.com', '0987654324', 'Điện tử', 'Hải Phòng', '04/04/2003', 8.0, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Hoàng Văn E', '21200005', 'e@example.com', '0987654325', 'MT-HTN', 'Cần Thơ', '05/05/2003', 7.5, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Vũ Văn G', '21200006', 'g@example.com', '0987654326', 'Viễn thông', 'Đà Lạt', '06/06/2003', 7.0, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Đặng Văn H', '21200007', 'h@example.com', '0987654327', 'Điện tử', 'Huế', '07/07/2003', 6.5, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Bùi Văn I', '21200008', 'i@example.com', '0987654328', 'MT-HTN', 'Nha Trang', '08/08/2003', 6.0, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Đỗ Văn K', '21200009', 'k@example.com', '0987654329', 'Viễn thông', 'Phú Quốc', '09/09/2003', 5.5, 'Nam')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Nguyễn Thị L', '21200010', 'l@example.com', '0987654330', 'Điện tử', 'TPHCM', '10/10/2003', 5.0, 'Nữ')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Trần Thị M', '21200011', 'm@example.com', '0987654331', 'MT-HTN', 'Hà Nội', '11/11/2003', 5.5, 'Nữ')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Lê Thị N', '21200012', 'n@example.com', '0987654332', 'Viễn thông', 'Đà Nẵng', '12/12/2003', 6.0, 'Nữ')");
        db.execSQL("INSERT INTO students (id, name, email, phone, chuyenNganh, place, day, avatar, gpa, gender) VALUES ('Phạm Thị O', '21200013', 'o@example.com', '0987654333', 'Điện tử', 'Hải Phòng', '31/12/2003', 6.5, 'Nữ')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Lấy tất cả sinh viên từ cơ sở dữ liệu
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String id = cursor.getString(1);
            String email = cursor.getString(2);
            String phone = cursor.getString(3);
            String chuyenNganh = cursor.getString(4);
            String place = cursor.getString(5);
            String day = cursor.getString(6);
            float gpa = cursor.getFloat(8);
            String gender = cursor.getString(9);
            list.add(new Student(name, id, email, phone, chuyenNganh, place, day, gpa, gender));
        }

        cursor.close();
        return list;
    }
}

