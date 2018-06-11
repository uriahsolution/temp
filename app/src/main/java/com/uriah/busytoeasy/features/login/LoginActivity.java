package com.uriah.busytoeasy.features.login;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.uriah.busytoeasy.R;
import com.uriah.busytoeasy.features.base.BaseActivity;
import com.uriah.busytoeasy.features.common.ErrorView;
import com.uriah.busytoeasy.injection.component.ActivityComponent;
import javax.inject.Inject;
import butterknife.BindView;
import timber.log.Timber;

public class LoginActivity extends BaseActivity implements  LoginMvpView,ErrorView.ErrorListener {
    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.view_error)
    ErrorView errorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void attachView() {
        loginPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        loginPresenter.attachView(this);
    }

    @Override
    public void onReloadData() {


    }

    @Override
    public void showProgress(boolean show) {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(Throwable error) {

        errorView.setVisibility(View.VISIBLE);
        Timber.e(error, "There was an error retrieving the login");

    }


}
