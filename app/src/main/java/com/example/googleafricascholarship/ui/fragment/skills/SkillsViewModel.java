package com.example.googleafricascholarship.ui.fragment.skills;

import androidx.lifecycle.ViewModel;

import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.data.model.SkillsModel;
import com.example.googleafricascholarship.data.network.ApiServices;
import com.example.googleafricascholarship.data.network.RetrofitService;

import java.util.List;

import io.reactivex.Observable;

public class SkillsViewModel extends ViewModel {
    private ApiServices service ;
    public SkillsViewModel() {
        this.service = RetrofitService.getClient();
    }

    public Observable<List<SkillsModel>> getSkills(){
        return service.getApi1();
    }
}