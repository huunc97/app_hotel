package com.example.app_hotel;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main2Activity extends Fragment {
    public GregorianCalendar cal_month, cal_month_copy;
    private HwAdapter hwAdapter;
    private TextView tv_month,txtTen;
    EditText edit_user,edit_pass;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_main2,container,false);
        if(thong_tin_nhan_vien.getTen().equals("Nguyễn Chí Hữu")) {

            HomeCollection.date_collection_arr = new ArrayList<HomeCollection>();
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-10", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-11", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-12", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-13", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-14", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-15", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-16", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-17", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-18", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-19", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-20", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-21", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-22", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-23", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-24", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-25", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-26", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-27", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-28", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-29", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-30", "Ca tối", "22h-6h", "this is holiday"));

        }
        else if(thong_tin_nhan_vien.getTen().equals("Quách Vĩ Tuấn")) {

            HomeCollection.date_collection_arr = new ArrayList<HomeCollection>();
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-10", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-11", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-12", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-13", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-14", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-15", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-16", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-17", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-18", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-19", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-20", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-21", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-22", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-23", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-24", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-25", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-26", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-27", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-28", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-29", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-30", "Ca sáng", "6h-14h", "this is holiday"));
        }
        else if(thong_tin_nhan_vien.getTen().equals("Nguyễn Thị Nữ")) {

            HomeCollection.date_collection_arr = new ArrayList<HomeCollection>();
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-10", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-11", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-12", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-13", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-14", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-15", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-16", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-17", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-18", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-19", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-20", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-21", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-22", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-23", "Ca chiều", "14h-22h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-24", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-25", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-26", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-27", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-28", "Ca tối", "22h-6h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-29", "Ca sáng", "6h-14h", "this is holiday"));
            HomeCollection.date_collection_arr.add(new HomeCollection("2019-06-30", "Ca sáng", "6h-14h", "this is holiday"));
        }
        else {
            HomeCollection.date_collection_arr = new ArrayList<HomeCollection>();
        }




        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new HwAdapter(Main2Activity.this.getActivity(), cal_month,HomeCollection.date_collection_arr);

        tv_month =view.findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));


        ImageButton previous =view.findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 4&&cal_month.get(GregorianCalendar.YEAR)==2017) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(Main2Activity.this.getActivity(), "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setPreviousMonth();
                    refreshCalendar();
                }


            }
        });
        ImageButton next =view.findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 5&&cal_month.get(GregorianCalendar.YEAR)==2018) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(Main2Activity.this.getActivity(), "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setNextMonth();
                    refreshCalendar();
                }
            }
        });
        GridView gridview =view.findViewById(R.id.gv_calendar);
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = HwAdapter.day_string.get(position);
                ((HwAdapter) parent.getAdapter()).getPositionList(selectedGridDate, Main2Activity.this.getActivity());
            }

        });
        return view;
    }
    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    public void refreshCalendar() {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
}
