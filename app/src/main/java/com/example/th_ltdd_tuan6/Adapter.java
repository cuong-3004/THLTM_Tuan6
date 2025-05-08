package com.example.th_ltdd_tuan6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
    Context context;
    private String[] name;
    private String[] mssv;
    private int[] image;

    // Constructor
    public Adapter(Context context, String[] name, String[] mssv, int[] image) {
        this.context = context;
        this.name = name;
        this.mssv = mssv;
        this.image = image;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // ViewHolder để tối ưu hóa việc tìm kiếm các thành phần giao diện
    private class ViewHolder {
        ImageView imageSV;
        TextView name;
        TextView mssv;
    }

    // Phương thức lấy dữ liệu hiển thị lên ListView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder.imageSV = (ImageView) convertView.findViewById(R.id.imageSV);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.mssv = (TextView) convertView.findViewById(R.id.mssv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageSV.setImageResource(image[position]);
        viewHolder.name.setText(name[position]);
        viewHolder.mssv.setText(mssv[position]);
        return convertView;
    }
}
