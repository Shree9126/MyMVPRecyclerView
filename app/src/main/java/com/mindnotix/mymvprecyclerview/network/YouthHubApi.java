package com.mindnotix.mymvprecyclerview.network;

import com.mindnotix.mymvprecyclerview.model.DataParticipantsListItems;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
//import rx.Observable;

/**
 * Created by Sridharan on 1/18/2018.
 */

public interface YouthHubApi {

    @POST("countmelistevent")
    @FormUrlEncoded
    Call<DataParticipantsListItems> getParticipants(@Header("Authorizations") String value, @FieldMap Map<String, String> options);

}


