package com.example.googleafricascholarship.data.network;

import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.data.model.SkillsModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("api/hours")
    Observable<List<LearningModel>> getApi();
    @GET("api/skilliq")
    Observable<List<SkillsModel>> getApi1();

}
