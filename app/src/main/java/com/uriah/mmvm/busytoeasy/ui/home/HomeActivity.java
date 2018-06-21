package com.uriah.mmvm.busytoeasy.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.uriah.mmvm.busytoeasy.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;


public class HomeActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @BindView(R.id.navigation) BottomNavigationView navigation;


    private static final String TAG_FRAGMENT_ONE = "home";
    private static final String TAG_FRAGMENT_TWO = "booking";
    private static final String TAG_FRAGMENT_THREE = "profile";

    private FragmentManager fragmentManager;
    private Fragment currentFragment;


    /*This line will programmatically perform click on nav_button_two in bottomNavigationView.. then all event will handle by bottomNavigationView .. Then it will highlight the stream icon.
    View view = bottomNavigationView.findViewById(R.id.nav_button_two);
    view.performClick();*/


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    //Bottom navigation
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment = null;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                     fragment = fragmentManager.findFragmentByTag(TAG_FRAGMENT_ONE);
                    if (fragment == null) {

                        fragment = HomeFragment.newInstance();
                    }
                    replaceFragment(fragment, TAG_FRAGMENT_ONE);
                    break;
                case R.id.navigation_dashboard:
                    fragment = fragmentManager.findFragmentByTag(TAG_FRAGMENT_TWO);
                    if (fragment == null) {

                        fragment = MyBookingsFragmentLogin.newInstance();
                    }
                    replaceFragment(fragment, TAG_FRAGMENT_TWO);
                    break;
                 case R.id.navigation_notifications:
                     fragment = fragmentManager.findFragmentByTag(TAG_FRAGMENT_THREE);
                     if (fragment == null) {

                         fragment = ProfileFragment.newInstance();
                     }
                     replaceFragment(fragment, TAG_FRAGMENT_THREE);
                     break;


            }
             return true;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        configureDagger();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // instantiate the fragment manager
        fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(TAG_FRAGMENT_ONE);
        if (fragment == null) {

            fragment = HomeFragment.newInstance();
        }
        replaceFragment(fragment, TAG_FRAGMENT_ONE);


    }

    private void replaceFragment(@NonNull Fragment fragment, @NonNull String tag) {
        if (!fragment.equals(currentFragment)) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment, tag)
                    .commit();
            currentFragment = fragment;
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
    private void configureDagger(){
        AndroidInjection.inject(this);
    }
}
