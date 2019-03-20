package com.example.mypermission;

public interface PermissionsListener {
    void onPermissionResult(boolean grantedAll, int[] grantResult);
}
