package com.mindnotix.mymvprecyclerview.view.IView;

import android.app.Activity;
import android.os.Handler;

import com.mindnotix.mymvprecyclerview.presenter.BasePresenter;


/**
 * Created by Admin on 3/23/2018.
 */

public interface IBaseView {

    void showMessage(String msg);

    Handler getHandler();

    Activity getActivity();


    void bindPresenter(BasePresenter basePresenter);
}
