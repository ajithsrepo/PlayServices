package com.ajithpoison.zerodha.varsity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class ContactFragment extends Fragment {
    private RelativeLayout r1, r2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_contact, container, false);
        r1 = (RelativeLayout) myView.findViewById(R.id.callme);
        r2 = (RelativeLayout) myView.findViewById(R.id.messageme);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "+919843993176";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "+919843993176", null   ));
        startActivity(intent);
    }
    });
        return myView;
}
}
