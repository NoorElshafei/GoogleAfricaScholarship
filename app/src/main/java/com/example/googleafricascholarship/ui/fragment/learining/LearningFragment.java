package com.example.googleafricascholarship.ui.fragment.learining;

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
import com.example.googleafricascholarship.ui.adapter.HoursLearningAdapter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.googleafricascholarship.ui.activity.main.MainActivity.dialog1;

public class LearningFragment extends Fragment {

    private LearningViewModel mViewModel;
    private RecyclerView recyclerView;
    private HoursLearningAdapter hoursLearningAdapter;

    public static LearningFragment newInstance() {
        return new LearningFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learning_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LearningViewModel.class);


        mViewModel.getHours().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<LearningModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<LearningModel> learningModels) {
                Log.d("gfdgds", "onNext: " + learningModels.size());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                hoursLearningAdapter = new HoursLearningAdapter(learningModels, getContext());
                recyclerView.setAdapter(hoursLearningAdapter);
                dialog1.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                Log.d("gfdgds", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }

}