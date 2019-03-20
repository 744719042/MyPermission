package com.example.mypermission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.ContextThemeWrapper;

class PermissionUtils {
    public static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        } else if (context instanceof ContextThemeWrapper) {
            return findActivity(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean isPermissionSupported() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public static boolean handleLowerVersions(String[] permissions, PermissionsListener listener) {
        if (!isPermissionSupported()) {
            notifyPermissionSuccess(permissions, listener);
            return true;
        }

        return false;
    }

    private static void notifyPermissionSuccess(String[] permissions, PermissionsListener listener) {
        int[] result = new int[permissions.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = PackageManager.PERMISSION_GRANTED;
        }
        if (listener != null) {
            listener.onPermissionResult(result);
        }
    }

    public static boolean hasPermission(Context context, String[] permissions, PermissionsListener listener) {
        if (isPermissionSupported()) {
            for (String permission : permissions) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                        return false;
                    }
                }
            }
        }

        notifyPermissionSuccess(permissions, listener);
        return true;
    }
}
