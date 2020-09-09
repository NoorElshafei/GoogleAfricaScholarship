package com.example.googleafricascholarship.ui.fragment.learining;

import androidx.lifecycle.ViewModel;

import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.data.network.ApiServices;
import com.example.googleafricascholarship.data.network.Common;
import com.example.googleafricascholarship.data.network.RetrofitService;

import java.util.List;

import io.reactivex.Observable;

public class LearningViewModel extends ViewModel {
    private ApiServices service ;

    public LearningViewModel() {
        this.service = RetrofitService.getClient(Common.getBaseUrl());
    }

    public Observable<List<LearningModel>> getHours(){
        return service.getApi();
    }
}