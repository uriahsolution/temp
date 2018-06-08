package com.uriah.mmvm.busytoeasy.ui.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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
import com.facebook.accountkit.ui.SkinManager;
import com.facebook.accountkit.ui.UIManager;
import com.uriah.mmvm.busytoeasy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login)
    Button login;
    @BindView(R.id.logout)
    Button logout;

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;


    private static final String TAG ="Login Activity" ;
    public static int APP_REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkAndRequestPermissions();



        }



    private  boolean checkAndRequestPermissions() {
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
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }

    //on activity

    private void getCurrentAccount(){
        AccessToken accessToken = AccountKit.getCurrentAccessToken();
        if (accessToken != null) {
            //Handle Returning User
            AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {

                @Override
                public void onSuccess(final Account account) {

                    // Get Account Kit ID
                    String accountKitId = account.getId();
                    Log.e("Account Kit Id", accountKitId);

                    if(account.getPhoneNumber()!=null) {
                        Log.e("CountryCode", "" + account.getPhoneNumber().getCountryCode());
                        Log.e("PhoneNumber", "" + account.getPhoneNumber().getPhoneNumber());

                        // Get phone number
                        PhoneNumber phoneNumber = account.getPhoneNumber();
                        String phoneNumberString = phoneNumber.toString();
                        logout.setVisibility(View.VISIBLE);
                        login.setVisibility(View.GONE);
                        Log.e("NumberString", phoneNumberString);


                    }

                    if(account.getEmail()!=null)
                        Log.e("Email",account.getEmail());
                }

                @Override
                public void onError(final AccountKitError error) {
                    // Handle Error
                    Log.e(TAG,error.toString());
                }
            });

        } else {
            //Handle new or logged out user
            Log.e(TAG,"Logged Out");
            Toast.makeText(this,"Logged Out User",Toast.LENGTH_SHORT).show();
        }
    }

    public void phoneLogin(@Nullable View view) {

            final Intent intent = new Intent(this, AccountKitActivity.class);
            AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                    new AccountKitConfiguration.AccountKitConfigurationBuilder(
                            LoginType.PHONE,

                            AccountKitActivity.ResponseType.CODE).setDefaultCountryCode("IN").setReceiveSMS(true).setReadPhoneStateEnabled(true);

            //Auto retrieve sms
                    configurationBuilder.setReadPhoneStateEnabled(true);
                    configurationBuilder.setReceiveSMS(true);
            // or .ResponseType.TOKEN
            // ... perform additional configuration ...
            intent.putExtra(
                    AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                    configurationBuilder.build());
            startActivityForResult(intent, APP_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(final int requestCode,final int resultCode,final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == APP_REQUEST_CODE && resultCode == RESULT_OK) {
            getCurrentAccount();
        }
    }

    public void logout(@Nullable View view){
        AccountKit.logOut();
        AccessToken accessToken = AccountKit.getCurrentAccessToken();
        if(accessToken!=null)
            Log.e(TAG,"Still Logged in...");

        else
            logout.setVisibility(View.GONE);
        login.setVisibility(View.VISIBLE);
    }







}
