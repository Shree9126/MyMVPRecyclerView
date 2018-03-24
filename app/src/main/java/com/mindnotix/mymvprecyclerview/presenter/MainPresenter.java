package com.mindnotix.mymvprecyclerview.presenter;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.mindnotix.mymvprecyclerview.adapter.CustomAdapter;
import com.mindnotix.mymvprecyclerview.listener.IBaseCallBack;
import com.mindnotix.mymvprecyclerview.model.DataParticipantsListItems;
import com.mindnotix.mymvprecyclerview.model.Eventcountmelist;
import com.mindnotix.mymvprecyclerview.network.ApiClient;
import com.mindnotix.mymvprecyclerview.network.YouthHubApi;
import com.mindnotix.mymvprecyclerview.presenter.IPresenter.IMainPresenter;
import com.mindnotix.mymvprecyclerview.view.IView.IMainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 3/23/2018.
 */

public class MainPresenter extends BasePresenter implements IMainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    ArrayList<Eventcountmelist> eventcountmelistArrayList;
    CustomAdapter customAdapter;
    private IMainView iMainView;
    private IBaseCallBack iBaseCallBack;

    public MainPresenter(IMainView iMainView, IBaseCallBack iBaseCallBack) {
        super(iMainView);
        this.iMainView = iMainView;
        this.iBaseCallBack = iBaseCallBack;
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {

/*        iMainView.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, 2000);*/
        getParticipantList();

    }

    private void getParticipantList() {
        eventcountmelistArrayList = new ArrayList<>();

        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRhIjp7InVzZXJpZCI6IjYwMjIiLCJ1c2VybmFtZSI6ImlvYW5hc2FsYS1zZXRpdSJ9LCJpYXQiOjE1MjE3OTgzMjQsImp0aSI6IllqQnZNMDFLUm1kRFFXSm1TVXBKZDBSUGIxbz0iLCJpc3MiOiJodHRwczpcL1wvYmFja2VuZC55b3V0aGh1Yi5jby5uelwvIiwibmJmIjoxNTIxNzk4MzI0LCJleHAiOjE1MjI0MDMxMjR9.0_CVvfhqxI-7yLNKP8uMXUiUaEEKDHIAuww-iQSnOvA";


        Map<String, String> data = new HashMap<>();
        data.put("event_id", "160");
        data.put("fm", "");


        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue();
            System.out.println("getParticipantsList  key, " + key + " value " + value);
        }


        YouthHubApi apiService =
                ApiClient.getClient().create(YouthHubApi.class);


        Log.d(TAG, "changePassword: token " + token);

        Call<DataParticipantsListItems> call = apiService.getParticipants(token, data);
        Log.d(TAG, "logMeIn: url " + call.request().url());

        call.enqueue(new Callback<DataParticipantsListItems>() {
            @Override
            public void onResponse(Call<DataParticipantsListItems> call, Response<DataParticipantsListItems> response) {

                try {

                    Log.d(TAG, "onResponse:DataJobListItems " + new Gson().toJson(response.body()));

                    if (response.body().getStatus().equals("1")) {

                        eventcountmelistArrayList.addAll(response.body().getData().getEventcountmelist());

                        Log.d(TAG, "onResponse: array size " + eventcountmelistArrayList.size());

                        if (customAdapter == null) {
                            customAdapter = new CustomAdapter(eventcountmelistArrayList, iBaseCallBack);
                        } else {
                            customAdapter.refresh(eventcountmelistArrayList);
                        }

                        iMainView.setReyclerAdapter(customAdapter);

                    } else {
                        iMainView.showMessage("No Record Available");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<DataParticipantsListItems> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }

    @Override
    public void onStartPresenter() {
        super.onStartPresenter();
    }
}
