package com.ajithpoison.zerodha.varsity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle nToggle;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.NavigationView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ChaptersFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_chapters);
        }
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mShare:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=com.ajithpoison.zerodha.varsity";
                String shareSub = "Your Subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent, "Share \"Zerodha Varsity App\" via"));
                break;
            case R.id.mRate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.ajithpoison.zerodha.varsity")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "com.ajithpoison.zerodha.varsity")));
                }
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_chapters:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChaptersFragment()).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.nav_exit:
                finish();
                System.exit(0);
                break;
            case R.id.nav_share:
                Intent myIntent1 = new Intent(Intent.ACTION_SEND);
                myIntent1.setType("text/plain");
                String shareBody1 = "https://play.google.com/store/apps/details?id=com.ajithpoison.zerodha.varsity";
                String shareSub1 = "Your Subject here";
                myIntent1.putExtra(Intent.EXTRA_SUBJECT,shareSub1);
                myIntent1.putExtra(Intent.EXTRA_TEXT,shareBody1);
                startActivity(Intent.createChooser(myIntent1, "Share \"Zerodha Varsity App\" via"));
                break;
            case R.id.nav_rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.ajithpoison.zerodha.varsity")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "com.ajithpoison.zerodha.varsity")));
                }
                break;
            case R.id.nav_newaccount:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://zerodha.com/open-account?c=ZW3185"));
                startActivity(browserIntent);
                break;
            case R.id.nav_products:
                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://zerodha.com/products?c=ZW3185"));
                startActivity(browserIntent1);
                break;
            case R.id.nav_pricing:
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://zerodha.com/pricing?c=ZW3185"));
                startActivity(browserIntent2);
                break;
            case R.id.nav_mutualfunds:
                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://coin.zerodha.com/?c=ZW3185"));
                startActivity(browserIntent3);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if((backPressedTime + 2000) > System.currentTimeMillis()) {
                backToast.cancel();
                super.onBackPressed();
                return;
            }
            else {
                backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
                backToast.show();
            }
        }
        backPressedTime = System.currentTimeMillis();
    }
}
