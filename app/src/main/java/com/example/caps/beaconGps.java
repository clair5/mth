package com.example.caps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

public class beaconGps extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static Object mContext;
    private BluetoothSPP bt;
    TextView txt1, txt1_1, txt1_5, txt2, txt1_2, txt1_4, txt1_8, user;
    TextView txt3, txt1_3, txt1_10;
    TextView txt4, txt1_6, txt1_11, txt1_15;
    TextView txt5, txt1_7, txt1_12, txt1_14, txt1_17;
    TextView txt6, txt1_9, txt1_13, txt1_21;
    TextView txt7, txt1_16, txt1_23;
    TextView txt8, txt1_18, txt1_24, txt1_26;
    TextView txt9, txt1_22, txt1_25, user1;
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    int count = 0;
    Button buttonMain, buttonsale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_4);
        buttonsale = (Button) findViewById(R.id.button_Scan);

        buttonsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, beaconScanner.class);
                startActivity(intent);
                finish();
            }
        });
        buttonMain = (Button) findViewById(R.id.buttonMain);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txt1 = (TextView) findViewById(R.id.text1);
        //mContext = this;
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, val.class);
                startActivity(intent);
                finish();
            }
        });
        txt2 = (TextView) findViewById(R.id.text2);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, GPS.class);
                startActivity(intent);
                finish();
            }
        });
        txt3 = (TextView) findViewById(R.id.text3);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, fish.class);
                startActivity(intent);
                finish();
            }
        });
        txt4 = (TextView) findViewById(R.id.text4);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, RamenActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txt5 = (TextView) findViewById(R.id.text5);
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, lceActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txt6 = (TextView) findViewById(R.id.text6);
        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, SimplyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txt7 = (TextView) findViewById(R.id.text7);
        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, NeedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txt8 = (TextView) findViewById(R.id.text8);
        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, SnakeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txt9 = (TextView) findViewById(R.id.text9);
        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(beaconGps.this, drinkActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bt = new BluetoothSPP(this);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                Map<String, Object> city = new HashMap<>();
                city.put("ultrasound", message);

                db.collection("raspberry").document("raspberry")
                        .set("ultrasound")
                        .addOnSuccessListener(new OnSuccessListener<java.lang.Void>() {
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
                city.put("result1", message);

                db.collection("raspberry").document("raspberry")
                        .set("result1")
                        .addOnSuccessListener(new OnSuccessListener<java.lang.Void>() {
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
                city.put("result2", message);

                db.collection("raspberry").document("raspberry")
                        .set("result2")
                        .addOnSuccessListener(new OnSuccessListener<java.lang.Void>() {
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
        DocumentReference docRef = db.collection("raspberry").document("raspberry");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    System.err.println("Listen failed: " + error);
                    return;
                }
                if (value != null && value.exists()) {
                    System.out.println("Current data: " + value);
                    float nNumber = Float.parseFloat(String.valueOf(value.getLong("ultrasound")));
                    @SuppressLint("DefaultLocale") String pm25 = String.format("%.0f", nNumber);


                    float nNumber1 = Float.parseFloat(String.valueOf(value.getLong("result1")));
                    @SuppressLint("DefaultLocale") String pm255 = String.format("%.0f", nNumber1);


                    float nNumber2 = Float.parseFloat(String.valueOf(value.getLong("result2")));
                    @SuppressLint("DefaultLocale") String pm256 = String.format("%.0f", nNumber2);
                    initProgress(pm25);
                    initpp(pm256);
                    //init(pm256);


                } else {
                    System.out.print("Current data: null");
                }
            }
        });

    }

    @SuppressLint({"WrongConstant", "ShowToast"})
    public void initProgress(String pm_25) {
        int pm25 = Integer.parseInt(pm_25);

        if (pm25 < 10) {
            Context applicationContext;
            Toast toast = Toast.makeText(beaconGps.this, "장애물이 감지되었습니다 ", Toast.LENGTH_SHORT);
            TextView toastMessage1 = (TextView) toast.getView().findViewById(android.R.id.message);
            toastMessage1.setTextColor(Color.RED);
            toastMessage1.setTextSize(20);
            toast.show();
        } else {
            Toast toast = Toast.makeText(beaconGps.this, " 스마트 장바구니 정상 작동 ", Toast.LENGTH_SHORT);
            TextView toastMessage2 = (TextView) toast.getView().findViewById(android.R.id.message);
            toastMessage2.setTextColor(Color.WHITE);
            toastMessage2.setTextSize(20);
            toast.show();
        }


    }

    @SuppressLint({"WrongConstant", "ResourceType"})
    public int initpp(String pm_26) {
        int pm255 = Integer.parseInt(pm_26);

        img1 = (ImageView) findViewById(R.id.imageBeef2);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageBeef4);
        img7 = (ImageView) findViewById(R.id.imageBeef5);
        img8 = (ImageView) findViewById(R.id.imageView8);
        img9 = (ImageView) findViewById(R.id.imageView9);

        txt1 = (TextView) findViewById(R.id.text1);
        txt1_1 = (TextView) findViewById(R.id.text1_1);
        txt1_5 = (TextView) findViewById(R.id.text1_5);

        txt2 = (TextView) findViewById(R.id.text2);
        txt1_4 = (TextView) findViewById(R.id.text1_4);
        txt1_2 = (TextView) findViewById(R.id.text1_2);
        txt1_8 = (TextView) findViewById(R.id.text1_8);

        txt3 = (TextView) findViewById(R.id.text3);
        txt1_3 = (TextView) findViewById(R.id.text1_3);
        txt1_10 = (TextView) findViewById(R.id.text1_10);

        txt4 = (TextView) findViewById(R.id.text4);
        txt1_6 = (TextView) findViewById(R.id.text1_6);
        txt1_11 = (TextView) findViewById(R.id.text1_11);
        txt1_15 = (TextView) findViewById(R.id.text1_15);

        txt5 = (TextView) findViewById(R.id.text5);
        txt1_7 = (TextView) findViewById(R.id.text1_7);
        txt1_12 = (TextView) findViewById(R.id.text1_12);
        txt1_14 = (TextView) findViewById(R.id.text1_14);
        txt1_17 = (TextView) findViewById(R.id.text1_17);

        txt6 = (TextView) findViewById(R.id.text6);
        txt1_9 = (TextView) findViewById(R.id.text1_9);
        txt1_13 = (TextView) findViewById(R.id.text1_13);
        txt1_21 = (TextView) findViewById(R.id.text1_21);

        txt7 = (TextView) findViewById(R.id.text7);
        txt1_16 = (TextView) findViewById(R.id.text1_16);
        txt1_23 = (TextView) findViewById(R.id.text1_23);

        txt8 = (TextView) findViewById(R.id.text8);
        txt1_18 = (TextView) findViewById(R.id.text1_18);
        txt1_24 = (TextView) findViewById(R.id.text1_24);
        txt1_26 = (TextView) findViewById(R.id.text1_26);

        txt9 = (TextView) findViewById(R.id.text9);
        txt1_22 = (TextView) findViewById(R.id.text1_22);
        txt1_25 = (TextView) findViewById(R.id.text1_25);


        user = (TextView) findViewById(R.id.user);
        //  user1 = (TextView)findViewById(R.id.user1);

/*
         if (pm255 == 1) {
             txt1.setText(Html.fromHtml("<font color=\"#ff0000\">" + "1." + "야채코너" + " </font>"));
             txt1.setTextSize(25);
             user.setText("1번 야채 코너에 스마트 장바구니 가 있습니다");
             user.setTextSize(25);
             user1.setText("1번 야채 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(25);
             user1.setTextColor(Color.BLUE);
             user.setTextColor(Color.RED);

             txt1_1.setVisibility(View.VISIBLE);
             txt1_5.setVisibility(View.VISIBLE);
             img1.setVisibility(View.VISIBLE);
         } else {
             txt1.setText(Html.fromHtml("<font color=\"#808080\">" + "1." + "야채코너" + " </font>"));
             txt1.setTextSize(25);
             txt1_1.setVisibility(View.INVISIBLE);
             txt1_5.setVisibility(View.INVISIBLE);
             img1.setVisibility(View.INVISIBLE);
         }

         if (pm255 == 2) {
             txt2.setText(Html.fromHtml("<font color=\"#ff0000\">" + "2." + "고기코너" + " </font>"));
             txt2.setTextSize(25);
             user.setText("2번 고기코너에 스마트 장바구니가 있습니다");
             user.setTextSize(25);
             user1.setText("2번 고기 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(25);
             user1.setTextColor(Color.BLUE);
             user.setTextColor(Color.RED);


             txt1_2.setVisibility(View.VISIBLE);
             txt1_4.setVisibility(View.VISIBLE);
             txt1_8.setVisibility(View.VISIBLE);
             img2.setVisibility(View.VISIBLE);

         } else {
             txt2.setText(Html.fromHtml("<font color=\"#808080\">" + "2." + "고기코너" + " </font>"));
             txt2.setTextSize(25);
             txt1_2.setVisibility(View.INVISIBLE);
             txt1_4.setVisibility(View.INVISIBLE);
             txt1_8.setVisibility(View.INVISIBLE);
             img2.setVisibility(View.INVISIBLE);

         }

         if (pm255 == 3) {
             txt3.setText(Html.fromHtml("<font color=\"#ff0000\">" + "3." + "생선코너" + " </font>"));
             txt3.setTextSize(25);
             user.setText("3번 생선코너에 스마트 장바구니 가 있습니다");
             user.setTextSize(25);
             user1.setText("3번 생선 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(25);
             user.setTextColor(Color.RED);
             user1.setTextColor(Color.BLUE);


             txt1_3.setVisibility(View.VISIBLE);
             txt1_10.setVisibility(View.VISIBLE);
             img3.setVisibility(View.VISIBLE);

         } else {
             txt3.setText(Html.fromHtml("<font color=\"#808080\">" + "3." + "생선코너" + " </font>"));
             txt3.setTextSize(25);
             txt1_3.setVisibility(View.INVISIBLE);
             txt1_10.setVisibility(View.INVISIBLE);
             img3.setVisibility(View.INVISIBLE);

         }

         if (pm255 == 4) {
             txt4.setText(Html.fromHtml("<font color=\"#ff0000\">" + "4." + "라면코너" + " </font>"));
             txt4.setTextSize(25);
             user.setText("4번 라면코너에 스마트 장바구니 가 있습니다");
             user.setTextSize(25);
             user1.setText("4번 라면 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(25);
             user.setTextColor(Color.RED);


             txt1_6.setVisibility(View.VISIBLE);
             txt1_11.setVisibility(View.VISIBLE);
             txt1_15.setVisibility(View.VISIBLE);
             img4.setVisibility(View.VISIBLE);

         } else {
             txt4.setText(Html.fromHtml("<font color=\"#808080\">" + "4." + "라면코너" + " </font>"));
             txt4.setTextSize(25);
             txt1_6.setVisibility(View.INVISIBLE);
             txt1_11.setVisibility(View.INVISIBLE);
             txt1_15.setVisibility(View.INVISIBLE);
             img4.setVisibility(View.INVISIBLE);

         }

         if (pm255 == 5) {
             txt5.setText(Html.fromHtml("<font color=\"#ff0000\">" + "5." + "냉동코너" + " </font>"));
             txt5.setTextSize(25);
             user.setText("5번 냉동식품 코너에 스마트 장바구니 가 있습니다");
             user.setTextSize(25);
             user1.setText("5번 냉동식품 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(23);
             user.setTextColor(Color.RED);
             user1.setTextColor(Color.BLUE);

             txt1_7.setVisibility(View.VISIBLE);
             txt1_12.setVisibility(View.VISIBLE);
             txt1_14.setVisibility(View.VISIBLE);
             txt1_17.setVisibility(View.VISIBLE);
             img5.setVisibility(View.VISIBLE);

         } else {
             txt5.setText(Html.fromHtml("<font color=\"#808080\">" + "5." + "냉동코너" + " </font>"));
             txt5.setTextSize(25);
             txt1_7.setVisibility(View.INVISIBLE);
             txt1_12.setVisibility(View.INVISIBLE);
             txt1_14.setVisibility(View.INVISIBLE);
             txt1_17.setVisibility(View.INVISIBLE);
             img5.setVisibility(View.INVISIBLE);

         }

         if (pm255 == 6) {
             txt6.setText(Html.fromHtml("<font color=\"#ff0000\">" + "6." + "즉석품코너" + " </font>"));
             txt6.setTextSize(23);
             user.setText("6번 즉석식품 코너에 스마트 장바구니 가 있습니다");
             user.setTextSize(25);
             user1.setText("6번 즉석식품 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(23);
             user.setTextColor(Color.RED);
             user1.setTextColor(Color.BLUE);


             txt1_9.setVisibility(View.VISIBLE);
             txt1_13.setVisibility(View.VISIBLE);
             txt1_21.setVisibility(View.VISIBLE);
             img6.setVisibility(View.VISIBLE);

         } else {
             txt6.setText(Html.fromHtml("<font color=\"#808080\">" + "6." + "즉석품코너" + " </font>"));
             txt6.setTextSize(23);
             txt1_9.setVisibility(View.INVISIBLE);
             txt1_13.setVisibility(View.INVISIBLE);
             txt1_21.setVisibility(View.INVISIBLE);
             img6.setVisibility(View.INVISIBLE);

         }


         if (pm255 == 7) {
             txt7.setText(Html.fromHtml("<font color=\"#ff0000\">" + "7." + "생필품코너" + " </font>"));
             txt7.setTextSize(23);
             user.setText("7번 생필품 코너에 스마트 장바구니 가 있습니다");
             user1.setText("7번 생필품 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(25);
             user.setTextSize(25);
             user.setTextColor(Color.RED);
             user1.setTextColor(Color.BLUE);



             txt1_16.setVisibility(View.VISIBLE);
             txt1_23.setVisibility(View.VISIBLE);
             img7.setVisibility(View.VISIBLE);

         } else {
             txt7.setText(Html.fromHtml("<font color=\"#808080\">" + "7." + "생필품코너" + " </font>"));
             txt7.setTextSize(23);
             txt1_16.setVisibility(View.INVISIBLE);
             txt1_23.setVisibility(View.INVISIBLE);
             img7.setVisibility(View.INVISIBLE);

         }

         if (pm255 == 8) {
             txt8.setText(Html.fromHtml("<font color=\"#ff0000\">" + "8." + "과자코너" + " </font>"));
             txt8.setTextSize(23);
             user.setText("8번 과자 코너에 스마트 장바구니 가 있습니다");
             user1.setText("8번 과자 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(25);
             user.setTextSize(25);
             user.setTextColor(Color.RED);
             user1.setTextColor(Color.BLUE);



             txt1_18.setVisibility(View.VISIBLE);
             txt1_24.setVisibility(View.VISIBLE);
             txt1_26.setVisibility(View.VISIBLE);
             img8.setVisibility(View.VISIBLE);

         } else {
             txt8.setText(Html.fromHtml("<font color=\"#808080\">" + "8." + " 과자코너" + " </font>"));
             txt8.setTextSize(23);
             txt1_18.setVisibility(View.INVISIBLE);
             txt1_24.setVisibility(View.INVISIBLE);
             txt1_26.setVisibility(View.INVISIBLE);
             img8.setVisibility(View.INVISIBLE);

         }


         if (pm255 == 9) {
             txt9.setText(Html.fromHtml("<font color=\"#ff0000\">" + "9." + "음료코너" + " </font>"));
             txt9.setTextSize(25);
             user.setText("9번 음료 코너에 스마트 장바구니 가 있습니다");
             user.setTextSize(25);
             user1.setText("9번 음료 코너를 눌러서 세일 정보를 확인해보세요");
             user1.setTextSize(25);
             user.setTextColor(Color.RED);
             user1.setTextColor(Color.BLUE);




             txt1_22.setVisibility(View.VISIBLE);
             txt1_25.setVisibility(View.VISIBLE);
             img9.setVisibility(View.VISIBLE);

         } else {
             txt9.setText(Html.fromHtml("<font color=\"#808080\">" + "9." + "음료코너" + " </font>"));
             txt9.setTextSize(25);
             txt1_22.setVisibility(View.INVISIBLE);
             txt1_25.setVisibility(View.INVISIBLE);
             img9.setVisibility(View.INVISIBLE);


         }

 */
        return pm255;
     }


}







