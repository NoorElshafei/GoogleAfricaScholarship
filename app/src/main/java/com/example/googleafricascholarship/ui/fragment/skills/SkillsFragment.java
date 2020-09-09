package com.example.googleafricascholarship.ui.fragment.skills;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.googleafricascholarship.R;
import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.data.model.SkillsModel;
import com.example.googleafricascholarship.ui.adapter.HoursLearningAdapter;
import com.example.googleafricascholarship.ui.adapter.SkillsAdapter;
import com.example.googleafricascholarship.ui.fragment.learining.LearningViewModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.googleafricascholarship.ui.activity.main.MainActivity.dialog1;

public class SkillsFragment extends Fragment {

    private SkillsViewModel mViewModel;
    private RecyclerView recyclerView;
    private SkillsAdapter skillsAdapter;

    public static SkillsFragment newInstance() {
        return new SkillsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skills_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SkillsViewModel.class);
        // TODO: Use the ViewModel


        mViewModel.getSkills().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<SkillsModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<SkillsModel> learningModels) {
                Log.d("gfdgds2", "onNext: " + learningModels.size());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                skillsAdapter = new SkillsAdapter(learningModels, getContext());
                recyclerView.setAdapter(skillsAdapter);
                dialog1.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                Log.d("gfdgds2", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

}