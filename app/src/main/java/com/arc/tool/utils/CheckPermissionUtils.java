package com.arc.tool.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * 權限檢查
 *
 * @author may
 */
public final class CheckPermissionUtils {
    private CheckPermissionUtils() {
    }

    //需要申请的权限
    private static String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    //检测权限
    public static String[] checkPermission(Context context) {
        List<String> data = new ArrayList<>();//存储未申请的权限
        for (String permission : permissions) {
            int checkSelfPermission = ContextCompat.checkSelfPermission(context, permission);
            if (checkSelfPermission == PackageManager.PERMISSION_DENIED) {//未申请
                data.add(permission);
            }
        }
        return data.toArray(new String[data.size()]);
    }

    public static boolean getCameraPermission(Context context) {

        int selfPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
        System.out.println("当前相机授权情况(说明:0=已授权)=" + selfPermission);

        int target = PackageManager.PERMISSION_GRANTED;
        System.out.println("PackageManager.PERMISSION_GRANTED" + target);

        System.out.println(selfPermission == target);
        if (selfPermission == PackageManager.PERMISSION_GRANTED) {
            //Toast.makeText(ActivityQRCode.this,"您成功申请了动态权限",Toast.LENGTH_SHORT).show();
            System.out.println("当前相机已授权");
        } else {
            System.out.println("当前无相机权限");
            //否则去请求相机权限
            ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.CAMERA}, 100);
        }

        System.out.println("当前SDK版本是:" + Build.VERSION.SDK_INT);
        return true;
    }
}
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            //版本判断
//            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
//            }
//        }
