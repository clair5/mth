package com.example.mth;



import static com.example.mth.R.*;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnMu;
    //    Button btnYa;
//    Button btnPa;
//    Button btnMa;
    Button btnCh;
//    ImageView imgMa;
//    ImageView imgYa;
//    ImageView imgPa;
//    ImageView imgMu;
//    ImageView imgCh;
//    ImageView imageView3;

    BluetoothManager btManager;
    BluetoothAdapter btAdapter;
    BluetoothLeScanner btScanner;

    private final static int REQUEST_ENABLE_BT = 1;
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCh = (Button) findViewById(R.id.btnCh);
        btnCh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startScanning();
            }
        });

        btnMu = (Button) findViewById(R.id.btnMu);
        btnMu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startScanning1();
            }
        });


        btManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        btAdapter = btManager.getAdapter();
        btScanner = btAdapter.getBluetoothLeScanner();


        if (btAdapter != null && !btAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        }

        // Make sure we have access coarse location enabled, if not, prompt the user to enable it
        if (this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("This app needs location access");
            builder.setMessage("Please grant location access so this app can detect peripherals.");
            builder.setPositiveButton(android.R.string.ok, null);
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_COARSE_LOCATION);
                }
            });
            builder.show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_COARSE_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                System.out.println("coarse location permission granted");
            } else {
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Functionality limited");
                builder.setMessage("Since location access has not been granted, this app will not be able to discover beacons when in the background.");
                builder.setPositiveButton(android.R.string.ok, null);
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                    }

                });
                builder.show();
            }
        }
    }

    private final ScanCallback leScanCallback = new ScanCallback() {
        @SuppressLint("SetTextI18n")
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override

        public void onScanResult(int callbackType, ScanResult result) {
            System.out.println(result);
            Button btnCh = (Button) findViewById(id.btnCh);
            Button btnMu = (Button) findViewById(id.btnMu);

            btnCh.setOnClickListener(new View.OnClickListener() {
                String name = "123";

                @Override
                public void onClick(View view) {
                    if (result.getDevice().toString().equals("EB:FD:53:17:5C:D3")) {
                        System.out.println("1212" + result.getRssi());
                        if (result.getRssi() > -100) {
                            name = "ok";
                            System.out.println("1212" + name);
                        }
                        if (name.equals("ok")) {
                            Intent intent = new Intent(getApplicationContext(), ChurchActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            });

            btnMu.setOnClickListener(new View.OnClickListener() {
                String name = "123";

                @Override
                public void onClick(View view) {
                    if (result.getDevice().toString().equals("F7:01:65:14:8B:78")) {
                        System.out.println("1212" + result.getRssi());
                        if (result.getRssi() > -100) {
                            name = "fxxx";
                            System.out.println("1212" + name);
                        }
                        if (name.equals("fxxx")) {
                            Intent intent = new Intent(getApplicationContext(), MuseumActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            });
        }
    };


    public void startScanning() {
        System.out.println("start scanning");
//        peripheralTextView.setText("");
        AsyncTask.execute(new Runnable() {
            @SuppressLint("MissingPermission")
            @Override
            public void run() {
                if (btScanner != null) {
                    btScanner.startScan(leScanCallback);
                }

            }
        });
    }

    public void startScanning1() {
        System.out.println("start scanning");
        //        peripheralTextView.setText("");
        AsyncTask.execute(new Runnable() {
            @SuppressLint("MissingPermission")
            @Override
            public void run() {
                if (btScanner != null) {
                    btScanner.startScan(leScanCallback);
                }

            }
        });
    }
}







