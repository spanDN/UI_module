package com.example.delle5540.ui_module.auth_operation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.delle5540.ui_module.R;

public class NavigationActivity extends AppCompatActivity {
    private Button mBtnSignIn;
    private Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mBtnSignIn = (Button) findViewById(R.id.btn_navigation_activity_sign_in);
        btnMain = (Button) findViewById(R.id.btn_navigation_activity_sign_up);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(NavigationActivity.this, AuthActivity.class);
                startActivity(i);
            }
        });
        btnMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(NavigationActivity.this, "btnMain pressed", Toast.LENGTH_LONG ).show();
            }
        });
    }

}
