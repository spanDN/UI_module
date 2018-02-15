package com.example.delle5540.ui_module.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.commons.IDetailListener;
import com.example.delle5540.ui_module.fragments.DetailsFragment;

public class DetailActivity extends AppCompatActivity {

    private IDetailListener onDetailsListener = new IDetailListener() {
        @Override
        public void getInfo(String email, String password) {
            Toast.makeText(DetailActivity.this, "GetInfo\n email" + email +
                            "\n password " + password + "\n", Toast.LENGTH_LONG ).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_details_activity,
                DetailsFragment.newInstance(onDetailsListener)).commit();



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
