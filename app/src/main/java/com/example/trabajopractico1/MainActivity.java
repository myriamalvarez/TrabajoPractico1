package com.example.trabajopractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private ConexionUSB conex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){

            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1100);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        this.conex=new ConexionUSB();
        registerReceiver(this.conex, new IntentFilter("android.hardware.usb.action.USB_STATE"));


    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(conex);

    }

}