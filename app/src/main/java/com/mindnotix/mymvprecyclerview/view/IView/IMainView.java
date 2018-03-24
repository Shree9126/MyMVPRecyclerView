package com.mindnotix.mymvprecyclerview.view.IView;

import com.mindnotix.mymvprecyclerview.adapter.CustomAdapter;

/**
 * Created by Admin on 3/23/2018.
 */

public interface IMainView extends IBaseView {

    void setReyclerAdapter(CustomAdapter customAdapter);
}
