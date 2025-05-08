package com.example.th_ltdd_tuan6;

public class Student {
    private String name;
    private String id;
    private String email;
    private String phone;
    private String chuyenNganh;
    private String place;
    private String day;
    private float gpa;
    private String gender;

    // Constructor
    public Student(String name, String id, String email, String phone, String chuyenNganh,
                   String place, String day, float gpa, String gender){
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.chuyenNganh = chuyenNganh;
        this.place = place;
        this.day = day;;
        this.gpa = gpa;
        this.gender = gender;
    }

    // Getters
    public String getName() { return name; }
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getChuyenNganh() { return chuyenNganh; }
    public String getPlace() { return place; }
    public String getDay() { return day; }
    public float getGpa() { return gpa; }
    public String getGender() { return gender; }
}
