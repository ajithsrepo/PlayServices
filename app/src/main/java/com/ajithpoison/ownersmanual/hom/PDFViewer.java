package com.ajithpoison.ownersmanual.hom;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class PDFViewer extends AppCompatActivity {
    PDFView pdfView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        MobileAds.initialize(this, "ca-app-pub-8453607245436940~6808633237");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8453607245436940/3914876580");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                startActivity(new Intent(PDFViewer.this, Home.class));
                finish();
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            pdfView = findViewById(R.id.pdfView);
            if (bundle.getString("Flag") != null) {
                setTitle(bundle.getString("Flag"));
                switch (bundle.getString("Flag")) {
                    case "Activa_5G":
                        pdfView.fromAsset("Activa_5G.pdf").load();
                        break;
                    case "Activa_125":
                        pdfView.fromAsset("Activa_125.pdf").load();
                        break;
                    case "Activa_i":
                        pdfView.fromAsset("Activa_i.pdf").load();
                        break;
                    case "Aviator":
                        pdfView.fromAsset("Aviator.pdf").load();
                        break;
                    case "CB300R":
                        pdfView.fromAsset("CB300R.pdf").load();
                        break;
                    case "CB_Hornet":
                        pdfView.fromAsset("CB_Hornet.pdf").load();
                        break;
                    case "CB_Shine":
                        pdfView.fromAsset("CB_Shine.pdf").load();
                        break;
                    case "CB_Shine_SP":
                        pdfView.fromAsset("CB_Shine_SP.pdf").load();
                        break;
                    case "CB_Unicorn_150":
                        pdfView.fromAsset("CB_Unicorn_150.pdf").load();
                        break;
                    case "CB_Unicorn_160":
                        pdfView.fromAsset("CB_Unicorn_160.pdf").load();
                        break;
                    case "CBR250R":
                        pdfView.fromAsset("CBR250R.pdf").load();
                        break;
                    case "CD110":
                        pdfView.fromAsset("CD110.pdf").load();
                        break;
                    case "Cliq":
                        pdfView.fromAsset("Cliq.pdf").load();
                        break;
                    case "Dio":
                        pdfView.fromAsset("Dio.pdf").load();
                        break;
                    case "Dream_Neo":
                        pdfView.fromAsset("Dream_Neo.pdf").load();
                        break;
                    case "Dream_Yuga":
                        pdfView.fromAsset("Dream_Yuga.pdf").load();
                        break;
                    case "Grazia":
                        pdfView.fromAsset("Grazia.pdf").load();
                        break;
                    case "Livo":
                        pdfView.fromAsset("Livo.pdf").load();
                        break;
                    case "Navi":
                        pdfView.fromAsset("Navi.pdf").load();
                        break;
                    case "XBlade":
                        pdfView.fromAsset("XBlade.pdf").load();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Error opening manual. Please contact developer.",
                                Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(),
                        "Error opening manual. Please contact developer.",
                        Toast.LENGTH_SHORT).show();
            }
        }


    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            super.onBackPressed();
            startActivity(new Intent(PDFViewer.this, Home.class));
            finish();
        }
    }

}
