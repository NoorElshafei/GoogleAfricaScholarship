package com.example.googleafricascholarship.ui.activity.submit;

import androidx.lifecycle.ViewModel;

import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.data.network.ApiServices;
import com.example.googleafricascholarship.data.network.Common;
import com.example.googleafricascholarship.data.network.RetrofitService;

import java.util.List;

import io.reactivex.Observable;

public class SubmitViewModel extends ViewModel {
    private ApiServices service ;

    public SubmitViewModel() {
        this.service = RetrofitService.getClient1(Common.getBaseUrl1());
    }

    public Observable<String> postSubmit(String fName,String lName,String eMail,String gitHub){
        return service.getApi2(eMail,fName,lName,gitHub);
    }
}
