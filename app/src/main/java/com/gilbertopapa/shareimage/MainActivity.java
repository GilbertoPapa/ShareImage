package com.gilbertopapa.shareimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.gilbertopapa.shareimage.adapter.TabAdapter;
import com.gilbertopapa.shareimage.widget.SlidingTabLayout;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slt_main);
        viewPager = (ViewPager) findViewById(R.id.vp_main);

        TabAdapter tabsAdapter = new TabAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(tabsAdapter);
        slidingTabLayout.setViewPager(viewPager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_exit:
                logoutUser();
                break;
            case R.id.action_settings:
                break;
            case R.id.action_share:
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }


    private void logoutUser() {
        ParseUser.logOut();
        Intent intentLogout = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intentLogout);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
