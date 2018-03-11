package com.example.delle5540.ui_module.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.util.Log;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.commons.IBaseView;
import com.example.delle5540.ui_module.commons.IMainPresenter;
import com.example.delle5540.ui_module.commons.MainPresenterImpl;
import com.example.delle5540.ui_module.model.Topic;
import 	android.support.v7.widget.LinearLayoutManager;

import android.view.Menu;
import android.widget.Toast;
import 	android.support.v7.widget.RecyclerView;
import com.example.delle5540.ui_module.adapters.MainListAdapter;

public class MainActivity extends AppCompatActivity implements IBaseView.IMainView{

    private TextView mTextMessage;
    IMainPresenter presenter;

    /* Recycler view */
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   presenter.doLogout("Facebook", 1);
                    Log.d("MYDEBUG" ,"HERE");

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new MainPresenterImpl();
        presenter.init(this);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View itemView, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        mRecyclerView = (RecyclerView) findViewById(R.id.my_list);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MainListAdapter(Topic.topics);
        mRecyclerView.setAdapter(mAdapter);
       //mRecyclerView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_return:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showMessage(String s) {

    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void doneLogout(String token, int type) {

    }

    @Override
    public void closeMain() {
        this.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }
}
