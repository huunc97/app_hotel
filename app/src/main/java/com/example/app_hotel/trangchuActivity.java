package com.example.app_hotel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class trangchuActivity extends AppCompatActivity {

    ActionBar toolbar;
    FrameLayout frameLayout;
    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        //frameLayout=(FrameLayout) findViewById(R.id.frame_container);
        toolbar = getSupportActionBar();
        toolbar.setTitle("Thông tin nhân viên");
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new chitiet_nhanvienActivity());

    }
    int idd=0;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    if(idd!=R.id.navigation_shop) {
                       // toolbar.setTitle("Shop");
                        idd=R.id.navigation_shop;
                        showDialog();
                    }
                    else
                    {
                        idd=R.id.navigation_shop;
                        showDialog();
                    }
                    return true;
                case R.id.navigation_gifts:
                    if(idd!=R.id.navigation_gifts) {
                        idd=R.id.navigation_gifts;
                        loadFragment(new cham_congActivity());
                        //Toast.makeText(trangchuActivity.this,"aaa",Toast.LENGTH_LONG).show();
                        toolbar.setTitle("Thống kê lương tháng");
                    }
                    else
                    {
                        idd=R.id.navigation_gifts;
                    }

                    return true;
                case R.id.navigation_cart:
                    if(idd!=R.id.navigation_cart) {
                        idd=R.id.navigation_cart;
                        loadFragment(new Main2Activity());
                        toolbar.setTitle("Thông tin ca làm");
                        //FragmentA fragmentA=(FragmentA) getFragmentManager().findFragmentById(R.id.)
                    }
                    else
                    {
                        idd=R.id.navigation_cart;
                    }

                    return true;
                case R.id.navigation_profile:
                    if(idd!=R.id.navigation_profile) {
                        loadFragment(new chitiet_nhanvienActivity());
                        idd=R.id.navigation_profile;
                        toolbar.setTitle("Thông tin nhân viên");

                    }
                    else
                    {
                        idd=R.id.navigation_profile;
                    }

                    return true;
            }

            return false;
        }
    };
    public void showDialog() {
       // dialog = new Dialog(MainActivity.this);
        AlertDialog.Builder dialog= new AlertDialog.Builder(this);
        dialog.setTitle("Thông báo!");
        dialog.setMessage("Bạn có muốn đăng xuất không ?");
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent mh_login=new Intent(trangchuActivity.this, MainActivity.class);
                startActivity(mh_login);
                finish();
            }
        });
        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getFragmentManager();

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.FrameContainer,fragment);

        fragmentTransaction.commit();
    }


}
