package com.ajithpoison.ownersmanual.hom;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.MobileAds;
import com.kobakei.ratethisapp.RateThisApp;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Toast backToast;
    boolean doubleBackToExitPressedOnce = false;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        MobileAds.initialize(this, "ca-app-pub-8453607245436940~6808633237");
        RateThisApp.Config config = new RateThisApp.Config(1, 1);
        RateThisApp.init(config);
        RateThisApp.onCreate(this);
        RateThisApp.showRateDialogIfNeeded(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.NavigationView);
        navigationView.setNavigationItemSelectedListener(this);

        this.getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        Fragment current = getCurrentFragment();
                        if (current instanceof ChaptersFragment) {
                            navigationView.setCheckedItem(R.id.nav_chapters);
                        } else if (current instanceof ContactFragment) {
                            navigationView.setCheckedItem(R.id.nav_contact);
                        } else {
                            navigationView.setCheckedItem(R.id.nav_chapters);
                        }
                    }
                });

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
                String shareBody = "https://play.google.com/store/apps/details?id=com.ajithpoison.ownersmanual.hom";
                String shareSub = "Your Subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent, "Share \"Honda Owners Manual App\" via"));
                break;
            case R.id.mRate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.ajithpoison.ownersmanual.hom")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "com.ajithpoison.ownersmanual.hom")));
                }
                break;
        }
        return true;
    }

    public Fragment getCurrentFragment() {
        return this.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_chapters:
                ChaptersFragment chaptersFragment = new ChaptersFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, chaptersFragment, "ChaptersFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.nav_contact:
                ContactFragment contactFrag = new ContactFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, contactFrag, "ContactFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.nav_exit:
                finish();
                System.exit(0);
                break;
            case R.id.nav_share:
                Intent myIntent1 = new Intent(Intent.ACTION_SEND);
                myIntent1.setType("text/plain");
                String shareBody1 = "https://play.google.com/store/apps/details?id=com.ajithpoison.ownersmanual.hom";
                String shareSub1 = "Your Subject here";
                myIntent1.putExtra(Intent.EXTRA_SUBJECT, shareSub1);
                myIntent1.putExtra(Intent.EXTRA_TEXT, shareBody1);
                startActivity(Intent.createChooser(myIntent1, "Share \"Honda Owners Manual App\" via"));
                break;
            case R.id.nav_rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.ajithpoison.ownersmanual.hom")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "com.ajithpoison.ownersmanual.hom")));
                }
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
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else if (!doubleBackToExitPressedOnce) {
                    this.doubleBackToExitPressedOnce = true;
                    backToast = Toast.makeText(this, "Tap back again to exit", Toast.LENGTH_SHORT);
                    backToast.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            doubleBackToExitPressedOnce = false;
                        }
                    }, 2000);
                } else {
                    backToast.cancel();
                    super.onBackPressed();
                }
            }
        }
    }
}
