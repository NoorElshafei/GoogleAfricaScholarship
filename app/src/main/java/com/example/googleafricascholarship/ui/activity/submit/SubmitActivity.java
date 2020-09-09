package com.example.googleafricascholarship.ui.activity.submit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.googleafricascholarship.R;
import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.ui.activity.main.MainActivity;
import com.example.googleafricascholarship.ui.adapter.HoursLearningAdapter;
import com.example.googleafricascholarship.ui.fragment.learining.LearningViewModel;
import com.example.googleafricascholarship.util.ViewDialog;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SubmitActivity extends AppCompatActivity {
    private Button submit_button;
    private EditText fName, lName,eMail,gitHub;
    private SubmitViewModel mViewModel;
    private ImageView imageView;
    public  static  ProgressDialog dialog2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        mViewModel = ViewModelProviders.of(this).get(SubmitViewModel.class);

        submit_button =findViewById(R.id.submit_button);
        fName =findViewById(R.id.fname);
        lName =findViewById(R.id.lname);
        eMail =findViewById(R.id.email);
        gitHub =findViewById(R.id.link);
        imageView =findViewById(R.id.back);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog viewDialog =  new ViewDialog();
                final Dialog dialog = viewDialog.showDialog(SubmitActivity.this);

                Button deleteYes = (Button) dialog.findViewById(R.id.yes);
                ImageView deleteNo = (ImageView) dialog.findViewById(R.id.cancel);

                deleteNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                deleteYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        dialog2 = ProgressDialog.show(SubmitActivity.this, "",
                                "Loading. Please wait...", true);
                        dialog2.setCancelable(true);

                        postForm(fName.getText().toString(),lName.getText().toString(),eMail.getText().toString(),gitHub.getText().toString());

                    }
                });

                dialog.show();

            }
        });

    }
    private void postForm(String fName,String lName,String eMail,String gitHub) {

        mViewModel.postSubmit(fName,lName,eMail,gitHub).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                dialog2.dismiss();
                ViewDialog.showDialogSuccess(SubmitActivity.this);


            }

            @Override
            public void onError(Throwable e) {
                dialog2.dismiss();
                ViewDialog.showDialogFailed(SubmitActivity.this);

            }

            @Override
            public void onComplete() {

            }
        });

    }


}