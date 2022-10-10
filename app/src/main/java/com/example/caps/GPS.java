package com.example.caps;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

public class GPS extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int one = 1, one_1 = 1;
    // creating a variable for our list view,
    // arraylist and firebase Firestore.
    private BluetoothSPP bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_3);
        TextView text;
        text = (TextView) findViewById(R.id.textDate2);
        Date currentTime = Calendar.getInstance().getTime();
        String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일", Locale.getDefault()).format(currentTime);
        text.setText(date_text);
        text.setTextSize(20);

        Button btn;
        btn = (Button)findViewById(R.id.buttonmain1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GPS.this, beaconGps.class);
                startActivity(intent);
            }
        });

        ImageView img1,img2,img3,img4,img5;
        Button btnchange;
        img1 = (ImageView)findViewById(R.id.imageBeef1);
        img2 = (ImageView)findViewById(R.id.imageBeef2);
        img3 = (ImageView)findViewById(R.id.imageBeef3);
        img4 = (ImageView)findViewById(R.id.imageBeef4);
        img5 = (ImageView)findViewById(R.id.imageBeef5);


        bt = new BluetoothSPP(this);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                Map<String, Object> city = new HashMap<>();
                city.put("name", message);

                db.collection("raspberry").document("table")
                        .set("name")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(java.lang.Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
            }
        });
        DocumentReference docRef1 = db.collection("raspberry").document("고기코너");
        docRef1.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value != null && value.exists()) {
                    System.out.println("Current data: " + value);
                    //String nNumber = Float.parseFloat(String.valueOf(value.getLong("name")));
                    String value1 = value.get("한우").toString();

                    //@SuppressLint("DefaultLocale") String pm25 = String.format("%.0f", value1);
                    salename(value1);
                }

            }
        });
        DocumentReference docRef1_1 = db.collection("raspberry").document("고기코너");
        docRef1_1.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value != null && value.exists()) {
                    System.out.println("Current data: " + value);
                    //String nNumber = Float.parseFloat(String.valueOf(value.getLong("name")));
                    String value1_1 = value.get("오겹살").toString();
                    //@SuppressLint("DefaultLocale") String pm25 = String.format("%.0f", value1);
                    salenameBeef(value1_1);
                }

            }
        });
        DocumentReference docRef1_2 = db.collection("raspberry").document("고기코너");
        docRef1_2.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value != null && value.exists()) {
                    System.out.println("Current data: " + value);
                    //String nNumber = Float.parseFloat(String.valueOf(value.getLong("name")));
                    String value1_2 = value.get("닭고기").toString();
                    //@SuppressLint("DefaultLocale") String pm25 = String.format("%.0f", value1);
                    salenamefish(value1_2);
                }

            }
        });
        DocumentReference docRef1_3 = db.collection("raspberry").document("고기코너");
        docRef1_3.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value != null && value.exists()) {
                    System.out.println("Current data: " + value);
                    //String nNumber = Float.parseFloat(String.valueOf(value.getLong("name")));
                    String value1_3 = value.get("오리고기").toString();
                    //@SuppressLint("DefaultLocale") String pm25 = String.format("%.0f", value1);
                    salenameOhri(value1_3);
                }

            }
        });
        DocumentReference docRef1_4 = db.collection("raspberry").document("고기코너");
        docRef1_4.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value != null && value.exists()) {
                    System.out.println("Current data: " + value);
                    //String nNumber = Float.parseFloat(String.valueOf(value.getLong("name")));
                    String value1_4 = value.get("삽겹살").toString();
                    //@SuppressLint("DefaultLocale") String pm25 = String.format("%.0f", value1);
                    salenamesan(value1_4);
                }

            }
        });
        // ---- 원래가격 입력 -- ------//
        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                Map<String, Object> city = new HashMap<>();
                city.put("상품가격", message);

                db.collection("raspberry").document("상품가격")
                        .set("상품가격")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(java.lang.Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
            }
        });
        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                Map<String, Object> city = new HashMap<>();
                city.put("상품가격", message);

                db.collection("raspberry").document("상품가격")
                        .set("상품가격")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(java.lang.Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
            }
        });
        DocumentReference docRef2 = db.collection("raspberry").document("상품가격");
        docRef2.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value != null && value.exists()) {
                    System.out.println("Current data: " + value);
                    String value1 = value.get("1번 상품").toString();
                    String value2 = value.get("고기세일").toString();
                    sale(value1);
                    salevalue(value1,value2);
                }

            }
        });
        DocumentReference docRef2_1 = db.collection("raspberry").document("상품가격");
        docRef2_1.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value1, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value1 != null && value1.exists()) {
                    System.out.println("Current data: " + value1);
                    String valueBeef1 = value1.get("2번 상품").toString();
                    String valueBeef2=  value1.get("세일가격").toString();
                   saleBeef(valueBeef1);
                   salevalueBeef(valueBeef1,valueBeef2);
                }

            }
        });
        DocumentReference docRef2_2 = db.collection("raspberry").document("상품가격");
        docRef2_2.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value1, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value1 != null && value1.exists()) {
                    System.out.println("Current data: " + value1);
                    String valuefish1 = value1.get("3번 상품").toString();
                    String valuefish2=  value1.get("생선가격").toString();
                    salefish(valuefish1);
                    salevaluefish(valuefish1,valuefish2);
                }

            }
        });
        DocumentReference docRef2_3 = db.collection("raspberry").document("상품가격");
        docRef2_3.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value1, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value1 != null && value1.exists()) {
                    System.out.println("Current data: " + value1);
                    String valueOhri1 = value1.get("4번 상품").toString();
                    String valueOhri2=  value1.get("오리가격").toString();
                    saleOhri(valueOhri1);
                    salevalueOhri(valueOhri1,valueOhri2);
                }

            }
        });
        DocumentReference docRef2_4 = db.collection("raspberry").document("상품가격");
        docRef2_4.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value1, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value1 != null && value1.exists()) {
                    System.out.println("Current data: " + value1);
                    String valuesan1 = value1.get("5번 상품").toString();
                    String valuesan2=  value1.get("삽겹살가격").toString();
                    salesan(valuesan1);
                    salevaluesan(valuesan1,valuesan2);
                }

            }
        });

    }

    public void salename(String pm25)
    {
        TextView txtOnion;
        txtOnion = (TextView)findViewById(R.id.textsale3);
        txtOnion.setText(pm25);
        txtOnion.setTextSize(25);
    }
    public void sale(String pm25)
    {
        TextView txt2;
        txt2 = (TextView)findViewById(R.id.textprice3);
        txt2.setPaintFlags(txt2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        txt2.setText(pm25);
        txt2.append("원");
        txt2.setTextSize(25);

    }
    public void  salevalue(String pm25 , String i)
    {
        double salevalue1 = Double.parseDouble(pm25);
        double salevalue2 = Double.parseDouble(i);
        TextView txt3;
        txt3 = (TextView)findViewById(R.id.textsalevalue3);
        txt3.setText("세일 가격 : " + salevalue2+"%");
        TextView txt4;
        txt4 = (TextView)findViewById(R.id.textViewResult3);
        txt3.setTextSize(20);
        double number;
        number = salevalue1 * (salevalue2 / 100);
        int result;
        result = (int) (salevalue1- number);
        //String s = Double.toString(number);
        txt4.setText((int) result+"원");
        txt4.setTextSize(25);
    }
//////////////////////////////// 여기 까지 1번 화면 ////////////////////////////
    public void salenameBeef (String pm25)
    {
        TextView txtBeef;
        txtBeef = (TextView)findViewById(R.id.textsale4);
        txtBeef.setText(pm25);
        txtBeef.setTextSize(25);
    }
    public void saleBeef(String pm25)
    {
        TextView txtBeef2;
        txtBeef2 = (TextView)findViewById(R.id.textprice4);
        txtBeef2.setPaintFlags(txtBeef2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        txtBeef2.setText(pm25);
        txtBeef2.append("원");
        txtBeef2.setTextSize(25);

    }
    public void  salevalueBeef(String pm25 , String i)
    {
        double salevalueBeef1 = Double.parseDouble(pm25);
        double salevalueBeef2 = Double.parseDouble(i);
        TextView txtBeef3;
        txtBeef3 = (TextView)findViewById(R.id.textsalevalue4);
        txtBeef3.setText("세일 가격 : " + salevalueBeef2+"%");
        TextView txtBeef4;
        txtBeef3.setTextSize(20);
        txtBeef4 = (TextView)findViewById(R.id.textViewResult4);

        double number;
        number = salevalueBeef1 * (salevalueBeef2 / 100);
        int result;
        result = (int) (salevalueBeef1- number);
        //String s = Double.toString(number);
        txtBeef4.setText((int) result+"원");
        txtBeef4.setTextSize(25);
    }
    /////////////////////////////////// 2번 끝 //////////////////////////

   public void salenamefish(String pm25)
   {
       TextView txtfish;
       txtfish = (TextView)findViewById(R.id.textsale5_1);
       txtfish.setText(pm25);
       txtfish.setTextSize(25);
   }
    public void salefish(String pm25)
    {
        TextView txtfish2;
        txtfish2 = (TextView)findViewById(R.id.textprice5_1);
        txtfish2.setPaintFlags(txtfish2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        txtfish2.setText(pm25);
        txtfish2.append("원");
        txtfish2.setTextSize(25);

    }
    public void  salevaluefish(String pm25 , String i)
    {
        double salevaluefish1 = Double.parseDouble(pm25);
        double salevaluefish2 = Double.parseDouble(i);
        TextView txtfish3;
        txtfish3 = (TextView)findViewById(R.id.textsalevalue5_1);
        txtfish3.setText("세일 가격 : " + salevaluefish2+"%");
        TextView txtBeef4;
        txtfish3.setTextSize(20);
        txtBeef4 = (TextView)findViewById(R.id.textViewResult5_1);

        double number;
        number = salevaluefish1 * (salevaluefish2 / 100);
        int result;
        result = (int) (salevaluefish1- number);
        //String s = Double.toString(number);
        txtBeef4.setText((int) result+"원");
        txtBeef4.setTextSize(25);
    }
///////////////////////////////////3번 끝/////////////////////
    public void salenameOhri(String pm25)
    {
        TextView txtOhri;
        txtOhri = (TextView)findViewById(R.id.textsale6_1);
        txtOhri.setText(pm25);
        txtOhri.setTextSize(25);
    }
    public void saleOhri(String pm25)
    {
        TextView txtOhri2;
        txtOhri2 = (TextView)findViewById(R.id.textprice6_1);
        txtOhri2.setPaintFlags(txtOhri2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        txtOhri2.setText(pm25);
        txtOhri2.append("원");
        txtOhri2.setTextSize(25);

    }
    public void  salevalueOhri(String pm25 , String i)
    {
        double salevalueOhri1 = Double.parseDouble(pm25);
        double salevalueOhri2 = Double.parseDouble(i);
        TextView txtOhri3;
        txtOhri3 = (TextView)findViewById(R.id.textsalevalue6_1);
        txtOhri3.setText("세일 가격 : " + salevalueOhri2+"%");
        TextView txtBeef4;
        txtOhri3.setTextSize(20);
        txtBeef4 = (TextView)findViewById(R.id.textViewResult6_1);

        double number;
        number = salevalueOhri1 * (salevalueOhri2 / 100);
        int result;
        result = (int) (salevalueOhri1- number);
        //String s = Double.toString(number);
        txtBeef4.setText((int) result+"원");
        txtBeef4.setTextSize(25);
    }

    ///////////////////////////// 4번 끝 ////////////////////////////////
    public void salenamesan(String pm25)
    {
        TextView txtsan;
        txtsan = (TextView)findViewById(R.id.textsale7_1);
        txtsan.setText(pm25);
        txtsan.setTextSize(25);
    }
    public void salesan(String pm25)
    {
        TextView txtsan2;
        txtsan2 = (TextView)findViewById(R.id.textprice7_1);
        txtsan2.setPaintFlags(txtsan2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        txtsan2.setText(pm25);
        txtsan2.append("원");
        txtsan2.setTextSize(25);

    }
    public void  salevaluesan(String pm25 , String i)
    {
        double salevaluesan1 = Double.parseDouble(pm25);
        double salevaluesan2 = Double.parseDouble(i);
        TextView txtsan3;
        txtsan3 = (TextView)findViewById(R.id.textsalevalue7_1);
        txtsan3.setText("세일 가격 : " + salevaluesan2+"%");
        TextView txtsan4;
        txtsan3.setTextSize(20);
        txtsan4 = (TextView)findViewById(R.id.textViewResult7_1);

        double number;
        number = salevaluesan1 * (salevaluesan2 / 100);
        int result;
        result = (int) (salevaluesan1- number);
        //String s = Double.toString(number);
        txtsan4.setText((int) result+"원");
        txtsan4.setTextSize(25);
    }


}




