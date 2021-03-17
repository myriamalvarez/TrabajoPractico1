package com.example.trabajopractico1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class ConexionUSB extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_STATE");
        boolean conectado=(intent.getExtras().getBoolean("connected"));

        if (conectado) {
            Toast.makeText(context, "Se ha conectado el USB. Generando llamada de emergencia", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel: 1234"));

            context.startActivity(i);
        }
        else {
            Toast.makeText(context, "No se puede realizar el llamado", Toast.LENGTH_LONG).show();
            }
     }
}

