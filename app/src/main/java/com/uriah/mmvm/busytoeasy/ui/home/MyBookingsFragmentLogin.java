package com.uriah.mmvm.busytoeasy.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TableLayout;

import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.ui.home.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MyBookingsFragmentLogin extends Fragment {

    private MyBookingsFragmentLoginViewModel mViewModel;

    @BindView(R.id.viewpager_fragment)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;




    public static MyBookingsFragmentLogin newInstance() {
        return new MyBookingsFragmentLogin();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_bookings_fragment_login_fragment,container, false);

        ButterKnife.bind(this,view);


        viewPager.setCurrentItem(2);
        // Setting ViewPager for each Tabs
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        tabs.setupWithViewPager(viewPager);
        return view;
        }

    @Override
    public void onResume() {
        super.onResume();
        Timber.d("on resume ");
        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(OngoingFragment.newInstance(), "Ongoing");
        adapter.addFragment(new HistoryFragment(), "History");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyBookingsFragmentLoginViewModel.class);
        // TODO: Use the ViewModel
    }



}
