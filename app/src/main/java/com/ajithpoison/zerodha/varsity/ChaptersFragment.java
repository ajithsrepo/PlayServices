package com.ajithpoison.zerodha.varsity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChaptersFragment extends Fragment {
    private CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_chapters, container, false);
        c1 = (CardView) myView.findViewById(R.id.chapter1);
        c2 = (CardView) myView.findViewById(R.id.chapter2);
        c3 = (CardView) myView.findViewById(R.id.chapter3);
        c4 = (CardView) myView.findViewById(R.id.chapter4);
        c5 = (CardView) myView.findViewById(R.id.chapter5);
        c6 = (CardView) myView.findViewById(R.id.chapter6);
        c7 = (CardView) myView.findViewById(R.id.chapter7);
        c8 = (CardView) myView.findViewById(R.id.chapter8);
        c9 = (CardView) myView.findViewById(R.id.chapter9);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap1.class);
                in.putExtra("some", "Introduction to Stock Markets");
                startActivity(in);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap2.class);
                in.putExtra("some", "Technical Analysis");
                startActivity(in);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap3.class);
                in.putExtra("some", "Fundamental Analysis");
                startActivity(in);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap4.class);
                in.putExtra("some", "Futures Trading");
                startActivity(in);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap5.class);
                in.putExtra("some", "Options Theory for Professional Trading");
                startActivity(in);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap6.class);
                in.putExtra("some", "Options Strategies");
                startActivity(in);
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap7.class);
                in.putExtra("some", "Markets and Taxation");
                startActivity(in);
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap8.class);
                in.putExtra("some", "Currency and Commodity Futures");
                startActivity(in);
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Chap9.class);
                in.putExtra("some", "Risk Management & Trading Psychology");
                startActivity(in);
            }
        });

        return myView;
    }
}
