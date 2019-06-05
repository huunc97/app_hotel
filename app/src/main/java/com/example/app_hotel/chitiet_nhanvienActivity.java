package com.example.app_hotel;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class chitiet_nhanvienActivity extends Fragment {

    TextView txtTen,txtGT,txtNS,txtCV;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_chitiet_nhanvien,container,false);
        txtTen=view.findViewById(R.id.textViewTen);
        txtTen.setText(thong_tin_nhan_vien.getTen());

        txtGT=view.findViewById(R.id.textViewGT);
        txtGT.setText(thong_tin_nhan_vien.getGioitinh());

        txtNS=view.findViewById(R.id.textViewNS);
//        setDate(txtNS);
//        txtNS.setText(thong_tin_nhan_vien.getNgaysinh());
        txtNS.setText(thong_tin_nhan_vien.getNgaysinh());

        txtCV=view.findViewById(R.id.textViewCV);
        txtCV.setText(thong_tin_nhan_vien.getChucvu());

        return view;
    }
}
