package com.mindnotix.mymvprecyclerview.presenter;

import android.content.Intent;

import com.mindnotix.mymvprecyclerview.presenter.IPresenter.IBasePresenter;
import com.mindnotix.mymvprecyclerview.view.IView.IMainView;

/**
 * Created by Admin on 3/23/2018.
 */

public abstract class BasePresenter implements IBasePresenter {

    private IMainView iMainView;
    BasePresenter basePresenter;

    public BasePresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        this.iMainView.bindPresenter(this);
    }


    @Override
    public void onStartPresenter() {

    }

    @Override
    public void onStopPresenter() {

    }

    @Override
    public void onPausePresenter() {

    }

    @Override
    public void onResumePresenter() {

    }

    @Override
    public void onDestroyPresenter() {

    }

    @Override
    public void onRestartPresenter() {

    }

    @Override
    public void onActivityResultPresenter(int requestCode, int resultCode, Intent data) {

    }
}
