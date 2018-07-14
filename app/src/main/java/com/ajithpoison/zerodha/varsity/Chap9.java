package com.ajithpoison.zerodha.varsity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Chap9 extends AppCompatActivity {
    private AdView mAdView;
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap9);

        MobileAds.initialize(this, "ca-app-pub-8453607245436940~6468819591");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString("some") != null) {
                Toast.makeText(getApplicationContext(),
                        "Chapter 9 : " + bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Module 9_Risk Management & Trading Psychology.pdf").load();

    }

}
