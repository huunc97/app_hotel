package com.example.app_hotel;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class cham_congActivity extends Fragment {

    TextView txtLCB,txtSNL,txtL,txtT;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_cham_cong,container,false);
        txtSNL=view.findViewById(R.id.textViewSNL);
        txtSNL.setText(thong_tin_nhan_vien.getSongaylam()+" ngày");

        txtLCB=view.findViewById(R.id.textViewLCB);
        txtLCB.setText(thong_tin_nhan_vien.getLuongcoban()+" $");

        txtT=view.findViewById(R.id.textViewThuong);
//        setDate(txtNS);
//        txtNS.setText(thong_tin_nhan_vien.getNgaysinh());
        txtT.setText(thong_tin_nhan_vien.getThuong()+" $");

        txtL=view.findViewById(R.id.textViewLuong);
        txtL.setText(thong_tin_nhan_vien.getTongluong()+" $");

        return view;
    }
}
