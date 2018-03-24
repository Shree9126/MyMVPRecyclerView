package com.mindnotix.mymvprecyclerview.view;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mindnotix.mymvprecyclerview.presenter.BasePresenter;
import com.mindnotix.mymvprecyclerview.view.IView.IBaseView;

/**
 * Created by Admin on 3/23/2018.
 */

public class BaseActivty extends AppCompatActivity implements IBaseView {

    BasePresenter basePresenter;
    private Handler mHandler;

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Handler getHandler() {
        synchronized (this) {
            if (mHandler == null) {
                mHandler = new Handler();
            }
        }

        return mHandler;
    }

    @Override
    public Activity getActivity() {
        return BaseActivty.this;
    }

    @Override
    public void bindPresenter(BasePresenter basePresenter) {
        this.basePresenter = basePresenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        assert basePresenter != null;
        basePresenter.onStartPresenter();
    }

    @Override
    protected void onPause() {
        super.onPause();
        assert basePresenter != null;
        basePresenter.onPausePresenter();
    }

    @Override
    protected void onStop() {
        super.onStop();
        assert basePresenter != null;
        basePresenter.onStopPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        assert basePresenter != null;
        basePresenter.onResumePresenter();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        assert basePresenter != null;
        basePresenter.onRestartPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        assert basePresenter != null;
        basePresenter.onDestroyPresenter();
    }
}
