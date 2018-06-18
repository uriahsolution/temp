package com.uriah.mmvm.busytoeasy.ui.login;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.ui.login.bus.Events;
import com.uriah.mmvm.busytoeasy.ui.login.bus.GlobalBus;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class LoginActivity extends AppCompatActivity implements HasSupportFragmentInjector {


    private static final String NUMBER_FRAGMENT ="Mobile number enter fragment" ;
    private static final String OTP_FRAGMENT ="Otp fragment" ;


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        configureDagger();
        showFragment(savedInstanceState);

        GlobalBus.getBus().register(this);


        // checkAndRequestPermissions();

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Register this fragment to listen to event.
        GlobalBus.getBus().register(this);
    }

    public void sendMessageToFragment() {

        Events.ActivityFragmentMessage activityFragmentMessageEvent =
                new Events.ActivityFragmentMessage("From Activity");

        GlobalBus.getBus().post(activityFragmentMessageEvent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalBus.getBus().unregister(this);
    }




    /*private  boolean checkAndRequestPermissions() {
        int camera = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int storage = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int loc = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int loc3 = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }
        if (storage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.INTERNET);
        }
        if (loc != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (loc3 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
        }
        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(this,listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();

        }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private void showFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {

            LoginFragment fragment = new LoginFragment();

            Bundle bundle = new Bundle();

            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, NUMBER_FRAGMENT)
                    .commit();


            /*ContactListFragment contactListFragment =
                    (ContactListFragment)getFragmentManager().findFragmentByTag("ContactList");
            if(contactListFragment == null){
                contactListFragment = new ContactListFragment();
            }
            ft.replace(R.id.fragment_container, contactListFragment,"ContactList";
            ft.commit();*/
        }
    }

    private void configureDagger()
    {
        AndroidInjection.inject(this);
    }


}
