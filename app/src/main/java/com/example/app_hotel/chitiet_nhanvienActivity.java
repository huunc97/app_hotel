package com.example.app_hotel;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class chitiet_nhanvienActivity extends Fragment {

    TextView txtTen,txtGT,txtNS,txtCV,txtCMND;
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

        txtCMND=view.findViewById(R.id.textViewCMND);
        txtCMND.setText(thong_tin_nhan_vien.getCMND());

        txtCV=view.findViewById(R.id.textViewCV);
        txtCV.setText(thong_tin_nhan_vien.getChucvu());

        return view;
    }
}
