package com.uriah.mmvm.busytoeasy.ui.home.services;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.uriah.mmvm.busytoeasy.R;


import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeTableActivity extends AppCompatActivity {


    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewPager);
        //Select category
        viewPager.setCurrentItem(3);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BlankFragment(), "Beauty");
        adapter.addFragment(new BlankFragment(), "Electronics");
        adapter.addFragment(new BlankFragment(), "Home cleaning");
        adapter.addFragment(new BlankFragment(), "Business & Taxes");
        adapter.addFragment(new BlankFragment(), "Health & fitness");
        adapter.addFragment(new BlankFragment(), "Tutors & lessons");
        adapter.addFragment(new BlankFragment(), "Moving homes");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return super.onNavigateUp();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
