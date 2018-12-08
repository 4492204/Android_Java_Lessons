package com.example.vasilii.portfolio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = null;
        Class fragmentClass = WelcomeFragment.class;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass = null;

        int id = item.getItemId();

        if (id == R.id.nav_about) {
            fragmentClass = AboutFragment.class;
        } else if (id == R.id.nav_free_time) {
            fragmentClass = FreeTimeFragment.class;
        } else if (id == R.id.nav_dissertation) {
            fragmentClass = DissertationFragment.class;
        } else if (id == R.id.nav_plans) {
            fragmentClass = PlansFragment.class;
        } else if (id == R.id.nav_contacts) {
            fragmentClass = ContactsFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);

        return activities.size() > 0;
    }

    public void onClick(View button) {
        String link = button.getTag().toString();
        String errorMessage;
        Intent intent;

        if (button.getId() == R.id.contact_email) {
            intent = new Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts(
                    "mailto",
                    link,
                    null
                )
            );
            errorMessage = "Your phone have no app to send an email";
        } else {
            Uri webPage = Uri.parse(link);
            intent = new Intent(Intent.ACTION_VIEW, webPage);
            errorMessage = "Your phone have no app to open a web page";
        }

        if (isIntentSafe(intent)) {
            startActivity(intent);
        } else {
            Toast.makeText(
                getApplicationContext(),
                errorMessage,
                Toast.LENGTH_SHORT
            ).show();
        }
    }
}
