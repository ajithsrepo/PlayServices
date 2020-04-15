package com.ajithpoison.ownersmanual.hom;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ChaptersFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_chapters, container, false);

        MobileAds.initialize(requireActivity(), "ca-app-pub-8453607245436940~6808633237");
        AdView mAdView = myView.findViewById(R.id.chaptersAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        CardView c1 = myView.findViewById(R.id.chapter1);
        c1.setOnClickListener(this);
        CardView c2 = myView.findViewById(R.id.chapter2);
        c2.setOnClickListener(this);
        CardView c3 = myView.findViewById(R.id.chapter3);
        c3.setOnClickListener(this);
        CardView c4 = myView.findViewById(R.id.chapter4);
        c4.setOnClickListener(this);
        CardView c5 = myView.findViewById(R.id.chapter5);
        c5.setOnClickListener(this);
        CardView c6 = myView.findViewById(R.id.chapter6);
        c6.setOnClickListener(this);
        CardView c7 = myView.findViewById(R.id.chapter7);
        c7.setOnClickListener(this);
        CardView c8 = myView.findViewById(R.id.chapter8);
        c8.setOnClickListener(this);
        CardView c9 = myView.findViewById(R.id.chapter9);
        c9.setOnClickListener(this);
        CardView c10 = myView.findViewById(R.id.chapter10);
        c10.setOnClickListener(this);
        CardView c11 = myView.findViewById(R.id.chapter11);
        c11.setOnClickListener(this);
        CardView c12 = myView.findViewById(R.id.chapter12);
        c12.setOnClickListener(this);
        CardView c13 = myView.findViewById(R.id.chapter13);
        c13.setOnClickListener(this);
        CardView c14 = myView.findViewById(R.id.chapter14);
        c14.setOnClickListener(this);
        CardView c15 = myView.findViewById(R.id.chapter15);
        c15.setOnClickListener(this);
        CardView c16 = myView.findViewById(R.id.chapter16);
        c16.setOnClickListener(this);
        CardView c17 = myView.findViewById(R.id.chapter17);
        c17.setOnClickListener(this);
        CardView c18 = myView.findViewById(R.id.chapter18);
        c18.setOnClickListener(this);
        CardView c19 = myView.findViewById(R.id.chapter19);
        c19.setOnClickListener(this);
        CardView c20 = myView.findViewById(R.id.chapter20);
        c20.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View view) {
        Intent in = new Intent(getActivity(), PDFViewer.class);
        switch (view.getId()) {

            case R.id.chapter1:
                in.putExtra("Flag", "Activa_5G");
                startActivity(in);
                break;

            case R.id.chapter2:
                in.putExtra("Flag", "Activa_125");
                startActivity(in);
                break;

            case R.id.chapter3:
                in.putExtra("Flag", "Activa_i");
                startActivity(in);
                break;

            case R.id.chapter4:
                in.putExtra("Flag", "Aviator");
                startActivity(in);
                break;

            case R.id.chapter5:
                in.putExtra("Flag", "CB300R");
                startActivity(in);
                break;

            case R.id.chapter6:
                in.putExtra("Flag", "CB_Hornet");
                startActivity(in);
                break;

            case R.id.chapter7:
                in.putExtra("Flag", "CB_Shine");
                startActivity(in);
                break;

            case R.id.chapter8:
                in.putExtra("Flag", "CB_Shine_SP");
                startActivity(in);
                break;

            case R.id.chapter9:
                in.putExtra("Flag", "CB_Unicorn_150");
                startActivity(in);
                break;

            case R.id.chapter10:
                in.putExtra("Flag", "CB_Unicorn_160");
                startActivity(in);
                break;

            case R.id.chapter11:
                in.putExtra("Flag", "CBR250R");
                startActivity(in);
                break;

            case R.id.chapter12:
                in.putExtra("Flag", "CD110");
                startActivity(in);
                break;

            case R.id.chapter13:
                in.putExtra("Flag", "Cliq");
                startActivity(in);
                break;

            case R.id.chapter14:
                in.putExtra("Flag", "Dio");
                startActivity(in);
                break;

            case R.id.chapter15:
                in.putExtra("Flag", "Dream_Neo");
                startActivity(in);
                break;

            case R.id.chapter16:
                in.putExtra("Flag", "Dream_Yuga");
                startActivity(in);
                break;

            case R.id.chapter17:
                in.putExtra("Flag", "Grazia");
                startActivity(in);
                break;

            case R.id.chapter18:
                in.putExtra("Flag", "Livo");
                startActivity(in);
                break;

            case R.id.chapter19:
                in.putExtra("Flag", "Navi");
                startActivity(in);
                break;

            case R.id.chapter20:
                in.putExtra("Flag", "XBlade");
                startActivity(in);
                break;

            default:
                break;
        }
    }
}
