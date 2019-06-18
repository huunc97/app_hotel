package com.example.app_hotel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {
    Button btn_click;
    EditText edit_user,edit_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_user=(EditText) findViewById(R.id.editText);
        edit_pass=(EditText) findViewById(R.id.editText2);
        btn_click=(Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new doc_du_lieu().execute(diachi.link+"login.php");
                new doc_du_lieu().execute("https://huunc97.000webhostapp.com/api/login.php");

            }
        });

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
                    //Intent mh_chinh=new Intent(MainActivity.this,MH_chinh.class);
                    thong_tin_nhan_vien.setTen(json.getString("hoten_nguoidung"));
                    thong_tin_nhan_vien.setGioitinh(json.getString("gioitinh_nguoidung"));
                    thong_tin_nhan_vien.setNgaysinh(json.getString("ngaysinh_nguoidung"));
                    thong_tin_nhan_vien.setChucvu(json.getString("chucvu"));
                    thong_tin_nhan_vien.setSongaylam(json.getString("songaylam"));
                    thong_tin_nhan_vien.setLuongcoban(json.getString("luongcoban"));
                    thong_tin_nhan_vien.setThuong(json.getString("thuong"));
                    thong_tin_nhan_vien.setCMND(json.getString("CMND"));
                    thong_tin_nhan_vien.setTongluong(json.getString("tongluong"));
                    Intent mh_trangchu=new Intent(MainActivity.this, trangchuActivity.class);
                    startActivity(mh_trangchu);
                    finish();
                    //startActivity(mh_trangchu);
                }
                //showDialog();
                Toast.makeText(MainActivity.this, json.getString("message"), Toast.LENGTH_SHORT).show();


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

    //post
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
            // Gán tham số vào URL
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
    public void showDialog() {
        // dialog = new Dialog(MainActivity.this);
        AlertDialog.Builder dialog= new AlertDialog.Builder(this);
        dialog.setMessage("Đăng nhập thất bại!");
        dialog.show();
    }
}
