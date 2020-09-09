package com.example.googleafricascholarship.data.network;

import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.data.model.SkillsModel;

import java.util.List;
import java.util.Queue;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("api/hours")
    Observable<List<LearningModel>> getApi();

    @GET("api/skilliq")
    Observable<List<SkillsModel>> getApi1();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Observable<String> getApi2(@Query("entry.1824927963") String email,
                               @Query("entry.1877115667") String fName,
                               @Query("entry.2006916086") String lName,
                               @Query("entry.284483984") String gitHub);

}
