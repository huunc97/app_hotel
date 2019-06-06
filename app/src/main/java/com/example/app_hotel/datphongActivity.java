package com.example.app_hotel;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class datphongActivity extends Fragment {
    Button btn_dp;
    EditText edit_user,edit_pass;
    TextView txtKH,txtP,txtSLP,txtNden,txtNdi,txtTTP;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_cham_cong, container, false);
        txtKH = view.findViewById(R.id.textViewKH);
        txtKH.setText(thong_tin_phong.getTenkhachhang());

        txtP = view.findViewById(R.id.textViewP);
        txtP.setText(thong_tin_phong.getTenphopng());

        txtSLP = view.findViewById(R.id.textViewSLP);
//        setDate(txtNS);
//        txtNS.setText(thong_tin_nhan_vien.getNgaysinh());
        txtSLP.setText(thong_tin_phong.getSoluongphong());

        txtNden = view.findViewById(R.id.textViewNden);
        txtNden.setText(thong_tin_phong.getNgayden());

        txtNdi = view.findViewById(R.id.textViewNdi2);
        txtNdi.setText(thong_tin_phong.getNgaydi());

        txtTTP = view.findViewById(R.id.textViewTTP);
        txtTTP.setText(thong_tin_phong.getTinhtrangphong());


        btn_dp=view.findViewById(R.id.buttonDP);
        btn_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new doc_du_lieu().execute("http://192.168.56.1:8080/API_Hotel/login.php");
                new doc_du_lieu().execute("http://192.168.56.1:8080/API_Hotel/phong.php");

            }
        });

        return view;
    }
    class doc_du_lieu extends AsyncTask<String,Integer,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            String nd=Post_du_lieu_dang_nhap(strings[0]);//gan' api post
            return nd;
        }
        @Override
        protected void onPostExecute(String s) {
            //s la dl tra ve tu api

//            if(s!="") {
            try {
                JSONObject json=new JSONObject(s);
                Integer errorCode=json.getInt("errorCode");
                if(errorCode==0)
                {
//                    //Intent mh_chinh=new Intent(MainActivity.this,MH_chinh.class);
//                    thong_tin_nhan_vien.setTen(json.getString("hoten_nguoidung"));
//                    thong_tin_nhan_vien.setGioitinh(json.getString("gioitinh_nguoidung"));
//                    thong_tin_nhan_vien.setNgaysinh(json.getString("ngaysinh_nguoidung"));
//                    thong_tin_nhan_vien.setChucvu(json.getString("chucvu"));
//                    thong_tin_nhan_vien.setSongaylam(json.getString("songaylam"));
//                    thong_tin_nhan_vien.setLuongcoban(json.getString("luongcoban"));
//                    thong_tin_nhan_vien.setThuong(json.getString("thuong"));
//                    thong_tin_nhan_vien.setCMND(json.getString("CMND"));
//                    thong_tin_nhan_vien.setTongluong(json.getString("tongluong"));
                    thong_tin_phong.setTenkhachhang(json.getString("ten_khachhang"));
                    thong_tin_phong.setTenphopng(json.getString("ten_loaiphong"));
                    thong_tin_phong.setSoluongphong(json.getString("soluongphong"));
                    thong_tin_phong.setNgayden(json.getString("ngayden"));
                    thong_tin_phong.setNgaydi(json.getString("ngaydi"));
                    thong_tin_phong.setTinhtrangphong(json.getString("tinhtrang_datphong"));

//                    Intent md_dp=new Intent(trangchuActivity.this, datphongActivity.class);
//                    startActivity(md_dp);
//                    finish();
                    //startActivity(mh_trangchu);
                }
                //Toast.makeText(datphongActivity.this, json.getString("message"), Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
            }
//
//            }
//            else
//            {
//                Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
//            }
        }
    }
    private String Post_du_lieu_dang_nhap(String link){
        HttpURLConnection connect;
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
        try {
            // cấu hình HttpURLConnection
            connect = (HttpURLConnection)url.openConnection();
            connect.setRequestMethod("POST");
//            // Gán tham số vào URL
            String user=edit_user.getText().toString();
            String pass=edit_pass.getText().toString();
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("user",user)
                    .appendQueryParameter("pass",pass);
            String query = builder.build().getEncodedQuery();

            // Mở kết nối gửi dữ liệu
            OutputStream os = connect.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();
            connect.connect();

        } catch (IOException e1) {
            e1.printStackTrace();
            return "";
        }
        try {
            int response_code = connect.getResponseCode();

            // kiểm tra kết nối ok
            if (response_code == HttpURLConnection.HTTP_OK) {
                // Đọc nội dung trả về
                InputStream input = connect.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            }else{
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            connect.disconnect();
        }
    }
}
