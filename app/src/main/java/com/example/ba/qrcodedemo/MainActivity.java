package com.example.ba.qrcodedemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.addpermission.BAPermissionTool.AddPermission;
import com.example.addpermission.BAPermissionTool.PermissionCallBack;
import com.example.ba.qrcodedemo.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    final int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCameraIntent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(openCameraIntent, 0);

            }
        });
    }


    public boolean checkPermission() {
        return AddPermission.requestPermission(this,101,Manifest.permission.CAMERA
                , Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        AddPermission.callBack(requestCode, permissions, grantResults, new PermissionCallBack() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "获取权限成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String[] strings) {
                Toast.makeText(MainActivity.this,"获取权限失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Log.d("ssssss", "onActivityResult: " + scanResult);
        }
    }
}
