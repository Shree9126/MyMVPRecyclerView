package com.mindnotix.mymvprecyclerview.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mindnotix.mymvprecyclerview.R;
import com.mindnotix.mymvprecyclerview.adapter.CustomAdapter;
import com.mindnotix.mymvprecyclerview.databinding.ActivityMainBinding;
import com.mindnotix.mymvprecyclerview.listener.IBaseCallBack;
import com.mindnotix.mymvprecyclerview.model.DataParticipantsListItems;
import com.mindnotix.mymvprecyclerview.presenter.IPresenter.IMainPresenter;
import com.mindnotix.mymvprecyclerview.presenter.MainPresenter;
import com.mindnotix.mymvprecyclerview.view.IView.IMainView;

public class MainActivity extends BaseActivty implements IMainView, IBaseCallBack {

    IMainPresenter iMainPresenter;
    private ActivityMainBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setAssets();
        iMainPresenter = new MainPresenter(this, this);
        iMainPresenter.onCreatePresenter(getIntent().getExtras());
    }

    private void setAssets() {
        loginBinding.recycerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setReyclerAdapter(CustomAdapter customAdapter) {

        loginBinding.recycerView.setAdapter(customAdapter);
    }

    @Override
    public void onClick(Object object) {

        if (object instanceof DataParticipantsListItems) {

        }
    }
}
