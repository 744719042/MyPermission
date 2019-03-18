package com.example.mypermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
//        PermissionManager.getInstance().requestPermissions(this, new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE }, new PermissionsListener() {
//            @Override
//            public void onPermissionResult(int[] grantResult) {
//                if (grantResult != null && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        new HelloWorld().request();
    }
}
