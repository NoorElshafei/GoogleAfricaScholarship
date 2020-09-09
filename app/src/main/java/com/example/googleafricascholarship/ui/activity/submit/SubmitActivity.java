package com.example.googleafricascholarship.ui.activity.submit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.googleafricascholarship.R;

public class SubmitActivity extends AppCompatActivity {
    private Button submit_button;
    private EditText fName, lName,eMail,gitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        submit_button = findViewById(R.id.submit_button);
        fName = findViewById(R.id.fname);
        lName = findViewById(R.id.lname);
        eMail = findViewById(R.id.email);
        gitHub = findViewById(R.id.link);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("sdasasa", "onClick: "+fName.getText());
                Log.d("sdasasa", "onClick: "+lName.getText());
                Log.d("sdasasa", "onClick: "+eMail.getText());
                Log.d("sdasasa", "onClick: "+gitHub.getText());

            }
        });

    }
}