package com.example.saviel.webview;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String programming = "/r/programming";
    private String programmerHumor = "/r/programmerhumor";
    private String news = "/r/news";
    private String theNetherlands = "/r/theNetherlands";
    private String coolGuides = "/r/coolguides";
    private String gaming = "/r/gaming";
    private String juggling = "/r/juggling";
    private String science = "/r/science";
    private String iAmA = "/r/iAmA";
    private String askScience = "/r/askscience";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadSubredditFragment(programming);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Programming) {
            loadSubredditFragment(programming);
        } else if (id == R.id.ProgrammerHumor) {
            loadSubredditFragment(programmerHumor);

        } else if (id == R.id.News) {
            loadSubredditFragment(news);

        } else if (id == R.id.TheNetherlands) {
            loadSubredditFragment(theNetherlands);

        } else if (id == R.id.coolguides) {
            loadSubredditFragment(coolGuides);
        } else if (id == R.id.gaming) {
            loadSubredditFragment(gaming);

        } else if (id == R.id.juggling) {
            loadSubredditFragment(juggling);

        } else if (id == R.id.science) {
            loadSubredditFragment(science);

        } else if (id == R.id.iama) {
            loadSubredditFragment(iAmA);

        } else if (id == R.id.askscience) {
            loadSubredditFragment(askScience);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadSubredditFragment(String subreddit) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE);
        SubredditFragment subredditFragment = new SubredditFragment();

        Bundle bundle = new Bundle();
        bundle.putString(SubredditFragment.SUBREDDIT, subreddit);
        subredditFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentLayout, subredditFragment);
        fragmentTransaction.commit();
    }
}
