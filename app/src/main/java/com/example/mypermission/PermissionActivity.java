package com.example.mypermission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.os.Bundle;

import static android.os.Build.VERSION_CODES.M;

@TargetApi(M)
public class PermissionActivity extends Activity {
    public static final String ARG_PERMISSIONS = "arg_permissions";
    private String[] mPermissions;
    private static final int PERMISSION_CODE = 0x9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() == null || !getIntent().hasExtra(ARG_PERMISSIONS)) {
            PermissionManager.getInstance().onRequestPermissionsResult(null);
            finish();
            return;
        }
        mPermissions = getIntent().getStringArrayExtra(ARG_PERMISSIONS);
        if (mPermissions == null || mPermissions.length == 0) {
            PermissionManager.getInstance().onRequestPermissionsResult(null);
            finish();
            return;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= M) {
            requestPermissions(mPermissions, PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            PermissionManager.getInstance().onRequestPermissionsResult(grantResults);
        }
        finish();
    }
}
