package com.uriah.mmvm.busytoeasy.ui.login;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;

import com.facebook.accountkit.AccessToken;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.PhoneNumber;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.ui.MainFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class LoginActivity extends AppCompatActivity implements HasSupportFragmentInjector {


    private static final String TAG ="Login Activity" ;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        configureDagger();
        showFragment(savedInstanceState);

       // checkAndRequestPermissions();

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
                    .add(R.id.fragment_container, fragment, null)
                    .commit();
        }
    }

    private void configureDagger()
    {
        AndroidInjection.inject(this);
    }


}
