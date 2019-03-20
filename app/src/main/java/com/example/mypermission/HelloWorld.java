package com.example.mypermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class HelloWorld {
    public void request() {
        PermissionManager.getInstance().requestPermissions(BaseApplication.getApplication(), new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE }, new PermissionsListener() {
            @Override
            public void onPermissionResult(boolean grantedAll, int[] grantResult) {
                if (grantResult != null && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(BaseApplication.getApplication(), "请求成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
